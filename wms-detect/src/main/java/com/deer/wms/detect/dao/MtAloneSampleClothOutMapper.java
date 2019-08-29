package com.deer.wms.detect.dao;

import com.deer.wms.detect.model.*;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MtAloneSampleClothOutMapper extends Mapper<MtAloneSampleClothOut> {
    List<MtAloneSampleClothOutDto> findList(MtAloneSampleClothOutParams params);

    MtAloneSampleClothOutDetVO findOutDetById(Integer id);
}