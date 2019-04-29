package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneCraftMapper;
import com.deer.wms.detect.model.MtAloneCraft;
import com.deer.wms.detect.model.MtAloneCraftParams;
import com.deer.wms.detect.service.MtAloneCraftService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/08.
 */
@Service
@Transactional
public class MtAloneCraftServiceImpl extends AbstractService<MtAloneCraft, Integer> implements MtAloneCraftService {

    @Autowired
    private MtAloneCraftMapper mtAloneCraftMapper;


    @Override
    public List<MtAloneCraft> findList(MtAloneCraftParams  params) {
        return mtAloneCraftMapper.findList(params);
    }


	@Override
	public List<MtAloneCraft> parentListById(MtAloneCraftParams params) {
		return mtAloneCraftMapper.parentListById(params);
	}
}
