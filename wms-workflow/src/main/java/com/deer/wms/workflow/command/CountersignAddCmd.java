package com.deer.wms.workflow.command;

import com.deer.wms.workflow.constant.FlowableVariableConstant;
import org.flowable.bpmn.model.*;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.impl.cfg.IdGenerator;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.bpmn.behavior.MultiInstanceActivityBehavior;
import org.flowable.engine.impl.delegate.ActivityBehavior;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManager;
import org.flowable.engine.impl.util.Flowable5Util;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;
import org.flowable.engine.impl.util.TaskHelper;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityImpl;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;
import org.flowable.task.service.impl.util.CommandContextUtil;

import java.util.Date;
import java.util.List;

/**
 * CountersignAddCmd
 * 自定义多实例加签
 *
 * @author luxin.yan
 * @date 2019/1/12
 **/
public class CountersignAddCmd implements Command {

    protected String taskId;
    protected String[] assignees;
    protected final String NUMBER_OF_INSTANCES = FlowableVariableConstant.NUMBER_OF_INSTANCES;
    protected final String NUMBER_OF_ACTIVE_INSTANCES = FlowableVariableConstant.NUMBER_OF_COMPLETED_INSTANCES;

    public CountersignAddCmd(String taskId, String[] assignees) {
        this.taskId = taskId;
        this.assignees = assignees;
    }

    @Override
    public Object execute(CommandContext commandContext) {
        if (assignees == null) {
            throw new RuntimeException("加签用户不能为空!");
        }
        ProcessEngineConfiguration processEngineConfiguration = (ProcessEngineConfiguration) commandContext.getCurrentEngineConfiguration();
        IdGenerator idGenerator = processEngineConfiguration.getIdGenerator();
        ExecutionEntityManager executionEntityManager = org.flowable.engine.impl.util.CommandContextUtil
                .getExecutionEntityManager();
        TaskEntityManager taskEntityManager = CommandContextUtil.getTaskEntityManager();
        TaskEntity oldTaskEntity = taskEntityManager.findById(taskId);
        ExecutionEntity miExecution = searchForMultiInstanceActivity(oldTaskEntity.getTaskDefinitionKey(), oldTaskEntity.getProcessInstanceId(), executionEntityManager);
        if (miExecution == null) {
            throw new FlowableException("No multi instance execution found for activity id " + oldTaskEntity.getTaskDefinitionKey());
        }
        if (Flowable5Util.isFlowable5ProcessDefinitionId(commandContext, miExecution.getProcessDefinitionId())) {
            throw new FlowableException("Flowable 5 process definitions are not supported");
        }
        for (String assignee : assignees) {
            ExecutionEntity childExecution = executionEntityManager.createChildExecution(miExecution);
            childExecution.setCurrentFlowElement(miExecution.getCurrentFlowElement());
            BpmnModel bpmnModel = ProcessDefinitionUtil.getBpmnModel(miExecution.getProcessDefinitionId());
            Activity miActivityElement = (Activity) bpmnModel.getFlowElement(miExecution.getActivityId());
            MultiInstanceLoopCharacteristics multiInstanceLoopCharacteristics = miActivityElement.getLoopCharacteristics();
            Integer currentNumberOfInstances = (Integer) miExecution.getVariable(NUMBER_OF_INSTANCES);
            miExecution.setVariableLocal(NUMBER_OF_INSTANCES, currentNumberOfInstances + 1);
            Integer currentNumberOfActiveInstances = (Integer) miExecution.getVariable(NUMBER_OF_ACTIVE_INSTANCES);
            miExecution.setVariableLocal(NUMBER_OF_ACTIVE_INSTANCES, currentNumberOfActiveInstances + 1);
            if (!multiInstanceLoopCharacteristics.isSequential()) {
                //新建一条执行流程
                childExecution.setActive(true);
                childExecution.setConcurrent(false);
                childExecution.setScope(false);
                //新建一条任务
                TaskEntityImpl taskEntity = new TaskEntityImpl();
                taskEntity.setCreateTime(new Date());
                taskEntity.setTaskDefinitionId(oldTaskEntity.getTaskDefinitionId());
                taskEntity.setProcessDefinitionId(oldTaskEntity.getProcessDefinitionId());
                taskEntity.setTaskDefinitionKey(oldTaskEntity.getTaskDefinitionKey());
                taskEntity.setProcessInstanceId(oldTaskEntity.getProcessInstanceId());
                taskEntity.setCountEnabled(true);
                taskEntity.setExecutionId(childExecution.getId());
                taskEntity.setName(oldTaskEntity.getName());
                taskEntity.setId(idGenerator.getNextId());
                taskEntity.setAssignee(assignee);
                taskEntity.setParentTaskId(taskId);
                FlowNode flowElement = (FlowNode) getCurrentFlowElement(childExecution);
                setLoopCounterVariable(flowElement, childExecution, currentNumberOfInstances);
                TaskHelper.insertTask(taskEntity, childExecution, true);
            }
//            else {
//                throw new RuntimeException("串行多实例任务");
//            }
        }
        return null;
    }

    protected ExecutionEntity searchForMultiInstanceActivity(String activityId, String parentExecutionId, ExecutionEntityManager executionEntityManager) {
        List<ExecutionEntity> childExecutions = executionEntityManager.findChildExecutionsByParentExecutionId(parentExecutionId);

        ExecutionEntity miExecution = null;
        for (ExecutionEntity childExecution : childExecutions) {
            if (activityId.equals(childExecution.getActivityId()) && childExecution.isMultiInstanceRoot()) {
                if (miExecution != null) {
                    throw new FlowableException("Multiple multi instance executions found for activity id " + activityId);
                }
                miExecution = childExecution;
            }

            ExecutionEntity childMiExecution = searchForMultiInstanceActivity(activityId, childExecution.getId(), executionEntityManager);
            if (childMiExecution != null) {
                if (miExecution != null) {
                    throw new FlowableException("Multiple multi instance executions found for activity id " + activityId);
                }
                miExecution = childMiExecution;
            }
        }
        return miExecution;
    }

    protected void setLoopCounterVariable(FlowNode flowNode, ExecutionEntity execution, int loopCounter) {
        ActivityBehavior activityBehavior = (ActivityBehavior) flowNode.getBehavior();
        if (activityBehavior instanceof MultiInstanceActivityBehavior) {
            MultiInstanceActivityBehavior multiInstanceActivityBehavior = (MultiInstanceActivityBehavior) activityBehavior;
            String elementIndexVariable = multiInstanceActivityBehavior.getCollectionElementIndexVariable();
            if (!flowNode.isAsynchronous()) {
                execution.setVariableLocal(elementIndexVariable, loopCounter);
            }
        } else {
            throw new FlowableException("Programmatic error: expected multi instance activity behavior, but got " + activityBehavior.getClass());
        }
    }

    protected FlowElement getCurrentFlowElement(final ExecutionEntity execution) {
        if (execution.getCurrentFlowElement() != null) {
            return execution.getCurrentFlowElement();
        } else if (execution.getCurrentActivityId() != null) {
            String processDefinitionId = execution.getProcessDefinitionId();
            org.flowable.bpmn.model.Process process = ProcessDefinitionUtil.getProcess(processDefinitionId);
            String activityId = execution.getCurrentActivityId();
            FlowElement currentFlowElement = process.getFlowElement(activityId, true);
            return currentFlowElement;
        }
        return null;
    }

}
