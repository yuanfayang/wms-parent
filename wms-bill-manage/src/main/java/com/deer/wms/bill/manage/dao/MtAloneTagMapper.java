package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneTagMapper extends Mapper<MtAloneTag> {

	List<MtAloneTag> findList(MtAloneTagCriteria criteria);

	void deleteByTagCode(MtAloneTagCriteria criteria );

	MtAloneTag findDefaultTag(MtAloneTagCriteria criteria);
}