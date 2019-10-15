package com.deer.wms.base.system.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.base.system.model.MtDict;
import com.deer.wms.base.system.model.MtDictParams;
import com.deer.wms.base.system.service.MtDictService;
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
 * Created by guotuanting on 2019/10/12.
 */
@Api(description = "字典管理接口")
@RestController
@RequestMapping("/mt/dicts")
public class MtDictController {

    @Autowired
    private MtDictService mtDictService;

    @OperateLog(description = "添加字典管理", type = "增加")
    @ApiOperation(value = "添加字典管理", notes = "添加字典管理")
    @PostMapping("/add")
    public Result add(@RequestBody MtDict mtDict, @ApiIgnore @User CurrentUser currentUser) {
        mtDict.setCreateTime(new Date());
        mtDict.setCompanyId(currentUser.getCompanyId());
        mtDict.setCreatorId(currentUser.getUserId());
        mtDict.setCreatorName(currentUser.getUserName());
        mtDict.setUpdateTime(new Date());
        mtDictService.save(mtDict);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除字典管理", type = "删除")
    @ApiOperation(value = "删除字典管理", notes = "删除字典管理")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtDictService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改字典管理", type = "更新")
    @ApiOperation(value = "修改字典管理", notes = "修改字典管理")
    @PostMapping("/update")
    public Result update(@RequestBody MtDict mtDict) {
        mtDict.setUpdateTime(new Date());
        mtDictService.update(mtDict);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtDict mtDict = mtDictService.detail(id);
        return ResultGenerator.genSuccessResult(mtDict);
    }

    @GetMapping("/list")
    public Result list(MtDictParams params, @ApiIgnore @User CurrentUser currentUser) {
        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtDict> list = mtDictService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @GetMapping("/list/type")
    public Result findTypeList(MtDictParams params, @ApiIgnore @User CurrentUser currentUser) {
        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtDict> list = mtDictService.findTypeList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
