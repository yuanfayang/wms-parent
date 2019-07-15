package com.deer.wms.system.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.system.manage.model.department.MtAloneDepartment;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentParams;
import com.deer.wms.system.manage.model.department.MtAloneDepartments;
import com.deer.wms.system.manage.service.MtAloneDepartmentService;
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
* Created by gtt on 2019/07/15.
*/
@Api(description = "部门接口")
@RestController
@RequestMapping("/mt/alone/departments")
public class MtAloneDepartmentController {

    @Autowired
    private MtAloneDepartmentService mtAloneDepartmentService;

    @OperateLog(description = "添加部门", type = "增加")
    @ApiOperation(value = "添加部门", notes = "添加部门")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDepartment mtAloneDepartment, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneDepartment.setCreateTime(new Date());
        mtAloneDepartment.setUpdateTime(new Date());
        mtAloneDepartment.setCreatorId(Long.valueOf(currentUser.getUserId()));
        mtAloneDepartmentService.save(mtAloneDepartment);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除部门", type = "删除")
    @ApiOperation(value = "删除部门", notes = "删除部门")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneDepartmentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改部门", type = "更新")
    @ApiOperation(value = "修改部门", notes = "修改部门")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDepartment mtAloneDepartment) {
        mtAloneDepartment.setUpdateTime(new Date());
        mtAloneDepartmentService.update(mtAloneDepartment);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改所有部门", type = "更新")
    @ApiOperation(value = "修改所有部门", notes = "修改所有部门")
    @PostMapping("/update/all")
    public Result updateAll(@RequestBody MtAloneDepartments mtAloneDepartments, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        for(MtAloneDepartment mtAloneDepartment : mtAloneDepartments.getMtAloneDepartments()){
            mtAloneDepartment.setUpdateTime(new Date());
            mtAloneDepartment.setUpdaterId(Long.valueOf(currentUser.getUserId()));
            mtAloneDepartmentService.update(mtAloneDepartment);
        }
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDepartment mtAloneDepartment = mtAloneDepartmentService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDepartment);
    }

    @GetMapping("/list")
    public Result list(MtAloneDepartmentParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneDepartment> list = mtAloneDepartmentService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
