package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.bill.manage.dao.MtAloneProductMapper;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by  on 2018/11/24.
 */
@Service
@Transactional
public class MtAloneProductServiceImpl extends AbstractService<MtAloneProduct, Integer> implements MtAloneProductService {

    @Autowired
    private MtAloneProductMapper mtAloneProductMapper;


    @Override
    public List<MtAloneProduct> findList(MtAloneProductCriteria  criteria) {
        return mtAloneProductMapper.findList(criteria);
    }
    
    @Override
    public List<MtAloneProduct> findListBykeyAndDate(MtAloneProductCriteria criteria){
    	 return mtAloneProductMapper.findListBykeyAndDate(criteria);
    }

	@Override
	public MtAloneProduct findByBarcode(@Param("productBarcode")String productBarcode) {
		return mtAloneProductMapper.findByBarcode(productBarcode);
	}

	@Override
	public List<MtAloneProduct> findListByWareState(MtAloneProductCriteria criteria) {
		return mtAloneProductMapper.findListByWareState(criteria);
	}

	@Override
	public List<MtAloneProduct> findListByRevieweState(MtAloneProductCriteria criteria) {
		return mtAloneProductMapper.findListByRevieweState(criteria);
	}

	@Override
	public List<MtAloneProduct> findListBySupplierCode(SupplierManageCriteria criteria) {
		return mtAloneProductMapper.findListBySupplierCode(criteria);
	}

	@Override
	public void deleteDetByProductCode(MtAloneProductCriteria criteria) {
		mtAloneProductMapper.deleteDetByProductCode(criteria);
	}

	@Override
	public List<MtAloneProductVO> findListNew(MtAloneProductParams params) {
		return mtAloneProductMapper.findListNew(params);
	}

    @Override
    public MtAloneCellStateDto findCountCellStateByComId(MtAloneHomePageParams params) {
        return mtAloneProductMapper.findCountCellStateByComId(params);
    }

	@Override
	public List<MtAloneProductDeliveryVO> findDeliveryProForms(MtAloneDeliveryParams params) {
		return mtAloneProductMapper.findDeliveryProForms(params);
	}

	@Override
	public MtAloneProductCellVO findByBarcodeNew(@Param("productBarcode")String productBarcode) {
		return mtAloneProductMapper.findByBarcodeNew(productBarcode);
	}


}
