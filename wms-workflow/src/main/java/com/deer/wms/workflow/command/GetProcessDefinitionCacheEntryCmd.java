package com.deer.wms.workflow.command;

import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.persistence.deploy.DeploymentManager;
import org.flowable.engine.impl.persistence.deploy.ProcessDefinitionCacheEntry;
import org.flowable.engine.impl.util.CommandContextUtil;

/**
 * 从缓存中获取ProcessDefinitionCacheEntry
 *
 * @author luxin.yan
 * @date 2019/2/11
 */
public class GetProcessDefinitionCacheEntryCmd implements Command<ProcessDefinitionCacheEntry> {
    protected String processDefinitionId;

    public GetProcessDefinitionCacheEntryCmd(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    @Override
    public ProcessDefinitionCacheEntry execute(CommandContext commandContext) {
        DeploymentManager deploymentManager = CommandContextUtil.getProcessEngineConfiguration().getDeploymentManager();
        ProcessDefinitionCacheEntry processDefinitionCacheEntry = deploymentManager.getProcessDefinitionCache()
                .get(processDefinitionId);
        return processDefinitionCacheEntry;
    }

}
