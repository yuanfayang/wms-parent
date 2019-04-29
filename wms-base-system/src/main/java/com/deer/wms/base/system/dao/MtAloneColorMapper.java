package com.deer.wms.base.system.dao;

import com.deer.wms.base.system.model.MtAloneColor;
import com.deer.wms.base.system.model.MtAloneColorCriteria;
import com.deer.wms.base.system.model.MtAloneColorParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneColorMapper extends Mapper<MtAloneColor> {

	List<MtAloneColor> findList(MtAloneColorCriteria criteria);
	void deleteByCode(String colorCode);

	List<MtAloneColor> findListByPTCode(MtAloneColorCriteria criteria);

    List<MtAloneColor> findListNew(MtAloneColorParams params);

    void deleteByIdParams(MtAloneColorParams params);

    Integer countRelProducts(MtAloneColorParams params);
}