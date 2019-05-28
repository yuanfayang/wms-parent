package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneComProDetFabric;
import com.deer.wms.detect.model.MtAloneExaminationDetails;
import com.deer.wms.detect.model.MtAloneExaminationDetailsCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deer.wms.detect.model.MtAloneExaminationDetails;

/**
 * Created by guo on 2018/12/18.
 */
public interface MtAloneExaminationDetailsService extends Service<MtAloneExaminationDetails, Integer> {


    List<MtAloneExaminationDetails> findList(MtAloneExaminationDetailsCriteria  criteria) ;

	List<MtAloneComProDetFabric> findFabricDetsByProCode(@Param("productBarcode")String productBarcode);

    void deleteByProductBarcode(String productDetBarcode);
}
