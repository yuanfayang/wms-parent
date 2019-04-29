package com.deer.wms.detect.service;

import com.deer.wms.detect.model.SampleCloth;
import com.deer.wms.detect.model.SampleClothParams;
import com.deer.wms.detect.model.SampleClothVo;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/12.
 */
public interface SampleClothService extends Service<SampleCloth, Integer> {


    List<SampleCloth> findList(SampleClothParams  params) ;

	List<SampleClothVo> findAccessoryList(SampleClothParams params);
	
	SampleClothVo findDetailById(Integer id);//通过ID查找
}
