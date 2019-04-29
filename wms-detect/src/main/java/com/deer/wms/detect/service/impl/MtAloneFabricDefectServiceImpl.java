package com.deer.wms.detect.service.impl;

import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.detect.dao.MtAloneFabricDefectMapper;
import com.deer.wms.detect.model.MtAloneFabricDefect;
import com.deer.wms.detect.model.MtAloneFabricDefectCriteria;
import com.deer.wms.detect.service.MtAloneFabricDefectService;
import com.deer.wms.project.seed.core.service.AbstractService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Created by guo on 2018/12/15.
 */
@Service
@Transactional
public class MtAloneFabricDefectServiceImpl extends AbstractService<MtAloneFabricDefect, Integer> implements MtAloneFabricDefectService {

    @Autowired
    private MtAloneFabricDefectMapper mtAloneFabricDefectMapper;


    @Override
    public List<MtAloneFabricDefect> findDefectByName(MtAloneFabricDefectCriteria  criteria) {
        return mtAloneFabricDefectMapper.findDefectByName(criteria);
    }


	@Override
	public List<MtAloneFabricDefect> findList(MtAloneFabricDefectCriteria criteria) {
		return mtAloneFabricDefectMapper.findList(criteria);
	}


	@Override
	public MtAloneProductDet findProductDetByBarCode(@Param("productDetBarCode")String productDetBarCode) {
		return mtAloneFabricDefectMapper.findProductDetByBarCode(productDetBarCode);
	}
}
