package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneSampleClothOutDet;
import com.deer.wms.detect.model.MtAloneSampleClothOutDetParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/08/28.
 */
public interface MtAloneSampleClothOutDetService extends Service<MtAloneSampleClothOutDet, Integer> {


    List<MtAloneSampleClothOutDet> findList(MtAloneSampleClothOutDetParams  params) ;

}
