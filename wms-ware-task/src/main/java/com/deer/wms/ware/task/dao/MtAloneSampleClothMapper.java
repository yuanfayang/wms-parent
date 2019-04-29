package com.deer.wms.ware.task.dao;

import java.util.List;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.ware.task.model.MtAloneSampleCloth;
import com.deer.wms.ware.task.model.MtAloneSampleClothCriteria;
import com.deer.wms.ware.task.model.MtAloneSampleClothDto;

public interface MtAloneSampleClothMapper extends Mapper<MtAloneSampleCloth> {

	List<MtAloneSampleClothDto> findList(MtAloneSampleClothCriteria criteria);	
}