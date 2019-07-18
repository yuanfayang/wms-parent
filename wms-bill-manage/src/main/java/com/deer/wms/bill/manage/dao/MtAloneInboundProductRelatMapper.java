package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneInboundProductRelat;
import com.deer.wms.bill.manage.model.MtAloneInboundProductRelatParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneInboundProductRelatMapper extends Mapper<MtAloneInboundProductRelat> {
    List<MtAloneInboundProductRelat> findList(MtAloneInboundProductRelatParams params);
}