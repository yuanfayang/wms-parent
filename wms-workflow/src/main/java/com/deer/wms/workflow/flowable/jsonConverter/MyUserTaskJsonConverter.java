package com.deer.wms.workflow.flowable.jsonConverter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.BaseElement;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.UserTask;
import org.flowable.editor.language.json.converter.BaseBpmnJsonConverter;
import org.flowable.editor.language.json.converter.UserTaskJsonConverter;

import java.util.Map;

/**
 * MyUserTaskJsonConverter
 *
 * @author luxin.yan
 * @date 2019/2/28
 **/
public class MyUserTaskJsonConverter extends UserTaskJsonConverter {

  public static void fillTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap, Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
    fillJsonTypes(convertersToBpmnMap);
    fillBpmnTypes(convertersToJsonMap);
  }

  public static void fillJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
    convertersToBpmnMap.put(STENCIL_TASK_USER, MyUserTaskJsonConverter.class);
  }

  public static void fillBpmnTypes(Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
    convertersToJsonMap.put(UserTask.class, MyUserTaskJsonConverter.class);
  }

  @Override
  protected void convertElementToJson(ObjectNode propertiesNode, BaseElement baseElement) {
    super.convertElementToJson(propertiesNode, baseElement);
  }


  @Override
  protected FlowElement convertJsonToElement(JsonNode elementNode, JsonNode modelNode, Map<String, JsonNode> shapeMap) {
    UserTask userTask = (UserTask) super.convertJsonToElement(elementNode, modelNode, shapeMap);
    String formKey = this.getPropertyValueAsString("formkeydefinition", elementNode);
    JsonNode assignmentNode;
    if (StringUtils.isNotEmpty(formKey)) {
      userTask.setFormKey(formKey);
    } else {
      assignmentNode = this.getProperty("formreference", elementNode);
      if (assignmentNode != null && assignmentNode.get("id") != null) {
        userTask.setFormKey(assignmentNode.get("key").asText());
      }
    }
    return userTask;
  }
}
