package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneAuditTask;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskParams;
import com.deer.wms.bill.manage.service.MtAloneAuditTaskService;
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
@Api(description = "审核业务接口")
@RestController
@RequestMapping("/mt/alone/audit/tasks")
public class MtAloneAuditTaskController {

    @Autowired
    private MtAloneAuditTaskService mtAloneAuditTaskService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加审核业务", type = "增加")
    @ApiOperation(value = "添加审核业务", notes = "添加审核业务")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAuditTask mtAloneAuditTask, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneAuditTask.setCreateTime(new Date());
		 mtAloneAuditTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditTaskService.save(mtAloneAuditTask);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除审核业务", type = "删除")
    @ApiOperation(value = "删除审核业务", notes = "删除审核业务")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneAuditTaskService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改审核业务", type = "更新")
    @ApiOperation(value = "修改审核业务", notes = "修改审核业务")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAuditTask mtAloneAuditTask) {
//        mtAloneAuditTask.setUpdateTime(new Date());
        mtAloneAuditTaskService.update(mtAloneAuditTask);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取审核业务", type = "获取")
    @ApiOperation(value = "根据ID获取审核业务", notes = "根据ID获取审核业务")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAuditTask mtAloneAuditTask = mtAloneAuditTaskService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAuditTask);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "审核业务列表", type = "获取")
    @ApiOperation(value = "审核业务列表", notes = "审核业务列表")
    @GetMapping("/list")
    public Result list(MtAloneAuditTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditTask> list = mtAloneAuditTaskService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
