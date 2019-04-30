package com.deer.wms.workflow.service;

import com.deer.wms.workflow.dto.FormResultDTO;
import com.deer.wms.workflow.model.TaskForm;
import org.flowable.form.api.FormInfo;
import org.flowable.task.api.Task;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * TaskInstanceService
 * 流程实例管理
 *
 * @author luxin.yan
 * @date 2019/1/11
 **/
public interface TaskInstanceService {
    /**
     * 查询用户可接受的任务
     *
     * @param taskForm 查询任务表单
     * @return 可受理任务
     */
    List<Task> listCandidateTask(TaskForm taskForm);

    /**
     * 查询可受理任务
     *
     * @param taskForm 查询任务表单
     * @return 代办的任务
     */
    List<Task> listAssigneeTasks(TaskForm taskForm);


    void claimTask(String taskId, String userId);

    /**
     * Z转办
     *
     * @param taskId   任务ID
     * @param assignId 转办目标用户ID
     */
    void delegateTask(String taskId, String assignId);

    /**
     * 节点回退
     *
     * @param taskId 任务id
     */
    void rollback(String taskId);

    /**
     * 减签
     *
     * @param taskId  任务ID
     * @param userIds 减签用户列表
     */
    void subtractUser(String taskId, List<String> userIds);

    /**
     * 加签
     *
     * @param taskId  任务ID
     * @param userIds 加签用户列表
     */
    void countersign(String taskId, List<String> userIds);


    /**
     * 完成当前任务
     *
     * @param taskId        任务ID
     * @param formDefinedId 表单ID
     * @param userId        当前用户ID
     * @param comment       处理意见
     * @param formVariables 表单参数
     * @throws IOException
     */
    void dealWith(String taskId, String formDefinedId, String userId, String comment, Map<String, Object> formVariables) throws IOException;

    FormInfo getTaskFormModel(String taskId);

    /**
     * 查询表单实例列表
     *
     * @param
     * @return java.util.List<org.flowable.form.api.FormInfo>
     * @author yanluxin  2019/4/24 19:40
     */
    List<FormResultDTO> listTaskFormModelByInstanceId(String instanceId);
}
