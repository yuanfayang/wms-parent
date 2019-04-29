package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneDetectDet;
import com.deer.wms.bill.manage.model.MtAloneDetectDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneDetectDetVO;
import com.deer.wms.bill.manage.model.MtAloneProductDetParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDetectDet;

/**
 * Created by  on 2019/03/14.
 */
public interface MtAloneDetectDetService extends Service<MtAloneDetectDet, Integer> {


    List<MtAloneDetectDet> findList(MtAloneDetectDetCriteria  criteria) ;

	List<MtAloneDetectDetVO> findListNew(MtAloneProductDetParams params);

}
