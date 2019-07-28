package com.deer.wms.produce.manage.web;

import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.produce.manage.constant.ProduceManagePublicMethod;
import com.deer.wms.produce.manage.model.*;
import com.deer.wms.produce.manage.service.MaterialsStockInfoService;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.service.MaterialsInfoService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List; 



/**
* Created by  on 2019/07/18.
*/
@Api(description = "物料接口")
@RestController
@RequestMapping("/materials/infos")
public class MaterialsInfoController {

    @Autowired
    private MaterialsInfoService materialsInfoService;

    @Autowired
    private MaterialsStockInfoService materialsStockInfoService;


    @OperateLog(description = "添加物料", type = "增加")
    @ApiOperation(value = "添加物料", notes = "添加物料")
    @PostMapping("/add")
    public Result add(@RequestBody MaterialsVO materialsVO, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        Date date = new Date();
        MaterialsInfo materialsInfo = materialsVO.getMaterialsInfo();
        materialsInfo.setCreateTime(date);
        materialsInfo.setVersion("1.1");
        materialsInfo.setStatus(ProduceManageConstant.STATUS_AVAILABLE);
        materialsInfo.setOperatorId(currentUser.getUserId());
        materialsInfo.setCompanyId(currentUser.getCompanyId());
        materialsInfo.setCode(ProduceManagePublicMethod.creatMaterialsCode());
        materialsInfoService.save(materialsInfo);

        MaterialsStockInfo stock = materialsVO.getMaterialsStockInfo();
        stock.setMaterialsId(materialsInfo.getId());
        stock.setOperatorId(materialsInfo.getOperatorId());
        stock.setStatus(ProduceManageConstant.STATUS_AVAILABLE);
        stock.setCompanyId(materialsInfo.getCompanyId());
        materialsStockInfoService.save(stock);

        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除物料", type = "删除")
    @ApiOperation(value = "删除物料", notes = "删除物料")
    @DeleteMapping("/delete/{materialsId}")
    public Result delete(@PathVariable Integer materialsId) {
        //删除物料，顺带删除相应的库存信息
        MaterialsInfo materialsInfo = materialsInfoService.findById(materialsId);
        materialsInfoService.deleteById(materialsId);
        MaterialsStockInfo stock = materialsStockInfoService.findBy("materialsId",
                materialsInfo.getId());
        materialsStockInfoService.deleteById(stock.getId());

        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改物料", type = "更新")
    @ApiOperation(value = "修改物料", notes = "修改物料")
    @PostMapping("/update")
    public Result update(@RequestBody MaterialsInfo materialsInfo) {
        materialsInfoService.update(materialsInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MaterialsInfo materialsInfo = materialsInfoService.findById(id);
        return ResultGenerator.genSuccessResult(materialsInfo);
    }


    @OperateLog(description = "物料信息分页查询", type = "查询")
    @ApiOperation(value = "物料信息列表分页", notes = "物料信息列表分页")
    @GetMapping("/list")
    public Result list(MaterialsInfoParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);

        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MaterialsInfoDto> list = materialsInfoService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
