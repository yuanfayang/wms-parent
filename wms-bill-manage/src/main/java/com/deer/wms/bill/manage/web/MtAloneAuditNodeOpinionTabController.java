package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTab;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabParams;
import com.deer.wms.bill.manage.service.MtAloneAuditNodeOpinionTabService;
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
* Created by gtt on 2019/07/18.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/audit/node/opinion/tabs")
public class MtAloneAuditNodeOpinionTabController {

    @Autowired
    private MtAloneAuditNodeOpinionTabService mtAloneAuditNodeOpinionTabService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneAuditNodeOpinionTab mtAloneAuditNodeOpinionTab, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneAuditNodeOpinionTab.setCreateTime(new Date());
		 mtAloneAuditNodeOpinionTab.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditNodeOpinionTabService.save(mtAloneAuditNodeOpinionTab);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneAuditNodeOpinionTabService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneAuditNodeOpinionTab mtAloneAuditNodeOpinionTab) {
//        mtAloneAuditNodeOpinionTab.setUpdateTime(new Date());
        mtAloneAuditNodeOpinionTabService.update(mtAloneAuditNodeOpinionTab);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneAuditNodeOpinionTab mtAloneAuditNodeOpinionTab = mtAloneAuditNodeOpinionTabService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneAuditNodeOpinionTab);
    }

    @GetMapping("/list")
    public Result list(MtAloneAuditNodeOpinionTabParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneAuditNodeOpinionTab> list = mtAloneAuditNodeOpinionTabService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}