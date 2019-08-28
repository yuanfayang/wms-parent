package com.deer.wms.detect.web;

import com.deer.wms.detect.model.MtAloneSampleClothDetDto;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneSampleClothDet;
import com.deer.wms.detect.model.MtAloneSampleClothDetParams;
import com.deer.wms.detect.service.MtAloneSampleClothDetService;
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
 * Created by guotuanting on 2019/08/28.
 */
@Api(description = "样布明细接口")
@RestController
@Authority
@RequestMapping("/mt/alone/sample/cloth/dets")
public class MtAloneSampleClothDetController {

    @Autowired
    private MtAloneSampleClothDetService mtAloneSampleClothDetService;

    @OperateLog(description = "添加样布明细", type = "增加")
    @ApiOperation(value = "添加样布明细", notes = "添加样布明细")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneSampleClothDet mtAloneSampleClothDet, @ApiIgnore @User CurrentUser currentUser) {
        mtAloneSampleClothDet.setCreateTime(new Date());
        mtAloneSampleClothDet.setCompanyId(currentUser.getCompanyId());
        mtAloneSampleClothDet.setCreatorId(currentUser.getUserId());
        mtAloneSampleClothDetService.save(mtAloneSampleClothDet);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除样布明细", type = "删除")
    @ApiOperation(value = "删除样布明细", notes = "删除样布明细")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneSampleClothDetService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改样布明细", type = "更新")
    @ApiOperation(value = "修改样布明细", notes = "修改样布明细")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneSampleClothDet mtAloneSampleClothDet) {
        mtAloneSampleClothDet.setUpdateTime(new Date());
        mtAloneSampleClothDetService.update(mtAloneSampleClothDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneSampleClothDet mtAloneSampleClothDet = mtAloneSampleClothDetService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneSampleClothDet);
    }

    @GetMapping("/list")
    public Result list(MtAloneSampleClothDetParams params, @ApiIgnore @User CurrentUser currentUser) {

        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneSampleClothDetDto> list = mtAloneSampleClothDetService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
