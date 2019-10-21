package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtNumberConf;
import com.deer.wms.produce.manage.model.MtNumberConfParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/17.
 */
public interface MtNumberConfService extends Service<MtNumberConf, Integer> {


    List<MtNumberConf> findList(MtNumberConfParams  params) ;

    void updatePinSerial(MtNumberConf mtNumberConf);
}
