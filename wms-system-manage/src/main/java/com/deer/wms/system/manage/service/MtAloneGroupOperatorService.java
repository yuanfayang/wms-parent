package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.department.MtAloneGroupOperator;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperatorParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/16.
 */
public interface MtAloneGroupOperatorService extends Service<MtAloneGroupOperator, Integer> {


    List<MtAloneGroupOperator> findList(MtAloneGroupOperatorParams  params) ;

    void deleteByGroupId(Integer groupId);

    List<MtAloneGroupOperator> findListByGroupId(Integer groupId);
}
