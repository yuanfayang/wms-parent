package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneJob;
import com.deer.wms.detect.model.MtAloneJobParams;
import com.deer.wms.detect.model.MtAloneJobVo;
import com.deer.wms.detect.service.MtAloneJobService;
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
 * Created by guotuanting on 2019/04/10.
 */
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/jobs")
public class MtAloneJobController {

	@Autowired
	private MtAloneJobService mtAloneJobService;

	@OperateLog(description = "添加xxx", type = "增加")
	@ApiOperation(value = "添加xxx", notes = "添加xxx")
	@PostMapping("/add")
	public Result add(@RequestBody MtAloneJob mtAloneJob, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		mtAloneJob.setCreateTime(new Date());
		mtAloneJob.setUpdateTime(new Date());
		mtAloneJob.setCompanyId(currentUser.getCompanyId());
		mtAloneJob.setCreatorId((long) currentUser.getUserId());
		mtAloneJobService.save(mtAloneJob);
		return ResultGenerator.genSuccessResult();
	}

	@OperateLog(description = "删除xxx", type = "删除")
	@ApiOperation(value = "删除xxx", notes = "删除xxx")
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable Integer id) {
		mtAloneJobService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@OperateLog(description = "修改xxx", type = "更新")
	@ApiOperation(value = "修改xxx", notes = "修改xxx")
	@PostMapping("/update")
	public Result update(@RequestBody MtAloneJob mtAloneJob) {
		mtAloneJob.setUpdateTime(new Date());
		mtAloneJob.setStartTime(new Date());
		mtAloneJobService.update(mtAloneJob);
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/detail/{id}")
	public Result detail(@PathVariable Integer id) {
		MtAloneJob mtAloneJob = mtAloneJobService.findById(id);
		return ResultGenerator.genSuccessResult(mtAloneJob);
	}

	@GetMapping("/list")
	public Result list(MtAloneJobParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<MtAloneJobVo> list = mtAloneJobService.findList(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}
