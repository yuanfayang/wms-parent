package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAlonePrintModelMapper;
import com.deer.wms.bill.manage.model.MtAlonePrintModel;
import com.deer.wms.bill.manage.model.MtAlonePrintModelParams;
import com.deer.wms.bill.manage.service.MtAlonePrintModelService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/02/21.
 */
@Service
@Transactional
public class MtAlonePrintModelServiceImpl extends AbstractService<MtAlonePrintModel, Integer> implements MtAlonePrintModelService {

    @Autowired
    private MtAlonePrintModelMapper mtAlonePrintModelMapper;


    @Override
    public List<MtAlonePrintModel> findList(MtAlonePrintModelParams  params) {
        return mtAlonePrintModelMapper.findList(params);
    }
}
