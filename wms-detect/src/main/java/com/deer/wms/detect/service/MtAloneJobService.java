package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneJob;
import com.deer.wms.detect.model.MtAloneJobParams;
import com.deer.wms.detect.model.MtAloneJobVo;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/10.
 */
public interface MtAloneJobService extends Service<MtAloneJob, Integer> {


    List<MtAloneJobVo> findList(MtAloneJobParams  params) ;

}
