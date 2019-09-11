package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProductBatchDetect;
import com.deer.wms.produce.manage.model.ProductBatchDetectParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface ProductBatchDetectService extends Service<ProductBatchDetect, Integer> {


    List<ProductBatchDetect> findList(ProductBatchDetectParams  params) ;

}
