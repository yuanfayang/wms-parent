package com.deer.wms.detect.service;

import com.deer.wms.detect.model.*;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guotuanting on 2019/08/28.
 */
public interface MtAloneSampleClothOutService extends Service<MtAloneSampleClothOut, Integer> {


    List<MtAloneSampleClothOutDto> findList(MtAloneSampleClothOutParams  params) ;

    void saveDetails(MtAloneSampleClothOutVO mtAloneSampleClothOutVO, CurrentUser currentUser);

    MtAloneSampleClothOutDetVO findOutDetById(Integer id);
}
