package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessBomDto;
import com.deer.wms.produce.manage.model.ProductProcessBomParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guo on 2019/07/18.
 */
public interface ProductProcessBomService extends Service<ProductProcessBom, Integer> {
    List<ProductProcessBomDto> findProBomAndProList(ProductProcessBomParams params);

    List<ProductProcessBomDto> findListByTerm(ProductProcessBomParams params);

    //static Integer getProductBomIdByProductId() {
    //}
}
