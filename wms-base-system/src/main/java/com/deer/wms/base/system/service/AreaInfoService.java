package com.deer.wms.base.system.service;
import com.deer.wms.base.system.model.AreaInfo;
import com.deer.wms.base.system.model.AreaInfoCriteria;
import com.deer.wms.base.system.model.AreaInfoDto;
import com.deer.wms.base.system.model.AreaInfoParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2018/06/20.
 */
public interface AreaInfoService extends Service<AreaInfo, Integer> {
    void deleteByCodeAndCom(AreaInfoCriteria criteria);
    List<AreaInfoDto> findList(AreaInfoCriteria  criteria);

    List<AreaInfoDto> findListNew(AreaInfoParams params);

    Integer countChildren(AreaInfoParams params);

    void deleteByIdAndComNew(AreaInfoParams params);
}
