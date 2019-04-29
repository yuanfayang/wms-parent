package com.deer.wms.workflow.command;

import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.UserTask;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManager;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;
import org.flowable.task.service.impl.util.CommandContextUtil;

import java.util.List;

/**
 * DeleteMultiInstanceExecutionCmd
 * 多实例任务减签
 *
 * @author luxin.yan
 * @date 2019/1/13
 **/
public class DeleteMultiInstanceExecutionCmd implements Command {

    protected String taskId;
    protected List<String> userIds;

    public DeleteMultiInstanceExecutionCmd(String taskId, List<String> userIds) {
        this.taskId = taskId;
        this.userIds = userIds;
    }

    @Override
    public Object execute(CommandContext commandContext) {
        ProcessEngineConfiguration processEngineConfiguration = (ProcessEngineConfiguration) commandContext.getCurrentEngineConfiguration();
        RuntimeService runtimeService = processEngineConfiguration.getRuntimeService();
        TaskEntityManager taskEntityManager = CommandContextUtil.getTaskEntityManager();
        TaskEntity currentTaskEntity = taskEntityManager.findById(taskId);
        Process process = ProcessDefinitionUtil.getProcess(currentTaskEntity.getProcessDefinitionId());
        UserTask userTask = (UserTask) process.getFlowElement(currentTaskEntity.getTaskDefinitionKey());
        validate(userTask);
        ExecutionEntityManager executionEntityManager = org.flowable.engine.impl.util.CommandContextUtil
                .getExecutionEntityManager();
        ExecutionEntity currentExecutionEntity = executionEntityManager.findById(currentTaskEntity.getExecutionId());
        //获取父执行器
        ExecutionEntity executionEntityParent = currentExecutionEntity.getParent();
        List<ExecutionEntity> findChildExecutionsByParentExecutionId = executionEntityManager
                .findChildExecutionsByParentExecutionId(executionEntityParent.getId());
        //暂时先循环执行，后续性能修改
        for (ExecutionEntity e : findChildExecutionsByParentExecutionId) {
            List<TaskEntity> taskEntityList = taskEntityManager.findTasksByExecutionId(e.getId());
            for (TaskEntity t : taskEntityList) {
                if (userIds.contains(t.getAssignee())) {
                    runtimeService.deleteMultiInstanceExecution(e.getId(), true);
                }
            }
        }


        return null;
    }

    public void validate(UserTask userTask) {
        /**
         * 建议使用这种方式，比较靠谱
         */
        Object behavior = userTask.getBehavior();
        if (behavior instanceof UserTaskActivityBehavior) {
            throw new RuntimeException(userTask.getId() + "是普通任务节点");
        }
    }
}
