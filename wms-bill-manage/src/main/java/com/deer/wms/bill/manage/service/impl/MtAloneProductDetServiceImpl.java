 package com.deer.wms.bill.manage.service.impl;

 import com.deer.wms.base.system.model.SupplierManageCriteria;
 import com.deer.wms.bill.manage.dao.MtAloneProductDetMapper;
 import com.deer.wms.bill.manage.model.*;
 import com.deer.wms.bill.manage.service.MtAloneProductDetService;
 import com.deer.wms.project.seed.core.service.AbstractService;
 import org.apache.ibatis.annotations.Param;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.math.BigDecimal;
 import java.util.*;

 /**
 * Created by  on 2018/11/24.
 */
@Service
@Transactional
public class MtAloneProductDetServiceImpl extends AbstractService<MtAloneProductDet, Integer> implements MtAloneProductDetService {

    @Autowired
    private MtAloneProductDetMapper mtAloneProductDetMapper;


    @Override
    public List<MtAloneProductDet> findList(MtAloneProductDetCriteria  criteria) {
        return mtAloneProductDetMapper.findList(criteria);
    }


	@Override
	public List<MtAloneProductDet> findDetilByProductBarcode(MtAloneProductDetCriteria  criteria) {
		return mtAloneProductDetMapper.findDetilByProductBarcode(criteria);
	}
	

	@Override
	public List<MtAloneProductDetDto> findDetilByProductId(MtAloneProductDetParams params) {
		return mtAloneProductDetMapper.findDetilByProductId(params);
	}

//     @Override
//     public List<MtAloneExaminationDetails> findDetExaminationDetails(@Param("productCode") String productCode) {
//         return mtAloneProductDetMapper.findDetExaminationDetails(productCode);
//     }

     @Override
     public List<MtAloneDetFabsListVO> findDetExaminationDetails(QueryParamsDet params) {
         return mtAloneProductDetMapper.findDetExaminationDetails(params);
     }


     @Override
	public void addRollNum(@Param("productCode") String productCode) {
		mtAloneProductDetMapper.addRollNum(productCode);
		
	}


	@Override
	public void minusRollNum(@Param("productCode") String productCode) {
		mtAloneProductDetMapper.minusRollNum(productCode);
	}


	@Override
	public int findCountByProductBarcode(@Param("productBarCode")String productBarCode) {
		return mtAloneProductDetMapper.findCountByProductBarcode(productBarCode);
		
	}
	
	@Override
	public MtAloneProductDet getIsNotDetectDet(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.getIsNotDetectDet(criteria);
	}

     @Override
     public MtAloneHomePageAboveNewDto findHomePageAboveCountNew(MtAloneHomePageParams params) {
         MtAloneHomePageAboveNewDto homePageAboveDto = mtAloneProductDetMapper.findHomePageAboveCountNew(params);
         return homePageAboveDto;
     }

