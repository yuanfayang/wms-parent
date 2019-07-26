package com.deer.wms.bill.manage.web;

import com.deer.wms.base.system.model.CellInfo;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.*;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;
import com.deer.wms.bill.manage.service.MtAloneFlowrecordService;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.lkx.util.ExcelTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.util.CollectionUtils;
import springfox.documentation.annotations.ApiIgnore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<MtAloneProductDetDto> detList = mtAloneProductDetService.findDetilByProductId(params);
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
//		List<MtAloneProductVO> listNew = new ArrayList();

//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getRemainLength() != 0 || list.get(i).getDeliveryLength() == 0) {
//				listNew.add(list.get(i));
//			}
//		}
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品信息导出excel", type = "查询new")
	@ApiOperation(value = "商品信息导出excel", notes = "商品信息导出excel")
	@PostMapping("/list/new/excel")
	public Result productNewListExcel(@RequestBody MtAloneProductParams params,@ApiIgnore @User CurrentUser currentUser,
									  HttpServletRequest request, HttpServletResponse response) throws Exception{
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		StringUtil.trimObjectStringProperties(params);

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}


		List<String> titles = params.getHeadersName();

		//创建poi导出数据对象
		SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();

		//创建sheet页
		SXSSFSheet sheet = sxssfWorkbook.createSheet("sheet1");

		CellStyle cellStyle = sxssfWorkbook.createCellStyle();
		//设置居中
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

		//设置边框
		cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
		cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
		cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
		cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框

		CellStyle cellStyleHead = sxssfWorkbook.createCellStyle();
		//设置居中
		cellStyleHead.setAlignment(XSSFCellStyle.ALIGN_CENTER);

		//设置边框
		cellStyleHead.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
		cellStyleHead.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
		cellStyleHead.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
		cellStyleHead.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框

		XSSFFont font = (XSSFFont)sxssfWorkbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 这是字体加粗
		cellStyleHead.setFont(font);

		//创建表头
		SXSSFRow headRow = sheet.createRow(0);

		for (int i=0;i<titles.size();i++){
			Cell cell = headRow.createCell(i);
			cell.setCellValue(titles.get(i));
			cell.setCellStyle(cellStyleHead);
		}

		List<MtAloneProductVO> list = mtAloneProductService.findListNew(params);
		List<List<String>> data = new ArrayList<>();
		for (MtAloneProductVO mtAloneProductVO:list){
			List<String> stringList = new ArrayList<>();
			for (int i = 0 ; i < params.getHeadersName().size() ; i++){
				if (params.getHeadersName().get(i).equals("产品编号")){
					stringList.add(mtAloneProductVO.getProductCode());
				}else if (params.getHeadersName().get(i).equals("产品名称")){
					stringList.add(mtAloneProductVO.getProductName());
				}else if (params.getHeadersName().get(i).equals("产品分类")){
					stringList.add(mtAloneProductVO.getItemTypeName());
				}else if (params.getHeadersName().get(i).equals("产品品种")){
					stringList.add(mtAloneProductVO.getItemVarietyName());
				}else if (params.getHeadersName().get(i).equals("供应商名称")){
					stringList.add(mtAloneProductVO.getSupplierName());
				}else if (params.getHeadersName().get(i).equals("颜色名称")){
					stringList.add(mtAloneProductVO.getColorName());
				}else if (params.getHeadersName().get(i).equals("产品缸号")){
					stringList.add(mtAloneProductVO.getDyelotNum());
				}else if (params.getHeadersName().get(i).equals("颜色")){
					stringList.add(mtAloneProductVO.getColorCode());
				}else if (params.getHeadersName().get(i).equals("登记卷数")){
					stringList.add(String.valueOf(mtAloneProductVO.getWareNum()));
				}else if (params.getHeadersName().get(i).equals("登记米数")){
					stringList.add(String.valueOf(mtAloneProductVO.getProductLength()));
				}else if (params.getHeadersName().get(i).equals("入库卷数")){
					stringList.add(String.valueOf(mtAloneProductVO.getRollNum()));
				}else if (params.getHeadersName().get(i).equals("入库米数")){
					stringList.add(String.valueOf(mtAloneProductVO.getDetectLength()));
				}else if (params.getHeadersName().get(i).equals("剩余米数")){
					stringList.add(String.valueOf(mtAloneProductVO.getRemainLength()));
				}else if (params.getHeadersName().get(i).equals("物料编号")){
					stringList.add(mtAloneProductVO.getItemCode());
				}else if (params.getHeadersName().get(i).equals("面料成分")){
					stringList.add(mtAloneProductVO.getShellFabric());
				}else if (params.getHeadersName().get(i).equals("产品组织")){
					stringList.add(String.valueOf(mtAloneProductVO.getIsDetection()));
				}else if (params.getHeadersName().get(i).equals("产品产地")){
					stringList.add(mtAloneProductVO.getOrigin());
				}else if (params.getHeadersName().get(i).equals("进货单价")){
					stringList.add(String.valueOf(mtAloneProductVO.getPrice()));
				}else if (params.getHeadersName().get(i).equals("门幅(cm)")){
					stringList.add(String.valueOf(mtAloneProductVO.getLarghezza()));
				}else if (params.getHeadersName().get(i).equals("克重(g/m2)")){
					stringList.add(String.valueOf(mtAloneProductVO.getGrammage()));
				}else if (params.getHeadersName().get(i).equals("产品密度")){
					stringList.add(mtAloneProductVO.getDensity());
				}else if (params.getHeadersName().get(i).equals("产品规格")){
					stringList.add(mtAloneProductVO.getSpecification());
				}else if (params.getHeadersName().get(i).equals("加工方式")){
					stringList.add(mtAloneProductVO.getProcessingMode());
				}else if (params.getHeadersName().get(i).equals("采购员")){
					stringList.add(mtAloneProductVO.getPurchaser());
				}else if (params.getHeadersName().get(i).equals("描述信息")){
					stringList.add(mtAloneProductVO.getDescription());
				}else if (params.getHeadersName().get(i).equals("产品备注")){
					stringList.add(mtAloneProductVO.getNote());
				}else if (params.getHeadersName().get(i).equals("创建时间")){
					stringList.add(DateUtils.dateToStr(mtAloneProductVO.getCreateTime(),DateUtils.DEFAULT_DATE_FORMAT));
				}else {

				}
			}
			data.add(stringList);
		}

		Cell cell = null;
		if(!CollectionUtils.isEmpty(data)){
			for (int i=0;i<data.size();i++) {
				//填充数据
				SXSSFRow dataRow = sheet.createRow(i + 1);
				for (int j=0;j<titles.size();j++) {
					cell = dataRow.createCell(j);
					cell.setCellValue(data.get(i).get(j));
					cell.setCellStyle(cellStyle); // 单元格的样式
				}
			}
		}


		// 下载导出
		String fileName = "库存Excel.xlsx";


		// 解决文件乱码
		final String userAgent = request.getHeader("user-agent");
		if (userAgent != null && userAgent.indexOf("Firefox") >= 0
				|| userAgent.indexOf("Chrome") >= 0 || userAgent.indexOf("Safari") >= 0) {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
		} else {
			fileName = URLEncoder.encode(fileName, "UTF8"); // 其他浏览器
		}

		// 设置头信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);


		//创建一个输出流
		ServletOutputStream outputStream = response.getOutputStream();

		response.flushBuffer();

		//写入数据
		sxssfWorkbook.write(outputStream);

		// 关闭
		outputStream.close();
		sxssfWorkbook.close();

		return ResultGenerator.genSuccessResult();
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
