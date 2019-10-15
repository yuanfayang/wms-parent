package com.deer.wms.base.system.service.impl;

import com.deer.wms.base.system.dao.MtDictMapper;
import com.deer.wms.base.system.model.MtDict;
import com.deer.wms.base.system.model.MtDictParams;
import com.deer.wms.base.system.service.MtDictService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guotuanting on 2019/10/12.
 */
@Service
@Transactional
public class MtDictServiceImpl extends AbstractService<MtDict, Integer> implements MtDictService {

    @Autowired
    private MtDictMapper mtDictMapper;


    @Override
    public List<MtDict> findList(MtDictParams  params) {
        return mtDictMapper.findList(params);
    }

    @Override
    public List<MtDict> findTypeList(MtDictParams params) {
        return mtDictMapper.findTypeList(params);
    }

    @Override
    public MtDict detail(Integer id) {
        return mtDictMapper.detail(id);
    }
}
