package com.deer.wms.workflow.command;

import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;
import org.flowable.task.service.impl.util.CommandContextUtil;

import java.util.Map;

/**
 * CompleteExecutionCmd
 * 自定义任务提交
 * <p>
 * 主要是为了多实例任务,提交多表单中都有下级受理人时进行合并
 * </p>
 *
 * @author luxin.yan
 * @date 2019/1/13
 **/
public class CompleteExecutionCmd implements Command {

  protected String taskId;
  /**
   * 表单参数
   */
  protected Map<String, Object> formVars;
  /**
   * 流程定义ID
   */
  protected String formDefinedId;

  public CompleteExecutionCmd(String taskId, String formDefinedId, Map<String, Object> vars) {
    this.taskId = taskId;
    this.formVars = vars;
    this.formDefinedId = formDefinedId;
  }

  @Override
  public Object execute(CommandContext commandContext) {
    ProcessEngineConfiguration processEngineConfiguration = (ProcessEngineConfiguration) commandContext.getCurrentEngineConfiguration();
    TaskService taskService = processEngineConfiguration.getTaskService();
    TaskEntityManager taskEntityManager = CommandContextUtil.getTaskEntityManager();
    TaskEntity currentTaskEntity = taskEntityManager.findById(taskId);
    Process process = ProcessDefinitionUtil.getProcess(currentTaskEntity.getProcessDefinitionId());
    FlowElement currentFlowElement = process.getFlowElement(currentTaskEntity.getTaskDefinitionKey());
    //完成任务并提交form表单
    taskService.completeTaskWithForm(taskId, formDefinedId, currentFlowElement.getName(), formVars);
    return null;
  }
}
