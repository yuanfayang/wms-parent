package com.deer.wms.ware.task.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deer.wms.base.system.model.AreaInfo;
import com.deer.wms.bill.manage.constant.BillManageConstant;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.DateUtils;
import com.deer.wms.ware.task.model.AreaInfoDto;
import com.deer.wms.ware.task.model.CompanyProductCriteria;
import com.deer.wms.ware.task.model.CompanyProductDto;
import com.deer.wms.ware.task.model.CountPalletBatch;
import com.deer.wms.ware.task.model.InventoryInfo;
import com.deer.wms.ware.task.model.InventoryInfoCriteria;
import com.deer.wms.ware.task.model.InventoryInfoDto;
import com.deer.wms.ware.task.model.ItemTypeDto;
import com.deer.wms.ware.task.model.ShelfInfoDto;
import com.deer.wms.ware.task.model.WareInfoDto;
import com.deer.wms.ware.task.service.InventoryInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(description = "CountStockTaskController库存盘点接口")
@RequestMapping("count/stocktask")
public class InventoryInfoController {
	
	@Autowired
	private InventoryInfoService inventoryInfoService;
	
	
	@PostMapping("/add")
    public Result add(@RequestBody InventoryInfo inventoryInfo) {
        inventoryInfoService.save(inventoryInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        inventoryInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody InventoryInfo inventoryInfo) {
        inventoryInfoService.update(inventoryInfo);
        inventoryInfo.setInventoryStatus(2);
        String now =  DateUtils.getNowDateTimeString();
        inventoryInfo.setUpdateTime(now);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        InventoryInfo inventoryInfo = inventoryInfoService.findById(id);
        return ResultGenerator.genSuccessResult(inventoryInfo);
    }

	@ApiOperation(value = "库存盘点list", notes = "库存盘点list")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
    @GetMapping("/list")
    public Result list(InventoryInfoCriteria criteria,@ApiIgnore @User CurrentUser currentUser) {
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<InventoryInfoDto> list = inventoryInfoService.findList(criteria,currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiOperation(value = "公司产品明细", notes = "公司产品明细")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
    @GetMapping("/companyProduct")
	public Result companyProductDet(CompanyProductCriteria companyProductCriteria,@ApiIgnore @User CurrentUser currentUser){
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
    	PageHelper.startPage(companyProductCriteria.getPageNum(), companyProductCriteria.getPageSize());
        List<CompanyProductDto> list = inventoryInfoService.findCompanyProductDet(companyProductCriteria,currentUser);        
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
	}
	@ApiOperation(value = "公司仓库名称", notes = "公司仓库名称")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
    @GetMapping("/wareName")
    public Result wareName(@ApiIgnore @User CurrentUser currentUser) {
        List<WareInfoDto> list = inventoryInfoService.findWareName(currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	
	@ApiOperation(value = "公司货区名称", notes = "公司货区名称")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
    @GetMapping("/areaName")
    public Result areaName(@ApiIgnore @User CurrentUser currentUser) {
        List<AreaInfoDto> list = inventoryInfoService.findAreaName(currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	
	@ApiOperation(value = "公司货架名称", notes = "公司货架名称")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
    @GetMapping("/shelfName")
    public Result shelfName(@ApiIgnore @User CurrentUser currentUser) {
        List<ShelfInfoDto> list = inventoryInfoService.findShelfName(currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	
	@ApiOperation(value = "公司物料类型名称", notes = "公司物料类型名称")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
    @GetMapping("/itemTypeName")
    public Result itemTypeName(@ApiIgnore @User CurrentUser currentUser) {
        List<ItemTypeDto> list = inventoryInfoService.findItemTypeName(currentUser);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiOperation(value = "获取盘点单号", notes = "获取盘点单号")
	@GetMapping("/getInventoryCode")
	public Result getInventoryCode(){
		InventoryInfo inventoryInfo = new InventoryInfo();
		inventoryInfo.setInventoryCode(BillManagePublicMethod.creatOrderCode(BillManageConstant.DELIVERY_ORDER_TYPE));
		return ResultGenerator.genSuccessResult(inventoryInfo);
	}
	@ApiOperation(value = "获取该公司的仓库库存数量", notes = "获取该公司的仓库库存数量")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
	@GetMapping("/getWareNum")
	public Result getWareNum(@ApiIgnore @User CurrentUser currentUser){
		Integer wareNum = inventoryInfoService.findWareNum(currentUser);
		return ResultGenerator.genSuccessResult(wareNum);
	}
	
	
	@ApiOperation(value = "提交盘点订单", notes = "提交盘点订单")
	@ApiImplicitParams( { @ApiImplicitParam( name = "access-token", value = "token", paramType = "header", dataType = "String", required = true ) } )
	@PostMapping("/addInventoryInfo")
	public Result addInventoryInfo(@ApiIgnore @User CurrentUser currentUser,@RequestBody List<InventoryInfo> inventoryInfos){
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        String now =  DateUtils.getNowDateTimeString();
        for(InventoryInfo inventoryInfo :inventoryInfos){
        	inventoryInfo.setOperatorId(currentUser.getUserId());
        	inventoryInfo.setCreateTime(now);
        	inventoryInfo.setUpdateTime(null);
        	inventoryInfo.setCreatorId(currentUser.getUserId());
        	inventoryInfo.setInventoryStatus(1);
        	inventoryInfo.setCompanyId(currentUser.getCompanyId());
        	inventoryInfo.setState("normal");
            inventoryInfoService.save(inventoryInfo);
        }
        return ResultGenerator.genSuccessResult();
	}
	
}
