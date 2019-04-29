package com.deer.wms.system.manage.service.impl;

import com.deer.wms.system.manage.dao.MtAloneLogMapper;
import com.deer.wms.system.manage.model.MtAloneLog;
import com.deer.wms.system.manage.model.MtAloneLogCriteria;
import com.deer.wms.system.manage.model.log.LogParams;
import com.deer.wms.system.manage.service.MtAloneLogService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/01/17.
 */
@Service
@Transactional
public class MtAloneLogServiceImpl extends AbstractService<MtAloneLog, Integer> implements MtAloneLogService {

    @Autowired
    private MtAloneLogMapper mtAloneLogMapper;


    @Override
    public List<MtAloneLog> findList(MtAloneLogCriteria  criteria) {
        return mtAloneLogMapper.findList(criteria);
    }


	@Override
	public List<MtAloneLog> findListNew(LogParams params) {
		// TODO Auto-generated method stub
		return mtAloneLogMapper.findListNew(params);
	}
}
