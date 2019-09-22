package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneFabricType;
import com.deer.wms.detect.model.MtAloneFabricTypeParams;
import com.deer.wms.detect.service.MtAloneFabricTypeService;
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
 * Created by zth on 2019/06/24.
 */
@Api(description = "瑕疵分类接口")
@RestController
@RequestMapping("/mt/alone/fabric/types")
public class MtAloneFabricTypeController {

    @Autowired
    private MtAloneFabricTypeService mtAloneFabricTypeService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "添加瑕疵分类", type = "增加")
    @ApiOperation(value = "添加瑕疵分类", notes = "添加瑕疵分类")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneFabricType mtAloneFabricType, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
        }
        mtAloneFabricType.setCreateTime(new Date());
        mtAloneFabricType.setCompanyId(currentUser.getCompanyId());
        mtAloneFabricTypeService.save(mtAloneFabricType);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "删除瑕疵分类", type = "删除")
    @ApiOperation(value = "删除瑕疵分类", notes = "删除瑕疵分类")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneFabricTypeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "修改瑕疵分类", type = "更新")
    @ApiOperation(value = "修改瑕疵分类", notes = "修改瑕疵分类")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneFabricType mtAloneFabricType) {
//        mtAloneFabricType.setUpdateTime(new Date());
        mtAloneFabricTypeService.update(mtAloneFabricType);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @OperateLog(description = "根据瑕疵分类ID获取单条瑕疵分类", type = "查询")
    @GetMapping("/{id}")
    @ApiOperation(value = "根据瑕疵分类ID获取单条瑕疵分类", notes = "根据瑕疵分类ID获取单条瑕疵分类")
    public Result detail(@PathVariable Integer id) {
        MtAloneFabricType mtAloneFabricType = mtAloneFabricTypeService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneFabricType);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)})
    @GetMapping("/fabricTypeList")
    @OperateLog(description = "获取瑕疵分类列表", type = "查询")
    @ApiOperation(value = "获取瑕疵分类列表", notes = "获取瑕疵分类列表")
    public Result list(MtAloneFabricTypeParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (currentUser == null) {
            return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
        }
        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneFabricType> list = mtAloneFabricTypeService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
