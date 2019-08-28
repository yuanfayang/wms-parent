package com.deer.wms.detect.web;

import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneSampleClothOut;
import com.deer.wms.detect.model.MtAloneSampleClothOutParams;
import com.deer.wms.detect.service.MtAloneSampleClothOutService;
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
@Api(description = "样布出库接口")
@RestController
@Authority
@RequestMapping("/mt/alone/sample/cloth/outs")
public class MtAloneSampleClothOutController {

    @Autowired
    private MtAloneSampleClothOutService mtAloneSampleClothOutService;

    @OperateLog(description = "添加样布出库", type = "增加")
    @ApiOperation(value = "添加样布出库", notes = "添加样布出库")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneSampleClothOut mtAloneSampleClothOut, @ApiIgnore @User CurrentUser currentUser) {
        mtAloneSampleClothOut.setCreateTime(new Date());
        mtAloneSampleClothOut.setCompanyId(currentUser.getCompanyId());
        mtAloneSampleClothOutService.save(mtAloneSampleClothOut);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除样布出库", type = "删除")
    @ApiOperation(value = "删除样布出库", notes = "删除样布出库")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneSampleClothOutService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "修改样布出库", type = "更新")
    @ApiOperation(value = "修改样布出库", notes = "修改样布出库")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneSampleClothOut mtAloneSampleClothOut) {
        mtAloneSampleClothOut.setUpdateTime(new Date());
        mtAloneSampleClothOutService.update(mtAloneSampleClothOut);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneSampleClothOut mtAloneSampleClothOut = mtAloneSampleClothOutService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneSampleClothOut);
    }

    @GetMapping("/list")
    public Result list(MtAloneSampleClothOutParams params, @ApiIgnore @User CurrentUser currentUser) {
        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneSampleClothOut> list = mtAloneSampleClothOutService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
