package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProductProcessBatch;
import com.deer.wms.produce.manage.model.ProductProcessBatchParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface ProductProcessBatchService extends Service<ProductProcessBatch, Integer> {


    List<ProductProcessBatch> findList(ProductProcessBatchParams  params) ;

}
