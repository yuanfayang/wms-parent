package com.deer.wms.detect.web;


import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneDetectDet;
import com.deer.wms.bill.manage.model.MtAloneDetectDetDto;
import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductCellVO;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDetDto;
import com.deer.wms.bill.manage.model.MtAloneProductDetVO;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;
import com.deer.wms.bill.manage.service.MtAloneDetectDetService;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.detect.model.MtAloneComProDetFabric;

import com.deer.wms.detect.model.MtAloneExaminationDetails;
import com.deer.wms.detect.model.MtAloneExaminationDetailsCriteria;
import com.deer.wms.detect.model.MtAloneProductDetFabrics;
import com.deer.wms.detect.model.MtAloneProductFabrics;

import com.deer.wms.detect.service.MtAloneExaminationDetailsService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
* Created by zth on 2018/12/18.
*/
@Api(description = "质量检测明细瑕疵接口")
@RestController
@RequestMapping("/mt/alone/examination/detailss")
public class MtAloneExaminationDetailsController {

    @Autowired
    private MtAloneExaminationDetailsService mtAloneExaminationDetailsService;
    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;
    @Autowired
    private MtAloneProductService mtAloneProductService;
    @Autowired
    private MtAloneDetectDetService mtAloneDetectDetService;
    @Autowired
    private MtAloneBarcodeService mtAloneBarcodeService;
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "保存明细的瑕疵信息", type = "增加")
    @PostMapping("/saveDefectDetails")
    @ApiOperation(value="保存明细的瑕疵信息",notes="保存明细的瑕疵信息")
    public Result add(@RequestBody List<MtAloneExaminationDetails> mtAloneExaminationDetails) {
		for(int i=0;i<mtAloneExaminationDetails.size();i++) {
			Date addTime=new Date();
			mtAloneExaminationDetails.get(i).setAddtime(addTime);
//			mtAloneExaminationDetails.get(i).setDeletestatus(0);
		}
        mtAloneExaminationDetailsService.save(mtAloneExaminationDetails);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "更新明细的瑕疵信息", type = "更新")
    @PostMapping("/updateDefectDetails")
    @ApiOperation(value="更新明细的瑕疵信息",notes="更新明细的瑕疵信息")
    public Result update(@RequestBody List<MtAloneExaminationDetails> mtAloneExaminationDetails) {

	    if(mtAloneExaminationDetails.size()==0){
            return ResultGenerator.genSuccessResult();
        }
	    //先删除之前的记录
        String productDetBarcode = mtAloneExaminationDetails.get(0).getProductDetBarcode();
        mtAloneExaminationDetailsService.deleteByProductBarcode(productDetBarcode);
        if(mtAloneExaminationDetails.get(0).getFabricId() != null){
            add(mtAloneExaminationDetails);
        }
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据明细瑕疵ID删除明细瑕疵信息", type = "删除")
    @GetMapping("/deleteDefectDetail")
    @ApiOperation(value="根据明细瑕疵ID删除明细瑕疵信息",notes="根据明细瑕疵ID删除明细瑕疵信息")
    public Result delete( Integer id) {
        mtAloneExaminationDetailsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "更新明细瑕疵信息", type = "更新")
    @PostMapping("/updateDefectDetail")
    @ApiOperation(value="更新明细瑕疵信息",notes="更新明细瑕疵信息")
    public Result update(@RequestBody MtAloneExaminationDetails mtAloneExaminationDetails) {
        mtAloneExaminationDetailsService.update(mtAloneExaminationDetails);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据ID获取明细瑕疵信息", type = "查询")
    @GetMapping("/findDefectDetailById")
    @ApiOperation(value="根据ID获取明细瑕疵信息",notes="根据ID获取明细瑕疵信息")
    public Result detail(Integer id) {
        MtAloneExaminationDetails mtAloneExaminationDetails = mtAloneExaminationDetailsService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneExaminationDetails);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据明细条码获得该明细的所有瑕疵/分页", type = "查询")
    @GetMapping("/findListByBarcode")
    @ApiOperation(value="根据明细条码获得该明细的所有瑕疵/分页",notes="根据明细条码获得该明细的所有瑕疵/分页")
    public Result list(MtAloneExaminationDetailsCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneExaminationDetails> list = mtAloneExaminationDetailsService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据明细条形码获取该明细信息", type = "查询")
    @GetMapping("/findProductDetByBarCode")
    @ApiOperation(value="根据明细条形码获取该明细信息",notes="根据明细条形码获取该明细信息")
    public Result productDetByBarCode(String productDetBarCode) {
    	MtAloneProductDetDto mtAloneProductDetDto=new MtAloneProductDetDto();
        MtAloneProductDet mtAloneProductDet= mtAloneProductDetService.findProductDetByBarCode(productDetBarCode);
        MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(mtAloneProductDet.getWarehouseBarcode());
        BeanUtils.copyProperties(mtAloneProductDet,mtAloneProductDetDto);
        mtAloneProductDetDto.setProductName(mtAloneProduct.getProductName());
        return ResultGenerator.genSuccessResult(mtAloneProductDetDto);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据产品条形码获取明细瑕疵信息", type = "查询")
    @GetMapping("/findFabricDetsByProCode")
    @ApiOperation(value="根据产品条形码获取明细瑕疵信息",notes="根据产品条形码获取明细瑕疵信息")
    public Result fabricDetsByProCode(MtAloneExaminationDetailsCriteria criteria) {
		String productBarCode = criteria.getProductBarCode();
    	List<String> productBarCodeList= new ArrayList<>();
    	productBarCodeList.add(productBarCode);
    	//最外层----产品层
    	List<MtAloneProductFabrics>mtAloneProductFabricsList=new ArrayList<>();

    	for(int i=0;i<productBarCodeList.size();i++) {
    		MtAloneProductFabrics mtAloneProductFabrics=new MtAloneProductFabrics();
    		
    		String productBarcode=productBarCodeList.get(i);
    		List<MtAloneComProDetFabric> mtAloneComProDetFabricList=mtAloneExaminationDetailsService.findFabricDetsByProCode(productBarcode);
        	List<MtAloneComProDetFabric> uniqueDetList = mtAloneComProDetFabricList.stream().collect(
                    Collectors.collectingAndThen(
                            Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MtAloneComProDetFabric::getProductDetBarcode))), ArrayList::new)
            );
        	List<String>productDetCodeList=new ArrayList();
        	for(int j=0;j<uniqueDetList.size();j++) {
        		productDetCodeList.add(uniqueDetList.get(j).getProductDetBarcode());
        	}
        		
        	//第二层----明细层
        	List<MtAloneProductDetFabrics>mtAloneProductDetFabricList=new ArrayList();
    	
        	for(int k=0;k<productDetCodeList.size();k++) {
        		MtAloneProductDetFabrics mtAloneProductDetFabrics=new MtAloneProductDetFabrics();
        		//第三层----瑕疵层
        		List<MtAloneExaminationDetails>mtAloneExaminationDetList=new ArrayList();
    		
        		for(int s=0;s<mtAloneComProDetFabricList.size();s++) {
        			if(mtAloneComProDetFabricList.get(s).getProductDetBarcode().equals(productDetCodeList.get(k))) {
        				MtAloneExaminationDetails mtAloneExaminationDetails=new MtAloneExaminationDetails();
        				mtAloneExaminationDetails.setPosition(mtAloneComProDetFabricList.get(s).getPosition());
        				mtAloneExaminationDetails.setDescription(mtAloneComProDetFabricList.get(s).getDescription());
        				mtAloneExaminationDetList.add(mtAloneExaminationDetails);
        				
        				mtAloneProductDetFabrics.setColorName(mtAloneComProDetFabricList.get(s).getColorName());
        				mtAloneProductDetFabrics.setNote(mtAloneComProDetFabricList.get(s).getDetNote());
        				mtAloneProductDetFabrics.setProductDetBarCode(mtAloneComProDetFabricList.get(s).getProductDetBarcode());
        				mtAloneProductDetFabrics.setProductDetIndex(mtAloneComProDetFabricList.get(s).getProductDetIndex());
        				mtAloneProductDetFabrics.setProductLevel(mtAloneComProDetFabricList.get(s).getProductLevel());
        				mtAloneProductDetFabrics.setRemainLength(mtAloneComProDetFabricList.get(s).getRemainLength());
        				mtAloneProductDetFabrics.setDetectLength(mtAloneComProDetFabricList.get(s).getDetectLength());
        				
        				mtAloneProductFabrics.setDyelotNum(mtAloneComProDetFabricList.get(s).getDyelotNum());
        				mtAloneProductFabrics.setGrammage(mtAloneComProDetFabricList.get(s).getGrammage());
        				mtAloneProductFabrics.setLarghezza(mtAloneComProDetFabricList.get(s).getLarghezza());
        				mtAloneProductFabrics.setSpecification(mtAloneComProDetFabricList.get(s).getSpecification());
        				mtAloneProductFabrics.setProductBarCode(mtAloneComProDetFabricList.get(s).getProductBarCode());
        				mtAloneProductFabrics.setProductName(mtAloneComProDetFabricList.get(s).getProductName());
        				mtAloneProductFabrics.setProductCode(mtAloneComProDetFabricList.get(s).getProductCode());
        			}
        		}
        		mtAloneProductDetFabrics.setMtAloneExaminationDetList(mtAloneExaminationDetList);
        		mtAloneProductDetFabricList.add(mtAloneProductDetFabrics);
        	}
        	mtAloneProductFabrics.setMtAloneProductDetFabricList(mtAloneProductDetFabricList);
        	mtAloneProductFabricsList.add(mtAloneProductFabrics);
    	}

        return ResultGenerator.genSuccessResult(mtAloneProductFabricsList);
    }
	
//------------------------------------------增加检测明细表，调整之前的业务----------------------------------------------------------------------------------
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "推送一条明细", type = "保存")
	@GetMapping("/productBarcode")
    @ApiOperation(value="检测时，每调用一次该方法可获取该产品下一条未检测的明细",notes="检测时，每调用一次该方法可获取该产品下一条未检测的明细")
    public Result findOneProductDet(String productBarcode,@ApiIgnore @User CurrentUser currentUser) {
    	MtAloneProductDetDto mtAloneProductDetDto=new MtAloneProductDetDto();
        MtAloneProductCellVO mtAloneProduct = mtAloneProductService.findByBarcodeNew(productBarcode);
        if(mtAloneProduct==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"仓库内没有该产品！",null );
        }
        MtAloneProductDetCriteria criteria=new MtAloneProductDetCriteria();
        criteria.setProductBarcode(productBarcode);
        MtAloneProductDet mtAloneProductDet=mtAloneProductDetService.getIsNotDetectDet(criteria);
    	if(mtAloneProductDet!=null) {
            BeanUtils.copyProperties(mtAloneProductDet,mtAloneProductDetDto);
            MtAloneDetectDet mtAloneDetectDet=mtAloneDetectDetService.findBy("productDetBarcode", mtAloneProductDet.getProductDetBarcode());
            if(mtAloneDetectDet!=null) {
                mtAloneDetectDetService.deleteById(mtAloneDetectDet.getDetectId());
            }
    	}else {
            mtAloneProductDet= creatDetByProBarcode(productBarcode);
            mtAloneProductDetService.save(mtAloneProductDet);
            BeanUtils.copyProperties(mtAloneProductDet,mtAloneProductDetDto);
    	}  
        mtAloneProductDetDto.setProductName(mtAloneProduct.getProductName());
        mtAloneProductDetDto.setColorName(mtAloneProduct.getColorName());
        mtAloneProductDetDto.setDyelotNum(mtAloneProduct.getDyelotNum());
        mtAloneProductDetDto.setItemCode(mtAloneProduct.getItemCode());
        mtAloneProductDetDto.setProductCode(mtAloneProduct.getProductCode());
        mtAloneProductDetDto.setCellCode(mtAloneProduct.getCellCode());
        mtAloneProductDetDto.setCellName(mtAloneProduct.getCellName());
        mtAloneProductDetDto.setImages(mtAloneProduct.getImages());
        return ResultGenerator.genSuccessResult(mtAloneProductDetDto);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "保存检测明细，检测一条保存一条，并更新明细和产品", type = "保存、更新")
    @PostMapping("/saveDetcetDet")
    @ApiOperation(value="保存检测明细，检测一条保存一条，并更新明细和产品",notes="保存检测明细，检测一条保存一条，并更新明细和产品")
    public Result saveDetcetDet(@RequestBody MtAloneDetectDetDto mtAloneDetectDetDto,@ApiIgnore @User CurrentUser currentUser) {
		MtAloneDetectDet mtAloneDetectDet=new MtAloneDetectDet();
		BeanUtils.copyProperties(mtAloneDetectDetDto,mtAloneDetectDet);
		if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		mtAloneDetectDet.setCompanyId(currentUser.getCompanyId());
		}else{
			mtAloneDetectDet.setCompanyId(null);
        }
        Date date=new Date();
		//----------------------------------------------更新明细的三个长度和检测状态---------------------------------------------------------
        MtAloneProductDet mtAloneProductDet= mtAloneProductDetService.findProductDetByBarCode(mtAloneDetectDet.getProductDetBarcode());
        MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(mtAloneProductDet.getWarehouseBarcode());
        mtAloneProductDet.setIsDetection(1);
        mtAloneProductDet.setProductDetLength(mtAloneDetectDet.getDetectLength());
        mtAloneProductDet.setProductDetRemainLength(mtAloneDetectDet.getDetectLength());
        mtAloneProductDet.setSalableProductLength(mtAloneDetectDet.getDetectLength());
        mtAloneProductDet.setProductLevel(mtAloneDetectDetDto.getProductLevel());
        mtAloneProductDet.setDetectionTime(date);
        mtAloneProductDet.setCellCode(mtAloneProduct.getCellCode());
        mtAloneProductDet.setDetectionManName(mtAloneDetectDetDto.getDetectMachineName());
        mtAloneProductDet.setDetectionManName(currentUser.getUserName());
        mtAloneProductDet.setDetectionManId(currentUser.getUserId());
        mtAloneProductDetService.update(mtAloneProductDet);
        
        mtAloneDetectDet.setCreateManId(currentUser.getUserId());
        mtAloneDetectDet.setCreateTime(date);
		mtAloneDetectDetService.save(mtAloneDetectDet);
        
        //----------------------------------------------更新产品的检测、剩余长度------------------------------------------------------------
