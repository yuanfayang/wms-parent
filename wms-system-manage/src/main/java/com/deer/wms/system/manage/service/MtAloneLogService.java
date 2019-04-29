package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.MtAloneLog;
import com.deer.wms.system.manage.model.MtAloneLogCriteria;
import com.deer.wms.system.manage.model.log.LogParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/01/17.
 */
public interface MtAloneLogService extends Service<MtAloneLog, Integer> {


    List<MtAloneLog> findList(MtAloneLogCriteria  criteria) ;

	List<MtAloneLog> findListNew(LogParams params);

}
