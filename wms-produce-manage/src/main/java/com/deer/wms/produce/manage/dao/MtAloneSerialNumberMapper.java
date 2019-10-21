package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtAloneSerialNumber;
import com.deer.wms.produce.manage.model.MtAloneSerialNumberParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneSerialNumberMapper extends Mapper<MtAloneSerialNumber> {
    List<MtAloneSerialNumber> findList(MtAloneSerialNumberParams params);

    void updatePinCounter(MtAloneSerialNumber mtAloneSerialNumber);
}