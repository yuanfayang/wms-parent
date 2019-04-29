package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.project.seed.util.StringUtil;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.bill.manage.constant.BillManageConstant;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetListDto;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderVO;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetVO;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;
import com.deer.wms.bill.manage.service.MtAloneDeliveryDetService;
import com.deer.wms.bill.manage.service.MtAloneDeliveryOrderService;
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
* Created by  on 2018/12/08.
*/
@Api(description = "产品出库单接口")
@RestController
@RequestMapping("/mt/alone/delivery/orders")
public class MtAloneDeliveryOrderController {

    @Autowired
    private MtAloneDeliveryOrderService mtAloneDeliveryOrderService;
    @Autowired
    private MtAloneFlowrecordService mtAloneFlowrecordService;
    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;
    @Autowired    
    private MtAloneProductService mtAloneProductService;
    @Autowired
    private CellInfoService cellInfoService;
    @Autowired
    private MtAloneDeliveryDetService mtAloneDeliveryDetService;
    @Autowired
    private MtAloneBarcodeService mtAloneBarcodeService;

	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "生成出库单", type = "增加")
    @ApiOperation(value = "生成商品出库单", notes = "生成商品出库单")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDeliveryDetListDto mtAloneDeliveryDetListDto,@ApiIgnore @User CurrentUser currentUser) {
		
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	
    	MtAloneDeliveryOrder mtAloneDeliveryOrder= mtAloneDeliveryDetListDto.getMtAloneDeliveryOrder();   

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		mtAloneDeliveryOrder.setCompanyId(currentUser.getCompanyId());
		}else{
			mtAloneDeliveryOrder.setCompanyId(null);
        }
    	
    	//------------------------------------------------保存出库单--------------------------------------------------------------

    	String deliveryOrderCode=BillManagePublicMethod.creatOrderCode(BillManageConstant.DELIVERY_ORDER_TYPE);   	
    	mtAloneDeliveryOrder.setDeliveryOrderCode(deliveryOrderCode);     
    	mtAloneDeliveryOrder.setDeliveryTime(new Date());
    	mtAloneDeliveryOrder.setState("normal");
    	mtAloneDeliveryOrder.setCreateTime(new Date());
    	mtAloneDeliveryOrder.setUpdateTime(new Date());
        mtAloneDeliveryOrderService.save(mtAloneDeliveryOrder);

    	//保存出库明细记录       
    	List<MtAloneDeliveryDet> mtAloneDeliveryDetList=new ArrayList();
    	
    	List<MtAloneProductDetVO> deliveryOrderDetVOList= mtAloneDeliveryDetListDto.getDeliveryOrderDetVOList();
    	
    	if(deliveryOrderDetVOList.size()!=0) {

		  for(int i=0;i<deliveryOrderDetVOList.size();i++) {
	
			//当前明细的剩余长度
			Float productDetRemainLength=deliveryOrderDetVOList.get(i).getProductDetRemainLength();
			//当前明细的出库长度
			Float deliveryLength=deliveryOrderDetVOList.get(i).getDeliveryLength();
			//当前明细的最新剩余长度
			Float productDetRemainLengthNow=productDetRemainLength-deliveryLength;
			if(productDetRemainLengthNow<=0) {
				productDetRemainLengthNow=(float) 0;
				//当前明细出库完成
				deliveryOrderDetVOList.get(i).setIsCompleteOut(1);
			}
			//更新产品明细的剩余米数
			deliveryOrderDetVOList.get(i).setProductDetRemainLength(productDetRemainLengthNow);
			//更新产品明细的出库状态
			deliveryOrderDetVOList.get(i).setDeliveryState(1);
			MtAloneProductDet mtAloneProductDet=new MtAloneProductDet();
	    	BeanUtils.copyProperties(deliveryOrderDetVOList.get(i),mtAloneProductDet);
			mtAloneProductDetService.update(mtAloneProductDet);
			
			//---------------------------------------保存出库明细记录，该记录只有出库长度---------------------------------------------
			MtAloneDeliveryDet mtAloneDeliveryDet=new MtAloneDeliveryDet();
			mtAloneDeliveryDet.setCreateTime(new Date());
			mtAloneDeliveryDet.setDeliveryLength(deliveryLength);
			mtAloneDeliveryDet.setProductBarcode(mtAloneProductDet.getWarehouseBarcode());
			mtAloneDeliveryDet.setProductDetBarcode(mtAloneProductDet.getProductDetBarcode());
			mtAloneDeliveryDet.setState("normal");
			mtAloneDeliveryDet.setDeliveryOrderCode(deliveryOrderCode);
			mtAloneDeliveryDet.setCompanyId(currentUser.getCompanyId());
			mtAloneDeliveryDet.setCreateManId(currentUser.getUserId());
			mtAloneDeliveryDetList.add(mtAloneDeliveryDet);
		  }
    	}
    	//保存出库记录           
    	mtAloneDeliveryDetService.save(mtAloneDeliveryDetList);

        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除出库单", type = "删除")
    @ApiOperation(value = "删除商品出库单", notes = "删除商品出库单")
    @GetMapping("/delete")
    public Result delete( Integer mtAloneDeliveryOrderId) {
		MtAloneDeliveryOrder mtAloneDeliveryOrder=mtAloneDeliveryOrderService.findById(mtAloneDeliveryOrderId);
		MtAloneDeliveryDetParams mtAloneDeliveryDetParams=new MtAloneDeliveryDetParams();
		mtAloneDeliveryDetParams.setDeliveryOrderCode(mtAloneDeliveryOrder.getDeliveryOrderCode());
		Integer detCount=mtAloneDeliveryDetService.findDeliveryDetCountByCode(mtAloneDeliveryDetParams);
		if(detCount==0) {
	        mtAloneDeliveryOrderService.deleteById(mtAloneDeliveryOrderId);
		}
        return ResultGenerator.genSuccessResult();
    }
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除出库单new", type = "删除")
    @ApiOperation(value = "删除商品出库单new", notes = "删除商品出库单new")
    @DeleteMapping("/delete/{id}")
    public Result deleteNew(@PathVariable Integer id, @ApiIgnore @User CurrentUser currentUser) {
		
		if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
		MtAloneDeliveryOrder mtAloneDeliveryOrder=mtAloneDeliveryOrderService.findById(id);
		MtAloneDeliveryDetParams mtAloneDeliveryDetParams=new MtAloneDeliveryDetParams();
		mtAloneDeliveryDetParams.setDeliveryOrderCode(mtAloneDeliveryOrder.getDeliveryOrderCode());
		Integer detCount=mtAloneDeliveryDetService.findDeliveryDetCountByCode(mtAloneDeliveryDetParams);
		if(detCount==0) {
	        mtAloneDeliveryOrderService.deleteById(id);
		}else {
	        return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"存在出库记录，请先删除！",null);
		}
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改出库单", type = "更新")
    @ApiOperation(value = "修改商品出库单", notes = "修改商品出库单")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDeliveryDetListDto mtAloneDeliveryDetListDto,@ApiIgnore @User CurrentUser currentUser) {

		if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	
    	MtAloneDeliveryOrder mtAloneDeliveryOrder= mtAloneDeliveryDetListDto.getMtAloneDeliveryOrder();   

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		mtAloneDeliveryOrder.setCompanyId(currentUser.getCompanyId());
		}else{
			mtAloneDeliveryOrder.setCompanyId(null);
        }
    	//--------------------------------------------更新出库单-------------------------------------------------------------
 
    	Date date = new Date();
    	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmm");
    	String batch2 = sdf2.format(date);
        mtAloneDeliveryOrderService.update(mtAloneDeliveryOrder);
        
        //----------------------------------------恢复明细表中的剩余长度，删除该出库单之前的出库记录-----------------------------------------------------------
        MtAloneDeliveryDetParams params=new MtAloneDeliveryDetParams();
        params.setDeliveryOrderCode(mtAloneDeliveryOrder.getDeliveryOrderCode());     
        List<MtAloneDeliveryDet> oldMtAloneDeliveryDetList=mtAloneDeliveryDetService.findDeliveryDetsByCode(params);
        if(oldMtAloneDeliveryDetList!=null) {
        	for(int i=0;i<oldMtAloneDeliveryDetList.size();i++) {
        		MtAloneProductDet mtAloneProductDet=mtAloneProductDetService.findProductDetByBarCode(oldMtAloneDeliveryDetList.get(i).getProductDetBarcode());
        		mtAloneProductDet.setProductDetRemainLength(mtAloneProductDet.getProductDetRemainLength()+oldMtAloneDeliveryDetList.get(i).getDeliveryLength());
            	mtAloneProductDetService.update(mtAloneProductDet);
        	}
        }
        mtAloneDeliveryDetService.delDetByDeliveryOrder(params);
        
        //---------------------------------------更新产品表产品明细表增加出库记录------------------------------------------------------------
        List<MtAloneProductDetVO> deliveryOrderDetVOList= mtAloneDeliveryDetListDto.getDeliveryOrderDetVOList();

    	//保存出库明细记录       
    	List<MtAloneDeliveryDet> mtAloneDeliveryDetList=new ArrayList();
    	if(deliveryOrderDetVOList.size()!=0) {
	    	for(int i=0;i<deliveryOrderDetVOList.size();i++) {
	    		
	    		//当前明细的剩余长度
	    		Float productDetRemainLength=deliveryOrderDetVOList.get(i).getProductDetRemainLength();
	    		//当前明细的出库长度
	    		Float deliveryLength=deliveryOrderDetVOList.get(i).getDeliveryLength();
	    		//当前明细的最新剩余长度
	    		Float productDetRemainLengthNow=productDetRemainLength-deliveryLength;
	    		if(productDetRemainLengthNow<0) {
	    			productDetRemainLengthNow=(float) 0;
	    		}
	    		//更新产品明细的剩余米数
	    		deliveryOrderDetVOList.get(i).setProductDetRemainLength(productDetRemainLengthNow);
	    		//更新产品明细的出库状态
	    		deliveryOrderDetVOList.get(i).setDeliveryState(1);
	    		MtAloneProductDet mtAloneProductDet=new MtAloneProductDet();
	        	BeanUtils.copyProperties(deliveryOrderDetVOList.get(i),mtAloneProductDet);
	    		mtAloneProductDetService.update(mtAloneProductDet);
	    		
				//---------------------------------------保存出库明细记录，该记录只有出库长度---------------------------------------------
				MtAloneDeliveryDet mtAloneDeliveryDet=new MtAloneDeliveryDet();
				mtAloneDeliveryDet.setCreateTime(new Date());
				mtAloneDeliveryDet.setDeliveryLength(deliveryLength);
				mtAloneDeliveryDet.setProductBarcode(mtAloneProductDet.getWarehouseBarcode());
				mtAloneDeliveryDet.setProductDetBarcode(mtAloneProductDet.getProductDetBarcode());
				mtAloneDeliveryDet.setState("normal");
				mtAloneDeliveryDet.setDeliveryOrderCode(mtAloneDeliveryOrder.getDeliveryOrderCode());
				mtAloneDeliveryDetList.add(mtAloneDeliveryDet);

	    	}
	    	//保存出库记录           
	    	mtAloneDeliveryDetService.save(mtAloneDeliveryDetList);
    	}

        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据id查询单个商品出库单", type = "查询")
    @ApiOperation(value = "id查询单个商品出库单", notes = "id查询单个商品出库单")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDeliveryOrder mtAloneDeliveryOrder = mtAloneDeliveryOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDeliveryOrder);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品出库单列表分页", type = "查询")
    @ApiOperation(value = "商品出库单列表分页", notes = "商品出库单列表分页")
    @GetMapping("/list")
    public Result list(MtAloneDeliveryOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDeliveryOrder> list = mtAloneDeliveryOrderService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "商品出库单列表分页", type = "查询")
    @ApiOperation(value = "商品出库单列表分页", notes = "商品出库单列表分页")
    @GetMapping("/list/new")
    public Result listNew(MtAloneDeliveryOrderParams params,@ApiIgnore @User CurrentUser currentUser) {
    	
		if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	StringUtil.trimObjectStringProperties(params);

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
            params.setCompanyId(null);
        }
    	PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneDeliveryOrderVO> list = mtAloneDeliveryOrderService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据产品名称日期查询出库单列表分页", type = "查询")
    @ApiOperation(value = "产品名称日期查询出库单列表分页", notes = "产品名称日期查询出库单列表分页")
    @GetMapping("/listByClientNameAndDate")
    public Result listByKeyAndDate(MtAloneDeliveryOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDeliveryOrder> list = mtAloneDeliveryOrderService.findListBykeyAndDate(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "生成打印的出库报表", type = "查询")
    @ApiOperation(value = "生成打印的出库报表", notes = "生成打印的出库报表")
    @GetMapping("/deliveryOrderDetList")
    public Result deliveryOrderDetList(MtAloneDeliveryDetParams params,@ApiIgnore @User CurrentUser currentUser) {
		if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneDeliveryOrder> list = mtAloneDeliveryDetService.findDeliveryOrderDetList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据出库单号查询出库明细", type = "查询")
    @ApiOperation(value = "根据出库单号查询出库明细", notes = "根据出库单号查询出库明细")
    @GetMapping("/productdetListByOrder")
    public Result productdetListByOrder(MtAloneDeliveryOrderParams params,@ApiIgnore @User CurrentUser currentUser) {
		if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneProductDetVO> list = mtAloneDeliveryDetService.finddeliveryDetsByOrder(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
