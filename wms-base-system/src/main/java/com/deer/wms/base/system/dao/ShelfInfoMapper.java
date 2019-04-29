package com.deer.wms.base.system.dao;
import com.deer.wms.base.system.model.ShelfInfo;
import com.deer.wms.base.system.model.ShelfInfoCriteria;
import com.deer.wms.base.system.model.ShelfInfoDto;
import com.deer.wms.base.system.model.ShelfInfoParams;
import com.deer.wms.project.seed.core.mapper.Mapper;
import java.util.List;
public interface ShelfInfoMapper extends Mapper<ShelfInfo> {
    void deleteByCodeAndCom(ShelfInfoCriteria criteria);
    List<ShelfInfoDto> findList(ShelfInfoCriteria criteria);

    List<ShelfInfoDto> findListNew(ShelfInfoParams params);

    void deleteByIdAndComNew(ShelfInfoParams params);

    Integer countNoEmptyCells(ShelfInfoParams params);
}