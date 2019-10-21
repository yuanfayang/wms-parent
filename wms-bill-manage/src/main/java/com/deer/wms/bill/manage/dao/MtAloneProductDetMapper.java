package com.deer.wms.bill.manage.dao;

import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MtAloneProductDetMapper extends Mapper<MtAloneProductDet> {
	List<MtAloneProductDet> findList(MtAloneProductDetCriteria  criteria);

	List<MtAloneProductDet> findDetilByProductBarcode(MtAloneProductDetCriteria  criteria);

	void minusRollNum(@Param("productCode") String productCode);

	void addRollNum(@Param("productCode") String productCode);

	int findCountByProductBarcode(@Param("productBarCode")String productBarCode);
	
	MtAloneProductDet findOneDetByProCode(@Param("productBarCode")String productBarCode);

	void setCellByOneKey(MtAloneProductDetCriteria criteria);

	List<MtAloneProductDet> findDetByCellCode(MtAloneProductDetCriteria criteria);

	int findInventoryDet(MtAloneProductDetCriteria criteria);

	int findForReviewPro(MtAloneProductDetCriteria criteria);

	int findAllDeliveryDet(MtAloneProductDetCriteria criteria);

	int findForOnShelfDet(MtAloneProductDetCriteria criteria);

	int findOnShelfDet(MtAloneProductDetCriteria criteria);

	int findDeliveryedDet(MtAloneProductDetCriteria criteria);

//	int findForDetecteDet(MtAloneProductDetCriteria criteria);

//	int findDetectedDet(MtAloneProductDetCriteria criteria);

	MtAloneProductDetUtilVO findUtilizationByWareCode(MtAloneHomePageCriteria criteria);

    MtAloneCellStateDto findCountCellStateByWareCode(MtAloneHomePageCriteria criteria);//统计不同状态货位数

	Integer findMaxIndex(MtAloneProductDetCriteria criteria);


	Integer findCountByCellCode(@Param("cellCode") String cellCode);

    List<MtAloneProductDet> findProDetListBySupCode(SupplierManageCriteria criteria);

	List<SupplierStorageInfo> findStorageListBySupCode(SupplierManageCriteria criteria);

    List<SupplierStorageInfo> findWareBySupCode(SupplierManageCriteria criteria);

	List<SupplierStorageInfo> findAreaBySupCode(SupplierManageCriteria criteria);

    List<SupplierStorageInfo> findShelfBySupCode(SupplierManageCriteria criteria);

	MtAloneProductDet findProductDetByBarCode(@Param("productDetBarCode")String productDetBarCode);

    List<MtAloneProductDetDto> findProDetListByCriteria(StockReportCriteria criteria);

	MtAloneHomePageAboveDto findHomePageAboveCount();

    List<MtAloneAriAndDelVo> findHomePageBelowArrivalCount(MtAloneHomePageCriteria criteria);

    List<MtAloneAriAndDelVo> findHomePageBelowDeliveryCount(MtAloneHomePageCriteria criteria);

	void updateCell(MtAloneProductCriteria mtAloneProductCriteria);

	List<MtAloneProductDetDto> findDetilByProductId(MtAloneProductDetParams params);

	MtAloneProductDet getIsNotDetectDet(MtAloneProductDetCriteria criteria);

    MtAloneHomePageAboveNewDto findHomePageAboveCountNew(MtAloneHomePageParams params);

    List<MtAloneAriAndDelVo> findHomePageBelowArrivalCountNew(MtAloneHomePageParams params);

    List<MtAloneAriAndDelVo> findHomePageBelowDeliveryCountNew(MtAloneHomePageParams params);

//    List<MtAloneExaminationDetails> findDetExaminationDetails(@Param("productCode") String productCode);
	List<MtAloneDetFabsListVO> findDetExaminationDetails(QueryParamsDet params);

    List<MtAloneDetFabsListVO> findDetsWithoutFabs(QueryParamsDet params);

    Long findDetsWithoutFabsCount(QueryParamsDet detParams);

    void rollFinish(MtAloneProductDetCriteria params);
}