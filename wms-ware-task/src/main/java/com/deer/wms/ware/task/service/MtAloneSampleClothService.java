package com.deer.wms.ware.task.service;



import com.deer.wms.project.seed.core.service.Service;
import com.deer.wms.ware.task.model.MtAloneSampleCloth;
import com.deer.wms.ware.task.model.MtAloneSampleClothCriteria;
import com.deer.wms.ware.task.model.MtAloneSampleClothDto;

import java.util.List;


/**
 * Created by  on 2019/03/21.
 */
public interface MtAloneSampleClothService extends Service<MtAloneSampleCloth, Integer> {


    List<MtAloneSampleClothDto> findList(MtAloneSampleClothCriteria  criteria) ;

}
