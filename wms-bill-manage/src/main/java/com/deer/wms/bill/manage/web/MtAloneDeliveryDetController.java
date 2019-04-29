package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.StringUtil;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryParams;
import com.deer.wms.bill.manage.model.MtAloneProductDeliveryVO;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.service.MtAloneDeliveryDetService;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;


/**
* Created by  on 2019/03/07.
*/
@Api(description = "产品出库单明细接口")
@RestController
@RequestMapping("/mt/alone/delivery/dets")
public class MtAloneDeliveryDetController {

    @Autowired
    private MtAloneDeliveryDetService mtAloneDeliveryDetService;
    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDeliveryDet mtAloneDeliveryDet) {
        mtAloneDeliveryDetService.save(mtAloneDeliveryDet);
        return ResultGenerator.genSuccessResult();
    }
	@OperateLog(description = "根据ID一条一条删除出库单记录", type = "删除")
    @ApiOperation(value = "根据ID一条一条删除出库单记录", notes = "根据ID一条一条删除出库单记录")
    @GetMapping("/delete")
    public Result delete( Integer mtAloneDeliveryDetId) {
    	MtAloneDeliveryDet mtAloneDeliveryDet=mtAloneDeliveryDetService.findById(mtAloneDeliveryDetId);
    	MtAloneProductDet mtAloneProductDet=mtAloneProductDetService.findProductDetByBarCode(mtAloneDeliveryDet.getProductDetBarcode());
    	mtAloneProductDet.setProductDetRemainLength(mtAloneProductDet.getProductDetRemainLength()+mtAloneDeliveryDet.getDeliveryLength());
    	mtAloneProductDetService.update(mtAloneProductDet);
    	mtAloneDeliveryDetService.deleteById(mtAloneDeliveryDetId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDeliveryDet mtAloneDeliveryDet) {
        mtAloneDeliveryDetService.update(mtAloneDeliveryDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDeliveryDet mtAloneDeliveryDet = mtAloneDeliveryDetService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDeliveryDet);
    }

    @GetMapping("/list")
    public Result list(MtAloneDeliveryDetCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDeliveryDet> list = mtAloneDeliveryDetService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据产品条形码查询该产品出库详细记录", type = "查询")
	@ApiOperation(value = "根据产品条形码查询该产品出库详细记录", notes = "根据产品条形码查询该产品出库详细记录")
	@GetMapping("/deliveryDetReportForms")
	public Result getDeliveryDetReportForms(MtAloneDeliveryParams params, @User CurrentUser currentUser) {
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		PageInfo pageInfo = new PageInfo();	
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		StringUtil.trimObjectStringProperties(params);

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		List<MtAloneProductDeliveryVO> list = new ArrayList();
		list = mtAloneDeliveryDetService.findDeliveryDetForms(params);
		pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);

	}

}
