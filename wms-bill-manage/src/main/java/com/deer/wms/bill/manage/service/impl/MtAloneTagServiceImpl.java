package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneTagMapper;
import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.bill.manage.service.MtAloneTagService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTag;

/**
 * Created by  on 2018/12/30.
 */
@Service
@Transactional
public class MtAloneTagServiceImpl extends AbstractService<MtAloneTag, Integer> implements MtAloneTagService {

    @Autowired
    private MtAloneTagMapper mtAloneTagMapper;


    @Override
    public List<MtAloneTag> findList(MtAloneTagCriteria  criteria) {
        return mtAloneTagMapper.findList(criteria);
    }


	@Override
	public void deleteByTagCode(MtAloneTagCriteria  criteria) {
		mtAloneTagMapper.deleteByTagCode(criteria);
		
	}


	@Override
	public MtAloneTag findDefaultTag(MtAloneTagCriteria criteria) {
		return mtAloneTagMapper.findDefaultTag(criteria);
	}
}
