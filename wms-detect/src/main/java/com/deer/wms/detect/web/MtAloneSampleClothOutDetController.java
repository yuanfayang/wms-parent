package com.deer.wms.detect.web;

import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneSampleClothOutDet;
import com.deer.wms.detect.model.MtAloneSampleClothOutDetParams;
import com.deer.wms.detect.service.MtAloneSampleClothOutDetService;
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
@Api(description = "样布出库明细接口")
@RestController
@Authority
@RequestMapping("/mt/alone/sample/cloth/out/dets")
public class MtAloneSampleClothOutDetController {

    @Autowired
    private MtAloneSampleClothOutDetService mtAloneSampleClothOutDetService;

    @OperateLog(description = "添加样布出库明细", type = "增加")
    @ApiOperation(value = "添加样布出库明细", notes = "添加样布出库明细")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneSampleClothOutDet mtAloneSampleClothOutDet, @ApiIgnore @User CurrentUser currentUser) {
        mtAloneSampleClothOutDet.setCreateTime(new Date());
        mtAloneSampleClothOutDet.setCompanyId(currentUser.getCompanyId());
        mtAloneSampleClothOutDetService.save(mtAloneSampleClothOutDet);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除样布出库明细", type = "删除")
    @ApiOperation(value = "删除样布出库明细", notes = "删除样布出库明细")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneSampleClothOutDetService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改样布出库明细", type = "更新")
    @ApiOperation(value = "修改样布出库明细", notes = "修改样布出库明细")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneSampleClothOutDet mtAloneSampleClothOutDet) {
        mtAloneSampleClothOutDet.setUpdateTime(new Date());
        mtAloneSampleClothOutDetService.update(mtAloneSampleClothOutDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneSampleClothOutDet mtAloneSampleClothOutDet = mtAloneSampleClothOutDetService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneSampleClothOutDet);
    }

    @GetMapping("/list")
    public Result list(MtAloneSampleClothOutDetParams params, @ApiIgnore @User CurrentUser currentUser) {
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneSampleClothOutDet> list = mtAloneSampleClothOutDetService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
