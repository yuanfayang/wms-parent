package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneObjAccessory;
import com.deer.wms.detect.model.MtAloneObjAccessoryParams;
import com.deer.wms.detect.service.MtAloneObjAccessoryService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

/**
* Created by guotuanting on 2019/04/13.
*/
@Api(description = "附件关联表接口")
@RestController
@RequestMapping("/mt/alone/obj/accessorys")
public class MtAloneObjAccessoryController {

    @Autowired
    private MtAloneObjAccessoryService mtAloneObjAccessoryService;

    @OperateLog(description = "添加附件关联表", type = "增加")
    @ApiOperation(value = "添加附件关联表", notes = "添加附件关联表")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneObjAccessory mtAloneObjAccessory, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneObjAccessoryService.save(mtAloneObjAccessory);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除附件关联表", type = "删除")
    @ApiOperation(value = "删除附件关联表", notes = "删除附件关联表")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer mtAloneObjAccessoryId) {
        mtAloneObjAccessoryService.deleteById(mtAloneObjAccessoryId);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改附件关联表", type = "更新")
    @ApiOperation(value = "修改附件关联表", notes = "修改附件关联表")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneObjAccessory mtAloneObjAccessory) {
        mtAloneObjAccessoryService.update(mtAloneObjAccessory);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneObjAccessory mtAloneObjAccessory = mtAloneObjAccessoryService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneObjAccessory);
    }

    @GetMapping("/list")
    public Result list(MtAloneObjAccessoryParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneObjAccessory> list = mtAloneObjAccessoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
