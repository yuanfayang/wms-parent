package com.deer.wms.detect.dao;

import com.deer.wms.detect.model.MtAloneSampleClothDet;
import com.deer.wms.detect.model.MtAloneSampleClothDetDto;
import com.deer.wms.detect.model.MtAloneSampleClothDetParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneSampleClothDetMapper extends Mapper<MtAloneSampleClothDet> {
    List<MtAloneSampleClothDetDto> findList(MtAloneSampleClothDetParams params);
}