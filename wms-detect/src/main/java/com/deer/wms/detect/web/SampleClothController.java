package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.detect.model.MtAloneAccessory;
import com.deer.wms.detect.model.MtAloneObjAccessory;
import com.deer.wms.detect.model.SampleCloth;
import com.deer.wms.detect.model.SampleClothDTO;
import com.deer.wms.detect.model.SampleClothParams;
import com.deer.wms.detect.model.SampleClothVo;
import com.deer.wms.detect.service.MtAloneAccessoryService;
import com.deer.wms.detect.service.MtAloneObjAccessoryService;
import com.deer.wms.detect.service.SampleClothService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/12.
 */
@Api(description = "样布接口")
@RestController
@RequestMapping("/mt/alone/sample/cloths/demo")
public class SampleClothController {

	@Autowired
	private SampleClothService mtAloneSampleClothService;

	@Autowired
	private MtAloneAccessoryService mtAloneAccessoryService;

	@Autowired
	private MtAloneObjAccessoryService mtAloneObjAccessoryService;

	@OperateLog(description = "添加样布", type = "增加")
	@ApiOperation(value = "添加样布", notes = "添加样布")
	@PostMapping("/add")
	public Result add(@RequestBody SampleClothDTO sampleClothDTO, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
		}
		sampleClothDTO.setCreateTime(new Date());
		return getResult(sampleClothDTO, currentUser);
	}

	@OperateLog(description = "删除样布", type = "删除")
	@ApiOperation(value = "删除样布", notes = "删除样布")
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable Integer id) {
		mtAloneSampleClothService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@OperateLog(description = "修改样布", type = "更新")
	@ApiOperation(value = "修改样布", notes = "修改样布")
	@PostMapping("/update")
	public Result update(@RequestBody SampleCloth mtAloneSampleCloth,@ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
		}
		mtAloneSampleCloth.setModifyTime(new Date());
		mtAloneSampleClothService.update(mtAloneSampleCloth);
		return ResultGenerator.genSuccessResult();
	}

	@OperateLog(description = "修改样布加附件", type = "更新")
	@ApiOperation(value = "修改样布加附件", notes = "修改样布加附件")
	@PostMapping("/update/accessory")
	public Result updateAccessory(@RequestBody SampleClothDTO sampleClothDTO,@ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
		}
		mtAloneSampleClothService.deleteClothAndAccessoryById(sampleClothDTO.getId());
		sampleClothDTO.setModifyTime(new Date());

		return getResult(sampleClothDTO, currentUser);
	}

	private Result getResult(@RequestBody SampleClothDTO sampleClothDTO, @User @ApiIgnore CurrentUser currentUser) {
		sampleClothDTO.setCompanyId(currentUser.getCompanyId());
		mtAloneSampleClothService.save(sampleClothDTO);
		List<MtAloneAccessory> accessorys = sampleClothDTO.getAccessorys();
		if(accessorys==null || accessorys.size()==0) {
			return ResultGenerator.genSuccessResult();
		}
		mtAloneAccessoryService.save(accessorys);
		List<MtAloneObjAccessory> objAccessorys = new ArrayList<MtAloneObjAccessory>();
		for (MtAloneAccessory m : accessorys) {
			MtAloneObjAccessory objAccessory = new MtAloneObjAccessory();
			objAccessory.setAccessoryId(m.getId());
			objAccessory.setObjId(sampleClothDTO.getId());
			objAccessorys.add(objAccessory);
		}
		mtAloneObjAccessoryService.save(objAccessorys);
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/detail/{id}")
	public Result detail(@PathVariable Integer id) {
		SampleClothVo mtAloneSampleCloth = mtAloneSampleClothService.findDetailById(id);
		return ResultGenerator.genSuccessResult(mtAloneSampleCloth);
	}

	@GetMapping("/list")
	public Result list(SampleClothParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<SampleCloth> list = mtAloneSampleClothService.findList(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@GetMapping("/accessory/list")
	public Result accessoryList(SampleClothParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<SampleClothVo> list = mtAloneSampleClothService.findAccessoryList(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}
