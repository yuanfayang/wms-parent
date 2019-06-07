package com.deer.wms.workflow.service;

import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;

import java.io.InputStream;
import java.util.List;

/**
 * ProcessinstanceService
 *
 * @author luxin.yan
 * @date 2019/1/10
 **/
public interface ProcessInstanceStartService {

    List<ProcessDefinition> listProcessDefinition(int first, int maxResult);

    InputStream genProcessDiagram(String processInstanceId, boolean autoLayout);


    ProcessInstance startProcessInstance(String processKey, String userId, String formJson);

}
