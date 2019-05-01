package com.deer.wms.workflow.service.impl;

import com.deer.wms.workflow.command.GenerateActivityUtil;
import com.deer.wms.workflow.command.GetProcessCmd;
import com.deer.wms.workflow.common.JsonToObjectUtil;
import com.deer.wms.workflow.constant.FormConstant;
import com.deer.wms.workflow.service.ProcessInstanceStartService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.ui.modeler.util.ImageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ProcessinstanceServiceImpl
 *
 * @author luxin.yan
 * @date 2019/1/10
 **/
@Service
public class ProcessInstanceStartServiceImpl implements ProcessInstanceStartService {
    private Logger logger = LoggerFactory.getLogger(ProcessInstanceStartServiceImpl.class);

    @Resource
    private RuntimeService runtimeService;
    @Resource
    private ProcessEngineConfiguration processEngineConfiguration;
    @Resource
    private ManagementService managementService;
    @Resource
    private RepositoryService repositoryService;

    @Override
    public List<ProcessDefinition> listProcessDefinition(int first, int maxResult) {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().latestVersion().listPage(first, maxResult);
        return processDefinitions;
    }

    @Override
    @Transactional
    public ProcessInstance startProcessInstance(String processId, String userId, String formJson) {

        ProcessInstance processInstance;
        if (StringUtils.isNotEmpty(formJson)) {
            Map<String, Object> forms = JsonToObjectUtil.jsonToMap(formJson);
            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode jsonNode = mapper.readTree(formJson.getBytes("UTF-8"));
                //正常节点运行
                //下一节点审批人
                JsonNode approverJsonNode = jsonNode.get(FormConstant.YUNLI_DOCUMENT_APPROVER);
                Set<String> approverUsers = FormConstant.parseJsonToSet(approverJsonNode);
                if (approverUsers != null) {
                    //设置第一个任务受理人
                    Process process = managementService.executeCommand(new GetProcessCmd(processId));
                    FlowNode startEvent = GenerateActivityUtil.getStartEvent(process);
                    String targetRef = startEvent.getOutgoingFlows().get(0).getTargetRef();
                    logger.info(targetRef + "设置第一个任务受理人" + approverUsers.size());
//                    forms.put(targetRef, approverUsers);
                    forms.put(targetRef + "list", approverUsers);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            processInstance = runtimeService.startProcessInstanceById(processId, forms);
            ExecutionEntityImpl executionEntity = (ExecutionEntityImpl) processInstance;
            //流程开始绑定form表单实例保存
            logger.debug("开始事件表单不为空创建表单实例!");
        }
        else {
            processInstance = runtimeService.startProcessInstanceById(processId);
        }
        return processInstance;
    }


    @Override
    public InputStream genProcessDiagram(String processInstanceId, boolean autoLayout) {
        HistoryService historyService = processEngineConfiguration.getHistoryService();
        //获取历史流程实例
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).notDeleted().singleResult();
        //获取流程图
        BpmnModel bpmnModel = processEngineConfiguration.getRepositoryService().getBpmnModel(processInstance.getProcessDefinitionId());

        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
        List<HistoricActivityInstance> highLightedActivitList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
        highLightedActivitList = highLightedActivitList.stream().filter(historicActivityInstance -> StringUtils.isBlank(historicActivityInstance.getDeleteReason())).collect(Collectors.toList());
        //高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<>();
        //用于判断
        Map<String, Boolean> highLightedActivitisMap;
        String processDefinitionId = processInstance.getProcessDefinitionId();
        Process process = managementService.executeCommand(new GetProcessCmd(processDefinitionId));

        Process process_1 = GenerateActivityUtil.cloneProcess(process);
        BpmnModel bpmnModel_1 = GenerateActivityUtil.cloneBpmnModel(bpmnModel);
        bpmnModel_1.getProcesses().clear();
        bpmnModel_1.addProcess(process_1);
        bpmnModel = bpmnModel_1;
        highLightedActivitisMap = layoutBpmnModel(process_1, highLightedActivitis, highLightedActivitList);
        List<String> highLightedFlows = getHighLightedFlows(bpmnModel.getMainProcess(), highLightedActivitisMap, highLightedActivitList, autoLayout);
        FileOutputStream outputStream= null;
        try {
            outputStream = new FileOutputStream(new File("d:\\dd.png"));
            try {
                outputStream.write(ImageGenerator.createByteArrayForImage(ImageGenerator.createImage(bpmnModel),"png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis, highLightedFlows, 1.0, true);
    }


    private void refreshDynamicProcess(FlowNode flowNode, FlowNode targetFlowNode, Process targetProcess) {
        //防止对原流程产生影响
        FlowNode flowNodeClone = GenerateActivityUtil.cloneFlowNode(flowNode);
        SequenceFlow outSequenceFlow = flowNodeClone.getOutgoingFlows().get(0);
        targetProcess.removeFlowElement(flowNode.getId());
        targetProcess.removeFlowElement(outSequenceFlow.getId());
        targetProcess.addFlowElement(flowNodeClone);
        targetProcess.addFlowElement(outSequenceFlow);
        outSequenceFlow.setTargetFlowElement(targetFlowNode);
        outSequenceFlow.setTargetRef(targetFlowNode.getId());
    }

    /**
     * 非动态高亮节点
     *
     * @param process
     * @param highLightedActivitis
     * @param highLightedActivitList
     * @return
     */
    private Map<String, Boolean> layoutBpmnModel(Process process, List<String> highLightedActivitis, List<HistoricActivityInstance> highLightedActivitList) {
        //高亮线路id集合
        Map<String, Boolean> highLightedActivitisMap = new HashMap<>();
        for (HistoricActivityInstance tempActivity : highLightedActivitList) {
            String activityId = tempActivity.getActivityId();
            //在原始的流程中才高亮
            FlowElement flowElement = process.getFlowElement(activityId);
            if (flowElement != null) {
                highLightedActivitis.add(activityId);
                highLightedActivitisMap.put(activityId, true);
            }
        }
        return highLightedActivitisMap;
    }

    /**
     * 获取需要高亮的线
     *
     * @param process                   流程bpmn对象
     * @param highLightedActivitis
     * @param historicActivityInstances 历史实例
     * @return bpmn连线id
     */
    private List<String> getHighLightedFlows(Process process, Map<String, Boolean> highLightedActivitis, List<HistoricActivityInstance> historicActivityInstances, boolean autoLayout) {
        // 用以保存高亮的线flowId
        List<String> highFlows = new ArrayList<>();
        // 对历史流程节点进行遍历
        for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
            if (highLightedActivitis.get(historicActivityInstance.getActivityId()) != null) {
                FlowNode activityImpl = (FlowNode) process.getFlowElement(historicActivityInstance.getActivityId(), autoLayout);// 得到节点定义的详细信息
                //结束时间不等空证明此任务已经完成
                if (historicActivityInstance.getEndTime() != null) {
                    List<SequenceFlow> pvmTransitions = activityImpl.getOutgoingFlows();// 取出节点的所有出去的线
                    for (SequenceFlow pvmTransition : pvmTransitions) {
                        String targetFlowElement = pvmTransition.getTargetRef();
                        // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                        if (highLightedActivitis.get(targetFlowElement) != null) {
                            highFlows.add(pvmTransition.getId());
                        }
                    }
                }
            }
        }
        return highFlows;
    }
}
