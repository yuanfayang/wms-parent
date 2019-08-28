package com.deer.wms.detect.dao;

import com.deer.wms.detect.model.MtAloneSampleClothOutDet;
import com.deer.wms.detect.model.MtAloneSampleClothOutDetParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneSampleClothOutDetMapper extends Mapper<MtAloneSampleClothOutDet> {
    List<MtAloneSampleClothOutDet> findList(MtAloneSampleClothOutDetParams params);
}