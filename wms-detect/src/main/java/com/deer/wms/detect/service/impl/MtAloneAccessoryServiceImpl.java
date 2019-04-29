package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneAccessoryMapper;
import com.deer.wms.detect.model.MtAloneAccessory;
import com.deer.wms.detect.model.MtAloneAccessoryParams;
import com.deer.wms.detect.service.MtAloneAccessoryService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/13.
 */
@Service
@Transactional
public class MtAloneAccessoryServiceImpl extends AbstractService<MtAloneAccessory, Integer> implements MtAloneAccessoryService {

    @Autowired
    private MtAloneAccessoryMapper mtAloneAccessoryMapper;


    @Override
    public List<MtAloneAccessory> findList(MtAloneAccessoryParams  params) {
        return mtAloneAccessoryMapper.findList(params);
    }
}
