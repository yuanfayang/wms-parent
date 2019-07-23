package com.deer.wms.bill.manage.web;

import com.deer.wms.bill.manage.constant.BillManageConstant;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.*;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
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
@Api(description = "入库单接口")
@RestController
@RequestMapping("/mt/alone/inbound/orders")
public class MtAloneInboundOrderController {

    @Autowired
    private MtAloneInboundOrderService mtAloneInboundOrderService;
    @Autowired
    private MtAloneAuditRelatMbService mtAloneAuditRelatMbService;
    @Autowired
    private MtAloneAuditRelatService mtAloneAuditRelatService;
    @Autowired
    private MtAloneAuditTaskMbService mtAloneAuditTaskMbService;
    @Autowired
    private MtAloneAuditTaskService mtAloneAuditTaskService;
    @Autowired
    private MtAloneAuditNodeTaskService mtAloneAuditNodeTaskService;
    @Autowired
    private MtAloneProductService mtAloneProductService;
    @Autowired
    private MtAloneBarcodeService mtAloneBarcodeService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加入库单", type = "增加")
    @ApiOperation(value = "添加入库单", notes = "添加入库单")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneInBoundOrderProVO mtAloneInBoundOrderProVO, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        //---------------------生成审核业务模板实例-----------------------------
        MtAloneAuditTaskMb mtAloneAuditTaskMb=mtAloneAuditTaskMbService.findById(BillManageConstant.INBOUND_TASK_MB_ID);
        MtAloneAuditTask mtAloneAuditTask=new MtAloneAuditTask();
        mtAloneAuditTask.setAuditTaskMbId(BillManageConstant.INBOUND_TASK_MB_ID);
        mtAloneAuditTask.setAuditTaskName(mtAloneAuditTaskMb.getAuditTaskName());
        mtAloneAuditTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditTask.setCreateTime(new Date());
        mtAloneAuditTask.setIsTaskCompleted(0);
        mtAloneAuditTaskService.save(mtAloneAuditTask);
        //-------------------生成审核业务节点模板实例----------------------------
        MtAloneAuditRelatMbParams params=new MtAloneAuditRelatMbParams();
        params.setCompanyId(currentUser.getCompanyId());
        params.setAuditTaskMBId(BillManageConstant.INBOUND_TASK_MB_ID);
        List<MtAloneAuditRelatMb> relatListMb=mtAloneAuditRelatMbService.findList(params);
        List<MtAloneAuditRelat> relatList=new ArrayList<MtAloneAuditRelat>();

        Integer maxId=mtAloneAuditRelatService.findMaxId();
        for(int i=0;i<relatListMb.size();i++){
            maxId=maxId+1;
            MtAloneAuditRelat relat=new MtAloneAuditRelat();
            BeanUtils.copyProperties(relatListMb.get(i), relat);
            if(i==0&&relatListMb.size()>1){
                relat.setPrevNodeId(0);
                relat.setNextNodeId(maxId+1);
            }
            else if(i==relatListMb.size()-1&&relatListMb.size()>1){
                relat.setPrevNodeId(maxId-1);
                relat.setNextNodeId(0);
            }
            else if(relatListMb.size()==1){
                relat.setPrevNodeId(0);
                relat.setNextNodeId(0);
            }else{
                relat.setPrevNodeId(maxId-1);
                relat.setNextNodeId(maxId+1);
            }
            relat.setAuditTaskId(mtAloneAuditTask.getId());
            relat.setId(maxId);
            relat.setNodeOrder(i+1);
            relatList.add(relat);
        }
        mtAloneAuditRelatService.save(relatList);
        //-------------------生成审核业务流程实例--------------------------------
        MtAloneAuditNodeTask mtAloneAuditNodeTask=new MtAloneAuditNodeTask();
        mtAloneAuditNodeTask.setAuditTaskId(mtAloneAuditTask.getId());
        mtAloneAuditNodeTask.setAuditTaskName(mtAloneAuditTask.getAuditTaskName());
        mtAloneAuditNodeTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeTask.setCreateTime(new Date());
        mtAloneAuditNodeTaskService.save(mtAloneAuditNodeTask);
        //-------------------生成入库单,保存相应产品------------------------------
        MtAloneInboundOrder mtAloneInboundOrder=new MtAloneInboundOrder();
        BeanUtils.copyProperties(mtAloneInBoundOrderProVO, mtAloneInboundOrder);
        mtAloneInboundOrder.setCreateTime(new Date());
        mtAloneInboundOrder.setCompanyId(currentUser.getCompanyId());
        mtAloneInboundOrder.setAuditTaskId(mtAloneAuditTask.getId());
        mtAloneInboundOrder.setInboundOrderCode(BillManagePublicMethod.creatInBoundOrderCode());
        mtAloneInboundOrderService.save(mtAloneInboundOrder);

        String maxBarcode = mtAloneBarcodeService.getMaxBarcode();
        List<MtAloneBarcode> barCodeList=new ArrayList<MtAloneBarcode>();
        for(int i=0;i<mtAloneInBoundOrderProVO.getProList().size();i++){
            mtAloneInBoundOrderProVO.getProList().get(i).setInboundOrderCode(BillManagePublicMethod.creatInBoundOrderCode());
            String productBarcode = BillManagePublicMethod.creatBarCode(maxBarcode);
            mtAloneInBoundOrderProVO.getProList().get(i).setProductBarCode(productBarcode);
            maxBarcode=productBarcode;

            MtAloneBarcode mtAloneBarcode = new MtAloneBarcode();
            mtAloneBarcode.setBarcode(maxBarcode);
            barCodeList.add(mtAloneBarcode);
        }
        mtAloneBarcodeService.save(barCodeList);
        mtAloneProductService.save(mtAloneInBoundOrderProVO.getProList());

        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除入库单", type = "删除")
    @ApiOperation(value = "删除入库单", notes = "删除入库单")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneInboundOrderService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改入库单", type = "更新")
    @ApiOperation(value = "修改入库单", notes = "修改入库单")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneInboundOrder mtAloneInboundOrder) {
        mtAloneInboundOrder.setUpdateTime(new Date());
        mtAloneInboundOrderService.update(mtAloneInboundOrder);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取入库单", type = "获取")
    @ApiOperation(value = "根据ID获取入库单", notes = "根据ID获取入库单")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneInboundOrder mtAloneInboundOrder = mtAloneInboundOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneInboundOrder);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "入库单及相应产品列表", type = "获取")
    @ApiOperation(value = "入库单及相应产品列表", notes = "入库单及相应产品列表")
    @GetMapping("/list")
    public Result list(MtAloneInboundOrderParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneInboundOrder> list = mtAloneInboundOrderService.findOrderProList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
