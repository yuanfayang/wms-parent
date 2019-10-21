package com.deer.wms.produce.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBom;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomParams;
import com.deer.wms.produce.manage.service.MtAloneProcessMaterialsBomService;
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
* Created by  on 2019/10/08.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/process/materials/boms")
public class MtAloneProcessMaterialsBomController {

    @Autowired
    private MtAloneProcessMaterialsBomService mtAloneProcessMaterialsBomService;

    /**
     * author:caixiang
     **/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)
    })
    @OperateLog(description = "添加原料", type = "添加原料")
    @ApiOperation(value = "添加原料", notes = "添加原料")
    @PostMapping("/addMaterialByProcessBomId")
    public Result add(@RequestBody MtAloneProcessMaterialsBom mtAloneProcessMaterialsBom, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneProcessMaterialsBom.setCreateTime(new Date());
		 mtAloneProcessMaterialsBom.setCompanyId(currentUser.getCompanyId());
        mtAloneProcessMaterialsBomService.save(mtAloneProcessMaterialsBom);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneProcessMaterialsBomService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneProcessMaterialsBom mtAloneProcessMaterialsBom) {
        mtAloneProcessMaterialsBom.setUpdateTime(new Date());
        mtAloneProcessMaterialsBomService.update(mtAloneProcessMaterialsBom);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneProcessMaterialsBom mtAloneProcessMaterialsBom = mtAloneProcessMaterialsBomService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneProcessMaterialsBom);
    }

    @GetMapping("/list")
    public Result list(MtAloneProcessMaterialsBomParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneProcessMaterialsBom> list = mtAloneProcessMaterialsBomService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
