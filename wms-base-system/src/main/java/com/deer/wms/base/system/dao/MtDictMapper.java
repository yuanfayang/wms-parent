package com.deer.wms.base.system.dao;

import com.deer.wms.base.system.model.MtDict;
import com.deer.wms.base.system.model.MtDictParams;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MtDictMapper extends Mapper<MtDict> {

    List<MtDict> findList(MtDictParams params);

    List<MtDict> findTypeList(MtDictParams params);

    MtDict detail(Integer id);
}