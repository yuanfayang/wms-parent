package com.deer.wms.detect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deer.wms.detect.model.MtAloneComProDetFabric;
import com.deer.wms.detect.model.MtAloneExaminationDetails;
import com.deer.wms.detect.model.MtAloneExaminationDetailsCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneExaminationDetailsMapper extends Mapper<MtAloneExaminationDetails> {
	 List<MtAloneExaminationDetails> findList(MtAloneExaminationDetailsCriteria  criteria);

	 List<MtAloneComProDetFabric> findFabricDetsByProCode(@Param("productBarcode")String productBarcode);

     void deleteByProductBarcode(String productDetBarcode);
}