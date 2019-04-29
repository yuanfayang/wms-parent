package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.bill.manage.model.MtAloneTagField;
import com.deer.wms.bill.manage.model.MtAloneTagFieldCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneTagFieldMapper extends Mapper<MtAloneTagField> {

	List<MtAloneTagField> findList(MtAloneTagFieldCriteria criteria);

	List<MtAloneTagField> findColumnListByLabelType(MtAloneTagCriteria criteria);

	void findColumnListByLabelType(MtAloneTag mtAloneTag);

	void deleteByTagCode(MtAloneTagCriteria criteria);
}