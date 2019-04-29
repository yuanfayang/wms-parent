package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneLabel;
import com.deer.wms.bill.manage.model.MtAloneLabelCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneLabel;

/**
 * Created by  on 2018/12/25.
 */
public interface MtAloneLabelService extends Service<MtAloneLabel, Integer> {


    List<MtAloneLabel> findList(MtAloneLabelCriteria  criteria) ;

}
