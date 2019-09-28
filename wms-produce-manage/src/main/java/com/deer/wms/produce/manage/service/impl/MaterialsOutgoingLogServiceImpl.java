package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.produce.manage.dao.MaterialsOutgoingLogMapper;
import com.deer.wms.produce.manage.dao.MaterialsStockInfoMapper;
import com.deer.wms.produce.manage.model.*;
import com.deer.wms.produce.manage.service.MaterialsOutgoingLogService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by guo on 2019/07/21.
 */
@Service
@Transactional
public class MaterialsOutgoingLogServiceImpl extends AbstractService<MaterialsOutgoingLog, Integer> implements MaterialsOutgoingLogService {

    @Autowired
    private MaterialsOutgoingLogMapper materialsOutgoingLogMapper;

    @Autowired
    private MaterialsStockInfoMapper materialsStockInfoMapper;


    @Override
    public List<MaterialsOutgoingLogVo> findListByOneMaterial(MaterialsOutgoingLogParams params) {
        return materialsOutgoingLogMapper.findListByOneMaterial(params);
    }

    @Override
    public void save(MaterialsOutgoingLogDto materialsOutgoingLogDto, CurrentUser currentUser) {
        Date date = new Date();

        MaterialsOutgoingLog materialsOutgoingLog = new MaterialsOutgoingLog();
        materialsOutgoingLog.setOperatorId(currentUser.getUserId());
        materialsOutgoingLog.setCreateTime(date);
        materialsOutgoingLog.setMaterialsId(materialsOutgoingLogDto.getMaterialsId());
        materialsOutgoingLog.setMaterialsName(materialsOutgoingLogDto.getMaterialsName());
        materialsOutgoingLog.setType(materialsOutgoingLogDto.getType());
        materialsOutgoingLog.setQuantity(materialsOutgoingLogDto.getQuantity());
        materialsOutgoingLog.setPositionName(materialsOutgoingLogDto.getPositionName());
        materialsOutgoingLog.setCompanyId(currentUser.getCompanyId());
        materialsOutgoingLogMapper.insert(materialsOutgoingLog);

        /**使用物料id（非stock主键）查询的写法**/
        MaterialsStockInfo tempStock = new MaterialsStockInfo();
        tempStock.setMaterialsId(materialsOutgoingLogDto.getMaterialsId());
        MaterialsStockInfo stock = materialsStockInfoMapper.selectOne(tempStock);

        if(stock==null){//如果是新的物料，库存表中没有该物料信息，则新增一条库存记录
            stock = new MaterialsStockInfo();
            stock.setOperatorId(currentUser.getUserId());
            stock.setMaterialsId(materialsOutgoingLogDto.getMaterialsId());
            stock.setUnitId(materialsOutgoingLogDto.getUnitId());
            stock.setCreateTime(date);
            if(materialsOutgoingLog.getType() == ProduceManageConstant.TYPE_OUT) {
                stock.setQuantity(0-materialsOutgoingLogDto.getQuantity());//新建物料的出库仓储数量为负数
            }else if(materialsOutgoingLog.getType() == ProduceManageConstant.TYPE_IN) {
                stock.setQuantity(materialsOutgoingLogDto.getQuantity());//新建物料的入库仓储数量为正数
            }

            stock.setPositionName(materialsOutgoingLogDto.getPositionName());
            stock.setCompanyId(currentUser.getCompanyId());

            materialsStockInfoMapper.insert(stock);
        }else{//如果库存表中有该物料信息，则更新对应的库存记录
            stock.setCreateTime(date);//日期取最新更新的日期
            MaterialsInfoParams params = new MaterialsInfoParams();//查询条件赋值
            params.setMaterialsId(materialsOutgoingLogDto.getMaterialsId());
            params.setCompanyId(currentUser.getCompanyId());

            //设置库存数量：已有库存数量+入库数量（或已有库存数量-出库数量）
            Float totalQuantity = materialsStockInfoMapper.getStockQuantityByMaId(params);
            if(materialsOutgoingLog.getType() == ProduceManageConstant.TYPE_OUT) {
                totalQuantity -= materialsOutgoingLog.getQuantity();
            }else if(materialsOutgoingLog.getType() == ProduceManageConstant.TYPE_IN) {
                totalQuantity += materialsOutgoingLog.getQuantity();
            }
            stock.setQuantity(totalQuantity);

            //设置库存位置：已有库存仓库,出入库记录对应仓库
            String inAndOutLogPosition = materialsOutgoingLog.getPositionName();
            String stockPosition = materialsStockInfoMapper.getStockPositionByMaId(params);
            if(stockPosition!=null && !stockPosition.trim().equals("")) {
                stock.setPositionName(stockPosition + "," +inAndOutLogPosition);
            }else{
                stock.setPositionName(inAndOutLogPosition);
            }

            materialsStockInfoMapper.updateByPrimaryKey(stock);
        }
    }
}
