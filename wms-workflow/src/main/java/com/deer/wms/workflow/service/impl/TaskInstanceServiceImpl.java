package com.deer.wms.workflow.service.impl;

import com.deer.wms.workflow.command.*;
import com.deer.wms.workflow.dto.FormResultDTO;
import com.deer.wms.workflow.model.TaskForm;
import com.deer.wms.workflow.service.TaskInstanceService;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.*;
import org.flowable.form.api.FormInfo;
import org.flowable.form.api.FormInstance;
import org.flowable.form.api.FormService;
import org.flowable.idm.api.User;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.ui.common.properties.FlowableCommonAppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TaskInstanceServiceImpl
 *
 * @author luxin.yan
 * @date 2019/1/11
 **/
@Service
@Transactional
public class TaskInstanceServiceImpl implements TaskInstanceService {
    @Resource
    private TaskService taskService;
    @Resource
    private HistoryService historyService;
    @Resource
    private IdentityService identityService;
    @Resource
    private ProcessEngineConfiguration processEngineConfiguration;
    private FlowableCommonAppProperties properties;
    @Resource
    private FormService formService;


    @Autowired
    public void setProperties(FlowableCommonAppProperties properties) {
        this.properties = properties;
    }

    @Resource
    private ManagementService managementService;


    @Override
    public List<Task> listCandidateTask(TaskForm taskForm) {
        return taskService.createTaskQuery().taskCandidateUser(taskForm.getUsreId()).list();
        //.listPage(taskForm.getCurrentPage()*taskForm.getPageSize(),taskForm.getPageSize());
    }

    @Override
    public List<Task> listAssigneeTasks(TaskForm taskForm) {
        return taskService.createTaskQuery().taskAssignee(taskForm.getUsreId()).list();
    }

    @Override
    public void claimTask(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }

    @Override
    public void delegateTask(String taskId, String assignId) {
        taskService.delegateTask(taskId, assignId);
    }

    @Override
    public void rollback(String taskId) {
        managementService.executeCommand(new RollbackJumpCmd(taskId));
    }

//    @Override
//    public void takeback(String taskId, String taskDefKey, String processDefinitionId,String processInstId) {
//        managementService.executeCommand(new TakebackJumpCmd(taskId, taskDefKey, processDefinitionId,processInstId));
//    }

    @Override
    public void subtractUser(String taskId, List<String> userIds) {
        managementService.executeCommand(new DeleteMultiInstanceExecutionCmd(taskId, userIds));
    }

    @Override
    public void countersign(String taskId, List<String> userIds) {
        managementService.executeCommand(new CountersignAddCmd(taskId, userIds.toArray(new String[userIds.size()])));
    }

    @Override
    public void dealWith(String taskId, String formDefinedId, String userId, String comment, Map<String, Object> formVariables) throws IOException {
        Task taskEntity = taskService.createTaskQuery().taskId(taskId).singleResult();
        Process process = managementService.executeCommand(new GetProcessCmd(taskEntity.getProcessDefinitionId()));
        identityService.setAuthenticatedUserId(userId);
        //添加意见
        if (StringUtils.isNotBlank(comment)) {
            taskService.addComment(taskId, taskEntity.getProcessInstanceId(), comment);
        }
        managementService.executeCommand(new CompleteExecutionCmd(taskId, formDefinedId, formVariables));
    }

    @Override
    public FormInfo getTaskFormModel(String taskId) {
        return taskService.getTaskFormModel(taskId);
    }

    @Override
    public List<FormResultDTO> listTaskFormModelByInstanceId(String instandId) {
        IdentityService identityService = processEngineConfiguration.getIdentityService();
        List<FormInstance> formInstanceList = formService.createFormInstanceQuery().processInstanceId(instandId).list();
        final List<FormResultDTO> formInfoList = new ArrayList<>();
        //查询流程实例
        final List<HistoricTaskInstance> taskEntityList = historyService.createHistoricTaskInstanceQuery().processInstanceId(instandId).list();
        final Map<String, HistoricTaskInstance> taskMap = new HashMap<>((int) (taskEntityList.size() / 0.75));
        taskEntityList.forEach(task -> taskMap.put(task.getId(), task));
        formInstanceList.forEach(formInstance -> {
            FormResultDTO formResultDTO = new FormResultDTO();
            HistoricTaskInstance historicTaskInstance = taskMap.get(formInstance.getTaskId());
            formResultDTO.setTaskId(historicTaskInstance.getId());
            formResultDTO.setTaskName(historicTaskInstance.getName());
            formResultDTO.setUserId(historicTaskInstance.getAssignee());
            if (StringUtils.isNotBlank(historicTaskInstance.getAssignee())) {
                User user = identityService.createUserQuery().userId(historicTaskInstance.getAssignee()).singleResult();
                if (user != null) {
                    formResultDTO.setUserName(user.getDisplayName());
                }
            }
            formResultDTO.setEndDate(historicTaskInstance.getCreateTime());
            formResultDTO.setFormInfo(getTaskFormModel(formInstance.getTaskId()));
            formInfoList.add(formResultDTO);
        });
        return formInfoList;
    }
}
