package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.service.MtAloneFlowrecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;


/**
* Created by  on 2018/12/10.
*/
@Api(description = "流水记录api接口")
@RestController
@RequestMapping("/mt/alone/flowrecords")
public class MtAloneFlowrecordController {

    @Autowired
    private MtAloneFlowrecordService mtAloneFlowrecordService;
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加流水记录", type = "增加")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneFlowrecord mtAloneFlowrecord) {
        mtAloneFlowrecordService.save(mtAloneFlowrecord);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除流水记录", type = "删除")
    @GetMapping("/delete")
    public Result delete( Integer mtAloneFlowrecordId) {
        mtAloneFlowrecordService.deleteById(mtAloneFlowrecordId);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "更新流水记录", type = "更新")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneFlowrecord mtAloneFlowrecord) {
        mtAloneFlowrecordService.update(mtAloneFlowrecord);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据id查询流水记录", type = "查询")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneFlowrecord mtAloneFlowrecord = mtAloneFlowrecordService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneFlowrecord);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "流水记录列表", type = "查询")
    @GetMapping("/list")
    public Result list(MtAloneFlowrecordCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneFlowrecord> list = mtAloneFlowrecordService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据单号orderCode查询流水记录及商品信息", type = "查询")
    @ApiOperation(value = "根据单号orderCode查询流水记录及商品信息", notes = "根据单号orderCode查询流水记录及商品信息")
    @GetMapping("/flowListByOrder")
    public Result flowListByOrder(MtAloneFlowrecordCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneFlowrecordCriteria> list = mtAloneFlowrecordService.findListByOrder(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据产品名称和时间段查询流水记录及商品信息", type = "查询")
    @ApiOperation(value = "根据产品名称和时间段查询流水记录及商品信息", notes = "根据产品名称和时间段查询流水记录及商品信息")
    @GetMapping("/flowListByProductName")
    public Result flowListByProductName(MtAloneFlowrecordCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneFlowrecordCriteria> list = mtAloneFlowrecordService.flowListByProductName(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
