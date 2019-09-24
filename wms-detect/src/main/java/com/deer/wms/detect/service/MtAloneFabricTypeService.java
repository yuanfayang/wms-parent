package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneFabricType;
import com.deer.wms.detect.model.MtAloneFabricTypeParams;

import com.deer.wms.detect.model.MtAloneFabricTypeVO;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/06/24.
 */
public interface MtAloneFabricTypeService extends Service<MtAloneFabricType, Integer> {


    List<MtAloneFabricType> findList(MtAloneFabricTypeParams params) ;

    List<MtAloneFabricTypeVO> fabricTypeList(MtAloneFabricTypeParams params);
}
