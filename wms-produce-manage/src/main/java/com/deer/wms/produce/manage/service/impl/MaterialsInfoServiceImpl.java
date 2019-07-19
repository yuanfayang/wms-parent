package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.model.MaterialsInfo;
import com.deer.wms.produce.manage.model.MaterialsInfoParams;
import com.deer.wms.produce.manage.service.MaterialsInfoService;

import com.deer.wms.project.seed.core.service.AbstractService;
import com.deer.wms.ware.task.dao.MaterialsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/07/18.
 */
@Service
@Transactional
public class MaterialsInfoServiceImpl extends AbstractService<MaterialsInfo, Integer> implements MaterialsInfoService {

    @Autowired
    private MaterialsInfoMapper materialsInfoMapper;


    //@Override
    //public List<MaterialsInfo> findList(MaterialsInfoParams params) {
    //    return materialsInfoMapper.findList(params);
    //}
}
