package com.deer.wms.produce.manage.web;

import com.deer.wms.produce.manage.model.*;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.Code;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.service.MtAloneProductProcessBomService;
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
* Created by  on 2019/09/28.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/product/process/boms")
public class MtAloneProductProcessBomController {

    @Autowired
    private MtAloneProductProcessBomService mtAloneProductProcessBomService;

/*    @Autowired
    private MtAloneMachiningProductService mtAloneMachiningProductService;*/

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneProductProcessBom mtAloneProductProcessBom, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneProductProcessBom.setCreateTime(new Date());
		 mtAloneProductProcessBom.setCompanyId(currentUser.getCompanyId());
        mtAloneProductProcessBomService.save(mtAloneProductProcessBom);
        return ResultGenerator.genSuccessResult();
    }
    /**
     * author:caixiang
     *
     * desc:依据产品名称、产品编号查询该产品的工艺列表
     **/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)
    })
    @ApiOperation(value = "依据产品名称、产品编号查询该产品的工艺列表", notes = "依据产品名称、产品编号查询该产品的工艺列表")
    @PostMapping("/selectProcessByProductNameNum")
    public Result selectProcessByProductNameNum(@RequestBody MtAloneProductProcessBomParams mtAloneProductProcessBomParams, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneProductProcessBomParams.setCompanyId(currentUser.getCompanyId());
        List<MtAloneProductProcessBomVO> byProductNameAndProductNum = new ArrayList<MtAloneProductProcessBomVO>();
        try {
            byProductNameAndProductNum = mtAloneProductProcessBomService.findByProductNameAndProductNum(mtAloneProductProcessBomParams);
        }catch (Exception e){
            ResultGenerator.genFailResult(CommonCode.SERVER_INERNAL_ERROR,"操作数据库异常","null");
        }
        return ResultGenerator.genSuccessResult().setData(byProductNameAndProductNum);
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneProductProcessBomService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneProductProcessBom mtAloneProductProcessBom) {
        mtAloneProductProcessBom.setUpdateTime(new Date());
        mtAloneProductProcessBomService.update(mtAloneProductProcessBom);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneProductProcessBom mtAloneProductProcessBom = mtAloneProductProcessBomService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneProductProcessBom);
    }

    @GetMapping("/list")
    public Result list(MtAloneProductProcessBomParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneProductProcessBom> list = mtAloneProductProcessBomService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
