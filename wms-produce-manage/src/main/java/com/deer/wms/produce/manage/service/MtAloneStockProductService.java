package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneStockProduct;
import com.deer.wms.produce.manage.model.MtAloneStockProductParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/06.
 */
public interface MtAloneStockProductService extends Service<MtAloneStockProduct, Integer> {


    List<MtAloneStockProduct> findList(MtAloneStockProductParams  params);

    List<MtAloneStockProduct> findListPart(MtAloneStockProductParams  params);

}
