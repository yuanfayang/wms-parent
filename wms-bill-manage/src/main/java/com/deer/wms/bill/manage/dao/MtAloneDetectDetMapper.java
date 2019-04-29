package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAloneDetectDet;
import com.deer.wms.bill.manage.model.MtAloneDetectDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneDetectDetVO;
import com.deer.wms.bill.manage.model.MtAloneProductDetParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneDetectDetMapper extends Mapper<MtAloneDetectDet> {

	List<MtAloneDetectDet> findList(MtAloneDetectDetCriteria criteria);

	List<MtAloneDetectDetVO> findListNew(MtAloneProductDetParams params);
}