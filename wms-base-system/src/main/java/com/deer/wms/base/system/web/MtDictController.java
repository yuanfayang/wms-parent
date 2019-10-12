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
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/dicts")
public class MtDictController {

    @Autowired
    private MtDictService mtDictService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtDict mtDict, @ApiIgnore @User CurrentUser currentUser) {
        mtDict.setCreateTime(new Date());
        mtDict.setCompanyId(currentUser.getCompanyId());
        mtDictService.save(mtDict);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtDictService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtDict mtDict) {
        mtDict.setUpdateTime(new Date());
        mtDictService.update(mtDict);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtDict mtDict = mtDictService.findById(id);
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
