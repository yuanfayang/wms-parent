package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneBarcodeMapper;
import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneBarcodeCriteria;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneBarcode;

/**
 * Created by  on 2019/03/13.
 */
@Service
@Transactional
public class MtAloneBarcodeServiceImpl extends AbstractService<MtAloneBarcode, Integer> implements MtAloneBarcodeService {

    @Autowired
    private MtAloneBarcodeMapper mtAloneBarcodeMapper;


    @Override
    public List<MtAloneBarcode> findList(MtAloneBarcodeCriteria  criteria) {
        return mtAloneBarcodeMapper.findList(criteria);
    }
}
