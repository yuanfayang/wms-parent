package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneMaterialsInfoMapper;
import com.deer.wms.produce.manage.model.MtAloneMaterialsInfo;
import com.deer.wms.produce.manage.model.MtAloneMaterialsInfoParams;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomVO;
import com.deer.wms.produce.manage.service.MtAloneMaterialsInfoService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/10/09.
 */
@Service
@Transactional
public class MtAloneMaterialsInfoServiceImpl extends AbstractService<MtAloneMaterialsInfo, Integer> implements MtAloneMaterialsInfoService {

    @Autowired
    private MtAloneMaterialsInfoMapper mtAloneMaterialsInfoMapper;


    @Override
    public List<MtAloneProcessMaterialsBomVO> findMaterialByNameAndNum(MtAloneMaterialsInfoParams params) {
        return mtAloneMaterialsInfoMapper.findMaterialByNameOrNum(params);
    }

    @Override
    public List<MtAloneMaterialsInfo> findList(MtAloneMaterialsInfoParams  params) {
        //return mtAloneMaterialsInfoMapper.findList(params);
        return null;
    }
}
