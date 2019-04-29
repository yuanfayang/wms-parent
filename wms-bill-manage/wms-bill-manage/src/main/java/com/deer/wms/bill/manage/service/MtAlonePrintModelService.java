package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAlonePrintModel;
import com.deer.wms.bill.manage.model.MtAlonePrintModelCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAlonePrintModel;

/**
 * Created by  on 2019/02/21.
 */
public interface MtAlonePrintModelService extends Service<MtAlonePrintModel, Integer> {


    List<MtAlonePrintModel> findList(MtAlonePrintModelCriteria  criteria) ;

}
