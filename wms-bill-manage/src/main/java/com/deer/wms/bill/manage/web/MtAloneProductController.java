package com.deer.wms.bill.manage.web;

import com.deer.wms.base.system.model.CellInfo;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.project.seed.util.StringUtil;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneDeliveryParams;
import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDeliveryVO;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDetParams;
import com.deer.wms.bill.manage.model.MtAloneProductParams;
import com.deer.wms.bill.manage.model.MtAloneProductVO;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;
import com.deer.wms.bill.manage.service.MtAloneFlowrecordService;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by on 2018/11/24.
 */
@Api(description = "产品信息api接口")
@RestController
@RequestMapping("/mt/alone/products")
public class MtAloneProductController {

	@Autowired
	private MtAloneProductService mtAloneProductService;
	@Autowired
	private MtAloneProductDetService mtAloneProductDetService;
	@Autowired
	private CellInfoService cellInfoService;
	@Autowired
	private MtAloneBarcodeService mtAloneBarcodeService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加商品", type = "增加")
	@ApiOperation(value = "添加商品信息", notes = "添加商品信息")
	@PostMapping("/add")
	public Result add(@RequestBody MtAloneProduct mtAloneProduct, @ApiIgnore @User CurrentUser currentUser) {

		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			mtAloneProduct.setCompanyId(currentUser.getCompanyId());
		} else {
			mtAloneProduct.setCompanyId(null);
		}

		Date date = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmm");
		String batch2 = sdf2.format(date);

		// ------------------------------------------------对产品进行保存--------------------------------------------------------

		MtAloneBarcode mtAloneBarcode = new MtAloneBarcode();
		String maxBarcode = mtAloneBarcodeService.getMaxBarcode();
		String productBarcode = BillManagePublicMethod.creatBarCode(maxBarcode);
		mtAloneBarcode.setBarcode(productBarcode);
		mtAloneBarcodeService.save(mtAloneBarcode);

		mtAloneProduct.setBatch(batch2);
		mtAloneProduct.setCreateTime(date);
		mtAloneProduct.setProductBarCode(productBarcode);
		// mtAloneProduct.setSpecimenBarCode(specimenBarcode);
		mtAloneProduct.setState("normal");

		mtAloneProductService.save(mtAloneProduct);

		CellInfo cellInfo = cellInfoService.findByCellCode(mtAloneProduct.getCellCode());
		if (cellInfo != null) {
			cellInfo.setState(1);
			cellInfoService.update(cellInfo);
		}

		return ResultGenerator.genSuccessResult();

	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除商品", type = "删除")
	@ApiOperation(value = "删除商品信息", notes = "删除商品信息")
	@DeleteMapping("/delete/{mtAloneProductId}")
	public Result delete(@PathVariable Integer mtAloneProductId, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		MtAloneProductDetParams params = new MtAloneProductDetParams();
		params.setProductId(mtAloneProductId);
		List<MtAloneProductDet> detList = mtAloneProductDetService.findDetilByProductId(params);
		if (detList != null && detList.size() > 0) {
			return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD, "存在未出完的布卷，请先确认！", null);
		}
		MtAloneProduct mtAloneProduct = mtAloneProductService.findById(mtAloneProductId);
		MtAloneProductCriteria criteria = new MtAloneProductCriteria();
		criteria.setProductBarCode(mtAloneProduct.getProductBarCode());
		mtAloneProductService.deleteDetByProductCode(criteria);
		mtAloneProductService.deleteById(mtAloneProductId);
		return ResultGenerator.genSuccessResult();

	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改商品", type = "更新")
	@ApiOperation(value = "修改商品信息", notes = "修改商品信息")
	@PostMapping("/update")
	public Result update(@RequestBody MtAloneProduct mtAloneProduct) {
		mtAloneProductService.update(mtAloneProduct);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据id查询单个商品信息", type = "查询")
	@ApiOperation(value = "id查询单个商品信息", notes = "id查询单个商品信息")
	@GetMapping("/{id}")
	public Result detail(@PathVariable Integer id) {
		MtAloneProduct mtAloneProduct = mtAloneProductService.findById(id);
		return ResultGenerator.genSuccessResult(mtAloneProduct);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据barcode查询单个商品信息", type = "查询")
	@ApiOperation(value = "barcode查询单个商品信息", notes = "barcode查询单个商品信息")
	@GetMapping("/barcode")
	public Result findByBarcode(String barcode) {
		MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(barcode);
		return ResultGenerator.genSuccessResult(mtAloneProduct);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品信息分页查询", type = "查询")
	@ApiOperation(value = "商品信息列表分页", notes = "商品信息列表分页")
	@GetMapping("/list")
	public Result list(MtAloneProductCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<MtAloneProduct> list = mtAloneProductService.findList(criteria);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品信息分页查询new", type = "查询new")
	@ApiOperation(value = "商品信息列表分页", notes = "商品信息列表分页")
	@GetMapping("/list/new")
	public Result productListNew(MtAloneProductParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		StringUtil.trimObjectStringProperties(params);

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}

		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<MtAloneProductVO> list = mtAloneProductService.findListNew(params);
		List<MtAloneProductVO> listNew = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRemainLength() != 0 || list.get(i).getDeliveryLength() == 0) {
				listNew.add(list.get(i));
			}
		}
		PageInfo pageInfo = new PageInfo(listNew);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据条件查询不同状态下的产品", type = "查询")
	@ApiOperation(value = "商品信息条件查询列表分页", notes = "商品信息条件查询列表分页")
	@GetMapping("/findListByCondition")
	public Result conditionList(MtAloneProductCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		PageInfo pageInfo = new PageInfo();
		List<MtAloneProduct> list = new ArrayList();
		list = mtAloneProductService.findListBykeyAndDate(criteria);
		if (criteria.getIsWareOrRevieweState() != null) {
			int isWareOrRevieweState = criteria.getIsWareOrRevieweState();
			if (isWareOrRevieweState == 0) {
				list = mtAloneProductService.findListByWareState(criteria);
			}
			if (isWareOrRevieweState == 1) {
				list = mtAloneProductService.findListByRevieweState(criteria);
			}
		}
		pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);

	}

	// @ApiOperation(value = "首页由仓库id统计货位利用率", notes = "根据仓库id统计货位利用率")
	// @GetMapping("/countProductByWareCode")
	// public Result countProductByWareCode(MtAloneProductDetCriteria criteria) {
	// Double utilization =
	// mtAloneProductDetService.findUtilizationByWareCode(criteria);
	// return ResultGenerator.genSuccessResult(utilization);
	// }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据条件查询出库产品报表", type = "查询")
	@ApiOperation(value = "根据条件查询出库产品报表", notes = "根据条件查询出库产品报表")
	@GetMapping("/deliveryReportForms")
	public Result getDeliveryReportForms(MtAloneDeliveryParams params, @User CurrentUser currentUser) {
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
		list = mtAloneProductService.findDeliveryProForms(params);
		pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);

	}

}
