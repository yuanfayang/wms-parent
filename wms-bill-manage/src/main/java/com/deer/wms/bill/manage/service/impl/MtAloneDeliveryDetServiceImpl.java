package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneDeliveryDetMapper;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetVO;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryParams;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDeliveryVO;
import com.deer.wms.bill.manage.model.MtAloneProductDetParams;
import com.deer.wms.bill.manage.model.MtAloneProductDetVO;
import com.deer.wms.bill.manage.service.MtAloneDeliveryDetService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;

/**
 * Created by  on 2019/02/27.
 */
@Service
@Transactional
public class MtAloneDeliveryDetServiceImpl extends AbstractService<MtAloneDeliveryDet, Integer> implements MtAloneDeliveryDetService {

    @Autowired
    private MtAloneDeliveryDetMapper mtAloneDeliveryDetMapper;


    @Override
    public List<MtAloneDeliveryDet> findList(MtAloneDeliveryDetCriteria  criteria) {
        return mtAloneDeliveryDetMapper.findList(criteria);
    }


	@Override
	public void delDetByDeliveryOrder(MtAloneDeliveryDetParams params) {
		mtAloneDeliveryDetMapper.delDetByDeliveryOrder(params);
		
	}


	@Override
	public Integer findDeliveryDetCountByCode(MtAloneDeliveryDetParams mtAloneDeliveryDetParams) {
		return mtAloneDeliveryDetMapper.findDeliveryDetCountByCode(mtAloneDeliveryDetParams);
	}


	@Override
	public List<MtAloneDeliveryDet> findDeliveryDetsByCode(MtAloneDeliveryDetParams params) {
		return mtAloneDeliveryDetMapper.findDeliveryDetsByCode(params);
	}


	@Override
	public List<MtAloneDeliveryDetVO> findListNew(MtAloneProductDetParams params) {
		return mtAloneDeliveryDetMapper.findListNew(params);
	}


	@Override
	public List<MtAloneDeliveryOrder> findDeliveryOrderDetList(MtAloneDeliveryDetParams params) {
		return mtAloneDeliveryDetMapper.findDeliveryOrderDetList(params);
	}


	@Override
	public List<MtAloneProductDetVO> finddeliveryDetsByOrder(MtAloneDeliveryOrderParams params) {
		return mtAloneDeliveryDetMapper.finddeliveryDetsByOrder(params);
	}


	@Override
	public List<MtAloneProductDeliveryVO> findDeliveryDetForms(MtAloneDeliveryParams params) {
		return mtAloneDeliveryDetMapper.findDeliveryDetForms(params);
	}
}
