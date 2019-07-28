package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTab;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabParams;
import com.deer.wms.bill.manage.service.MtAloneAuditNodeOpinionTabService;
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
@Api(description = "审核意见接口")
@RestController
@RequestMapping("/mt/alone/audit/node/opinion/tabs")
public class MtAloneAuditNodeOpinionTabController {

    @Autowired
    private MtAloneAuditNodeOpinionTabService mtAloneAuditNodeOpinionTabService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加审核意见", type = "增加")
    @ApiOperation(value = "添加审核意见", notes = "添加审核意见")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAuditNodeOpinionTab mtAloneAuditNodeOpinionTab, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneAuditNodeOpinionTab.setCreateTime(new Date());
		 mtAloneAuditNodeOpinionTab.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeOpinionTabService.save(mtAloneAuditNodeOpinionTab);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除审核意见", type = "删除")
    @ApiOperation(value = "删除审核意见", notes = "删除审核意见")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneAuditNodeOpinionTabService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改审核意见", type = "更新")
    @ApiOperation(value = "修改审核意见", notes = "修改审核意见")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAuditNodeOpinionTab mtAloneAuditNodeOpinionTab) {
//        mtAloneAuditNodeOpinionTab.setUpdateTime(new Date());
        mtAloneAuditNodeOpinionTabService.update(mtAloneAuditNodeOpinionTab);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取审核意见", type = "获取")
    @ApiOperation(value = "根据ID获取审核意见", notes = "根据ID获取审核意见")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAuditNodeOpinionTab mtAloneAuditNodeOpinionTab = mtAloneAuditNodeOpinionTabService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAuditNodeOpinionTab);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据taskId获取审核意见列表", type = "获取")
    @ApiOperation(value = "根据taskId获取审核意见列表", notes = "根据taskId获取审核意见列表")
    @GetMapping("/list")
    public Result list(MtAloneAuditNodeOpinionTabParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditNodeOpinionTab> list = mtAloneAuditNodeOpinionTabService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
