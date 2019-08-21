package com.deer.wms.produce.manage.web;

import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.produce.manage.model.*;
import com.deer.wms.produce.manage.service.MaterialsOutgoingLogDTOService;
import com.deer.wms.produce.manage.service.MaterialsOutgoingLogService;
import com.deer.wms.produce.manage.service.MaterialsStockInfoService;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;


/**
* Created by guo on 2019/07/21.
*/
@Api(description = "物料出入库接口")
@RestController
@RequestMapping("/materials/outgoing/logs")
public class MaterialsOutgoingLogController {

    @Autowired
    private MaterialsOutgoingLogService materialsOutgoingLogService;

    @Autowired
    private MaterialsStockInfoService materialsStockInfoService;

    //@Autowired
    //private MaterialsOutgoingLogDTOService materialsOutgoingLogDTOService;

    @OperateLog(description = "添加一条出入库记录", type = "增加")
    @ApiOperation(value = "添加一条出入库记录", notes = "添加一条出入库记录")
    @PostMapping("/add")
    public Result add(@RequestBody MaterialsOutgoingLogDTO materialsOutgoingLogDTO, @ApiIgnore @User CurrentUser currentUser) {
        //if(currentUser==null){
        //    return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        //}

        Date date = new Date();
        MaterialsInfo materialsInfo = materialsOutgoingLogDTO.getMaterialsInfo();

        MaterialsOutgoingLog materialsOutgoingLog = new MaterialsOutgoingLog();
        materialsOutgoingLog.setOperatorId(1);
        materialsOutgoingLog.setCreateTime(date);
        materialsOutgoingLog.setMaterialsId(materialsInfo.getId());
        materialsOutgoingLog.setMaterialsName(materialsInfo.getMaterialsName());
        materialsOutgoingLog.setType(materialsOutgoingLogDTO.getType());
        materialsOutgoingLog.setQuantity(materialsOutgoingLogDTO.getQuantity());
        materialsOutgoingLog.setPositionName(materialsOutgoingLogDTO.getPositionName());
        materialsOutgoingLog.setCompanyId(1);
        materialsOutgoingLogService.save(materialsOutgoingLog);

        MaterialsStockInfo stock = materialsStockInfoService.findBy("materialsId", materialsInfo.getId());

        if(stock==null){//如果是新的物料，库存表中没有该物料信息，则新增一条库存记录
            stock = new MaterialsStockInfo();
            stock.setOperatorId(1);
            stock.setMaterialsId(materialsInfo.getId());
            stock.setUnitId(materialsInfo.getUnitId());
            stock.setCreateTime(date);
            stock.setQuantity(materialsOutgoingLogDTO.getQuantity());
            stock.setPositionName(materialsOutgoingLogDTO.getPositionName());
            stock.setCompanyId(1);
            materialsStockInfoService.save(stock);
        }else{//如果库存表中有该物料信息，则更新对应的库存记录
            stock.setCreateTime(date);//日期取最新更新的日期
            MaterialsInfoParams params = new MaterialsInfoParams();//查询条件赋值
            params.setId(materialsInfo.getId());
            params.setCompanyId(1);

            //设置库存数量：已有库存数量+入库数量（或已有库存数量-出库数量）
            Float totalQuantity = materialsStockInfoService.getStockQuantityByMaId(params);
            if(materialsOutgoingLog.getType() == ProduceManageConstant.TYPE_OUT) {
                totalQuantity -= materialsOutgoingLog.getQuantity();
            }else if(materialsOutgoingLog.getType() == ProduceManageConstant.TYPE_IN) {
                totalQuantity += materialsOutgoingLog.getQuantity();
            }
            stock.setQuantity(totalQuantity);

            //设置库存位置：已有库存仓库+，+出入库记录对应仓库
            String inAndOutLogPosition = materialsOutgoingLog.getPositionName();
            String stockPosition = materialsStockInfoService.getStockPositionByMaId(params);
            if(stockPosition!=null && !stockPosition.trim().equals("")) {
                stock.setPositionName(stockPosition + "," +inAndOutLogPosition);
            }else{
                stock.setPositionName(inAndOutLogPosition);
            }

            materialsStockInfoService.update(stock);
        }

        //materialsOutgoingLogDTO.setMaterialsId(materialsInfo.getId());
        //materialsOutgoingLogDTO.setMaterialsName(materialsInfo.getMaterialsName());
        //materialsOutgoingLogDTO.setCreateTime(new Date());
        //materialsOutgoingLogDTO.setCompanyId(currentUser.getCompanyId());
        //materialsOutgoingLogDTO.setOperatorId(currentUser.getUserId());
        //materialsOutgoingLogDTOService.save(materialsOutgoingLogDTO);//业务层同时调用出入库信息和存储信息的两个save方法
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        materialsOutgoingLogService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MaterialsOutgoingLog materialsOutgoingLog) {
        //materialsOutgoingLog.setUpdateTime(new Date());
        materialsOutgoingLogService.update(materialsOutgoingLog);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MaterialsOutgoingLog materialsOutgoingLog = materialsOutgoingLogService.findById(id);
        return ResultGenerator.genSuccessResult(materialsOutgoingLog);
    }

    @GetMapping("/list")
    public Result list(MaterialsOutgoingLogParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MaterialsOutgoingLog> list = materialsOutgoingLogService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
