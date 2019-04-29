package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneCraft;
import com.deer.wms.detect.model.MtAloneCraftParams;
import com.deer.wms.detect.service.MtAloneCraftService;
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
* Created by guotuanting on 2019/04/08.
*/
@Api(description = "工艺产品接口")
@RestController
@RequestMapping("/mt/alone/crafts")
public class MtAloneCraftController {

    @Autowired
    private MtAloneCraftService mtAloneCraftService;
    
	@OperateLog(description = "添加工艺产品", type = "增加")
    @ApiOperation(value = "添加工艺产品", notes = "添加工艺产品")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneCraft mtAloneCraft, @ApiIgnore @User CurrentUser currentUser) {
		if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		mtAloneCraft.setCreateTime(new Date());
		mtAloneCraft.setCompanyId(currentUser.getCompanyId());
		mtAloneCraftService.save(mtAloneCraft);
        return ResultGenerator.genSuccessResult();
    }
	
	@OperateLog(description = "删除工艺产品", type = "删除")
    @ApiOperation(value = "删除工艺产品", notes = "删除工艺产品")
	@DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneCraftService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
	
	@OperateLog(description = "修改工艺产品", type = "更新")
    @ApiOperation(value = "修改工艺产品", notes = "修改工艺产品")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneCraft mtAloneCraft) {
    	mtAloneCraft.setUpdateTime(new Date());
        mtAloneCraftService.update(mtAloneCraft);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneCraft mtAloneCraft = mtAloneCraftService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneCraft);
    }

    @GetMapping("/list")
    public Result list(MtAloneCraftParams params, @ApiIgnore @User CurrentUser currentUser) {
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneCraft> list = mtAloneCraftService.findList(params); 
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    
    @GetMapping("/parentListById")
    public Result parentListById(MtAloneCraftParams params, @ApiIgnore @User CurrentUser currentUser) {
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneCraft> list = mtAloneCraftService.parentListById(params); 
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
