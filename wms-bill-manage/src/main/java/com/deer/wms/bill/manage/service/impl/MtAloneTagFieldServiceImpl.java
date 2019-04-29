package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneTagFieldMapper;
import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.bill.manage.model.MtAloneTagField;
import com.deer.wms.bill.manage.model.MtAloneTagFieldCriteria;
import com.deer.wms.bill.manage.service.MtAloneTagFieldService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTagField;

/**
 * Created by  on 2018/12/30.
 */
@Service
@Transactional
public class MtAloneTagFieldServiceImpl extends AbstractService<MtAloneTagField, Integer> implements MtAloneTagFieldService {

    @Autowired
    private MtAloneTagFieldMapper mtAloneTagFieldMapper;


    @Override
    public List<MtAloneTagField> findList(MtAloneTagFieldCriteria  criteria) {
        return mtAloneTagFieldMapper.findList(criteria);
    }


	@Override
	public List<MtAloneTagField> findColumnListByLabelType(MtAloneTagCriteria criteria) {
		   return mtAloneTagFieldMapper.findColumnListByLabelType(criteria);
	}


	@Override
	public void deleteByTagCode(MtAloneTagCriteria criteria) {
		mtAloneTagFieldMapper.deleteByTagCode(criteria);
		
	}
}
