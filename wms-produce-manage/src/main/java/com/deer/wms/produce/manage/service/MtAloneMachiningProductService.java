package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneMachiningProduct;
import com.deer.wms.produce.manage.model.MtAloneMachiningProductParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/19.
 */
public interface MtAloneMachiningProductService extends Service<MtAloneMachiningProduct, Integer> {


    List<MtAloneMachiningProduct> findList(MtAloneMachiningProductParams params) ;

    List<MtAloneMachiningProduct> findListByClothAttr(MtAloneMachiningProduct mtAloneMachiningProduct);

    MtAloneMachiningProduct findByProductTypeCode(String productTypeCode);

}
