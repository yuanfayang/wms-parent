package com.deer.wms.workflow.command;

import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManager;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;
import org.flowable.task.service.impl.util.CommandContextUtil;

import java.util.List;

/**
 * RollbackJumpCmd
 * 回退
 *
 * @author luxin.yan
 * @date 2019/1/12
 **/
public class RollbackJumpCmd implements Command<Void> {
    protected String taskId;

    public RollbackJumpCmd(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public Void execute(CommandContext commandContext) {
        ExecutionEntityManager executionEntityManager = org.flowable.engine.impl.util.CommandContextUtil
                .getExecutionEntityManager();
        TaskEntityManager taskEntityManager = CommandContextUtil.getTaskEntityManager();
        // 根据taskId获取执行实例信息
        TaskEntity taskEntity = taskEntityManager.findById(taskId);
        // 获取执行实例ID
        String executionId = taskEntity.getExecutionId();
        ExecutionEntity executionEntity = executionEntityManager.findById(executionId);
        Process process = ProcessDefinitionUtil.getProcess(executionEntity.getProcessDefinitionId());
        // 当前任务的key
        String currentTaskDefinitionKey = taskEntity.getTaskDefinitionKey();
        // 当前任务
        Activity currentActivity = (Activity) process.getFlowElement(currentTaskDefinitionKey);
        List<SequenceFlow> sequenceFlowList_in = currentActivity.getIncomingFlows();
        CommonForwardJumpCmd aJump = null;
        if (sequenceFlowList_in.size() == 1) {
            //只有一个入口
            FlowElement flowElementSource = sequenceFlowList_in.get(0).getSourceFlowElement();
            if (flowElementSource instanceof Gateway) {
                //如果是网关跳到网关前一个节点
                aJump = new CommonForwardJumpCmd(taskId, ((Gateway) flowElementSource).getIncomingFlows().get(0).getTargetRef());
                aJump.setProcess(process);
                aJump.setTaskEntity(taskEntity);
                aJump.execute(commandContext);
            } else {
                aJump = new CommonForwardJumpCmd(taskId, flowElementSource.getId());
                aJump.setProcess(process);
                aJump.setTaskEntity(taskEntity);
                aJump.execute(commandContext);
            }
        }
        if (aJump == null) {
            if (sequenceFlowList_in.size() > 1) {
                //如果是多入口，分别回退到每个入口的源节点上
                for (SequenceFlow sequenceFlow : sequenceFlowList_in) {
                    aJump = new CommonForwardJumpCmd(taskId, sequenceFlow.getSourceRef());
                    aJump.setProcess(process);
                    aJump.setTaskEntity(taskEntity);
                    aJump.execute(commandContext);
                }
            }
        }

        return null;
    }
}
