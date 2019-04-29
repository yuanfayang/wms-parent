package com.deer.wms.base.system.service.impl;

import com.deer.wms.base.system.dao.AreaInfoMapper;
import com.deer.wms.base.system.model.AreaInfo;
import com.deer.wms.base.system.model.AreaInfoCriteria;
import com.deer.wms.base.system.model.AreaInfoDto;
import com.deer.wms.base.system.model.AreaInfoParams;
import com.deer.wms.base.system.service.AreaInfoService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by  on 2018/06/20.
 */
@Service
@Transactional
public class AreaInfoServiceImpl extends AbstractService<AreaInfo, Integer> implements AreaInfoService {

    @Autowired
    private AreaInfoMapper areaInfoMapper;

    @Override
    public void deleteByCodeAndCom(AreaInfoCriteria criteria) {
         areaInfoMapper.deleteByCodeAndCom(criteria); 
    }

    @Override
    public List<AreaInfoDto> findList(AreaInfoCriteria criteria) {
        return areaInfoMapper.findList(criteria);
    }

    @Override
    public List<AreaInfoDto> findListNew(AreaInfoParams params) {
        return areaInfoMapper.findListNew(params);
    }

    @Override
    public Integer countChildren(AreaInfoParams params) {
        return areaInfoMapper.countChildren(params);
    }

    @Override
    public void deleteByIdAndComNew(AreaInfoParams params) {
        areaInfoMapper.deleteByIdAndComNew(params);
    }

}
