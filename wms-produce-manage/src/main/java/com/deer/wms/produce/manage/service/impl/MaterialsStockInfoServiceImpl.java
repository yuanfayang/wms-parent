package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MaterialsStockInfoMapper;
import com.deer.wms.produce.manage.model.MaterialsStockInfo;
import com.deer.wms.produce.manage.model.MaterialsStockInfoParams;
import com.deer.wms.produce.manage.service.MaterialsStockInfoService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guo on 2019/07/21.
 */
@Service
@Transactional
public class MaterialsStockInfoServiceImpl extends AbstractService<MaterialsStockInfo, Integer> implements MaterialsStockInfoService {

    @Autowired
    private MaterialsStockInfoMapper materialsStockInfoMapper;


    @Override
    public List<MaterialsStockInfo> findList(MaterialsStockInfoParams params) {
        return materialsStockInfoMapper.findList(params);
    }
}
