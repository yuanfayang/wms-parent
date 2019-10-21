package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtNumberConf;
import com.deer.wms.produce.manage.model.MtNumberConfParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtNumberConfMapper extends Mapper<MtNumberConf> {
    List<MtNumberConf> findList(MtNumberConfParams params);

    void updatePinSerial(MtNumberConf mtNumberConf);
}