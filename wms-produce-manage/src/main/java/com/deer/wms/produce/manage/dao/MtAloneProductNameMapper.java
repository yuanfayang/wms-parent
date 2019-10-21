package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtAloneProductName;
import com.deer.wms.produce.manage.model.MtAloneProductNameParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneProductNameMapper extends Mapper<MtAloneProductName> {
    List<MtAloneProductName> findList(MtAloneProductNameParams params);
}