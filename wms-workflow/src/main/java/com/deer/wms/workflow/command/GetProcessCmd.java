package com.deer.wms.workflow.command;

import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;

/**
 * 根据流程定义的id获取Process实例对象
 *
 * @author luxin.yan
 * @date 2019/1/9
 */
public class GetProcessCmd implements Command<Process> {

    protected String processDefinitionId;

    public GetProcessCmd(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    @Override
    public Process execute(CommandContext commandContext) {
        Process process = ProcessDefinitionUtil.getProcess(processDefinitionId);
        return process;
    }

}
