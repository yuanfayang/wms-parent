package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAlonePrintModel;
import com.deer.wms.bill.manage.model.MtAlonePrintModelParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAlonePrintModelMapper extends Mapper<MtAlonePrintModel> {

	List<MtAlonePrintModel> findList(MtAlonePrintModelParams params);
}