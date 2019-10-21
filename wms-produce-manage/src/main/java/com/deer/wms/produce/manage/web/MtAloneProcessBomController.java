package com.deer.wms.produce.manage.web;

import com.deer.wms.produce.manage.constant.ProduceManagePublicMethod;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MtAloneProcessBom;
import com.deer.wms.produce.manage.model.MtAloneProcessBomParams;
import com.deer.wms.produce.manage.service.MtAloneProcessBomService;
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
@RequestMapping("/mt/alone/process/boms")
public class MtAloneProcessBomController {

    @Autowired
    private MtAloneProcessBomService mtAloneProcessBomService;

    /**
     * author:caixiang
     **/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)
    })
    @OperateLog(description = "添加工序", type = "添加工序")
    @ApiOperation(value = "添加工序", notes = "添加工序")
    @PostMapping("/addProcess")
    public Result addProcess(@RequestBody MtAloneProcessBom mtAloneProcessBom, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        String processNum = ProduceManagePublicMethod.creatUniqueCode("GX");
        mtAloneProcessBom.setProcessNum(processNum);
        mtAloneProcessBom.setCreateTime(new Date());
        mtAloneProcessBom.setCompanyId(currentUser.getCompanyId());
        mtAloneProcessBomService.save(mtAloneProcessBom);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneProcessBomService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * author:caixiang
     **/
    @OperateLog(description = "批量删除", type = "批量删除")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    @DeleteMapping("/batchDelete/{Id}")
    public Result delete(@PathVariable String Id) {
        String[] ids = Id.split(",");
        try {
            for(String i:ids){
                mtAloneProcessBomService.deleteById(Integer.parseInt(i));
            };
        }catch (Exception e){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"写入数据库失败",null);
        }
        return ResultGenerator.genSuccessResult();
    }


    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneProcessBom mtAloneProcessBom) {
        mtAloneProcessBom.setUpdateTime(new Date());
        mtAloneProcessBomService.update(mtAloneProcessBom);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneProcessBom mtAloneProcessBom = mtAloneProcessBomService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneProcessBom);
    }

    @GetMapping("/list")
    public Result list(MtAloneProcessBomParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneProcessBom> list = mtAloneProcessBomService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
