package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneProductProcessBomMapper;
import com.deer.wms.produce.manage.model.MtAloneProductProcessBom;
import com.deer.wms.produce.manage.model.MtAloneProductProcessBomParams;
import com.deer.wms.produce.manage.model.MtAloneProductProcessBomVO;
import com.deer.wms.produce.manage.service.MtAloneProductProcessBomService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/09/28.
 */
@Service
@Transactional
public class MtAloneProductProcessBomServiceImpl extends AbstractService<MtAloneProductProcessBom, Integer> implements MtAloneProductProcessBomService {

    @Autowired
    private MtAloneProductProcessBomMapper mtAloneProductProcessBomMapper;


    @Override
    public List<MtAloneProductProcessBom> findList(MtAloneProductProcessBomParams  params) {
        //return mtAloneProductProcessBomMapper.findList(params);
        return null;
    }

    @Override
    public List<MtAloneProductProcessBom> findByProductID(Integer productId) {
        return mtAloneProductProcessBomMapper.findByProductId(productId);
    }

    @Override
    public List<MtAloneProductProcessBomVO> findByProductNameAndProductNum(MtAloneProductProcessBomParams mtAloneProductProcessBomParams) {
        return mtAloneProductProcessBomMapper.findByProductNameAndProductNum(mtAloneProductProcessBomParams);
    }
}
