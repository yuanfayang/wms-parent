package com.deer.wms.base.system.service;
import com.deer.wms.base.system.model.*;
import com.deer.wms.project.seed.core.service.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by  on 2018/06/20.
 */
public interface CellInfoService extends Service<CellInfo, Integer> {
    void  deleteByCodeAndCom(CellInfoCriteria criteria);
    List<CellInfoDto> findList(CellInfoCriteria criteria);
    CellInfo findByCellCode(String cellCode);

    //设置货位优先级
    void setOrder(ShelfInfo shelfInfo);
	List<CellInfoDto> findListByRowColumn(CellInfoCriteriaRowColumn criteria);

    int findRollCountByCellCode(@Param("cellCode") String cellCode);

    List<CellInfoDto> findListNew(CellInfoParams params);

    List<CellInfoDto> findListByRowColumnNew(CellInfoParamsRowColumn params);

    void deleteByShelfId(ShelfInfoParams params);

    void deleteListByIds(List<CellInfo> list);
}
