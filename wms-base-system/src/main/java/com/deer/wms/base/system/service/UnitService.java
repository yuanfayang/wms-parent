package com.deer.wms.base.system.service;

import com.deer.wms.base.system.model.Unit;
import com.deer.wms.base.system.model.UnitCriteria;
import com.deer.wms.base.system.model.UnitParams;
import com.deer.wms.project.seed.core.service.Service;

import java.util.List;

/**
 * Created by  on 2018/06/29.
 */
public interface UnitService extends Service<Unit, Integer> {

    void deleteByCodeAndCom(UnitCriteria criteria);
    List<Unit> findList(UnitCriteria criteria);

    List<Unit> findListNew(UnitParams params);

    void deleteByIdAndCom(UnitParams params);

    Integer countRelProducts(UnitParams params);
}
