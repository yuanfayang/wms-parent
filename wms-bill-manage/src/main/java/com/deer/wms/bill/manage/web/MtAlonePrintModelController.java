package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.StringUtil;
import com.deer.wms.bill.manage.model.MtAlonePrintModel;
import com.deer.wms.bill.manage.model.MtAlonePrintModelParams;
import com.deer.wms.bill.manage.service.MtAlonePrintModelService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by on 2019/02/21.
 */
@Api(description = "打印模板表api接口")
@RestController
@RequestMapping("/mt/alone/print/models")
public class MtAlonePrintModelController {

	@Autowired
	private MtAlonePrintModelService mtAlonePrintModelService;

	@PostMapping("/add")
    public Result add(@RequestBody MtAlonePrintModel mtAlonePrintModel, @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        Integer companyId  = currentUser.getCompanyId();
        mtAlonePrintModel.setCompanyId(companyId);
    	mtAlonePrintModel.setCreateTime(new Date());
    	mtAlonePrintModel.setUpdateTime(new Date());
        mtAlonePrintModelService.save(mtAlonePrintModel);
        return ResultGenerator.genSuccessResult();
    }

	@GetMapping("/delete")
	public Result delete(Integer mtAlonePrintModelId) {
		mtAlonePrintModelService.deleteById(mtAlonePrintModelId);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody MtAlonePrintModel mtAlonePrintModel) {
		mtAlonePrintModelService.update(mtAlonePrintModel);
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/{id}")
	public Result detail(@PathVariable Integer id) {
		MtAlonePrintModel mtAlonePrintModel = mtAlonePrintModelService.findById(id);
		return ResultGenerator.genSuccessResult(mtAlonePrintModel);
	}

	@GetMapping("/list")
	public Result list(MtAlonePrintModelParams params,@User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<MtAlonePrintModel> list = mtAlonePrintModelService.findList(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}
