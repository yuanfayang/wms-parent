package com.deer.wms.system.manage.dao;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperator;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperatorParams;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MtAloneGroupOperatorMapper extends Mapper<MtAloneGroupOperator> {
    List<MtAloneGroupOperator> findList(MtAloneGroupOperatorParams params);

    void deleteByGroupId(Integer groupId);

    List<MtAloneGroupOperator> findListByGroupId(Integer groupId);
}