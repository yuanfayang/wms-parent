package com.deer.wms.system.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroup;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroupParams;
import com.deer.wms.system.manage.service.MtAloneDepartmentGroupService;
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
@Api(description = "部门分组接口")
@RestController
@RequestMapping("/mt/alone/department/groups")
public class MtAloneDepartmentGroupController {

    @Autowired
    private MtAloneDepartmentGroupService mtAloneDepartmentGroupService;

    @OperateLog(description = "添加部门分组", type = "增加")
    @ApiOperation(value = "添加部门分组", notes = "添加部门分组")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDepartmentGroup mtAloneDepartmentGroup, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneDepartmentGroup.setCreateTime(new Date());
        mtAloneDepartmentGroup.setUpdateTime(new Date());
        mtAloneDepartmentGroup.setCreatorId(Long.valueOf(currentUser.getUserId()));
        mtAloneDepartmentGroup.setUpdaterId(Long.valueOf(currentUser.getUserId()));
        mtAloneDepartmentGroupService.save(mtAloneDepartmentGroup);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除部门分组", type = "删除")
    @ApiOperation(value = "删除部门分组", notes = "删除部门分组")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneDepartmentGroupService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改部门分组", type = "更新")
    @ApiOperation(value = "修改部门分组", notes = "修改部门分组")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDepartmentGroup mtAloneDepartmentGroup, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneDepartmentGroup.setUpdateTime(new Date());
        mtAloneDepartmentGroupService.update(mtAloneDepartmentGroup);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDepartmentGroup mtAloneDepartmentGroup = mtAloneDepartmentGroupService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDepartmentGroup);
    }

    @GetMapping("/list")
    public Result list(MtAloneDepartmentGroupParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneDepartmentGroup> list = mtAloneDepartmentGroupService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
