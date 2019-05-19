package com.deer.wms.bill.manage.web;


import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@SuppressWarnings("ALL")
@Api(description = "首页接口")
@RestController
@RequestMapping("/mt/alone/homepage")
public class MtAloneHomePageController {

    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;

    @Autowired
    private MtAloneProductService productService;

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    //@OperateLog(description = "查询首页上面统计信息", type = "查询")
    //@ApiOperation(value = "查询首页上面统计信息", notes = "查询首页上面统计信息")
    //@GetMapping("/homePageAboveCount")
    //public Result homePageAboveCount() {
    //    MtAloneHomePageAboveDto homePageAboveDto = mtAloneProductDetService.findHomePageAboveCount();
    //    return ResultGenerator.genSuccessResult(homePageAboveDto);
    //}

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    //@OperateLog(description = "查询首页下面统计信息", type = "查询")
    //@ApiOperation(value = "查询首页下面统计信息", notes = "查询首页下面统计信息")
    //@GetMapping("/homePageBelowCount")
    //public Result homePageBelowCount(MtAloneHomePageCriteria criteria) {
    //    MtAloneHomePageBelowDto homePageBelowDto = mtAloneProductDetService.findHomePageBelowCount(criteria);
    //    return ResultGenerator.genSuccessResult(homePageBelowDto);
    //}
    //
    ///**弃用*/
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    //@OperateLog(description = "根据仓库id统计不同状态货位数", type = "查询")
    //@ApiOperation(value = "根据仓库id统计不同状态货位数", notes = "根据仓库id统计不同状态货位数")
    //@GetMapping("/countCellStateByWareCode")
    //public Result countCellStateByWareCode(MtAloneHomePageCriteria criteria) {
    //    MtAloneCellStateDto cellUtil = mtAloneProductDetService.findCountCellStateByWareCode(criteria);
    //    return ResultGenerator.genSuccessResult(cellUtil);
    //}

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据公司id统计不同状态货位数", type = "查询")
    @ApiOperation(value = "根据公司id统计不同状态货位数", notes = "根据公司id统计不同状态货位数")
    @GetMapping("/countCellStateByComId")
    public Result countCellStateByComId(MtAloneHomePageParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        MtAloneCellStateDto cellUtil = productService.findCountCellStateByComId(params);
        cellUtil.setCountNoStock(cellUtil.getSumCells() - cellUtil.getCountInStock());
        return ResultGenerator.genSuccessResult(cellUtil);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "查询首页上面统计信息", type = "查询")
    @ApiOperation(value = "查询首页上面统计信息", notes = "查询首页上面统计信息")
    @GetMapping("/homePageAboveCountNew")
    public Result homePageAboveCountNew(MtAloneHomePageParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());
        params.setCurrentDate(new Date());

        MtAloneHomePageAboveNewDto homePageAboveDto = mtAloneProductDetService.findHomePageAboveCountNew(params);
        return ResultGenerator.genSuccessResult(homePageAboveDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "查询首页下面统计信息", type = "查询")
    @ApiOperation(value = "查询首页下面统计信息", notes = "查询首页下面统计信息")
    @GetMapping("/homePageBelowCountNew")
    public Result homePageBelowCountNew(MtAloneHomePageParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());
        params.setCurrentDate(new Date());

        MtAloneHomePageBelowDto homePageBelowDto = mtAloneProductDetService.findHomePageBelowCountNew(params);
        return ResultGenerator.genSuccessResult(homePageBelowDto);
    }
}
