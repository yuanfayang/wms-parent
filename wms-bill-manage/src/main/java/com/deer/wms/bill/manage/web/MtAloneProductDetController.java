package com.deer.wms.bill.manage.web;

import com.deer.wms.base.system.model.CellInfo;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;
import com.deer.wms.bill.manage.service.MtAloneDeliveryDetService;
import com.deer.wms.bill.manage.service.MtAloneDetectDetService;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.bill.manage.service.MtAloneRelocateRecordService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by on 2018/11/24.
 */
@Api(description = "产品明细信息api接口")
@RestController
@RequestMapping("/mt/alone/product/dets")
public class MtAloneProductDetController {

	@Autowired
	private MtAloneProductDetService mtAloneProductDetService;
	@Autowired
	private MtAloneProductService mtAloneProductService;
	@Autowired
	private CellInfoService cellInfoService;
	@Autowired
	private MtAloneRelocateRecordService mtAloneRelocateRecordService;
	@Autowired
	private MtAloneBarcodeService mtAloneBarcodeService;
	@Autowired
	private MtAloneDetectDetService mtAloneDetectDetService;
	@Autowired
	private MtAloneDeliveryDetService mtAloneDeliveryDetService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加商品明细", type = "增加")
	@ApiOperation(value = "添加商品明细信息", notes = "添加商品明细信息")
	@PostMapping("/add")
	public Result add(@RequestBody MtAloneProductDet mtAloneProductDet) {
		MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(mtAloneProductDet.getWarehouseBarcode());
		MtAloneProductDetCriteria criteria = new MtAloneProductDetCriteria();
		criteria.setProductBarcode(mtAloneProductDet.getWarehouseBarcode());
		Integer maxIndex = mtAloneProductDetService.findMaxIndex(criteria);
		// 设置创建时间和卷号
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		String bach1 = sdf1.format(date);
		String productDetRondom = RandomUtil.generateString(6);
		String productDetBarcode = "DET" + bach1 + productDetRondom;

		mtAloneProductDet.setProductId(mtAloneProduct.getId());
		mtAloneProductDet.setProductDetBarcode(productDetBarcode);
		mtAloneProductDet.setProductDetIndex(maxIndex + 1);
		mtAloneProductDet.setCreateTime(new Date());
		mtAloneProductDet.setDeliveryState(0);
		mtAloneProductDet.setIsCompleteOut(0);
		mtAloneProductDet.setIsDetection(0);
		mtAloneProductDet.setState("normal");
		mtAloneProductDetService.save(mtAloneProductDet);

		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加商品明细", type = "增加")
	@ApiOperation(value = "添加商品明细信息", notes = "添加商品明细信息")
	@PostMapping("/add/new")
	public Result addNew(@RequestBody MtAloneProductDet mtAloneProductDet, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			mtAloneProductDet.setCompanyId(currentUser.getCompanyId());
		} else {
			mtAloneProductDet.setCompanyId(null);
		}

		MtAloneProduct mtAloneProduct = mtAloneProductService.findById(mtAloneProductDet.getProductId());
		MtAloneProductDetCriteria criteria = new MtAloneProductDetCriteria();
		criteria.setProductBarcode(mtAloneProduct.getProductBarCode());
		Integer maxIndex = mtAloneProductDetService.findMaxIndex(criteria);

		MtAloneBarcode mtAloneBarcode = new MtAloneBarcode();
		String maxBarcode = mtAloneBarcodeService.getMaxBarcode();
		String productDetBarcode = BillManagePublicMethod.creatBarCode(maxBarcode);
		mtAloneBarcode.setBarcode(productDetBarcode);
		mtAloneBarcodeService.save(mtAloneBarcode);

		//单独增加的明细三个长度已经在前台赋值了
		mtAloneProductDet.setProductId(mtAloneProduct.getId());
		mtAloneProductDet.setProductDetBarcode(productDetBarcode);
		mtAloneProductDet.setWarehouseBarcode(mtAloneProduct.getProductBarCode());
		mtAloneProductDet.setProductDetIndex(maxIndex + 1);
		mtAloneProductDet.setCreateTime(new Date());
		mtAloneProductDet.setDeliveryState(0);
		mtAloneProductDet.setIsCompleteOut(0);
		//单独添加的明细就默认为检测过了
		mtAloneProductDet.setIsDetection(1);
		mtAloneProductDet.setState("normal");
		mtAloneProductDet.setCellCode(mtAloneProduct.getCellCode());
		mtAloneProductDetService.save(mtAloneProductDet);
        //检测表中也增加相应记录
		MtAloneDetectDet mtAloneDetectDet = new MtAloneDetectDet();
		mtAloneDetectDet.setProductBarcode(mtAloneProduct.getProductBarCode());
		mtAloneDetectDet.setProductDetBarcode(productDetBarcode);
		mtAloneDetectDet.setDetectLength(mtAloneProductDet.getSalableProductLength());
		mtAloneDetectDet.setCompanyId(mtAloneProductDet.getCompanyId());
		mtAloneDetectDet.setCreateTime(new Date());
		mtAloneDetectDet.setCreateManId(currentUser.getUserId());
		mtAloneDetectDetService.save(mtAloneDetectDet);

		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "批量分配仓位", type = "更新")
	@ApiOperation(value = "批量分配仓位", notes = "批量分配仓位")
	@PostMapping("/distribute")
	public Result distributeBatchCell(@RequestBody MtAloneProductDetNewCell mtAloneProductDetNewCells) {
		List<MtAloneProductDet> mtAloneProductDets = new ArrayList();
		mtAloneProductDets = mtAloneProductDetNewCells.getMtAloneProductDetList();
		List<MtAloneProductDet> mtAloneProductDets2 = new ArrayList();
		for (int i = 0; i < mtAloneProductDets.size(); i++) {
			MtAloneProductDet mtAloneProductDet = new MtAloneProductDet();
			BeanUtils.copyProperties(mtAloneProductDets.get(i), mtAloneProductDet);
			mtAloneProductDets2.add(mtAloneProductDet);
		}
		List<MtAloneRelocateRecord> mtAloneRelocateRecordList = new ArrayList();
		// 设置入库时间
		Date warehouseEntryTime = new Date();
		CellInfo cellInfo = cellInfoService.findByCellCode(mtAloneProductDetNewCells.getNewCellCode());
		cellInfo.setState(1);
		cellInfoService.update(cellInfo);
		// ---------------------------------------------生成移仓记录，更新明细---------------------------------------------------------------------------
		for (int i = 0; i < mtAloneProductDets.size(); i++) {
			if (mtAloneProductDets.get(i).getCellCode() != null
					&& mtAloneProductDets.get(i).getCellCode() != mtAloneProductDetNewCells.getNewCellCode()) {
				MtAloneRelocateRecord mtAloneRelocateRecord = new MtAloneRelocateRecord();
				mtAloneRelocateRecord.setDetectionBarcode(mtAloneProductDets.get(i).getProductDetBarcode());
				mtAloneRelocateRecord.setBeforeCellCode(mtAloneProductDets.get(i).getCellCode());
				mtAloneRelocateRecord.setAfterCellCode(mtAloneProductDetNewCells.getNewCellCode());
				mtAloneRelocateRecord.setRelocateTime(new Date());
				mtAloneRelocateRecordList.add(mtAloneRelocateRecord);
			}
			mtAloneProductDets.get(i).setWarehouseEntryTime(warehouseEntryTime);
			mtAloneProductDets.get(i).setProductDetState(1);
			mtAloneProductDets.get(i).setCellCode(mtAloneProductDetNewCells.getNewCellCode());
			mtAloneProductDetService.update(mtAloneProductDets.get(i));
		}
		if (mtAloneRelocateRecordList.size() != 0) {
			mtAloneRelocateRecordService.save(mtAloneRelocateRecordList);
		}
		// -----------------------------------------------更新产品的入库状态-----------------------------------------------------------------------
		String productBarCode = mtAloneProductDets.get(0).getWarehouseBarcode();
		MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(productBarCode);
		// 产品的卷数
		Integer wareNum = mtAloneProduct.getWareNum();
		// 如果不检测，将商品入库状态改为全部入库
		if (mtAloneProduct.getIsDetection() == 0) {
			mtAloneProduct.setProductState(2);
			mtAloneProductService.update(mtAloneProduct);
		}
		if (mtAloneProduct.getIsDetection() == 1) {
			// 要将明细剩余长度为0的明细过滤掉
			Integer cunKuNum = mtAloneProductDetService.findCountByProductBarcode(productBarCode);
			if (cunKuNum == wareNum) {
				// 产品状态为全部入库
				mtAloneProduct.setProductState(2);
				mtAloneProductService.update(mtAloneProduct);
			} else {
				// 产品状态为部分入库
				mtAloneProduct.setProductState(1);
				mtAloneProductService.update(mtAloneProduct);
			}
		}
		// ----------------------------------------------更新明细之前仓位的状态----------------------------------------------------------------------
		Integer isnull = 0;
		for (int i = 0; i < mtAloneProductDets2.size(); i++) {
			if (mtAloneProductDets2.get(i).getCellCode() != null) {
				isnull = 1;
			}
		}
		if (isnull == 1) {
			// 将移仓之前的仓位的状态进行更新,首先对仓位去重
			List<MtAloneProductDet> uniqueDetList = mtAloneProductDets2.stream()
					.collect(Collectors.collectingAndThen(
							Collectors.toCollection(
									() -> new TreeSet<>(Comparator.comparing(MtAloneProductDet::getCellCode))),
							ArrayList::new));
			List<String> cellCodeList = new ArrayList();
			for (int i = 0; i < uniqueDetList.size(); i++) {
				cellCodeList.add(uniqueDetList.get(i).getCellCode());
			}
			// 更新该仓位的状态
			for (int i = 0; i < cellCodeList.size(); i++) {
				Integer count = mtAloneProductDetService.findCountByCellCode(cellCodeList.get(i));
				if (count == 0) {
					CellInfo cell = cellInfoService.findByCellCode(cellCodeList.get(i));
					cell.setState(0);
					cellInfoService.update(cell);
				}
			}
		}
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "一键分配仓位", type = "更新")
	@ApiOperation(value = "一键分配仓位", notes = "一键分配仓位")
	@PostMapping("/onekeydistribute")
	public Result onekeydistributeCell(@RequestBody MtAloneProductDetCriteria criteria) {
		// 存放移仓流水记录
		List<MtAloneRelocateRecord> mtAloneRelocateRecordList = new ArrayList();
		List<MtAloneProductDet> detList = mtAloneProductDetService.findDetilByProductBarcode(criteria);

		CellInfo cellInfo = cellInfoService.findByCellCode(criteria.getCellCode());
		cellInfo.setState(1);
		cellInfoService.update(cellInfo);
		// -------------------------------------------------生成移仓记录---------------------------------------------------------------------
		for (int i = 0; i < detList.size(); i++) {
			if (detList.get(i).getCellCode() != null && detList.get(i).getCellCode() != criteria.getCellCode()) {
				MtAloneRelocateRecord mtAloneRelocateRecord = new MtAloneRelocateRecord();
				mtAloneRelocateRecord.setDetectionBarcode(detList.get(i).getProductDetBarcode());
				mtAloneRelocateRecord.setBeforeCellCode(detList.get(i).getCellCode());
				mtAloneRelocateRecord.setAfterCellCode(criteria.getCellCode());
				mtAloneRelocateRecord.setRelocateTime(new Date());
				mtAloneRelocateRecordList.add(mtAloneRelocateRecord);
			}
		}
		if (mtAloneRelocateRecordList.size() != 0) {
			mtAloneRelocateRecordService.save(mtAloneRelocateRecordList);
		}

		// ------------------------------------------------一键分配，更新产品-----------------------------------------------------------------
		// 设置入库时间
		criteria.setWarehouseEntryTime(new Date());
		mtAloneProductDetService.setCellByOneKey(criteria);
		MtAloneProduct mtAloneProduct = mtAloneProductService.findBy("productBarCode", criteria.getProductBarcode());
		mtAloneProduct.setProductState(2);
		mtAloneProductService.update(mtAloneProduct);
		// --------------------------------------------------更新之前仓位的状态--------------------------------------------------------------------
		Integer isnull = 0;
		for (int i = 0; i < detList.size(); i++) {
			if (detList.get(i).getCellCode() != null) {
				isnull = 1;
			}
		}
		if (isnull == 1) {
			List<MtAloneProductDet> uniqueDetList = detList.stream()
					.collect(Collectors.collectingAndThen(
							Collectors.toCollection(
									() -> new TreeSet<>(Comparator.comparing(MtAloneProductDet::getCellCode))),
							ArrayList::new));
			List<String> cellCodeList = new ArrayList();

			for (int i = 0; i < uniqueDetList.size(); i++) {
				cellCodeList.add(uniqueDetList.get(i).getCellCode());
			}

			for (int i = 0; i < cellCodeList.size(); i++) {
				Integer count = mtAloneProductDetService.findCountByCellCode(cellCodeList.get(i));
				if (count == 0) {
					CellInfo cell = cellInfoService.findByCellCode(cellCodeList.get(i));
					cell.setState(0);
					cellInfoService.update(cell);
				}
			}
		}
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除明细", type = "删除")
	@ApiOperation(value = "删除商品明细信息", notes = "删除商品明细信息")
	@DeleteMapping("/delete/{mtAloneProductDetId}")
	public Result delete(@PathVariable Integer mtAloneProductDetId) {
		MtAloneProductDet mtAloneProductDet = mtAloneProductDetService.findById(mtAloneProductDetId);
		// 如果该明细未出过库，可以删除
		if (mtAloneProductDet.getDeliveryState() == 0) {
			mtAloneProductDetService.deleteById(mtAloneProductDetId);
			MtAloneDetectDet mtAloneDetectDet = mtAloneDetectDetService.findBy("productDetBarcode",
					mtAloneProductDet.getProductDetBarcode());
			mtAloneDetectDetService.deleteById(mtAloneDetectDet.getDetectId());
		}
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改商品明细信息", type = "更新")
	@ApiOperation(value = "修改商品明细信息", notes = "修改商品明细信息")
	@PostMapping("/update")
	public Result update(@RequestBody MtAloneProductDet mtAloneProductDet) {
		// 如果该明细未出过库，可以更新
		if (mtAloneProductDet.getDeliveryState() == 0) {
			mtAloneProductDetService.update(mtAloneProductDet);
			MtAloneDetectDet mtAloneDetectDet = mtAloneDetectDetService.findBy("productDetBarcode",
					mtAloneProductDet.getProductDetBarcode());
			mtAloneDetectDet.setDetectLength(mtAloneProductDet.getSalableProductLength());
			mtAloneDetectDetService.update(mtAloneDetectDet);
		}
		return ResultGenerator.genSuccessResult();
	}


	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改商品明细信息", type = "更新")
	@ApiOperation(value = "修改商品明细信息", notes = "修改商品明细信息")
	@PostMapping("/update/all")
	public Result updateAll(@RequestBody MtAloneProductDets mtAloneProductDetList) {
		for(MtAloneProductDet det : mtAloneProductDetList.getMtAloneProductDetList()){
			mtAloneProductDetService.update(det);
		}
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据ID查询单个明细信息", type = "查询")
	@ApiOperation(value = "单个商品明细信息", notes = "单个商品明细信息")
	@GetMapping("/{id}")
	public Result detail(@PathVariable Integer id) {
		MtAloneProductDet mtAloneProductDet = mtAloneProductDetService.findById(id);
		return ResultGenerator.genSuccessResult(mtAloneProductDet);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品明细信息列表分页息", type = "查询")
	@ApiOperation(value = "商品明细信息列表分页", notes = "商品明细信息列表分页")
	@GetMapping("/list")
	public Result list(@RequestBody MtAloneProductDetCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<MtAloneProductDet> list = mtAloneProductDetService.findList(criteria);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
	        @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "出入库明细信息列表分页息", type = "查询")
	@ApiOperation(value = "出入库明细信息列表分页", notes = "出入库明细信息列表分页")
	@GetMapping("/list/new")
	public Result listNew(MtAloneProductDetParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		PageInfo pageInfo = null;
		if (params.getProductDetType() == 0) {
			List<MtAloneDetectDetVO> list = mtAloneDetectDetService.findListNew(params);
			pageInfo = new PageInfo(list);
		}
		if (params.getProductDetType() == 1) {
			List<MtAloneDeliveryDetVO> list = mtAloneDeliveryDetService.findListNew(params);
			pageInfo = new PageInfo(list);
		}
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@OperateLog(description = "明细信息列表分页parmas", type = "查询")
	@ApiOperation(value = "明细信息列表分页parmas", notes = "出入库明细信息列表分页parmas")
	@GetMapping("/list/params")
	public Result listParams(MtAloneProductDetParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<MtAloneDetectDetVO> list = mtAloneDetectDetService.findListNew(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "单个产品对应产品明细信", type = "查询")
	@ApiOperation(value = "单个产品对应产品明细信息", notes = "单个产品对应产品明细信息")
	@GetMapping("/ProductBarcode")
	public Result detailByBarcode(MtAloneProductDetCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<MtAloneProductDet> list = mtAloneProductDetService.findDetilByProductBarcode(criteria);
//		MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(list.get(0).getWarehouseBarcode());
//		for(int i=0;i<list.size();i++) {
//			list.get(i).setColorName(mtAloneProduct.getColorName());
//			list.get(i).setDyelotNum(mtAloneProduct.getDyelotNum());
//		}
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "单个产品对应产品明细信", type = "查询")
	@ApiOperation(value = "单个产品对应产品明细信息,检测用", notes = "单个产品对应产品明细信息,检测用")
	@GetMapping("/detection/ProductBarcode")
	public Result detailByProBarcode(MtAloneProductDetCriteria criteria, @User CurrentUser currentUser) {
		MtAloneProductCellVO mtAloneProduct = mtAloneProductService.findByBarcodeNew(criteria.getProductBarcode());
		if(mtAloneProduct.getCompanyId()!=currentUser.getCompanyId()) {
			return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"非该用户产品",null );
		}
		List<MtAloneProductDetDto> listDto=new ArrayList<MtAloneProductDetDto>();
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<MtAloneProductDet> list = mtAloneProductDetService.findDetilByProductBarcode(criteria);
		for(int i=0;i<list.size();i++) {
			MtAloneProductDetDto mtAloneProductDetDto=new MtAloneProductDetDto();
			BeanUtils.copyProperties(list.get(i),mtAloneProductDetDto);
			mtAloneProductDetDto.setColorName(mtAloneProduct.getColorName());
			mtAloneProductDetDto.setDyelotNum(mtAloneProduct.getDyelotNum());
			mtAloneProductDetDto.setProductCode(mtAloneProduct.getProductCode());
			mtAloneProductDetDto.setItemCode(mtAloneProduct.getItemCode());
			mtAloneProductDetDto.setProductName(mtAloneProduct.getProductName());
			mtAloneProductDetDto.setCellCode(mtAloneProduct.getCellCode());
			mtAloneProductDetDto.setCellName(mtAloneProduct.getCellName());
			listDto.add(mtAloneProductDetDto);
		}
		PageInfo pageInfo = new PageInfo(listDto);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
//	@OperateLog(description = "单个产品对应产品明细信", type = "查询")
//	@ApiOperation(value = "单个产品对应产品明细信息", notes = "单个产品对应产品明细信息")
//	@GetMapping("/detsByProductId")
//	public Result detsById(MtAloneProductDetParams params, @ApiIgnore @User CurrentUser currentUser) {
//		if (currentUser == null) {
//			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
//		}
//
//		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
//			params.setCompanyId(currentUser.getCompanyId());
//		} else {
//			params.setCompanyId(null);
//		}
//		PageHelper.startPage(params.getPageNum(), params.getPageSize());
//		List<MtAloneProductDetDto> list = mtAloneProductDetService.findDetilByProductId(params);
//		List<MtAloneProductDetExamDto> detExaminationDetailsList = new ArrayList<MtAloneProductDetExamDto>();
//		if(!list.isEmpty()){
//			List<MtAloneExaminationDetails> listExaminationDetails=mtAloneProductDetService.findDetExaminationDetails(list.get(0).getWarehouseBarcode());
//			for(int i=0;i<list.size();i++){
//				MtAloneProductDetExamDto mtAloneProductDetExamDto=new MtAloneProductDetExamDto();
//				BeanUtils.copyProperties(list.get(i),mtAloneProductDetExamDto);
//				for(int j=0;j<listExaminationDetails.size();j++){
//					if(list.get(i).getProductDetBarcode().equals(listExaminationDetails.get(j).getProductDetBarcode())){
//						mtAloneProductDetExamDto.getDetExaminationDetailsList().add(listExaminationDetails.get(j));
//					}
//				}
//				detExaminationDetailsList.add(mtAloneProductDetExamDto);
//			}
//			PageInfo pageInfo = new PageInfo(detExaminationDetailsList);
//			return ResultGenerator.genSuccessResult(pageInfo);
//		}else{
//			PageInfo pageInfo = new PageInfo(list);
//			return ResultGenerator.genSuccessResult(pageInfo);
//		}
//	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "单个产品对应产品明细信", type = "查询")
	@ApiOperation(value = "单个产品对应产品明细信息", notes = "单个产品对应产品明细信息")
	@GetMapping("/detsByProductBarCode")
	public Result detsById(MtAloneProductDetParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		QueryParamsDet detParams=new QueryParamsDet();
		BeanUtils.copyProperties(params, detParams);
		detParams.setPageNumber(params.getPageNum());
		detParams.setPageSizes(params.getPageSize());
		detParams.setStartRow((detParams.getPageNumber()-1)*detParams.getPageSizes());
		List<MtAloneDetFabsListVO> listExaminationDetails=mtAloneProductDetService.findDetExaminationDetails(detParams);
		return ResultGenerator.genSuccessResult(listExaminationDetails);
	}
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "单个产品对应产品明细信，不含瑕疵", type = "查询")
	@ApiOperation(value = "单个产品对应产品明细信息，不含瑕疵", notes = "单个产品对应产品明细信息，不含瑕疵")
	@GetMapping("/detsWithoutFabs")
	public Result detsWithoutFabs(MtAloneProductDetParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		QueryParamsDet detParams=new QueryParamsDet();
		BeanUtils.copyProperties(params, detParams);
		detParams.setPageNumber(params.getPageNum());
		detParams.setPageSizes(params.getPageSize());
		detParams.setStartRow((detParams.getPageNumber()-1)*detParams.getPageSizes());
		List<MtAloneDetFabsListVO> listExaminationDetails=mtAloneProductDetService.findDetsWithoutFabs(detParams);
		return ResultGenerator.genSuccessResult(listExaminationDetails);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "仓位号查询产品明细", type = "查询")
	@ApiOperation(value = "仓位号查询产品明细", notes = "仓位号查询产品明细")
	@GetMapping("/listDetByCellCode")
	public Result listByCellCode(MtAloneProductDetCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<MtAloneProductDet> list = mtAloneProductDetService.findDetByCellCode(criteria);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据仓库id统计首页面8个参数", type = "查询")
	@ApiOperation(value = "根据仓库id统计首页面8个参数", notes = "根据仓库id统计首页面8个参数")
	@GetMapping("/countByWareCode")
	public Result countParamByWareCode(MtAloneProductDetCriteria criteria) {

		int inventoryDet = mtAloneProductDetService.findInventoryDet(criteria);

		int forReviewPro = mtAloneProductDetService.findForReviewPro(criteria);

		int allDeliveryDet = mtAloneProductDetService.findAllDeliveryDet(criteria);

		// int detectedDet = mtAloneProductDetService.findDetectedDet(criteria);

		int forOnShelfDet = mtAloneProductDetService.findForOnShelfDet(criteria);

		int onShelfDet = mtAloneProductDetService.findOnShelfDet(criteria);

		// int forDetecteDet = mtAloneProductDetService.findForDetecteDet(criteria);

		int deliveryedDet = mtAloneProductDetService.findDeliveryedDet(criteria);

		MtAloneProductDetView count = new MtAloneProductDetView();

		count.setInventoryDet(inventoryDet);
		count.setForReviewPro(forReviewPro);
		count.setAllDeliveryDet(allDeliveryDet);
		// count.setDetectedDet(detectedDet);
		count.setDetectedDet(0);
		count.setForOnShelfDet(forOnShelfDet);
		count.setOnShelfDet(onShelfDet);
		// count.setForDetecteDet(forDetecteDet);
		count.setForDetecteDet(0);
		count.setDeliveryedDet(deliveryedDet);

		return ResultGenerator.genSuccessResult(count);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据仓库id统计货位利用率", type = "查询")
	@ApiOperation(value = "根据仓库id统计货位利用率", notes = "根据仓库id统计货位利用率")
	@GetMapping("/countUtilizationByWareCode")
	public Result countUtilizationByWareCode(MtAloneHomePageCriteria criteria) {
		Double utilization = mtAloneProductDetService.findUtilizationByWareCode(criteria);
		return ResultGenerator.genSuccessResult(utilization);
	}

}
