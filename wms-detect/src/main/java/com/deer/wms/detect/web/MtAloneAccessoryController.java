package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneAccessory;
import com.deer.wms.detect.model.MtAloneAccessoryParams;
import com.deer.wms.detect.service.MtAloneAccessoryService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List; 



/**
* Created by guotuanting on 2019/04/13.
*/
@Api(description = "附件接口")
@RestController
@RequestMapping("/mt/alone/accessorys")
public class MtAloneAccessoryController {

    @Autowired
    private MtAloneAccessoryService mtAloneAccessoryService;

    @OperateLog(description = "添加附件", type = "增加")
    @ApiOperation(value = "添加附件", notes = "添加附件")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAccessory mtAloneAccessory, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneAccessory.setCreateTime(new Date());
		 mtAloneAccessory.setCompanyId(currentUser.getCompanyId());
        mtAloneAccessoryService.save(mtAloneAccessory);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除附件", type = "删除")
    @ApiOperation(value = "删除附件", notes = "删除附件")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer mtAloneAccessoryId) {
        mtAloneAccessoryService.deleteById(mtAloneAccessoryId);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改附件", type = "更新")
    @ApiOperation(value = "修改附件", notes = "修改附件")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAccessory mtAloneAccessory) {
        mtAloneAccessory.setUpdateTime(new Date());
        mtAloneAccessoryService.update(mtAloneAccessory);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAccessory mtAloneAccessory = mtAloneAccessoryService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAccessory);
    }

    @GetMapping("/list")
    public Result list(MtAloneAccessoryParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAccessory> list = mtAloneAccessoryService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
