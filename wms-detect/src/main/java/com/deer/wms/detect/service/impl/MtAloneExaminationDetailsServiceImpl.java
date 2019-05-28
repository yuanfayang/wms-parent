package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneExaminationDetailsMapper;
import com.deer.wms.detect.model.MtAloneComProDetFabric;
import com.deer.wms.detect.model.MtAloneExaminationDetails;
import com.deer.wms.detect.model.MtAloneExaminationDetailsCriteria;
import com.deer.wms.detect.service.MtAloneExaminationDetailsService;

import com.deer.wms.project.seed.core.service.AbstractService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.detect.model.MtAloneExaminationDetails;

/**
 * Created by guo on 2018/12/18.
 */
@Service
@Transactional
public class MtAloneExaminationDetailsServiceImpl extends AbstractService<MtAloneExaminationDetails, Integer> implements MtAloneExaminationDetailsService {

    @Autowired
    private MtAloneExaminationDetailsMapper mtAloneExaminationDetailsMapper;


    @Override
    public List<MtAloneExaminationDetails> findList(MtAloneExaminationDetailsCriteria  criteria) {
        return mtAloneExaminationDetailsMapper.findList(criteria);
    }


	@Override
	public List<MtAloneComProDetFabric> findFabricDetsByProCode(@Param("productBarcode")String productBarcode) {
		return mtAloneExaminationDetailsMapper.findFabricDetsByProCode(productBarcode);
	}

    @Override
    public void deleteByProductBarcode(String productDetBarcode) {
        mtAloneExaminationDetailsMapper.deleteByProductBarcode(productDetBarcode);
    }
}
