package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneSampleClothDetMapper;
import com.deer.wms.detect.dao.MtAloneSampleClothOutDetMapper;
import com.deer.wms.detect.dao.MtAloneSampleClothOutMapper;
import com.deer.wms.detect.model.*;
import com.deer.wms.detect.service.MtAloneSampleClothOutService;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by guotuanting on 2019/08/28.
 */
@Service
@Transactional
public class MtAloneSampleClothOutServiceImpl extends AbstractService<MtAloneSampleClothOut, Integer> implements MtAloneSampleClothOutService {

    @Autowired
    private MtAloneSampleClothOutMapper mtAloneSampleClothOutMapper;
    @Autowired
    private MtAloneSampleClothOutDetMapper mtAloneSampleClothOutDetMapper;
    @Autowired
    private MtAloneSampleClothDetMapper mtAloneSampleClothDetMapper;

    @Override
    public List<MtAloneSampleClothOutDto> findList(MtAloneSampleClothOutParams params) {
        return mtAloneSampleClothOutMapper.findList(params);
    }

    @Override
    public void saveDetails(MtAloneSampleClothOutVO mtAloneSampleClothOutVO, CurrentUser currentUser) {
        MtAloneSampleClothOut mtAloneSampleClothOut = mtAloneSampleClothOutVO.getMtAloneSampleClothOut();
        mtAloneSampleClothOutMapper.insertSelective(mtAloneSampleClothOut);
        List<MtAloneSampleClothOutDet> mtAloneSampleClothOutDetList = mtAloneSampleClothOutVO.getMtAloneSampleClothOutDetList();
        MtAloneSampleClothDet det = null;
        for (MtAloneSampleClothOutDet outDet : mtAloneSampleClothOutDetList) {
            outDet.setCompanyId(currentUser.getCompanyId());
            outDet.setCreateTime(new Date());
            outDet.setCreatorId(currentUser.getUserId());
            outDet.setSampleClothOutId(mtAloneSampleClothOut.getId());

            det = new MtAloneSampleClothDet();
            det.setId(outDet.getId());
            det.setStatus(2);
            mtAloneSampleClothDetMapper.updateByPrimaryKeySelective(det);
        }
        mtAloneSampleClothOutDetMapper.insertList(mtAloneSampleClothOutDetList);
    }

    @Override
    public MtAloneSampleClothOutDetVO findOutDetById(Integer id) {
        return mtAloneSampleClothOutMapper.findOutDetById(id);
    }
}