//        MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(mtAloneProductDet.getWarehouseBarcode());
//        Float detectLength=(float) 0;
//        if(mtAloneProduct.getProductDetectLength()!=null) {
//            detectLength=mtAloneDetectDet.getDetectLength()+mtAloneProduct.getProductDetectLength();
//            mtAloneProduct.setProductDetectLength(detectLength);
//            mtAloneProduct.setProductRemainLength(detectLength);
//        }else {
//        	mtAloneProduct.setProductDetectLength(mtAloneDetectDet.getDetectLength());
//        	mtAloneProduct.setProductRemainLength(mtAloneDetectDet.getDetectLength());
//        }
//        mtAloneProductService.update(mtAloneProduct);

        return ResultGenerator.genSuccessResult();
	}
	
	public MtAloneProductDet creatDetByProBarcode(String productBarcode) {
        MtAloneProduct mtAloneProduct = mtAloneProductService.findByBarcode(productBarcode);
        MtAloneProductDet mtAloneProductDet=new MtAloneProductDet();
        
        MtAloneProductDetCriteria criteria=new MtAloneProductDetCriteria();
        criteria.setProductBarcode(productBarcode);
        Integer maxIndex=mtAloneProductDetService.findMaxIndex(criteria);
        
        MtAloneBarcode mtAloneBarcode=new MtAloneBarcode();
        String maxBarcode=mtAloneBarcodeService.getMaxBarcode();
        String productDetBarcode=BillManagePublicMethod.creatBarCode(maxBarcode);
        mtAloneBarcode.setBarcode(productDetBarcode);
        mtAloneBarcodeService.save(mtAloneBarcode);
    	
        mtAloneProductDet.setProductDetBarcode(productDetBarcode);
        mtAloneProductDet.setWarehouseBarcode(mtAloneProduct.getProductBarCode());
    	mtAloneProductDet.setProductDetIndex(maxIndex+1);
    	mtAloneProductDet.setCreateTime(new Date());
		mtAloneProductDet.setDeliveryState(0);
		mtAloneProductDet.setIsCompleteOut(0);
		mtAloneProductDet.setIsDetection(0);
		mtAloneProductDet.setState("normal");
		mtAloneProductDet.setProductId(mtAloneProduct.getId());
		mtAloneProductDet.setCompanyId(mtAloneProduct.getCompanyId());
        mtAloneProductDet.setCellCode(mtAloneProduct.getCellCode());
   
		return mtAloneProductDet;	
	}
}
