package com.deer.wms.detect.service;

import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.detect.model.MtAloneFabricDefect;
import com.deer.wms.detect.model.MtAloneFabricDefectCriteria;
import com.deer.wms.detect.model.MtAloneFabricGroup;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * Created by guo on 2018/12/15.
 */
public interface MtAloneFabricDefectService extends Service<MtAloneFabricDefect, Integer> {


    List<MtAloneFabricDefect> findDefectByName(MtAloneFabricDefectCriteria  criteria) ;

	List<MtAloneFabricDefect> findList(MtAloneFabricDefectCriteria criteria);

	MtAloneProductDet findProductDetByBarCode(@Param("productDetBarCode")String productDetBarCode);

    List<MtAloneFabricDefect> findListByTypeId(MtAloneFabricDefectCriteria criteria);

    List<MtAloneFabricGroup> groupList(MtAloneFabricDefectCriteria criteria);
}
