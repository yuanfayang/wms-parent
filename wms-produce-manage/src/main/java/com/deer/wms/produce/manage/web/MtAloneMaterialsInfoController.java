package com.deer.wms.produce.manage.web;

import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomParams;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomVO;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MtAloneMaterialsInfo;
import com.deer.wms.produce.manage.model.MtAloneMaterialsInfoParams;
import com.deer.wms.produce.manage.service.MtAloneMaterialsInfoService;
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
* Created by  on 2019/10/09.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/materials/infos")
public class MtAloneMaterialsInfoController {

    @Autowired
    private MtAloneMaterialsInfoService mtAloneMaterialsInfoService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneMaterialsInfo mtAloneMaterialsInfo, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneMaterialsInfo.setCreateTime(new Date());
		 mtAloneMaterialsInfo.setCompanyId(currentUser.getCompanyId());
        mtAloneMaterialsInfoService.save(mtAloneMaterialsInfo);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneMaterialsInfoService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneMaterialsInfo mtAloneMaterialsInfo) {
        mtAloneMaterialsInfoService.update(mtAloneMaterialsInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneMaterialsInfo mtAloneMaterialsInfo = mtAloneMaterialsInfoService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneMaterialsInfo);
    }

    /**
     * author:caixiang
     *
     * desc:依据物料名称、编号查询该物料的bom
     **/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)
    })
    @ApiOperation(value = "依据材料名称或者num查找物料bom", notes = "依据材料名称或者num查找物料bom")
    @PostMapping("/selectMaterialByNameOrNum")
    public Result selectMaterialByNameOrNum(@RequestBody MtAloneMaterialsInfoParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        params.setCompanyId(currentUser.getCompanyId());
        List<MtAloneProcessMaterialsBomVO> list = new ArrayList<>();
        try {
            list = mtAloneMaterialsInfoService.findMaterialByNameAndNum(params);
        }catch (Exception e){
            ResultGenerator.genFailResult(CommonCode.SERVER_INERNAL_ERROR,"操作数据库异常","null");
        }
        return ResultGenerator.genSuccessResult().setData(list);
    }

    @GetMapping("/list")
    public Result list(MtAloneMaterialsInfoParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneMaterialsInfo> list = mtAloneMaterialsInfoService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
