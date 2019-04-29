package com.deer.wms.system.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.system.manage.model.MtAloneLog;
import com.deer.wms.system.manage.model.MtAloneLogCriteria;
import com.deer.wms.system.manage.model.log.LogParams;
import com.deer.wms.system.manage.service.MtAloneLogService;
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
 * Created by on 2019/01/17.
 */
@Api(description = "系统日志api接口")
@RestController
@RequestMapping("/mt/alone/logs")
public class MtAloneLogController {

	@Autowired
	private MtAloneLogService mtAloneLogService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@PostMapping("/add")
	@OperateLog(description = "增加日志", type = "增加")
	public Result add(@RequestBody MtAloneLog mtAloneLog) {
		mtAloneLogService.save(mtAloneLog);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/delete")
	@OperateLog(description = "删除日志", type = "删除")
	public Result delete(Integer mtAloneLogId) {
		mtAloneLogService.deleteById(mtAloneLogId);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@PostMapping("/update")
	@OperateLog(description = "更新日志", type = "更新")
	public Result update(@RequestBody MtAloneLog mtAloneLog) {
		mtAloneLogService.update(mtAloneLog);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/{id}")
	@OperateLog(description = "查询日志详情", type = "查询")
	public Result detail(@PathVariable Integer id) {
		MtAloneLog mtAloneLog = mtAloneLogService.findById(id);
		return ResultGenerator.genSuccessResult(mtAloneLog);
	}

	@ApiOperation(value = "查询日志分页列表", notes = "日志列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/list")
	public Result list(MtAloneLogCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<MtAloneLog> list = mtAloneLogService.findList(criteria);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
	
	
	@ApiOperation(value = "查询日志分页列表new", notes = "日志列表new")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/list/new")
	public Result listNew(LogParams params) {
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<MtAloneLog> list = mtAloneLogService.findListNew(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}
