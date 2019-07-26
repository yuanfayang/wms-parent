package com.deer.wms.bill.manage.dao;

import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MtAloneProductMapper extends Mapper<MtAloneProduct> {
	List<MtAloneProduct> findList(MtAloneProductCriteria  criteria);

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
}