package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneRelocateRecord;
import com.deer.wms.bill.manage.model.MtAloneRelocateRecordCriteria;
import com.deer.wms.bill.manage.service.MtAloneRelocateRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



/**
* Created by mt on 2018/12/30.
*/

@Api(description = "移库记录接口")
@RestController
@RequestMapping("/mt/alone/relocate/records")
public class RelocateRecordController {

    @Autowired
    private MtAloneRelocateRecordService mtAloneRelocateRecordService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "增加移库记录", type = "增加")
    @ApiOperation(value = "增加移库记录", notes = "增加移库记录")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneRelocateRecord mtAloneRelocateRecord) {
        mtAloneRelocateRecordService.save(mtAloneRelocateRecord);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除移库记录", type = "删除")
    @ApiOperation(value = "删除移库记录", notes = "删除移库记录")
    @GetMapping("/delete")
    public Result delete( Integer mtAloneRelocateRecordId) {
        mtAloneRelocateRecordService.deleteById(mtAloneRelocateRecordId);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "更新移库记录", type = "更新")
    @ApiOperation(value = "更新移库记录", notes = "更新移库记录")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneRelocateRecord mtAloneRelocateRecord) {
        mtAloneRelocateRecordService.update(mtAloneRelocateRecord);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID查询移库记录", type = "查询")
    @ApiOperation(value = "根据ID查询移库记录", notes = "根据ID查询加移库记录")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneRelocateRecord mtAloneRelocateRecord = mtAloneRelocateRecordService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneRelocateRecord);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "查询移库记录列表", type = "查询")
    @ApiOperation(value = "查询移库记录列表", notes = "查询移库记录列表")
    @GetMapping("/list")
    public Result list(MtAloneRelocateRecordCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneRelocateRecord> list = mtAloneRelocateRecordService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
