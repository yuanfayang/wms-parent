package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDetVO;
import com.deer.wms.bill.manage.model.MtAloneProductReturnDet;
import com.deer.wms.bill.manage.model.MtAloneReturnDetAndProductDto;
import com.deer.wms.bill.manage.model.MtAloneReturnDetListDto;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;
import com.deer.wms.bill.manage.service.MtAloneFlowrecordService;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.bill.manage.service.MtAloneReturnOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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

import com.deer.wms.bill.manage.model.MtAloneReturnOrder;


/**
* Created by  on 2018/12/11.
*/
@Api(description = "产品退货单接口")
@RestController
@RequestMapping("/mt/alone/return/orders")
public class MtAloneReturnOrderController {

    @Autowired
    private MtAloneReturnOrderService mtAloneReturnOrderService;
    @Autowired
    private MtAloneProductService mtAloneProductService;
    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;
    @Autowired
    private MtAloneFlowrecordService mtAloneFlowrecordService;
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @ApiOperation(value = "生成商品退货单", notes = "生成商品退货单")
    @PostMapping("/add")
	@OperateLog(description = "生成退货单", type = "增加")
    public Result add(@RequestBody MtAloneReturnDetListDto mtAloneReturnDetListDto) {

    	MtAloneReturnOrder mtAloneReturnOrder=mtAloneReturnDetListDto.getMtAloneReturnOrder();
    	List<MtAloneProductDet> returnOrderDetList=mtAloneReturnDetListDto.getReturnOrderDetList();
 	
    	Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	String bach1 = sdf1.format(date);
    	String productRondom=RandomUtil.generateString(4);
    	String returnOrderCode="TH"+bach1+productRondom;
    	mtAloneReturnOrder.setReturnOrderCode(returnOrderCode);
    	mtAloneReturnOrder.setReturnTime(date);
    	
    	//--------------------------------------------------------------------------------------------------------------
    	//获得当前出库单有几种产品
    	List<MtAloneProductDet> uniqueDetList = returnOrderDetList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MtAloneProductDet::getWarehouseBarcode))), ArrayList::new)
        );
    	List<String>productCodeList=new ArrayList();
    	for(int i=0;i<uniqueDetList.size();i++) {
    		productCodeList.add(uniqueDetList.get(i).getWarehouseBarcode());
    	}
    	//流水记录
    	List<MtAloneFlowrecord> mtAloneFlowrecordList=new ArrayList();
    	MtAloneProduct mtAloneProduct=null;
    	MtAloneProductDetCriteria criteria=new MtAloneProductDetCriteria();
    	for(int k=0;k<productCodeList.size();k++) {
    		mtAloneProduct=mtAloneProductService.findByBarcode(productCodeList.get(k));
    		criteria.setProductBarcode(productCodeList.get(k));
            Integer maxIndex=mtAloneProductDetService.findMaxIndex(criteria);
    		for(int i=0;i<returnOrderDetList.size();i++) {
	    		if(returnOrderDetList.get(i).getWarehouseBarcode().equals(productCodeList.get(k))) {
	    			//更新产品的剩余长度
	            	Float newRemainLength=mtAloneProduct.getProductRemainLength();
	            	Float newProductLength=mtAloneProduct.getProductLength();
                	newRemainLength=newRemainLength+returnOrderDetList.get(i).getProductDetLength();
                	newProductLength=newProductLength+returnOrderDetList.get(i).getProductDetLength();
	                //更新产品的卷数
	                Integer newWareNum=mtAloneProduct.getWareNum()+1;
                	//表示退货回来的明细
                	returnOrderDetList.get(i).setReturnState(1);
                	//明细设置条形码
                	String rondomStr=RandomUtil.generateString(6);
                     returnOrderDetList.get(i).setProductDetBarcode("DET"+bach1+rondomStr);
                	 returnOrderDetList.get(i).setCreateTime(new Date());
                	 returnOrderDetList.get(i).setWarehouseBarcode(mtAloneProduct.getProductBarCode());
                	 returnOrderDetList.get(i).setColorCode(mtAloneProduct.getColorCode());
                	 returnOrderDetList.get(i).setDyelotNum(mtAloneProduct.getDyelotNum());
                	 returnOrderDetList.get(i).setColorName(mtAloneProduct.getColorName());
                	 returnOrderDetList.get(i).setRgbHex(mtAloneProduct.getRgbHex());
                	 maxIndex=maxIndex+1;
                     returnOrderDetList.get(i).setProductDetIndex(maxIndex);
                	 //将该退货明细的剩余长度默认设置为原长度
                	 returnOrderDetList.get(i).setProductDetRemainLength(returnOrderDetList.get(i).getProductDetLength());
                	 //表示出过库
                	 returnOrderDetList.get(i).setDeliveryState(1);
                	 //表示是退货进来的
                	 returnOrderDetList.get(i).setReturnState(1);
                	 //表示未出完
                	 returnOrderDetList.get(i).setIsCompleteOut(0);
                 	 //表示未上架
                	 returnOrderDetList.get(i).setProductDetState(0);
                	
                	//生成退货流水记录
                	MtAloneFlowrecord mtAloneFlowrecord=new MtAloneFlowrecord();
                	mtAloneFlowrecord.setFlowcodeState(2);
                	mtAloneFlowrecord.setProductDetBarcode(returnOrderDetList.get(i).getProductDetBarcode());
                	mtAloneFlowrecord.setProductBarcode(mtAloneProduct.getProductBarCode());
                	mtAloneFlowrecord.setProductDetReturntime(new Date());
                	mtAloneFlowrecord.setReturnOrderCode(returnOrderCode);
                	mtAloneFlowrecordList.add(mtAloneFlowrecord);
                	
                    mtAloneProduct.setProductRemainLength(newRemainLength);
                	mtAloneProduct.setProductLength(newProductLength);
	                mtAloneProduct.setWareNum(newWareNum);
	                //该产品有退货
	                mtAloneProduct.setReturnState(1);
	                //产品部分入库
	                mtAloneProduct.setProductState(1);
	                }
	        	}
            //更新产品表
            mtAloneProductService.update(mtAloneProduct);
	    	}
        //保存明细
        mtAloneProductDetService.save(returnOrderDetList);
        //保存流水记录
        mtAloneFlowrecordService.save(mtAloneFlowrecordList);
        //保存退货单
        mtAloneReturnOrderService.save(mtAloneReturnOrder);
        
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @ApiOperation(value = "删除商品退货单", notes = "删除商品退货单")
    @GetMapping("/delete")
	@OperateLog(description = "删除退货单", type = "删除")
    public Result delete( Integer mtAloneReturnOrderId) {
        mtAloneReturnOrderService.deleteById(mtAloneReturnOrderId);
        return ResultGenerator.genSuccessResult();
    }
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改退货单", type = "更新")
    @ApiOperation(value = "修改商品退货单", notes = "修改商品退货单")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneReturnDetListDto mtAloneReturnDetListDto) {
    	MtAloneReturnOrder mtAloneReturnOrder=mtAloneReturnDetListDto.getMtAloneReturnOrder();
    	List<MtAloneProductReturnDet> returnOrderDetList=mtAloneReturnDetListDto.getReturnDetList();

    	Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	String bach1 = sdf1.format(date);
        //保存退货单
        mtAloneReturnOrderService.update(mtAloneReturnOrder);
        //----------------------------------------删除该退货单之前的出库流水记录-----------------------------------------------------------
        MtAloneFlowrecordCriteria flowCriteria=new MtAloneFlowrecordCriteria();
        flowCriteria.setReturnOrderCode(mtAloneReturnOrder.getReturnOrderCode());
        mtAloneFlowrecordService.deleteByReturnOrderCode(flowCriteria);
    	
    	//--------------------------------------------------------------------------------------------------------------
    	//获得当前出库单有几种产品
    	List<MtAloneProductDet> uniqueDetList = returnOrderDetList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MtAloneProductDet::getWarehouseBarcode))), ArrayList::new)
        );
    	List<String>productCodeList=new ArrayList();
    	for(int i=0;i<uniqueDetList.size();i++) {
    		productCodeList.add(uniqueDetList.get(i).getWarehouseBarcode());
    	}
    	//流水记录
    	List<MtAloneFlowrecord> mtAloneFlowrecordList=new ArrayList();
      	List<MtAloneProductDet> mtAloneProductDetList=new ArrayList();
    	MtAloneProduct mtAloneProduct=null;
    	MtAloneProductDetCriteria criteriaDet=new MtAloneProductDetCriteria();
    	for(int k=0;k<productCodeList.size();k++) {
    		mtAloneProduct=mtAloneProductService.findByBarcode(productCodeList.get(k));
    		criteriaDet.setProductBarcode(productCodeList.get(k));
            Integer maxIndex=mtAloneProductDetService.findMaxIndex(criteriaDet);
    		for(int i=0;i<returnOrderDetList.size();i++) {
	    		if(returnOrderDetList.get(i).getWarehouseBarcode().equals(productCodeList.get(k))) {	    			
	    			if(returnOrderDetList.get(i).getIsDelete()==1) {
		    			//更新产品的剩余长度
		            	Float newRemainLength=mtAloneProduct.getProductRemainLength();
		            	Float newProductLength=mtAloneProduct.getProductLength();
	                	newRemainLength=newRemainLength-returnOrderDetList.get(i).getProductDetLength();
	                	newProductLength=newProductLength-returnOrderDetList.get(i).getProductDetLength();
		                //更新产品的卷数
		                Integer newWareNum=mtAloneProduct.getWareNum()-1;
	                    mtAloneProduct.setProductRemainLength(newRemainLength);
	                	mtAloneProduct.setProductLength(newProductLength);
		                mtAloneProduct.setWareNum(newWareNum);
		                //该产品有退货
		                mtAloneProduct.setReturnState(1);
		                //产品部分入库
		                mtAloneProduct.setProductState(1);
		                mtAloneProductDetService.deleteById(returnOrderDetList.get(i).getProductDetId());
		                continue;
	    			}

	    			if(returnOrderDetList.get(i).getIsNewCreate()==0) {
	    				returnOrderDetList.get(i).setProductDetRemainLength(returnOrderDetList.get(i).getProductDetLength());
	    				mtAloneProductDetService.update( returnOrderDetList.get(i));
		    			//更新产品的剩余长度
		            	Float newRemainLength=mtAloneProduct.getProductRemainLength();
		            	Float newProductLength=mtAloneProduct.getProductLength();
	                	newRemainLength=newRemainLength+returnOrderDetList.get(i).getProductDetLength()-returnOrderDetList.get(i).getProductDetRemainLength();
	                	newProductLength=newProductLength+returnOrderDetList.get(i).getProductDetLength()-returnOrderDetList.get(i).getProductDetRemainLength();
	                    mtAloneProduct.setProductRemainLength(newRemainLength);
	                	mtAloneProduct.setProductLength(newProductLength);
		                //该产品有退货
		                mtAloneProduct.setReturnState(1);
		                //产品部分入库
		                mtAloneProduct.setProductState(1);
	    			}else {
	    				 //表示退货回来的明细
	                	 returnOrderDetList.get(i).setReturnState(1);
	                	 //明细设置条形码
	                	 String rondomStr=RandomUtil.generateString(6);
	                     returnOrderDetList.get(i).setProductDetBarcode("DET"+bach1+rondomStr);
	                	 returnOrderDetList.get(i).setCreateTime(new Date());
	                	 returnOrderDetList.get(i).setWarehouseBarcode(mtAloneProduct.getProductBarCode());
	                	 returnOrderDetList.get(i).setColorCode(mtAloneProduct.getColorCode());
	                	 returnOrderDetList.get(i).setDyelotNum(mtAloneProduct.getDyelotNum());
	                	 maxIndex=maxIndex+1;
	                     returnOrderDetList.get(i).setProductDetIndex(maxIndex);
	                	 //将该退货明细的剩余长度默认设置为原长度
	                	 returnOrderDetList.get(i).setProductDetRemainLength(returnOrderDetList.get(i).getProductDetLength());
	                	 //表示出过库
	                	 returnOrderDetList.get(i).setDeliveryState(1);
	                	 //表示是退货进来的
	                	 returnOrderDetList.get(i).setReturnState(1);
	                	 mtAloneProductDetList.add(returnOrderDetList.get(i));
	                	 
                		//更新产品的剩余长度
		            	Float newRemainLength=mtAloneProduct.getProductRemainLength();
		            	Float newProductLength=mtAloneProduct.getProductLength();
	                	newRemainLength=newRemainLength+returnOrderDetList.get(i).getProductDetLength();
	                	newProductLength=newProductLength+returnOrderDetList.get(i).getProductDetLength();
		                //更新产品的卷数
		                Integer newWareNum=mtAloneProduct.getWareNum()+1;
	                    mtAloneProduct.setProductRemainLength(newRemainLength);
	                	mtAloneProduct.setProductLength(newProductLength);
		                mtAloneProduct.setWareNum(newWareNum);
		                //该产品有退货
		                mtAloneProduct.setReturnState(1);
		                //产品部分入库
		                mtAloneProduct.setProductState(1);
	    			}	
	              }
	        	}
            //更新产品表
            mtAloneProductService.update(mtAloneProduct);
	    	}
	        //保存明细
	    	if(mtAloneProductDetList.size()>0) {
		        mtAloneProductDetService.save(mtAloneProductDetList);
	    	}
	    	for(int i=0;i<returnOrderDetList.size();i++) {
	    		if(returnOrderDetList.get(i).getIsDelete()==0) {
	            	//生成退货流水记录
	            	MtAloneFlowrecord mtAloneFlowrecord=new MtAloneFlowrecord();
	            	mtAloneFlowrecord.setFlowcodeState(2);
	            	mtAloneFlowrecord.setProductDetBarcode(returnOrderDetList.get(i).getProductDetBarcode());
	            	mtAloneFlowrecord.setProductBarcode(returnOrderDetList.get(i).getWarehouseBarcode());
	            	mtAloneFlowrecord.setProductDetReturntime(new Date());
	            	mtAloneFlowrecord.setReturnOrderCode(mtAloneReturnOrder.getReturnOrderCode());
	            	mtAloneFlowrecordList.add(mtAloneFlowrecord);
	    		}
	    	}

	        //保存流水记录
	        mtAloneFlowrecordService.save(mtAloneFlowrecordList);
	        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据id查询单个商品退货单", type = "查询")
    @ApiOperation(value = "id查询单个商品退货单", notes = "id查询单个商品退货单")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneReturnOrder mtAloneReturnOrder = mtAloneReturnOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneReturnOrder);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品退货单列表分页", type = "查询")
    @ApiOperation(value = "商品退货单列表分页", notes = "商品退货单列表分页")
    @GetMapping("/list")
    public Result list(MtAloneReturnOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneReturnOrder> list = mtAloneReturnOrderService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据产品名称日期查询退货单列表分页", type = "查询")
    @ApiOperation(value = "产品名称日期查询退货单列表分页", notes = "产品名称日期查询退货单列表分页")
    @GetMapping("/listByProductNameAndDate")
    public Result ReturnOrderlistByProductNameAndDate(MtAloneReturnOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDeliveryOrder> list = mtAloneReturnOrderService.findListBykeyAndDate(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据退货单号查询退货明细", type = "查询")
    @ApiOperation(value = "根据退货单号查询退货明细", notes = "根据退货单号查询退货明细")
    @GetMapping("/productdetListByOrder")
    public Result productdetListByOrder(MtAloneReturnOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneProductDet> list = mtAloneReturnOrderService.findDetListByOrder(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
   
}
