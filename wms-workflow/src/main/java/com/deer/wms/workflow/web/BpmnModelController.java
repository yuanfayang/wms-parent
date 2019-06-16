package com.deer.wms.workflow.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.workflow.service.BpmnModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/workflow/model")
@Api(tags = "流程模板发布", value = "流程模板")
public class BpmnModelController {


    @Autowired
    @Qualifier(value = "bpmnModelServiceImpl")
    private BpmnModelService bpmnModelService;

    @RequestMapping(value = "/publishModel", method = RequestMethod.GET)
    @ApiOperation(value = "发布流程", notes = "发布流程")

    public Result publishModel(String modelId) throws IOException {
        int resultCode = bpmnModelService.publishModel(modelId);
        if (resultCode > 0) {
            return new Result<>().setMessage("发布成功");
        }
        return new Result<>().setMessage("发布失败");
    }
}