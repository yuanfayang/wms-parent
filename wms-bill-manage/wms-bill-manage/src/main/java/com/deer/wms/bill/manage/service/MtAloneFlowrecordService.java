package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;

/**
 * Created by  on 2018/12/11.
 */
public interface MtAloneFlowrecordService extends Service<MtAloneFlowrecord, Integer> {


    List<MtAloneFlowrecord> findList(MtAloneFlowrecordCriteria  criteria) ;

}
