package com.deer.wms.base.system.web;
import com.deer.wms.base.system.constant.BaseSystemConstant;
import com.deer.wms.base.system.model.UnitParams;
import com.deer.wms.base.system.model.WareInfoCriteria;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.base.system.model.Unit;
import com.deer.wms.base.system.model.UnitCriteria;
import com.deer.wms.base.system.service.UnitService;
import com.deer.wms.project.seed.util.RandomNo;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
* Created by  on 2018/06/29.
*/
@Api(description = "单位管理接口")
@RestController
@RequestMapping("/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/insert")
    @ApiOperation(value="添加单位信息",notes="添加单位信息")
    public Result add(@RequestBody Unit unit,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        Integer companyId = currentUser.getCompanyId();
        unit.setCompanyId(companyId);

        String unitCode ="DW" + companyId +RandomNo.createTimeString().substring(2,14);
        unit.setUnitCode(unitCode);
        unitService.save(unit);
        return ResultGenerator.genSuccessResult();
    }


    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/delete")
    //@ApiOperation(value="删除单位信息",notes="删除单位信息")
    //public Result delete( String unitCode,@ApiIgnore @User CurrentUser currentUser ) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    Integer companyId ;
    //    UnitCriteria criteria = new UnitCriteria();
    //    criteria.setUnitCode(unitCode);
    //    if(currentUser.getCompanyType() != -1){
    //        companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    unitService.deleteByCodeAndCom(criteria);
    //    return ResultGenerator.genSuccessResult();
    //}

    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "unitId", value = "单位id", paramType="path", dataType="Integer", required = true)
    })
    @DeleteMapping("/delete/{unitId}")
    @ApiOperation(value="删除单位信息",notes="删除单位信息")
    @OperateLog(description = "删除单位", type = "删除")
    public Result delete( @PathVariable Integer unitId, @ApiIgnore @User CurrentUser currentUser ) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        UnitParams params = new UnitParams();
        params.setCompanyId(currentUser.getCompanyId());
        params.setUnitId(unitId);

        Integer countRelProducts =  unitService.countRelProducts(params);//统计关联产品数
        if(countRelProducts!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该单位已被货物关联，无法删除！",null);
        }

        unitService.deleteByIdAndCom(params);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/update")
    @ApiOperation(value="更新单位信息",notes="更新单位信息")
    public Result update(@RequestBody Unit unit, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        Integer companyId = currentUser.getCompanyId();
        unit.setCompanyId(companyId);
        unitService.update(unit);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    @ApiOperation(value="单个单位查询",notes="单个单位查询")
    public Result detail( Integer id) {
        Unit unit = unitService.findById(id);
        return ResultGenerator.genSuccessResult(unit);
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/list")
    //@ApiOperation(value="单位查询列表",notes="单位查询列表")
    //public Result list(UnitCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    if(currentUser.getCompanyType() != -1){
    //        Integer companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<Unit> list = unitService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/list")
    @ApiOperation(value="单位查询列表",notes="单位查询列表")
    public Result listNew(UnitParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Unit> list = unitService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
