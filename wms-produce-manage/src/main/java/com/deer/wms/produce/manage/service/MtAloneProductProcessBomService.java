package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneProductProcessBom;
import com.deer.wms.produce.manage.model.MtAloneProductProcessBomParams;

import com.deer.wms.produce.manage.model.MtAloneProductProcessBomVO;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/28.
 */
public interface MtAloneProductProcessBomService extends Service<MtAloneProductProcessBom, Integer> {


    List<MtAloneProductProcessBom> findList(MtAloneProductProcessBomParams  params) ;

    List<MtAloneProductProcessBom> findByProductID(Integer productId);

    List<MtAloneProductProcessBomVO> findByProductNameAndProductNum(MtAloneProductProcessBomParams mtAloneProductProcessBomParams);

}
