package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneMachiningProductMapper;
import com.deer.wms.produce.manage.model.MtAloneMachiningProduct;
import com.deer.wms.produce.manage.model.MtAloneMachiningProductParams;
import com.deer.wms.produce.manage.service.MtAloneMachiningProductService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/09/19.
 */
@Service
@Transactional
public class MtAloneMachiningProductServiceImpl extends AbstractService<MtAloneMachiningProduct, Integer> implements MtAloneMachiningProductService {

    @Autowired
    private MtAloneMachiningProductMapper mtAloneMachiningProductMapper;


    @Override
    public List<MtAloneMachiningProduct> findList(MtAloneMachiningProductParams  params) {
        //return mtAloneMachiningProductMapper.findList(params);
        return null;
    }

    @Override
    public List<MtAloneMachiningProduct> findListByClothAttr(MtAloneMachiningProduct mtAloneMachiningProduct) {

        return mtAloneMachiningProductMapper.findListByClothAttr(mtAloneMachiningProduct);
    }

    @Override
    public MtAloneMachiningProduct findByProductTypeCode(String productTypeCode) {
        return mtAloneMachiningProductMapper.findByProductTypeCode(productTypeCode);
    }
}
