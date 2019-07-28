package com.deer.wms.bill.manage.web;

import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.MtAloneAuditRelatService;
import com.deer.wms.bill.manage.service.MtAloneInboundOrderService;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
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

import java.util.ArrayList;
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
    @Autowired
    private MtAloneAuditRelatService mtAloneAuditRelatService;
    @Autowired
    private MtAloneInboundOrderService mtAloneInboundOrderService;
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
    @OperateLog(description = "启动审核流程", type = "增加")
    @ApiOperation(value = "启动审核流程", notes = "启动审核流程")
    @PostMapping("/startTask")
    public Result startTask(@RequestBody MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        MtAloneAuditRelatParams relatParams=new MtAloneAuditRelatParams();
        relatParams.setAuditTaskId(params.getAuditTaskId());
        List<MtAloneAuditRelat>relatList=mtAloneAuditRelatService.findList(relatParams);

        MtAloneAuditNodeTask mtAloneAuditNodeTask=new MtAloneAuditNodeTask();
        mtAloneAuditNodeTask.setCreateTime(new Date());
        mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeTask.setAuditUrl(params.getAuditUrl());
        mtAloneAuditNodeTask.setIsAudit(0);
        mtAloneAuditNodeTask.setOperatorId(currentUser.getUserId());
        mtAloneAuditNodeTask.setCurrentAuditNodeId(relatList.get(0).getId());
        mtAloneAuditNodeTask.setCurrentAuditNodeName(relatList.get(0).getAuditNodeName());
        mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);

        MtAloneInboundOrderParams mtAloneInboundOrderParams=new MtAloneInboundOrderParams();
        mtAloneInboundOrderParams.setAuditTaskId(params.getAuditTaskId());
        MtAloneInboundOrder mtAloneInboundOrder=mtAloneInboundOrderService.findOrderByAuditTaskId(mtAloneInboundOrderParams);
        mtAloneInboundOrder.setRevieweState(0);
        mtAloneInboundOrderService.update(mtAloneInboundOrder);
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

//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
//    @OperateLog(description = "审核流程流转", type = "更新")
//    @ApiOperation(value = "审核流程流转", notes = "审核流程流转")
//    @PostMapping("/updateTask")
//    public Result updateTask(MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
//        if(currentUser==null){
//            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
//        }
//
//        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
//            params.setCompanyId(currentUser.getCompanyId());
//        }else{
//            params.setCompanyId(null);
//        }
//
//        MtAloneAuditRelatParams relatParams=new MtAloneAuditRelatParams();
//        relatParams.setAuditTaskId(params.getAuditTaskId());
//        List<MtAloneAuditRelat>relatList=mtAloneAuditRelatService.findList(relatParams);
//        List<MtAloneAuditNodeTask>taskList=mtAloneAuditNodeTaskService.findList(params);
//        MtAloneInboundOrderParams orderParams=new MtAloneInboundOrderParams();
//        orderParams.setAuditTaskId(params.getAuditTaskId());
//        MtAloneInboundOrder mtAloneInboundOrder = mtAloneInboundOrderService.findOrderByAuditTaskId(orderParams);
//        if(params.getNodeOrderNow()==1&&taskList.size()==1){
//            taskList.get(0).setCurrentAuditNodeId(relatList.get(0).getId());
//            taskList.get(0).setCurrentAuditNodeName(relatList.get(0).getAuditNodeName());
//            taskList.get(0).setIsAudit(0);
//            mtAloneAuditNodeTaskService.update(taskList.get(0));
//        }
//        else if(params.getIsAudit()==1){
//            taskList.get(taskList.size()-1).setIsAudit(1);
//            taskList.get(taskList.size()-1).setAuditTime(new Date());
//            taskList.get(taskList.size()-1).setReviewerId(currentUser.getUserId());
//            mtAloneAuditNodeTaskService.update(taskList.get(taskList.size()-1));
//            mtAloneInboundOrder.setIsAuditTask(2);
//            mtAloneInboundOrderService.update(mtAloneInboundOrder);
//        }else {
//            //删除该节点后的那条记录，这一步有可能是回退的
//            if(params.getNodeOrderNow()<taskList.size()){
//                mtAloneAuditNodeTaskService.deleteById(taskList.get(taskList.size()-1).getId());
//                taskList.get(params.getNodeOrderNow()-1).setIsAudit(0);
//                taskList.get(params.getNodeOrderNow()-1).setReviewerId(0);
//                taskList.get(params.getNodeOrderNow()-1).setAuditTime(null);
//                mtAloneAuditNodeTaskService.update(taskList.get(params.getNodeOrderNow()-1));
//            }else {
//                //将上个节点的状态更新，变为审核通过
//                taskList.get(params.getNodeOrderNow()-2).setIsAudit(1);
//                taskList.get(params.getNodeOrderNow()-2).setAuditTime(new Date());
//                taskList.get(params.getNodeOrderNow()-2).setReviewerId(currentUser.getUserId());
//                mtAloneAuditNodeTaskService.update(taskList.get(params.getNodeOrderNow()-2));
//
//                //对当前节点进行插入一条记录
//                MtAloneAuditNodeTask mtAloneAuditNodeTask=new MtAloneAuditNodeTask();
//                mtAloneAuditNodeTask.setIsAudit(0);
//                mtAloneAuditNodeTask.setCurrentAuditNodeName(relatList.get(params.getNodeOrderNow()-1).getAuditNodeName());
//                mtAloneAuditNodeTask.setCurrentAuditNodeId(relatList.get(params.getNodeOrderNow()-1).getId());
//                mtAloneAuditNodeTask.setAuditTaskId(taskList.get(0).getAuditTaskId());
//                mtAloneAuditNodeTask.setAuditTaskName(taskList.get(0).getAuditTaskName());
//                mtAloneAuditNodeTask.setCreateTime(new Date());
//                mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
//                mtAloneAuditNodeTask.setOperatorId(currentUser.getUserId());
//                mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);
//            }
//
//        }
//        return ResultGenerator.genSuccessResult();
//    }

}
