package com.deer.wms.workflow.command;

import com.deer.wms.workflow.model.TaskModel;
import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.flowable.engine.impl.bpmn.parser.factory.ActivityBehaviorFactory;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.beans.BeanUtils;

import java.util.LinkedHashMap;
import java.util.List;

public class GenerateActivityUtil {
    /**
     * &#x751f;&#x6210;&#x8fde;&#x7ebf;&#x4fe1;&#x606f;
     *
     * @param id
     * @param source
     * @param target
     * @return
     */
    public static SequenceFlow generateSequenceFlow(String id, String source, String target) {
        SequenceFlow sequenceFlow = new SequenceFlow();
        sequenceFlow.setId(id);
        sequenceFlow.setSourceRef(source);
        sequenceFlow.setTargetRef(target);
        return sequenceFlow;
    }

    /**
     * 生成任务节点
     *
     * @param id
     * @param name
     * @param assignee
     * @param processEngine
     * @return
     */
    public static UserTask generateUserTask(String id, String name, String assignee, ProcessEngine processEngine) {
        UserTask userTask = new UserTask();
        userTask.setId(id);
        userTask.setAssignee(assignee);
        userTask.setName(name);
        userTask.setBehavior(createUserTaskBehavior(userTask, processEngine));
        return userTask;
    }

    /**
     * 将TaskModel实例对象转换为UserTask实例对象
     *
     * @param taskModel
     * @param processEngine
     * @return
     */
    public static UserTask transformation(TaskModel taskModel, ProcessEngine processEngine) {
        UserTask generateUserTask = generateUserTask(taskModel.getId(), taskModel.getName(), taskModel.getDoUserId(), processEngine);
        return generateUserTask;
    }

    /**
     * 生成自定义任务模型
     *
     * @param id
     * @param name
     * @param assignee
     * @return
     */
    public static TaskModel generateTaskModel(String id, String name, String assignee) {
        TaskModel userTask = new TaskModel();
        userTask.setId(id);
        userTask.setDoUserId(assignee);
        userTask.setName(name);
        return userTask;
    }

    /**
     * 生成任务节点行为类
     *
     * @param userTask
     * @param processEngine
     * @return
     */
    public static Object createUserTaskBehavior(UserTask userTask, ProcessEngine processEngine) {
        ProcessEngineConfigurationImpl processEngineConfiguration = (ProcessEngineConfigurationImpl) processEngine
                .getProcessEngineConfiguration();
        // activityBehaviorFactory
        ActivityBehaviorFactory activityBehaviorFactory = processEngineConfiguration.getActivityBehaviorFactory();
        UserTaskActivityBehavior userTaskActivityBehavior = activityBehaviorFactory
                .createUserTaskActivityBehavior(userTask);
        return userTaskActivityBehavior;
    }


    public static FlowNode cloneFlowNode(FlowNode flowNode) {
        FlowNode flowNodeClone = (FlowNode) flowNode.clone();
        SequenceFlow sequenceFlow = flowNode.getOutgoingFlows().get(0).clone();
        flowNodeClone.getOutgoingFlows().add(sequenceFlow);
        return flowNodeClone;
    }

    public static Process cloneProcess(Process process) {
        Process targetProcess = process.clone();
        BeanUtils.copyProperties(process, targetProcess);
        //防止对象传递，对原流程的影响
        targetProcess.setFlowElementMap(new LinkedHashMap<>());
        targetProcess.getFlowElementMap().putAll(process.getFlowElementMap());
        targetProcess.getFlowElements().addAll(process.getFlowElements());
        return targetProcess;
    }

    public static BpmnModel cloneBpmnModel(BpmnModel bpmnModel) {
        BpmnModel target = new BpmnModel();
        BeanUtils.copyProperties(bpmnModel, target);
        target.getLabelLocationMap().putAll(bpmnModel.getLabelLocationMap());
        target.getLocationMap().putAll(bpmnModel.getLocationMap());
        target.getFlowLocationMap().putAll(bpmnModel.getFlowLocationMap());
        target.getNamespaces().putAll(bpmnModel.getNamespaces());
        return target;
    }

    public static StartEvent getStartEvent(Process process) {
        List<StartEvent> startEvents = process.findFlowElementsOfType(StartEvent.class);
        StartEvent startEvent = startEvents.get(0);
        return startEvent;
    }
}
