package com.deer.wms.workflow.service;

import org.flowable.form.api.FormInfo;

import java.io.IOException;

/**
 * FlowableFormService
 *
 * @author luxin.yan
 * @date 2019/2/17
 **/
public interface FlowableFormService {
    /**
     * 发布表单定义
     *
     * @param formModelId
     * @return
     */
    int publishForm(String formModelId) throws IOException;

    /**
     * 查询表单信息
     *
     * @param formKey
     * @return
     */
    FormInfo getFormInfo(String formKey);
}
