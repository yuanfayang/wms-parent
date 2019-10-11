package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.produce.manage.dao.ProductProcessMapper;
import com.deer.wms.produce.manage.model.ProductProcess;
import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessDto;
import com.deer.wms.produce.manage.model.ProductProcessParams;
import com.deer.wms.produce.manage.service.ProductProcessService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hy on 2019/07/19.
 */
@Service
@Transactional
public class ProductProcessServiceImpl extends AbstractService<ProductProcess, Integer> implements ProductProcessService {

    @Autowired
    private ProductProcessMapper productProcessMapper;


    @Override
    public List<ProductProcess> findList(ProductProcessParams params) {
        return productProcessMapper.findList(params);
    }

    @Override
    public void save(ProductProcessDto productProcessDto, CurrentUser currentUser) {
        ProductProcess productProcess = new ProductProcess();
        productProcess.setOperatorId(currentUser.getUserId());

        Date date = new Date();
        productProcess.setCreateTime(date);
        productProcess.setUpdateTime(date);
        productProcess.setVersion("1.1");
        productProcess.setStatus(ProduceManageConstant.STATUS_AVAILABLE);
        productProcess.setWorkOrderCode(productProcessDto.getWorkOrderCode());
        productProcess.setWorkOrderName(productProcessDto.getWorkOrderName());
        productProcess.setDeliveryCode(productProcessDto.getDeliveryCode());
        productProcess.setPlanBeginTime(productProcessDto.getPlanBeginTime());
        productProcess.setPlanFinishTime(productProcessDto.getPlanFinishTime());
        productProcess.setClientId(productProcessDto.getClientId());
        productProcess.setClientName(productProcessDto.getClientName());
        productProcess.setContractCode(productProcessDto.getContractCode());
        productProcess.setContractName(productProcessDto.getContractName());
        productProcess.setProductProcessCode(productProcessDto.getProductProcessCode());
        productProcess.setProductProcessName(productProcessDto.getProductProcessName());
        productProcess.setSpecification(productProcessDto.getSpecification());
        productProcess.setProcessPrice(productProcessDto.getProcessPrice());
        productProcess.setLen(productProcessDto.getLen());
        productProcess.setDeliveryLen(productProcessDto.getDeliveryLen());
        productProcess.setDetectionLen(productProcessDto.getDetectionLen());
        productProcess.setBatchCode(productProcessDto.getBatchCode());

        NumberFormat nt = NumberFormat.getPercentInstance();//百分数转换,保留两位小数
        nt.setMinimumFractionDigits(2);
        Float shrinkage = productProcess.getDeliveryLen()/productProcessDto.getLen();
        productProcess.setShrinkage(nt.format(shrinkage));

        productProcess.setPiNum(productProcessDto.getPiNum());
        productProcess.setProcessContent(productProcessDto.getProcessContent());
        productProcess.setMerchandiserId(productProcessDto.getMerchandiserId());
        productProcess.setMemo(productProcessDto.getMemo());
        productProcess.setReviewStatus(ProduceManageConstant.REVIEW_STATUS_FORREVIEW);
        productProcess.setCompanyId(currentUser.getCompanyId());

        //ProductProcessBom productProcessBom =
        //productProcess.setProductBomId(ProductProcessBomService.getProductBomIdByProductId());//该方法待完善···
        productProcessMapper.insert(productProcess);


    }
}
