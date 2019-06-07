package com.deer.wms.workflow.command;

import org.flowable.bpmn.model.Activity;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.FlowableEngineAgenda;
import org.flowable.engine.impl.bpmn.behavior.MultiInstanceActivityBehavior;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManager;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;

/**
 * AJump
 *
 * @author luxin.yan
 * @date 2019/1/21
 **/
public class AJump implements Command<Void> {


    @Override
    public Void execute(CommandContext commandContext) {
        return null;
    }

    /**
     * @param deleteMuliMy    删除多实例任务父执行器
     * @param executionEntity 需要删除的执行器
     */
    protected void deleteCurrentExecutions(TaskEntity taskEntity, Process process, boolean deleteMuliMy, TaskEntityManager taskEntityManager, ExecutionEntityManager executionEntityManager, ExecutionEntity executionEntity) {
        // 如果是多实例任务
        Activity currentActivity = (Activity) process.getFlowElement(taskEntity.getTaskDefinitionKey());
        Object behavior = currentActivity.getBehavior();
        if (behavior instanceof MultiInstanceActivityBehavior) {
            executionEntityManager.deleteChildExecutions(executionEntity, "muli-jump", false);
            if (deleteMuliMy) {
                executionEntityManager.deleteExecutionAndRelatedData(executionEntity, "muli-jump");
            } else {
                //修改is_mi_root_字段
                executionEntity.setMultiInstanceRoot(false);
                //修改is_active_
                executionEntity.setActive(true);
                //需要更新数据
                executionEntityManager.update(executionEntity);
            }
        } else {
            //删除当前的任务
            taskEntityManager.delete(taskEntity.getId());

            org.flowable.engine.impl.util.CommandContextUtil.getHistoryManager().recordTaskEnd(taskEntity,
                    executionEntity, "task-jump");

            org.flowable.engine.impl.util.CommandContextUtil.getHistoryManager().recordActivityEnd(executionEntity,
                    "task-jump");
        }


    }

    protected void jump(Process process, ExecutionEntityManager executionEntityManager, ExecutionEntity executionEntity, String targetNodeId) {
        FlowElement targetFlowElement = process.getFlowElement(targetNodeId);
        executionEntity.setCurrentFlowElement(targetFlowElement);
        // 设置当前的执行实例ID对应的 CurrentFlowElement为目标节点，目标节点是一个参数，可以进行传递。
        FlowableEngineAgenda flowableEngineAgenda = org.flowable.engine.impl.util.CommandContextUtil.getAgenda();
        executionEntity.setCurrentFlowElement(targetFlowElement);
        flowableEngineAgenda.planContinueProcessInCompensation(executionEntity);
    }


}
