package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MachiningProductMapper;
import com.deer.wms.produce.manage.model.MachiningProduct;
import com.deer.wms.produce.manage.model.MachiningProductParams;
import com.deer.wms.produce.manage.service.MachiningProductService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
@Service
@Transactional
public class MachiningProductServiceImpl extends AbstractService<MachiningProduct, Integer> implements MachiningProductService {

    @Autowired
    private MachiningProductMapper machiningProductMapper;


    @Override
    public List<MachiningProduct> findList(MachiningProductParams  params) {
        return machiningProductMapper.findList(params);
    }

    @Override
    public List<MachiningProduct> findProductList(MachiningProductParams params) {
        return machiningProductMapper.findProductList(params);
    }

    @Override
    public List<MachiningProduct> findProductHaveBomList(MachiningProductParams params) {
        return machiningProductMapper.findProductHaveBomList(params);
    }
}
