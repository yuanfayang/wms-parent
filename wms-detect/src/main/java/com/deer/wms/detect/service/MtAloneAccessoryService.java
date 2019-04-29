package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneAccessory;
import com.deer.wms.detect.model.MtAloneAccessoryParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/13.
 */
public interface MtAloneAccessoryService extends Service<MtAloneAccessory, Integer> {


    List<MtAloneAccessory> findList(MtAloneAccessoryParams  params) ;

}
