package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProductProcessBatchDet;
import com.deer.wms.produce.manage.model.ProductProcessBatchDetParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface ProductProcessBatchDetService extends Service<ProductProcessBatchDet, Integer> {


    List<ProductProcessBatchDet> findList(ProductProcessBatchDetParams  params) ;

}
