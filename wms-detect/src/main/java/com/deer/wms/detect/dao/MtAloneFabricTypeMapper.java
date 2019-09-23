package com.deer.wms.detect.dao;

import com.deer.wms.detect.model.MtAloneFabricType;
import com.deer.wms.detect.model.MtAloneFabricTypeParams;
import com.deer.wms.detect.model.MtAloneFabricTypeVO;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneFabricTypeMapper extends Mapper<MtAloneFabricType> {
    List<MtAloneFabricType> findList(MtAloneFabricTypeParams params);

    List<MtAloneFabricTypeVO> fabricTypeList(MtAloneFabricTypeParams params);
}