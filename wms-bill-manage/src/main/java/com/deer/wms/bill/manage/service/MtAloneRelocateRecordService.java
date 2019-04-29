package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneRelocateRecord;
import com.deer.wms.bill.manage.model.MtAloneRelocateRecordCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by mt on 2018/12/30.
 */
public interface MtAloneRelocateRecordService extends Service<MtAloneRelocateRecord, Integer> {


    List<MtAloneRelocateRecord> findList(MtAloneRelocateRecordCriteria  criteria) ;

}
