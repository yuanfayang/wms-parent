package com.deer.wms.detect.dao;

import com.deer.wms.detect.model.MtAloneSampleClothOut;
import com.deer.wms.detect.model.MtAloneSampleClothOutParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneSampleClothOutMapper extends Mapper<MtAloneSampleClothOut> {
    List<MtAloneSampleClothOut> findList(MtAloneSampleClothOutParams params);
}