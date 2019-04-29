package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneProductMapper;
import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductCriteria;
import com.deer.wms.bill.manage.service.MtAloneProductService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneProduct;

/**
 * Created by  on 2019/03/01.
 */
@Service
@Transactional
public class MtAloneProductServiceImpl extends AbstractService<MtAloneProduct, Integer> implements MtAloneProductService {

    @Autowired
    private MtAloneProductMapper mtAloneProductMapper;


    @Override
    public List<MtAloneProduct> findList(MtAloneProductCriteria  criteria) {
        return mtAloneProductMapper.findList(criteria);
    }
}
