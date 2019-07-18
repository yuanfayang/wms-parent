package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneInboundProductRelat;
import com.deer.wms.bill.manage.model.MtAloneInboundProductRelatParams;
import com.deer.wms.bill.manage.service.MtAloneInboundProductRelatService;
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
@Api(description = "产品跟入库单关联接口")
@RestController
@RequestMapping("/mt/alone/inbound/product/relats")
public class MtAloneInboundProductRelatController {

    @Autowired
    private MtAloneInboundProductRelatService mtAloneInboundProductRelatService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加产品跟入库单关联", type = "增加")
    @ApiOperation(value = "添加产品跟入库单关联", notes = "添加产品跟入库单关联")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneInboundProductRelat mtAloneInboundProductRelat, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneInboundProductRelat.setCreateTime(new Date());
		 mtAloneInboundProductRelat.setCompanyId(currentUser.getCompanyId());
        mtAloneInboundProductRelatService.save(mtAloneInboundProductRelat);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除产品跟入库单关联", type = "删除")
    @ApiOperation(value = "删除产品跟入库单关联", notes = "删除产品跟入库单关联")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneInboundProductRelatService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改产品跟入库单关联", type = "更新")
    @ApiOperation(value = "修改产品跟入库单关联", notes = "修改产品跟入库单关联")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneInboundProductRelat mtAloneInboundProductRelat) {
        mtAloneInboundProductRelat.setUpdateTime(new Date());
        mtAloneInboundProductRelatService.update(mtAloneInboundProductRelat);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取审核业务模板", type = "获取")
    @ApiOperation(value = "根据ID获取产品跟入库单关联", notes = "根据ID获取产品跟入库单关联")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneInboundProductRelat mtAloneInboundProductRelat = mtAloneInboundProductRelatService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneInboundProductRelat);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "产品跟入库单关联列表", type = "获取")
    @ApiOperation(value = "产品跟入库单关联列表", notes = "产品跟入库单关联列表")
    @GetMapping("/list")
    public Result list(MtAloneInboundProductRelatParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneInboundProductRelat> list = mtAloneInboundProductRelatService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
