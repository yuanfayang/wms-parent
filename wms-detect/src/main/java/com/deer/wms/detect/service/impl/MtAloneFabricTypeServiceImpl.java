package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneFabricTypeMapper;
import com.deer.wms.detect.model.MtAloneFabricType;
import com.deer.wms.detect.model.MtAloneFabricTypeParams;
import com.deer.wms.detect.service.MtAloneFabricTypeService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guotuanting on 2019/06/24.
 */
@Service
@Transactional
public class MtAloneFabricTypeServiceImpl extends AbstractService<MtAloneFabricType, Integer> implements MtAloneFabricTypeService {

    @Autowired
    private MtAloneFabricTypeMapper mtAloneFabricTypeMapper;


    @Override
    public List<MtAloneFabricType> findList(MtAloneFabricTypeParams  params) {
        return mtAloneFabricTypeMapper.findList(params);
    }
}
