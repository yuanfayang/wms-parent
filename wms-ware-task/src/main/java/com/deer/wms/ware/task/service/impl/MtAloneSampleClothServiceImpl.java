package com.deer.wms.ware.task.service.impl;

import com.deer.wms.project.seed.core.service.AbstractService;
import com.deer.wms.ware.task.dao.MtAloneSampleClothMapper;
import com.deer.wms.ware.task.model.MtAloneSampleCloth;
import com.deer.wms.ware.task.model.MtAloneSampleClothCriteria;
import com.deer.wms.ware.task.model.MtAloneSampleClothDto;
import com.deer.wms.ware.task.service.MtAloneSampleClothService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/03/21.
 */
@Service
@Transactional
public class MtAloneSampleClothServiceImpl extends AbstractService<MtAloneSampleCloth, Integer> implements MtAloneSampleClothService {

    @Autowired
    private MtAloneSampleClothMapper mtAloneSampleClothMapper;


    @Override
    public List<MtAloneSampleClothDto> findList(MtAloneSampleClothCriteria  criteria) {
        return mtAloneSampleClothMapper.findList(criteria);
    }
}
