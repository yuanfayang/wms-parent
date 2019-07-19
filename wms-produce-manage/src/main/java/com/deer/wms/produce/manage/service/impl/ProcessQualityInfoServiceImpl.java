package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProcessQualityInfoMapper;
import com.deer.wms.produce.manage.model.ProcessQualityInfo;
import com.deer.wms.produce.manage.model.ProcessQualityInfoParams;
import com.deer.wms.produce.manage.service.ProcessQualityInfoService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hy on 2019/07/19.
 */
@Service
@Transactional
public class ProcessQualityInfoServiceImpl extends AbstractService<ProcessQualityInfo, Integer> implements ProcessQualityInfoService {

    @Autowired
    private ProcessQualityInfoMapper processQualityInfoMapper;


    //@Override
    //public List<ProcessQualityInfo> findList(ProcessQualityInfoParams params) {
    //    return processQualityInfoMapper.findList(params);
    //}
}
