package com.deer.wms.ware.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.service.AbstractService;
import com.deer.wms.ware.task.dao.InventoryInfoMapper;
import com.deer.wms.ware.task.model.AreaInfoDto;
import com.deer.wms.ware.task.model.CompanyProductCriteria;
import com.deer.wms.ware.task.model.CompanyProductDto;
import com.deer.wms.ware.task.model.InventoryInfo;
import com.deer.wms.ware.task.model.InventoryInfoCriteria;
import com.deer.wms.ware.task.model.InventoryInfoDto;
import com.deer.wms.ware.task.model.ItemTypeDto;
import com.deer.wms.ware.task.model.ShelfInfoDto;
import com.deer.wms.ware.task.model.WareInfoDto;
import com.deer.wms.ware.task.service.InventoryInfoService;


@Service
@Transactional
public class InventoryInfoServiceImple extends AbstractService<InventoryInfo, Integer> implements InventoryInfoService {

	@Autowired
	private InventoryInfoMapper inventoryInfoMapper;
	

    @Override
    public List<InventoryInfoDto> findList(InventoryInfoCriteria  criteria,CurrentUser currentUser) {
        return inventoryInfoMapper.findList(criteria,currentUser);
    }


	@Override
	public List<CompanyProductDto> findCompanyProductDet(CompanyProductCriteria companyProductCriteria, CurrentUser currentUser) {
		// TODO Auto-generated method stub
		return inventoryInfoMapper.findCompanyProductDet(companyProductCriteria,currentUser);
	}


	@Override
	public List<WareInfoDto> findWareName(CurrentUser currentUser) {
		
		return inventoryInfoMapper.findWareName(currentUser);
	}


	@Override
	public List<AreaInfoDto> findAreaName(CurrentUser currentUser) {
		// TODO Auto-generated method stub
		return inventoryInfoMapper.findAreaName(currentUser);
	}


	@Override
	public List<ShelfInfoDto> findShelfName(CurrentUser currentUser) {
		// TODO Auto-generated method stub
		return inventoryInfoMapper.findShelfName(currentUser);
	}


	@Override
	public List<ItemTypeDto> findItemTypeName(CurrentUser currentUser) {
		// TODO Auto-generated method stub
		return inventoryInfoMapper.findItemTypeName(currentUser);
	}


	@Override
	public Integer findWareNum(CurrentUser currentUser) {
		// TODO Auto-generated method stub
		return inventoryInfoMapper.findWareNum(currentUser);
	}


}
