package com.deer.wms.base.system.service;

import com.deer.wms.base.system.model.MtAloneColor;
import com.deer.wms.base.system.model.MtAloneColorCriteria;

import com.deer.wms.base.system.model.MtAloneColorParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;


/**
 * Created by  on 2018/11/18.
 */
public interface MtAloneColorService extends Service<MtAloneColor, Integer> {


    List<MtAloneColor> findList(MtAloneColorCriteria  criteria) ;

	void deleteByCode(String colorCode);

    List<MtAloneColor> findListByPTCode(MtAloneColorCriteria criteria);

    List<MtAloneColor> findListNew(MtAloneColorParams params);

    void deleteByIdParams(MtAloneColorParams params);

    Integer countRelProducts(MtAloneColorParams params);
}
