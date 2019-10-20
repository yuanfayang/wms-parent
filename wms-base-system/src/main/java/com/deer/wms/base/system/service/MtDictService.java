package com.deer.wms.base.system.service;

import com.deer.wms.base.system.model.MtDict;
import com.deer.wms.base.system.model.MtDictModel;
import com.deer.wms.base.system.model.MtDictParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/10/12.
 */
public interface MtDictService extends Service<MtDict, Integer> {


    List<MtDict> findList(MtDictParams  params) ;

    List<MtDict> findTypeList(MtDictParams params);

    MtDict detail(Integer id);

    void updateList(MtDictModel mtDictModel);
}
