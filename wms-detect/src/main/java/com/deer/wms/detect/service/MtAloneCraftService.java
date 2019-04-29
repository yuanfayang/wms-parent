package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneCraft;
import com.deer.wms.detect.model.MtAloneCraftParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/08.
 */
public interface MtAloneCraftService extends Service<MtAloneCraft, Integer> {

    List<MtAloneCraft> findList(MtAloneCraftParams  params) ;

	/**
	 * @param params
	 * @return
	 */
	List<MtAloneCraft> parentListById(MtAloneCraftParams params);

}
