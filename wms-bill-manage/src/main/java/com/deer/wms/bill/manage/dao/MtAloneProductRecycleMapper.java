package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneProductRecycle;
import com.deer.wms.bill.manage.model.MtAloneProductRecycleParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneProductRecycleMapper extends Mapper<MtAloneProductRecycle> {
    List<MtAloneProductRecycle> findList(MtAloneProductRecycleParams params);
}