package com.deer.wms.workflow.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.workflow.service.BpmnModelService;
import com.deer.wms.workflow.service.FlowableFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.flowable.form.api.FormInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/workflow/form")
@Api(tags = "表单模板发布", value = "表单模板发布")
public class FlowableFormController {
    @Autowired
    @Qualifier(value = "flowableFormServiceImpl")
    private FlowableFormService flowableFormService;

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    @ApiOperation(value = "发布表单", notes = "发布表单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "modelId", paramType = "query", dataType = "String", value = "模板ID"),
    })
    public Result publishModel(String modelId) throws IOException {
        int resultCode = flowableFormService.publishForm(modelId);
        if (resultCode > 0) {
            return new Result<>().setMessage("发布成功");
        }
        return new Result<>().setMessage("发布失败");
    }

    @RequestMapping(value = "/getFormModel", method = RequestMethod.GET)
    @ApiOperation(value = "获取单个表单模板", notes = "获取单个表单模板")
    public Result getFormModel(String formKey) throws IOException {
        FormInfo formInfo = flowableFormService.getFormInfo(formKey);
        if (formInfo != null) {
            return new Result<>().setData(formInfo.getFormModel());
        }
        return new Result<>().setMessage("表单不存在");
    }
}