package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;
import com.deer.wms.bill.manage.service.MtAloneAuditNodeTaskService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List; 



/**
* Created by gtt on 2019/07/18.
*/
@Api(description = "审核流程实例接口")
@RestController
@RequestMapping("/mt/alone/audit/node/tasks")
public class MtAloneAuditNodeTaskController {

    @Autowired
    private MtAloneAuditNodeTaskService mtAloneAuditNodeTaskService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加审核流程实例", type = "增加")
    @ApiOperation(value = "添加审核流程实例", notes = "添加审核流程实例")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAuditNodeTask mtAloneAuditNodeTask, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneAuditNodeTask.setCreateTime(new Date());
		 mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除审核流程实例", type = "删除")
    @ApiOperation(value = "删除审核流程实例", notes = "删除审核流程实例")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneAuditNodeTaskService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改审核流程实例", type = "更新")
    @ApiOperation(value = "修改审核流程实例", notes = "修改审核流程实例")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAuditNodeTask mtAloneAuditNodeTask) {
//        mtAloneAuditNodeTask.setUpdateTime(new Date());
        mtAloneAuditNodeTaskService.update(mtAloneAuditNodeTask);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取审核流程实例", type = "获取")
    @ApiOperation(value = "根据ID获取审核流程实例", notes = "根据ID获取审核流程实例")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAuditNodeTask mtAloneAuditNodeTask = mtAloneAuditNodeTaskService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAuditNodeTask);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "审核流程实例列表", type = "获取")
    @ApiOperation(value = "审核流程实例列表", notes = "审核流程实例列表")
    @GetMapping("/list")
    public Result list(MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditNodeTask> list = mtAloneAuditNodeTaskService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
