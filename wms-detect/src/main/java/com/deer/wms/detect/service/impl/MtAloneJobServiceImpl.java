package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneJobMapper;
import com.deer.wms.detect.model.MtAloneJob;
import com.deer.wms.detect.model.MtAloneJobParams;
import com.deer.wms.detect.model.MtAloneJobVo;
import com.deer.wms.detect.service.MtAloneJobService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/10.
 */
@Service
@Transactional
public class MtAloneJobServiceImpl extends AbstractService<MtAloneJob, Integer> implements MtAloneJobService {

    @Autowired
    private MtAloneJobMapper mtAloneJobMapper;


    @Override
    public List<MtAloneJobVo> findList(MtAloneJobParams  params) {
        return mtAloneJobMapper.findList(params);
    }
}
