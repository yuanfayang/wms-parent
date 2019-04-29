package com.deer.wms.ware.task.service;

import java.util.List;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.service.Service;
import com.deer.wms.ware.task.model.AreaInfoDto;
import com.deer.wms.ware.task.model.CompanyProductCriteria;
import com.deer.wms.ware.task.model.CompanyProductDto;
import com.deer.wms.ware.task.model.InventoryInfo;
import com.deer.wms.ware.task.model.InventoryInfoCriteria;
import com.deer.wms.ware.task.model.InventoryInfoDto;
import com.deer.wms.ware.task.model.ItemTypeDto;
import com.deer.wms.ware.task.model.ShelfInfoDto;
import com.deer.wms.ware.task.model.WareInfoDto;

public interface InventoryInfoService extends Service<InventoryInfo, Integer>{

	List<InventoryInfoDto> findList(InventoryInfoCriteria criteria,CurrentUser currentUser);
	
	List<CompanyProductDto> findCompanyProductDet(CompanyProductCriteria companyProductCriteria,CurrentUser currentUser);

	List<WareInfoDto> findWareName(CurrentUser currentUser) ;
	
	List<AreaInfoDto> findAreaName(CurrentUser currentUser) ;
	
	List<ShelfInfoDto> findShelfName(CurrentUser currentUser) ;
	
	List<ItemTypeDto> findItemTypeName(CurrentUser currentUser) ;
	
	Integer findWareNum(CurrentUser currentUser);
	
}
