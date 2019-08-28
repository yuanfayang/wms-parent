package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneSampleClothOut;
import com.deer.wms.detect.model.MtAloneSampleClothOutParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/08/28.
 */
public interface MtAloneSampleClothOutService extends Service<MtAloneSampleClothOut, Integer> {


    List<MtAloneSampleClothOut> findList(MtAloneSampleClothOutParams  params) ;

}
