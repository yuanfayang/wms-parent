package com.deer.wms.detect.dao;

import java.util.List;

import com.deer.wms.detect.model.SampleCloth;
import com.deer.wms.detect.model.SampleClothParams;
import com.deer.wms.detect.model.SampleClothVo;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface SampleClothMapper extends Mapper<SampleCloth> {

	List<SampleCloth> findList(SampleClothParams params);

	List<SampleClothVo> findAccessoryList(SampleClothParams params);

	SampleClothVo findDetailById(Integer id);
}