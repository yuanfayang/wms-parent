package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneSampleClothOutDetMapper;
import com.deer.wms.detect.model.MtAloneSampleClothOutDet;
import com.deer.wms.detect.model.MtAloneSampleClothOutDetParams;
import com.deer.wms.detect.service.MtAloneSampleClothOutDetService;

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
public class MtAloneSampleClothOutDetServiceImpl extends AbstractService<MtAloneSampleClothOutDet, Integer> implements MtAloneSampleClothOutDetService {

    @Autowired
    private MtAloneSampleClothOutDetMapper mtAloneSampleClothOutDetMapper;


    @Override
    public List<MtAloneSampleClothOutDet> findList(MtAloneSampleClothOutDetParams  params) {
        return mtAloneSampleClothOutDetMapper.findList(params);
    }
}
