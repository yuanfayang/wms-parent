package com.deer.wms.workflow.service;

import java.io.IOException;

/**
 * BpmnModelService
 *
 * @author luxin.yan
 * @date 2019/2/17
 **/
public interface BpmnModelService {
    /**
     * 发布流程定义
     * @param modelId
     */
    int publishModel(String modelId) throws IOException;
}
