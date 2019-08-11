package com.deer.wms.bill.manage.web;

import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.MtAloneAuditRelatService;
import com.deer.wms.bill.manage.service.MtAloneDeliveryOrderService;
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
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private MtAloneDeliveryOrderService mtAloneDeliveryOrderService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "添加审核流程实例", type = "增加")
    @ApiOperation(value = "添加审核流程实例", notes = "添加审核流程实例")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAuditNodeTask mtAloneAuditNodeTask, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        mtAloneAuditNodeTask.setCreateTime(new Date());
        mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "启动审核流程", type = "增加")
    @ApiOperation(value = "启动审核流程", notes = "启动审核流程")
    @PostMapping("/startTask")
    public Result startTask(@RequestBody MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        params.setCompanyId(currentUser.getCompanyId());
        MtAloneAuditRelatParams relatParams = new MtAloneAuditRelatParams();
        relatParams.setAuditTaskId(params.getAuditTaskId());
        relatParams.setCompanyId(currentUser.getCompanyId());
        List<MtAloneAuditRelat> relatList = mtAloneAuditRelatService.findList(relatParams);

        MtAloneAuditNodeTask mtAloneAuditNodeTask = new MtAloneAuditNodeTask();
        mtAloneAuditNodeTask.setCreateTime(new Date());
        mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeTask.setAuditUrl(params.getAuditUrl());
        mtAloneAuditNodeTask.setIsAudit(0);
        mtAloneAuditNodeTask.setOperatorName(currentUser.getUserName());
        mtAloneAuditNodeTask.setOperatorId(currentUser.getUserId());
        mtAloneAuditNodeTask.setCurrentAuditNodeId(relatList.get(0).getId());
        mtAloneAuditNodeTask.setCurrentAuditNodeName(relatList.get(0).getAuditNodeName());
        mtAloneAuditNodeTask.setAuditTaskId(params.getAuditTaskId());
        mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);

