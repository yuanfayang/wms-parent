package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneSampleClothDet;
import com.deer.wms.detect.model.MtAloneSampleClothDetDto;
import com.deer.wms.detect.model.MtAloneSampleClothDetParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/08/28.
 */
public interface MtAloneSampleClothDetService extends Service<MtAloneSampleClothDet, Integer> {


    List<MtAloneSampleClothDetDto> findList(MtAloneSampleClothDetParams  params) ;

}
