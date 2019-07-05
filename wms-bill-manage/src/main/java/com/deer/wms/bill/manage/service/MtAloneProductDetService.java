package com.deer.wms.bill.manage.service;

import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.core.service.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by  on 2018/11/24.
 */
public interface MtAloneProductDetService extends Service<MtAloneProductDet, Integer> {


    List<MtAloneProductDet> findList(MtAloneProductDetCriteria  criteria) ;

    List<MtAloneProductDet> findDetilByProductBarcode(MtAloneProductDetCriteria  criteria);
    
    void addRollNum(@Param("productCode") String productCode);
    void minusRollNum(@Param("productCode") String productCode);
	MtAloneProductDet findProductDetByBarCode(@Param("productDetBarCode")String productDetBarCode);
	int findCountByProductBarcode(@Param("productBarCode")String productBarCode);
	MtAloneProductDet findOneDetByProCode(@Param("productBarCode")String productBarCode);

	void setCellByOneKey(MtAloneProductDetCriteria criteria);

	List<MtAloneProductDet> findDetByCellCode(MtAloneProductDetCriteria criteria);

	int findForReviewPro(MtAloneProductDetCriteria criteria);

	int findInventoryDet(MtAloneProductDetCriteria criteria);

	int findAllDeliveryDet(MtAloneProductDetCriteria criteria);

//	int findDetectedDet(MtAloneProductDetCriteria criteria);

	int findForOnShelfDet(MtAloneProductDetCriteria criteria);

	int findOnShelfDet(MtAloneProductDetCriteria criteria);

//	int findForDetecteDet(MtAloneProductDetCriteria criteria);

	int findDeliveryedDet(MtAloneProductDetCriteria criteria);

	double findUtilizationByWareCode(MtAloneHomePageCriteria criteria);

	Integer findMaxIndex(MtAloneProductDetCriteria criteria);

	Integer findCountByCellCode(@Param("cellCode") String cellCode);

	List<MtAloneProductDet> findProDetListBySupCode(SupplierManageCriteria criteria);

	List<SupplierStorageInfo> findStorageListBySupCode(SupplierManageCriteria criteria);

    List<MtAloneProductDetDto> findProDetListByCriteria(StockReportCriteria criteria);

    MtAloneHomePageAboveDto findHomePageAboveCount() ;

    MtAloneHomePageBelowDto findHomePageBelowCount(MtAloneHomePageCriteria criteria);

    MtAloneProductDetUtilVO findCountCellUtilByWareCode(MtAloneHomePageCriteria criteria);

    MtAloneCellStateDto findCountCellStateByWareCode(MtAloneHomePageCriteria criteria);

	void updateCell(MtAloneProductCriteria mtAloneProductCriteria);

	List<MtAloneProductDetDto> findDetilByProductId(MtAloneProductDetParams params);

//	List<MtAloneExaminationDetails> findDetExaminationDetails(@Param("productCode") String productCode);
	List<MtAloneDetFabsListVO> findDetExaminationDetails(@Param("productCode") String productCode);

	MtAloneProductDet getIsNotDetectDet(MtAloneProductDetCriteria criteria);

    MtAloneHomePageAboveNewDto findHomePageAboveCountNew(MtAloneHomePageParams params);

    MtAloneHomePageBelowDto findHomePageBelowCountNew(MtAloneHomePageParams params);

    List<MtAloneDetFabsListVO> findDetsWithoutFabs(@Param("productCode") String productCode);
}
