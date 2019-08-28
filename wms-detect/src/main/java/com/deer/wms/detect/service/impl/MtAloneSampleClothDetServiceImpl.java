package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneSampleClothDetMapper;
import com.deer.wms.detect.model.MtAloneSampleClothDet;
import com.deer.wms.detect.model.MtAloneSampleClothDetDto;
import com.deer.wms.detect.model.MtAloneSampleClothDetParams;
import com.deer.wms.detect.service.MtAloneSampleClothDetService;

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
public class MtAloneSampleClothDetServiceImpl extends AbstractService<MtAloneSampleClothDet, Integer> implements MtAloneSampleClothDetService {

    @Autowired
    private MtAloneSampleClothDetMapper mtAloneSampleClothDetMapper;


    @Override
    public List<MtAloneSampleClothDetDto> findList(MtAloneSampleClothDetParams  params) {
        return mtAloneSampleClothDetMapper.findList(params);
    }
}
