package com.deer.wms.base.system.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.base.system.model.SupplierManageParams;
import com.deer.wms.base.system.service.SupplierManageService;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.DateUtils;
import com.deer.wms.project.seed.util.RandomNo;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
* Created by  on 2018/07/04.
*/
@RestController
@Api(description = "供应商管理接口")
@RequestMapping("/supplier/manages")
public class SupplierManageController {

    @Autowired
    private SupplierManageService supplierManageService;

    @PostMapping("/insert")
    @ApiOperation(value="添加供应商信息",notes="添加供应商信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    public Result add(@RequestBody SupplierManage supplierManage,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        Integer companyId    = currentUser.getCompanyId();
        supplierManage.setCompanyId(companyId);

        String  supplierCode="GYS"+currentUser.getCompanyId()+RandomNo.createTimeString().substring(2,14);
        supplierManage.setSupplierCode(supplierCode);
        String nowDate = DateUtils.getNowDateTimeString();
        supplierManage.setCreateTime(nowDate);
        supplierManageService.save(supplierManage);
        return ResultGenerator.genSuccessResult();
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/delete")
    //@ApiOperation(value="删除供应商信息",notes="删除供应商信息")
    //public Result delete( String supplierCode,@ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    Integer companyId ;
    //    SupplierManageCriteria criteria = new SupplierManageCriteria();
    //    criteria.setSupplierCode(supplierCode);
    //    if(currentUser.getCompanyType() != -1){
    //        companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    supplierManageService.deleteByCodeAndCom(criteria);
    //    return ResultGenerator.genSuccessResult();
    //}

    /**
     * 只能删除无货的供应商
     * @param supplierId
     * @param currentUser
     * @return
     */
    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "supplierId", value = "供应商id", paramType="path", dataType="Integer", required = true)
    })
    @DeleteMapping("/delete/{supplierId}")
    @ApiOperation(value="删除供应商信息",notes="删除供应商信息")
    @OperateLog(description = "删除供应商", type = "删除")
    public Result delete( @PathVariable Integer supplierId, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        SupplierManageParams params = new SupplierManageParams();
        params.setSupplierId(supplierId);
        params.setCompanyId(currentUser.getCompanyId());
        Integer countRelProducts = supplierManageService.countRelProducts(params);//统计关联产品数
        if(countRelProducts!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该供应商有货，无法删除！",null);
        }

        supplierManageService.deleteByIdAndCom(params);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/update")
    @ApiOperation(value="更新供应商信息",notes="更新供应商信息")
    public Result update(@RequestBody SupplierManage supplierManage, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        supplierManage.setCompanyId(currentUser.getCompanyId());
        supplierManageService.update(supplierManage);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/detail")
    @ApiOperation(value="单供应商信息查询",notes="单供应商信息查询")
    public Result detail( Integer id, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        SupplierManage supplierManage = supplierManageService.findById(id);
        return ResultGenerator.genSuccessResult(supplierManage);
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/list")
    //@ApiOperation(value="供应商信息查询列表",notes="供应商信息查询列表")
    //public Result list(SupplierManageCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
    //
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    if(currentUser.getCompanyType() != -1){
    //        Integer companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<SupplierManage> list = supplierManageService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/list")
    @ApiOperation(value="供应商信息查询列表",notes="供应商信息查询列表")
    public Result listNew(SupplierManageParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<SupplierManage> list = supplierManageService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
