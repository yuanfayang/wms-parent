package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneSampleClothOutMapper;
import com.deer.wms.detect.model.MtAloneSampleClothOut;
import com.deer.wms.detect.model.MtAloneSampleClothOutParams;
import com.deer.wms.detect.service.MtAloneSampleClothOutService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guotuanting on 2019/08/28.
 */
@Service
@Transactional
public class MtAloneSampleClothOutServiceImpl extends AbstractService<MtAloneSampleClothOut, Integer> implements MtAloneSampleClothOutService {

    @Autowired
    private MtAloneSampleClothOutMapper mtAloneSampleClothOutMapper;


    @Override
    public List<MtAloneSampleClothOut> findList(MtAloneSampleClothOutParams  params) {
        return mtAloneSampleClothOutMapper.findList(params);
    }
}
