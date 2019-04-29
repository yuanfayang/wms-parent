package com.deer.wms.base.system.web;

import com.deer.wms.base.system.constant.BaseSystemConstant;
import com.deer.wms.base.system.model.MtAloneColorParams;
import com.deer.wms.base.system.model.SupplierManageParams;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.base.system.model.MtAloneColor;
import com.deer.wms.base.system.model.MtAloneColorCriteria;
import com.deer.wms.base.system.service.MtAloneColorService;
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
* Created by  on 2018/11/18.
*/
@Api(description = "颜色管理接口")
@RestController
@RequestMapping("/mt/alone/colors")
public class MtAloneColorController {

    @Autowired
    private MtAloneColorService mtAloneColorService;


    @OperateLog(description = "添加颜色信息", type = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="添加颜色信息",notes="添加颜色信息")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneColor mtAloneColor,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        mtAloneColor.setCompanyId(currentUser.getCompanyId());

    	//产品条形码
    	String colorCodeRondom=RandomUtil.generateString(6);
    	mtAloneColor.setColorCode(colorCodeRondom);
        mtAloneColorService.save(mtAloneColor);
        return ResultGenerator.genSuccessResult();
    }


    //@OperateLog(description = "删除颜色信息", type = "删除")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@ApiOperation(value="删除颜色信息",notes="删除颜色信息")
    //@GetMapping("/delete")
    //public Result delete( String colorCode) {
    //    mtAloneColorService.deleteByCode(colorCode);
    //    return ResultGenerator.genSuccessResult();
    //}

    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "colorId", value = "颜色id", paramType="path", dataType="Integer", required = true)
    })
    @ApiOperation(value="删除颜色信息",notes="删除颜色信息")
    @DeleteMapping("/delete/{colorId}")
    @OperateLog(description = "删除颜色", type = "删除")
    public Result delete(@PathVariable Integer colorId, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        MtAloneColorParams params = new MtAloneColorParams();
        params.setColorId(colorId);
        params.setCompanyId(currentUser.getCompanyId());

        Integer countRelProducts = mtAloneColorService.countRelProducts(params);
        if(countRelProducts!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该颜色下有关联的货物，无法删除！",null);
        }

        mtAloneColorService.deleteByIdParams(params);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "更新颜色信息", type = "更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="更新颜色信息",notes="更新颜色信息")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneColor mtAloneColor,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        mtAloneColorService.update(mtAloneColor);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "根据ID查询颜色信息", type = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="单个颜色查询",notes="单个颜色查询")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneColor mtAloneColor = mtAloneColorService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneColor);
    }

    //@OperateLog(description = "查询颜色列表", type = "查询")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@ApiOperation(value="颜色查询列表",notes="颜色查询列表")
    //@GetMapping("/list")
    //public Result list(MtAloneColorCriteria criteria) {
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<MtAloneColor> list = mtAloneColorService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @OperateLog(description = "查询颜色列表", type = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="颜色查询列表",notes="颜色查询列表")
    @GetMapping("/ptList")
    public Result list(MtAloneColorParams params, @ApiIgnore @User CurrentUser currentUser) {

        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneColor> list = mtAloneColorService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    //@OperateLog(description = "根据潘通色号查颜色列表", type = "查询")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@ApiOperation(value="根据潘通色号查颜色列表",notes="根据潘通色号查颜色列表")
    //@GetMapping("/ptList")
    //public Result findListByPTCode(MtAloneColorCriteria criteria) {
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<MtAloneColor> list = mtAloneColorService.findListByPTCode(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}
}
