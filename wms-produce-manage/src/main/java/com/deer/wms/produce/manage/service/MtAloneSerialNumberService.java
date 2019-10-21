package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneSerialNumber;
import com.deer.wms.produce.manage.model.MtAloneSerialNumberParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/17.
 */
public interface MtAloneSerialNumberService extends Service<MtAloneSerialNumber, Integer> {


    List<MtAloneSerialNumber> findList(MtAloneSerialNumberParams  params) ;

    void updatePinCounter(MtAloneSerialNumber mtAloneSerialNumber);

}