//        MtAloneInboundOrderParams mtAloneInboundOrderParams = new MtAloneInboundOrderParams();
//        mtAloneInboundOrderParams.setAuditTaskId(params.getAuditTaskId());
//
//        MtAloneInboundOrder mtAloneInboundOrder = mtAloneInboundOrderService.findBy("auditTaskId",params.getAuditTaskId());
//        mtAloneInboundOrder.setRevieweState(0);
//        mtAloneInboundOrderService.update(mtAloneInboundOrder);
        mtAloneAuditNodeTaskService.updateOrder(params);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "删除审核流程实例", type = "删除")
    @ApiOperation(value = "删除审核流程实例", notes = "删除审核流程实例")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneAuditNodeTaskService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "修改审核流程实例", type = "更新")
    @ApiOperation(value = "修改审核流程实例", notes = "修改审核流程实例")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAuditNodeTask mtAloneAuditNodeTask) {
//        mtAloneAuditNodeTask.setUpdateTime(new Date());
        mtAloneAuditNodeTaskService.update(mtAloneAuditNodeTask);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "根据ID获取审核流程实例", type = "获取")
    @ApiOperation(value = "根据ID获取审核流程实例", notes = "根据ID获取审核流程实例")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAuditNodeTask mtAloneAuditNodeTask = mtAloneAuditNodeTaskService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAuditNodeTask);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "审核流程实例列表", type = "获取")
    @ApiOperation(value = "审核流程实例列表", notes = "审核流程实例列表")
    @GetMapping("/list")
    public Result list(MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }

        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
            params.setCompanyId(currentUser.getCompanyId());
        } else {
            params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditNodeTask> list = mtAloneAuditNodeTaskService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "根据用户ID获取待办/已办列表", type = "获取")
    @ApiOperation(value = "根据用户ID获取待办/已办列表", notes = "根据用户ID获取待办/已办列表")
    @GetMapping("/taskListByUserId")
    public Result backlogByUserId(MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditNodeTask> list = mtAloneAuditNodeTaskService.findBacklogByUserId(currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "根据用户ID获取已读/未读列表", type = "获取")
    @ApiOperation(value = "根据用户ID获取已读/未读列表", notes = "根据用户ID获取已读/未读列表")
    @GetMapping("/taskListReadByUserId")
    public Result taskListReadByUserId(MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditNodeTaskRead> list = mtAloneAuditNodeTaskService.findTasksReadByUserId(currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "根据用户ID获取待办数量", type = "获取")
    @ApiOperation(value = "根据用户ID获取待办数量", notes = "根据用户ID获取待办数量")
    @GetMapping("/backlogNumByUserId")
    public Result backlogNumByUserId(@ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        Integer backlogNum = mtAloneAuditNodeTaskService.findBacklogNumByUserId(currentUser);
        return ResultGenerator.genSuccessResult(backlogNum);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "审核流程流转", type = "更新")
    @ApiOperation(value = "审核流程流转", notes = "审核流程流转")
    @PostMapping("/updateTask")
    public Result updateTask(@RequestBody MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }

        params.setCompanyId(currentUser.getCompanyId());

        //获取入库单
        MtAloneInboundOrderParams mtAloneInboundOrderParams = new MtAloneInboundOrderParams();
        mtAloneInboundOrderParams.setAuditTaskId(params.getAuditTaskId());
        mtAloneInboundOrderParams.setCompanyId(currentUser.getCompanyId());
        MtAloneInboundOrder mtAloneInboundOrder = mtAloneInboundOrderService.findOrderByAuditTaskId(mtAloneInboundOrderParams);

        List<MtAloneAuditNodeTask> taskList = mtAloneAuditNodeTaskService.findList(params);
        MtAloneAuditNodeTask lastTask = taskList.get(taskList.size() - 1);
        Integer currentId = lastTask.getCurrentAuditNodeId();
        MtAloneAuditRelat currentRelat = mtAloneAuditRelatService.findById(currentId);
        MtAloneAuditRelat nextRelat = mtAloneAuditRelatService.findById(currentRelat.getNextNodeId());

        if (params.getIsPass() == 1) {
            lastTask.setIsAudit(1);
            lastTask.setAuditTime(new Date());
            lastTask.setReviewerId(currentUser.getUserId());
            mtAloneAuditNodeTaskService.update(lastTask);
            if (currentRelat.getNextNodeId() == 0) {
                mtAloneInboundOrder.setIsAuditTask(2);
                mtAloneInboundOrder.setRevieweState(1);
                mtAloneInboundOrderService.update(mtAloneInboundOrder);
            } else {
                //对当前节点进行插入一条记录
                MtAloneAuditNodeTask mtAloneAuditNodeTask = new MtAloneAuditNodeTask();
                mtAloneAuditNodeTask.setIsAudit(0);
                mtAloneAuditNodeTask.setCurrentAuditNodeName(nextRelat.getAuditNodeName());
                mtAloneAuditNodeTask.setCurrentAuditNodeId(nextRelat.getId());
                mtAloneAuditNodeTask.setAuditTaskId(params.getAuditTaskId());
                mtAloneAuditNodeTask.setAuditTaskName(taskList.get(0).getAuditTaskName());
                mtAloneAuditNodeTask.setCreateTime(new Date());
                mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
                mtAloneAuditNodeTask.setAuditUrl(taskList.get(0).getAuditUrl());
                mtAloneAuditNodeTask.setOperatorName(lastTask.getOperatorName());
                mtAloneAuditNodeTask.setOperatorId(lastTask.getOperatorId());

                mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);
            }

        } else if (params.getIsPass() == 0) {
            if (currentRelat.getPrevNodeId() == 0) {
                mtAloneInboundOrder.setRevieweState(2);
                mtAloneInboundOrderService.update(mtAloneInboundOrder);
            } else {
                MtAloneAuditNodeTaskParams prevParams = new MtAloneAuditNodeTaskParams();
                prevParams.setAuditTaskId(params.getAuditTaskId());
                prevParams.setCurrentId(currentRelat.getPrevNodeId());
                MtAloneAuditNodeTask preNodeTask = mtAloneAuditNodeTaskService.findByTaskIdAndCurrentId(prevParams);
                preNodeTask.setIsAudit(0);
                preNodeTask.setAuditTime(null);
                preNodeTask.setReviewerId(null);
                mtAloneAuditNodeTaskService.updateTem(preNodeTask);
            }
            mtAloneAuditNodeTaskService.deleteById(taskList.get(taskList.size() - 1).getId());
        }

        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "审核流程流转(出库单)", type = "更新")
    @ApiOperation(value = "审核流程流转(出库单)", notes = "审核流程流转(出库单)")
    @PostMapping("/updateTask/outboundOrder")
    public Result updateTaskOutboundOrder(@RequestBody MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
        }
        params.setCompanyId(currentUser.getCompanyId());
        //获取出库单
        MtAloneDeliveryOrderParams mtAloneOutboundOrderParams = new MtAloneDeliveryOrderParams();
        mtAloneOutboundOrderParams.setAuditTaskId(params.getAuditTaskId());
        mtAloneOutboundOrderParams.setCompanyId(currentUser.getCompanyId());
        MtAloneDeliveryOrder mtAloneOutboundOrder = mtAloneDeliveryOrderService.findOrderByAuditTaskId(mtAloneOutboundOrderParams);

        List<MtAloneAuditNodeTask> taskList = mtAloneAuditNodeTaskService.findList(params);
        MtAloneAuditNodeTask lastTask = taskList.get(taskList.size() - 1);
        Integer currentId = lastTask.getCurrentAuditNodeId();
        MtAloneAuditRelat currentRelat = mtAloneAuditRelatService.findById(currentId);
        MtAloneAuditRelat nextRelat = mtAloneAuditRelatService.findById(currentRelat.getNextNodeId());

        if (params.getIsPass() == 1) {
            lastTask.setIsAudit(1);
            lastTask.setAuditTime(new Date());
            lastTask.setReviewerId(currentUser.getUserId());
            mtAloneAuditNodeTaskService.update(lastTask);
            if (currentRelat.getNextNodeId() == 0) {
                mtAloneOutboundOrder.setIsAuditTask(2);
                mtAloneOutboundOrder.setRevieweState(1);
                mtAloneDeliveryOrderService.update(mtAloneOutboundOrder);
            } else {
                //对当前节点进行插入一条记录
                MtAloneAuditNodeTask mtAloneAuditNodeTask = new MtAloneAuditNodeTask();
                mtAloneAuditNodeTask.setIsAudit(0);
                mtAloneAuditNodeTask.setCurrentAuditNodeName(nextRelat.getAuditNodeName());
                mtAloneAuditNodeTask.setCurrentAuditNodeId(nextRelat.getId());
                mtAloneAuditNodeTask.setAuditTaskId(params.getAuditTaskId());
                mtAloneAuditNodeTask.setAuditTaskName(taskList.get(0).getAuditTaskName());
                mtAloneAuditNodeTask.setCreateTime(new Date());
                mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
                mtAloneAuditNodeTask.setAuditUrl(taskList.get(0).getAuditUrl());
                mtAloneAuditNodeTask.setOperatorName(lastTask.getOperatorName());
                mtAloneAuditNodeTask.setOperatorId(lastTask.getOperatorId());

                mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);
            }

        } else if (params.getIsPass() == 0) {
            if (currentRelat.getPrevNodeId() == 0) {
                mtAloneOutboundOrder.setRevieweState(2);
                mtAloneDeliveryOrderService.update(mtAloneOutboundOrder);
            } else {
                MtAloneAuditNodeTaskParams prevParams = new MtAloneAuditNodeTaskParams();
                prevParams.setAuditTaskId(params.getAuditTaskId());
                prevParams.setCurrentId(currentRelat.getPrevNodeId());
                MtAloneAuditNodeTask preNodeTask = mtAloneAuditNodeTaskService.findByTaskIdAndCurrentId(prevParams);
                preNodeTask.setIsAudit(0);
                preNodeTask.setAuditTime(null);
                preNodeTask.setReviewerId(null);
                mtAloneAuditNodeTaskService.updateTem(preNodeTask);
            }
            mtAloneAuditNodeTaskService.deleteById(taskList.get(taskList.size() - 1).getId());
        }

        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "根据实例id获取任务列表", type = "查询")
    @ApiOperation(value = "根据实例id获取任务列表", notes = "根据实例id获取任务列表")
    @GetMapping("/list/auditTaskId")
    public Result listByAuditTaskId(MtAloneAuditNodeTaskParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
        }
        params.setCompanyId(currentUser.getCompanyId());
        List<MtAloneAuditNodeTask> list = mtAloneAuditNodeTaskService.listByAuditTaskId(params.getAuditTaskId());
        return ResultGenerator.genSuccessResult(list);
    }
}
