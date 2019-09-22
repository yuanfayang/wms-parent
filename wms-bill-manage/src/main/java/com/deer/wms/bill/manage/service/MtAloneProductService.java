package com.deer.wms.bill.manage.service;

import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.core.service.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by  on 2018/11/24.
 */
public interface MtAloneProductService extends Service<MtAloneProduct, Integer> {


    List<MtAloneProduct> findList(MtAloneProductCriteria criteria) ;

	List<MtAloneProduct> findListBykeyAndDate(MtAloneProductCriteria criteria);

	MtAloneProduct findByBarcode(@Param("productBarcode")String productBarcode);

	List<MtAloneProduct> findListByWareState(MtAloneProductCriteria criteria);

	List<MtAloneProduct> findListByRevieweState(MtAloneProductCriteria criteria);

	List<MtAloneProduct> findListBySupplierCode(SupplierManageCriteria criteria);

	void deleteDetByProductCode(MtAloneProductCriteria criteria);

	List<MtAloneProductVO> findListNew(MtAloneProductParams params);

	Integer findListNewCount(MtAloneProductParams params);

    MtAloneCellStateDto findCountCellStateByComId(MtAloneHomePageParams params);

	List<MtAloneProductDeliveryVO> findDeliveryProForms(MtAloneDeliveryParams params);

	MtAloneProductCellVO findByBarcodeNew(@Param("productBarcode")String productBarcode);

	MtAloneProductCellVO findById(Integer id);

	List<MtAloneProduct> rollList(MtAloneProductParams params);
}