     @Override
     public MtAloneHomePageBelowDto findHomePageBelowCountNew(MtAloneHomePageParams params) {
         //根据时间类型、起始时间和结束时间，生成完整的日期list，便于补充hashmap
         Date currentDate = MtAloneDateFuns.setHMSZero(new Date());//把日期時分秒變為00:00:00

         Date begDate = MtAloneDateFuns.getBegAndEndOfWeekOrMonth(currentDate,params.getTimeType())[0];
         Date endDate = MtAloneDateFuns.getBegAndEndOfWeekOrMonth(currentDate,params.getTimeType())[1];
         params.setBegDate(begDate);//给criteria赋起止日期
         params.setEndDate(endDate);

         ArrayList<Date> completeDateList = new ArrayList<Date>();
         completeDateList.clear();
         completeDateList = MtAloneDateFuns.completeDateList(begDate,endDate);

         MtAloneHomePageBelowDto homePageBelowDto = new MtAloneHomePageBelowDto();
         HashMap<Date,Double> arrMap = new HashMap<Date,Double>();
         HashMap<Date,Double> delMap = new HashMap<Date,Double>();
         ArrayList<MtAloneAriAndDelVo> tempArrList = (ArrayList<MtAloneAriAndDelVo>) mtAloneProductDetMapper.findHomePageBelowArrivalCountNew(params);
         ArrayList<MtAloneAriAndDelVo> tempDelList = (ArrayList<MtAloneAriAndDelVo>) mtAloneProductDetMapper.findHomePageBelowDeliveryCountNew(params);

         for (int i = 0; i < tempArrList.size(); i++) {//入库信息赋值hashmap
             MtAloneAriAndDelVo arrVo = tempArrList.get(i);
             Date date = arrVo.getDate();
             Double milesSum = arrVo.getMilesSum();
             //System.out.println("++++++ari:"+date+"   "+milesSum);
             arrMap.put(date,milesSum);
         }

         for (int i = 0; i < tempDelList.size(); i++) {//出库信息赋值hashmap
             MtAloneAriAndDelVo delVo = tempDelList.get(i);
             Date date = delVo.getDate();
             Double milesSum = delVo.getMilesSum();
             delMap.put(date, milesSum);
         }

         if(completeDateList.size()!=0){//判断hashmap中是否包含某日期，没有的话加入该日期并赋值米数0
             for (int i = 0; i < completeDateList.size(); i++) {
                 Date oneDay = completeDateList.get(i);
                 if(!arrMap.containsKey(oneDay)){
                     arrMap.put(oneDay,0.0);
                     //System.out.println("  ari!contain:"+oneDay+"    ++"+ariMap.get(oneDay));
                 }

                 if(!delMap.containsKey(oneDay)){
                     delMap.put(oneDay,0.0);
                     //System.out.println("  del!contain:"+oneDay+"    ++"+delMap.get(oneDay));
                 }
             }
         }

         //hashmap按照日期排序后赋给结构中List
         ArrayList<Date> arrDateList = homePageBelowDto.getArrDateList();
         ArrayList<Date> delDateList = homePageBelowDto.getDelDateList();
         ArrayList<Double> arrMilesList = homePageBelowDto.getArrMilesList();
         ArrayList<Double> delMilesList = homePageBelowDto.getDelMilesList();

         Iterator<Date> arrIt = arrMap.keySet().iterator();
         while(arrIt.hasNext()){
             Date date = arrIt.next();
             arrDateList.add(date);
         }
         Collections.sort(arrDateList);

         for (int i = 0; i < arrDateList.size(); i++) {
             Date date = arrDateList.get(i);
             arrMilesList.add(arrMap.get(date));
         }

         Iterator<Date> delIt = delMap.keySet().iterator();
         while(delIt.hasNext()){
             Date date = delIt.next();
             delDateList.add(date);
         }
         Collections.sort(delDateList);
         for (int i = 0; i < delDateList.size(); i++) {
             Date date = delDateList.get(i);
             delMilesList.add(delMap.get(date));
         }

         return homePageBelowDto;
     }

     @Override
     public List<MtAloneDetFabsListVO> findDetsWithoutFabs(QueryParamsDet params) {
         return  mtAloneProductDetMapper.findDetsWithoutFabs(params);
     }


     @Override
	public MtAloneProductDet findOneDetByProCode(@Param("productBarCode")String productBarCode) {
		return mtAloneProductDetMapper.findOneDetByProCode(productBarCode);
	}


	@Override
	public void setCellByOneKey(MtAloneProductDetCriteria criteria) {
		mtAloneProductDetMapper.setCellByOneKey(criteria);
		
	}


	@Override
	public List<MtAloneProductDet> findDetByCellCode(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findDetByCellCode(criteria);
	}


	@Override
	public int findForReviewPro(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findForReviewPro(criteria);
	}


	@Override
	public int findInventoryDet(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findInventoryDet(criteria);
	}


	@Override
	public int findAllDeliveryDet(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findAllDeliveryDet(criteria);
	}

	@Override
	public void updateCell(MtAloneProductCriteria mtAloneProductCriteria) {
		mtAloneProductDetMapper.updateCell(mtAloneProductCriteria);
		
	}
//	@Override
//	public int findDetectedDet(MtAloneProductDetCriteria criteria) {
//		return mtAloneProductDetMapper.findDetectedDet(criteria);
//	}


	@Override
	public int findForOnShelfDet(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findForOnShelfDet(criteria);
	}


	@Override
	public int findOnShelfDet(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findOnShelfDet(criteria);
	}


//	@Override
//	public int findForDetecteDet(MtAloneProductDetCriteria criteria) {
//		return mtAloneProductDetMapper.findForDetecteDet(criteria);
//	}


