package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProductBatchDetectDet;
import com.deer.wms.produce.manage.model.ProductBatchDetectDetParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface ProductBatchDetectDetService extends Service<ProductBatchDetectDet, Integer> {


    List<ProductBatchDetectDet> findList(ProductBatchDetectDetParams  params) ;

}
