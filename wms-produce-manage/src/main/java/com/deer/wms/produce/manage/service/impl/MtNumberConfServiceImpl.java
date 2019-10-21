package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtNumberConfMapper;
import com.deer.wms.produce.manage.model.MtNumberConf;
import com.deer.wms.produce.manage.model.MtNumberConfParams;
import com.deer.wms.produce.manage.service.MtNumberConfService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/10/17.
 */
@Service
@Transactional
public class MtNumberConfServiceImpl extends AbstractService<MtNumberConf, Integer> implements MtNumberConfService {

    @Autowired
    private MtNumberConfMapper mtNumberConfMapper;


    @Override
    public List<MtNumberConf> findList(MtNumberConfParams  params) {
        return mtNumberConfMapper.findList(params);
    }

    @Override
    public void updatePinSerial(MtNumberConf mtNumberConf) {
        mtNumberConfMapper.updatePinSerial(mtNumberConf);
    }

}
