package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatMb;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatMbParams;
import com.deer.wms.bill.manage.service.MtAloneAuditRelatMbService;
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
@Api(description = "审核业务模板-关联节点模板接口")
@RestController
@RequestMapping("/mt/alone/audit/relat/mbs")
public class MtAloneAuditRelatMbController {

    @Autowired
    private MtAloneAuditRelatMbService mtAloneAuditRelatMbService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加关联节点模板", type = "增加")
    @ApiOperation(value = "添加关联节点模板", notes = "添加关联节点模板")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAuditRelatMb mtAloneAuditRelatMb, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneAuditRelatMb.setCreateTime(new Date());
		 mtAloneAuditRelatMb.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditRelatMbService.save(mtAloneAuditRelatMb);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除关联节点模板", type = "删除")
    @ApiOperation(value = "删除关联节点模板", notes = "删除关联节点模板")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneAuditRelatMbService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改关联节点模板", type = "更新")
    @ApiOperation(value = "修改关联节点模板", notes = "修改关联节点模板")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAuditRelatMb mtAloneAuditRelatMb) {
//        mtAloneAuditRelatMb.setUpdateTime(new Date());
        mtAloneAuditRelatMbService.update(mtAloneAuditRelatMb);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取关联节点模板", type = "获取")
    @ApiOperation(value = "根据ID获取关联节点模板", notes = "根据ID获取关联节点模板")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAuditRelatMb mtAloneAuditRelatMb = mtAloneAuditRelatMbService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAuditRelatMb);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据业务模板ID获取关联节点模板列表", type = "获取")
    @ApiOperation(value = "根据业务模板ID获取关联节点模板列表", notes = "根据业务模板ID获取关联节点模板列表")
    @GetMapping("/list")
    public Result list(MtAloneAuditRelatMbParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditRelatMb> list = mtAloneAuditRelatMbService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
