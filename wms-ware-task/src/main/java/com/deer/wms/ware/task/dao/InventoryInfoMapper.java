package com.deer.wms.ware.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.ware.task.model.AreaInfoDto;
import com.deer.wms.ware.task.model.CompanyProductCriteria;
import com.deer.wms.ware.task.model.CompanyProductDto;
import com.deer.wms.ware.task.model.InventoryInfo;
import com.deer.wms.ware.task.model.InventoryInfoCriteria;
import com.deer.wms.ware.task.model.InventoryInfoDto;
import com.deer.wms.ware.task.model.ItemTypeDto;
import com.deer.wms.ware.task.model.ShelfInfoDto;
import com.deer.wms.ware.task.model.WareInfoDto;

public interface InventoryInfoMapper extends Mapper<InventoryInfo>{

	List<InventoryInfoDto> findList(@Param(value = "criteria")InventoryInfoCriteria criteria,@Param(value = "currentUser")CurrentUser currentUser);
	
	List<CompanyProductDto> findCompanyProductDet(@Param(value = "companyProductCriteria")CompanyProductCriteria companyProductCriteria,@Param(value = "currentUser")CurrentUser currentUser); 

	List<WareInfoDto> findWareName(@Param(value = "currentUser")CurrentUser currentUser) ;

	List<AreaInfoDto> findAreaName(@Param(value = "currentUser")CurrentUser currentUser) ;

	List<ShelfInfoDto> findShelfName(@Param(value = "currentUser")CurrentUser currentUser) ;
	
	List<ItemTypeDto> findItemTypeName(@Param(value = "currentUser")CurrentUser currentUser) ;

	Integer findWareNum(@Param(value = "currentUser")CurrentUser currentUser);

}