	@Override
	public int findDeliveryedDet(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findDeliveryedDet(criteria);
	}


	@Override
	 public double findUtilizationByWareCode(MtAloneHomePageCriteria criteria) {
		double result = 0;
		MtAloneProductDetUtilVO vo = mtAloneProductDetMapper.findUtilizationByWareCode(criteria);
		if(vo!=null) {
			double denominator = vo.getDenominator();
			double numerator = vo.getNumerator();
			if(denominator!=0) 
				result =  (numerator/denominator) * 100;				 
		}
		
		result = (new BigDecimal(result)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}

    @Override
    public MtAloneProductDetUtilVO findCountCellUtilByWareCode(MtAloneHomePageCriteria criteria) {
        return mtAloneProductDetMapper.findUtilizationByWareCode(criteria);
    }

    @Override
    public  MtAloneCellStateDto findCountCellStateByWareCode(MtAloneHomePageCriteria criteria) {
        return mtAloneProductDetMapper.findCountCellStateByWareCode(criteria);
    }

    @Override
	public Integer findMaxIndex(MtAloneProductDetCriteria criteria) {
		return mtAloneProductDetMapper.findMaxIndex(criteria);
	}

    @Override
    public List<MtAloneProductDet> findProDetListBySupCode(SupplierManageCriteria criteria) {
		return mtAloneProductDetMapper.findProDetListBySupCode(criteria);
    }

	@Override
	public List<SupplierStorageInfo> findStorageListBySupCode(SupplierManageCriteria criteria) {
        List<SupplierStorageInfo> wares = mtAloneProductDetMapper.findWareBySupCode(criteria);
        List<SupplierStorageInfo> areas = mtAloneProductDetMapper.findAreaBySupCode(criteria);
        List<SupplierStorageInfo> shelfs = mtAloneProductDetMapper.findShelfBySupCode(criteria);

        for (int i = 0; i < wares.size(); i++) {
            SupplierStorageInfo ware = wares.get(i);
            ware.setParentValue(null);
            ArrayList<SupplierStorageInfo> wareChlidren = ware.getChildren();
            for (int j = 0; j < areas.size(); j++) {
                SupplierStorageInfo area = areas.get(j);
                if(area.getParentValue()!=null && area.getParentValue().trim().equals(ware.getValue().trim()))
                    wareChlidren.add(area);
            }
        }

        for (int i = 0; i < areas.size(); i++) {
            SupplierStorageInfo area = areas.get(i);
            ArrayList<SupplierStorageInfo> areaChlidren = area.getChildren();
            for (int j = 0; j < shelfs.size(); j++) {
                SupplierStorageInfo shelf = shelfs.get(j);
                if(shelf.getParentValue()!=null && shelf.getParentValue().trim().equals(area.getValue()))
                    areaChlidren.add(shelf);
            }
        }

        for (int i = 0; i < shelfs.size(); i++) {//暂时将货架的孩子定为空
            SupplierStorageInfo shelf = shelfs.get(i);
           shelf.setChildren(null);
        }

        System.out.println(wares.get(0).getLabel()+" ===  "+wares.get(0).getChildren().get(0).getLabel());
        return wares;
	}

    @Override
    public List<MtAloneProductDetDto> findProDetListByCriteria(StockReportCriteria criteria) {
        return mtAloneProductDetMapper.findProDetListByCriteria(criteria);
    }

    @Override
	public Integer findCountByCellCode(@Param("cellCode") String cellCode) {
		return mtAloneProductDetMapper.findCountByCellCode(cellCode);
	}


	@Override
	public MtAloneProductDet findProductDetByBarCode(@Param("productDetBarCode")String productDetBarCode) {
		return mtAloneProductDetMapper.findProductDetByBarCode(productDetBarCode);
	}

    @Override
    public MtAloneHomePageAboveDto findHomePageAboveCount() {
        MtAloneHomePageAboveDto homePageAboveDto = mtAloneProductDetMapper.findHomePageAboveCount();
        return homePageAboveDto;
    }

    @Override
        public MtAloneHomePageBelowDto findHomePageBelowCount(MtAloneHomePageCriteria criteria) {
            //根据时间类型、起始时间和结束时间，生成完整的日期list，便于补充hashmap
            Date currentDate = MtAloneDateFuns.setHMSZero(new Date());//把日期時分秒變為00:00:00

            Date begDate = MtAloneDateFuns.getBegAndEndOfWeekOrMonth(currentDate,criteria.getTimeType())[0];
            Date endDate = MtAloneDateFuns.getBegAndEndOfWeekOrMonth(currentDate,criteria.getTimeType())[1];
            criteria.setBegDate(begDate);//给criteria赋起止日期
            criteria.setEndDate(endDate);

            ArrayList<Date> completeDateList = new ArrayList<Date>();
            completeDateList.clear();
            completeDateList = MtAloneDateFuns.completeDateList(begDate,endDate);

        //System.out.println("begin:"+begDate+"   end:"+endDate);
        //for (int i = 0; i <completeDateList.size(); i++) {
        //    System.out.println("---------"+completeDateList.get(i));
        //}

            MtAloneHomePageBelowDto homePageBelowDto = new MtAloneHomePageBelowDto();
            HashMap<Date,Double> arrMap = new HashMap<Date,Double>();
            HashMap<Date,Double> delMap = new HashMap<Date,Double>();
            ArrayList<MtAloneAriAndDelVo> tempArrList = (ArrayList<MtAloneAriAndDelVo>)mtAloneProductDetMapper.findHomePageBelowArrivalCount(criteria);
            ArrayList<MtAloneAriAndDelVo> tempDelList = (ArrayList<MtAloneAriAndDelVo>)mtAloneProductDetMapper.findHomePageBelowDeliveryCount(criteria);

            for (int i = 0; i < tempArrList.size(); i++) {//来货信息赋值hashmap
                MtAloneAriAndDelVo arrVo = tempArrList.get(i);
                Date date = arrVo.getDate();
                Double milesSum = arrVo.getMilesSum();
                //System.out.println("++++++ari:"+date+"   "+milesSum);
                arrMap.put(date,milesSum);
            }

            for (int i = 0; i < tempDelList.size(); i++) {//出库信息赋值hashmap
                MtAloneAriAndDelVo delVo = tempDelList.get(i);
                Date date = delVo.getDate();
                Double milesSum = delVo.getMilesSum();
                //System.out.println("++++++del:"+date+"   "+milesSum);
                delMap.put(date, milesSum);
            }

            if(completeDateList.size()!=0){//判断hashmap中是否包含日期，没有的话加入并赋值0
                for (int i = 0; i < completeDateList.size(); i++) {
                    Date oneDay = completeDateList.get(i);
                    if(!arrMap.containsKey(oneDay)){
                        arrMap.put(oneDay,0.0);
                        //System.out.println("  ari!contain:"+oneDay+"    ++"+ariMap.get(oneDay));
                    }

                    if(!delMap.containsKey(oneDay)){
                        delMap.put(oneDay,0.0);
                        //System.out.println("  del!contain:"+oneDay+"    ++"+delMap.get(oneDay));
                    }
                }
            }

            //hashmap按照日期排序后赋给结构中List
            ArrayList<Date> arrDateList = homePageBelowDto.getArrDateList();
            ArrayList<Date> delDateList = homePageBelowDto.getDelDateList();
            ArrayList<Double> arrMilesList = homePageBelowDto.getArrMilesList();
            ArrayList<Double> delMilesList = homePageBelowDto.getDelMilesList();

            Iterator<Date> arrIt = arrMap.keySet().iterator();
            while(arrIt.hasNext()){
                Date date = arrIt.next();
                arrDateList.add(date);
            }
            Collections.sort(arrDateList);

            for (int i = 0; i < arrDateList.size(); i++) {
                Date date = arrDateList.get(i);
                arrMilesList.add(arrMap.get(date));
            }

            Iterator<Date> delIt = delMap.keySet().iterator();
            while(delIt.hasNext()){
                Date date = delIt.next();
                delDateList.add(date);
            }
            Collections.sort(delDateList);
            for (int i = 0; i < delDateList.size(); i++) {
                Date date = delDateList.get(i);
                delMilesList.add(delMap.get(date));
            }

            return homePageBelowDto;
        }

    }

