package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTag;

/**
 * Created by  on 2018/12/30.
 */
public interface MtAloneTagService extends Service<MtAloneTag, Integer> {


    List<MtAloneTag> findList(MtAloneTagCriteria  criteria) ;

	void deleteByTagCode(MtAloneTagCriteria criteria);

	MtAloneTag findDefaultTag(MtAloneTagCriteria criteria);

}
