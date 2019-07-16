package com.deer.wms.system.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperator;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperatorParams;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperators;
import com.deer.wms.system.manage.service.MtAloneGroupOperatorService;
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
 * Created by gtt on 2019/07/16.
 */
@Api(description = "部门分组人员接口")
@RestController
@RequestMapping("/mt/alone/group/operators")
public class MtAloneGroupOperatorController {

    @Autowired
    private MtAloneGroupOperatorService mtAloneGroupOperatorService;

    @OperateLog(description = "添加部门分组人员", type = "增加")
    @ApiOperation(value = "添加部门分组人员", notes = "添加部门分组人员")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneGroupOperator mtAloneGroupOperator, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        mtAloneGroupOperatorService.save(mtAloneGroupOperator);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "添加部门分组人员all", type = "增加")
    @ApiOperation(value = "添加部门分组人员all", notes = "添加部门分组人员all")
    @PostMapping("/add/all")
    public Result addAll(@RequestBody MtAloneGroupOperators mtAloneGroupOperators, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        mtAloneGroupOperatorService.deleteByGroupId(mtAloneGroupOperators.getGroupId());
        mtAloneGroupOperatorService.save(mtAloneGroupOperators.getMtAloneGroupOperators());
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除部门分组人员", type = "删除")
    @ApiOperation(value = "删除部门分组人员", notes = "删除部门分组人员")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneGroupOperatorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改部门分组人员", type = "更新")
    @ApiOperation(value = "修改部门分组人员", notes = "修改部门分组人员")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneGroupOperator mtAloneGroupOperator) {
        mtAloneGroupOperatorService.update(mtAloneGroupOperator);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneGroupOperator mtAloneGroupOperator = mtAloneGroupOperatorService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneGroupOperator);
    }

    @GetMapping("/list")
    public Result list(MtAloneGroupOperatorParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }

        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
            params.setCompanyId(currentUser.getCompanyId());
        } else {
            params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneGroupOperator> list = mtAloneGroupOperatorService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list/{groupId}")
    public Result list(@PathVariable Integer groupId, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        List<MtAloneGroupOperator> list = mtAloneGroupOperatorService.findListByGroupId(groupId);
        return ResultGenerator.genSuccessResult(list);
    }

}
