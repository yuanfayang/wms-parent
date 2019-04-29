package com.deer.wms.base.system.dao;
import com.deer.wms.base.system.model.*;
import com.deer.wms.project.seed.core.mapper.Mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CellInfoMapper extends Mapper<CellInfo> {
    void deleteByCodeAndCom(CellInfoCriteria criteria);
    List<CellInfoDto> findList(CellInfoCriteria criteria);
    CellInfo findByCellCode(String cellCode) ;
	List<CellInfoDto> findListByRowColumn(CellInfoCriteriaRowColumn criteria);
	
	int findRollCountByCellCode(@Param("cellCode") String cellCode);

    List<CellInfoDto> findListNew(CellInfoParams params);

    List<CellInfoDto> findListByRowColumnNew(CellInfoParamsRowColumn params);

    void deleteByShelfId(ShelfInfoParams params);
}