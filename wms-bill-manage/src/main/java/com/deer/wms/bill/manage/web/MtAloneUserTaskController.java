package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneUserTask;
import com.deer.wms.bill.manage.model.MtAloneUserTaskParams;
import com.deer.wms.bill.manage.service.MtAloneUserTaskService;
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
* Created by gtt on 2019/08/11.
*/
@Api(description = "任务流程实例已读/未读接口")
@RestController
@RequestMapping("/mt/alone/user/tasks")
public class MtAloneUserTaskController {

    @Autowired
    private MtAloneUserTaskService mtAloneUserTaskService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "添加已读流程实例", type = "增加")
    @ApiOperation(value = "添加已读流程实例", notes = "添加已读流程实例")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneUserTask mtAloneUserTask, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneUserTask.setCreateTime(new Date());
        mtAloneUserTask.setUserId(currentUser.getUserId());
        mtAloneUserTaskService.save(mtAloneUserTask);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "删除已读流程实例", type = "删除")
    @ApiOperation(value = "删除已读流程实例", notes = "删除已读流程实例")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer mtAloneUserTaskId) {
        mtAloneUserTaskService.deleteById(mtAloneUserTaskId);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "修改已读流程实例", type = "更新")
    @ApiOperation(value = "修改已读流程实例", notes = "修改已读流程实例")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneUserTask mtAloneUserTask) {
        mtAloneUserTaskService.update(mtAloneUserTask);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneUserTask mtAloneUserTask = mtAloneUserTaskService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneUserTask);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @GetMapping("/list")
    public Result list(MtAloneUserTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneUserTask> list = mtAloneUserTaskService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
