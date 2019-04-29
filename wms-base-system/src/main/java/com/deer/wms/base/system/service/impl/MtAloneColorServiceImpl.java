package com.deer.wms.base.system.service.impl;

import com.deer.wms.base.system.dao.MtAloneColorMapper;
import com.deer.wms.base.system.model.MtAloneColor;
import com.deer.wms.base.system.model.MtAloneColorCriteria;
import com.deer.wms.base.system.model.MtAloneColorParams;
import com.deer.wms.base.system.service.MtAloneColorService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Created by  on 2018/11/18.
 */
@Service
@Transactional
public class MtAloneColorServiceImpl extends AbstractService<MtAloneColor, Integer> implements MtAloneColorService {


    @Autowired
    private MtAloneColorMapper mtAloneColorMapper;


    @Override
    public List<MtAloneColor> findList(MtAloneColorCriteria  criteria) {
        return mtAloneColorMapper.findList(criteria);
    }


	@Override
	public void deleteByCode(String colorCode) {
		mtAloneColorMapper.deleteByCode(colorCode);
		
	}

    @Override
    public List<MtAloneColor> findListByPTCode(MtAloneColorCriteria criteria) {
        return mtAloneColorMapper.findListByPTCode(criteria);
    }

    @Override
    public List<MtAloneColor> findListNew(MtAloneColorParams params) {
        return mtAloneColorMapper.findListNew(params);
    }

    @Override
    public void deleteByIdParams(MtAloneColorParams params) {
        mtAloneColorMapper.deleteByIdParams(params);
    }

    @Override
    public Integer countRelProducts(MtAloneColorParams params) {
        return mtAloneColorMapper.countRelProducts(params);
    }


}
