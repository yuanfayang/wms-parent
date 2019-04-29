package com.deer.wms.workflow.service.impl;

import com.deer.wms.workflow.service.FlowableFormService;
import org.flowable.form.api.FormDefinition;
import org.flowable.form.api.FormDeployment;
import org.flowable.form.api.FormInfo;
import org.flowable.form.api.FormRepositoryService;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * FlowableFormServiceImpl
 *
 * @author luxin.yan
 * @date 2019/2/17
 **/
@Service
@Transactional
public class FlowableFormServiceImpl implements FlowableFormService {
    @Autowired
    private FormRepositoryService formRepositoryService;
    @Autowired
    protected ModelService modelService;

    @Override
    public int publishForm(String formModelId) throws IOException {
        Model model = modelService.getModel(formModelId);

        publishPorcessAndSaveModel(model);
        return 1;
    }

    /**
     * 发布新的表单
     *
     * @return 无返回值
     * @throws IOException json解析异常
     */
    private void publishPorcessAndSaveModel(Model model) throws IOException {
        byte[] jsonXml = model.getModelEditorJson().getBytes("utf-8");
        String processName = model.getName() + ".form";
        FormDeployment formDeployment = formRepositoryService.createDeployment()
                .name(processName)
                .addFormBytes(processName, jsonXml)
                .deploy();
        FormDefinition formDefinition = formRepositoryService.createFormDefinitionQuery().deploymentId(formDeployment.getId()).singleResult();
        if (formDefinition == null) {
            throw new RuntimeException("表单发布失败");
        }
    }

    @Override
    public FormInfo getFormInfo(String formKey) {
        return formRepositoryService.getFormModelByKey(formKey);
    }
}
