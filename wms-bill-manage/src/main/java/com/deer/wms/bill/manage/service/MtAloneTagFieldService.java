package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.bill.manage.model.MtAloneTagField;
import com.deer.wms.bill.manage.model.MtAloneTagFieldCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTagField;

/**
 * Created by  on 2018/12/30.
 */
public interface MtAloneTagFieldService extends Service<MtAloneTagField, Integer> {


    List<MtAloneTagField> findList(MtAloneTagFieldCriteria  criteria) ;

	List<MtAloneTagField> findColumnListByLabelType(MtAloneTagCriteria criteria);

	void deleteByTagCode(MtAloneTagCriteria criteria);

}
