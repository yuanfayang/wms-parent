package com.deer.wms.workflow.command;

import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManager;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;
import org.flowable.task.service.impl.util.CommandContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommonForwardJumpCmd
 * 任意节点跳转，往前跳
 *
 * @author luxin.yan
 * @date 2019/1/12
 **/
public class CommonForwardJumpCmd extends AJump {
    private TaskEntityManager taskEntityManager;
    private ExecutionEntityManager executionEntityManager;
    protected String taskId;
    protected String targetNodeId;
    protected Process process;
    protected TaskEntity taskEntity;
    public CommonForwardJumpCmd(String taskId, String targetNodeId) {
        this.taskId=taskId;
        this.targetNodeId=targetNodeId;
    }

    @Override
    public Void execute(CommandContext commandContext) {
        executionEntityManager = org.flowable.engine.impl.util.CommandContextUtil
                .getExecutionEntityManager();
        taskEntityManager = CommandContextUtil.getTaskEntityManager();
        // 根据taskId获取执行实例信息
        if (taskEntity == null) {
            taskEntity = taskEntityManager.findById(taskId);
        }
        // 获取执行实例ID
        String executionId = taskEntity.getExecutionId();

        ExecutionEntity executionEntity = executionEntityManager.findById(executionId);
        if (process == null) {
            process = ProcessDefinitionUtil.getProcess(executionEntity.getProcessDefinitionId());
        }
        List<ExecutionEntity> executionEntities = executionEntityManager.findChildExecutionsByParentExecutionId(taskEntity.getProcessInstanceId());
        Map<String, ExecutionEntity> data = new HashMap<>();
        for (ExecutionEntity executionEntity1 : executionEntities) {
            data.put(executionEntity1.getCurrentActivityId(), executionEntity1);
        }
        FlowElement targetFlowElement = process.getFlowElement(targetNodeId);
        Activity targetActivity = (Activity) targetFlowElement;
        ExecutionEntity tar_executionEntity = data.get(targetActivity.getId());
        if (tar_executionEntity != null) {
            deleteCurrentExecutions(taskEntity, process, true, taskEntityManager, executionEntityManager, tar_executionEntity);
        }
        List<SequenceFlow> sequenceFlowList_out = targetActivity.getOutgoingFlows();
        roll(sequenceFlowList_out, data);
        executionEntity = executionEntityManager.createChildExecution(executionEntityManager.findByRootProcessInstanceId(taskEntity.getProcessInstanceId()));
        jump(process, executionEntityManager, executionEntity,targetNodeId);
        return null;
    }

    private void roll(List<SequenceFlow> sequenceFlowList, Map<String, ExecutionEntity> data) {
        for (SequenceFlow sequenceFlow : sequenceFlowList) {
            ExecutionEntity executionEntity = data.get(sequenceFlow.getTargetRef());
            if (executionEntity != null) {
                deleteCurrentExecutions(taskEntity, process, true, taskEntityManager, executionEntityManager, executionEntity);
            } else {
                FlowElement flowElement = sequenceFlow.getTargetFlowElement();
                if (flowElement instanceof FlowNode) {
                    FlowNode targetActivity = (FlowNode) flowElement;
                    roll(targetActivity.getOutgoingFlows(), data);
                }
            }
        }
    }



    public void setProcess(Process process) {
        this.process = process;
    }



    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
