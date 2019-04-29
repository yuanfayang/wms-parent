package com.deer.wms.workflow.service.impl;

import com.deer.wms.workflow.flowable.jsonConverter.MyBpmnJsonConverter;
import com.deer.wms.workflow.service.BpmnModelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.repository.ModelRepository;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BpmnModelServiceImpl
 *
 * @author luxin.yan
 * @date 2019/2/17
 **/
@Service
@Transactional
public class BpmnModelServiceImpl implements BpmnModelService {
  @Autowired
  protected ModelService modelService;
  @Autowired
  RepositoryService repositoryService;
  @Autowired
  protected ModelRepository modelRepository;

  @Override
  public int publishModel(String modelId) throws IOException {
    Model model = modelService.getModel(modelId);
    publishPorcessAndSaveModel(model);
    return 1;
  }

  /**
   * 创建新的流程模板
   * 发布新的流程定义
   *
   * @return 无返回值
   * @throws IOException json解析异常
   */
  private void publishPorcessAndSaveModel(Model model) throws IOException {
    List<Model> models = modelRepository.findByModelType(2, null);
    Map<String, String> formKeyMap = new HashMap<>();
    if (models != null && models.size() > 0) {
      models.forEach(model1 -> formKeyMap.put(model.getId(), model.getKey()));
    }
    byte[] jsonXml = model.getModelEditorJson().getBytes("utf-8");
    ObjectNode modelNode = (ObjectNode) (new ObjectMapper()).readTree(jsonXml);
    BpmnJsonConverter bpmnJsonConverter = new MyBpmnJsonConverter();
    BpmnModel bpmnModel = bpmnJsonConverter.convertToBpmnModel(modelNode);
    String key = bpmnModel.getProcesses().get(0).getId();
    byte[] bpmnBytes = (new BpmnXMLConverter()).convertToXML(bpmnModel);
    String processName = model.getName() + ".bpmn20.xml";
    Deployment deployment = this.repositoryService.createDeployment().key(key).name(processName).addString(processName, new String(bpmnBytes)).deploy();
    ProcessDefinition proDefinition = this.repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
    if (proDefinition == null) {
      throw new RuntimeException("流程发布失败");
    }
  }

}
