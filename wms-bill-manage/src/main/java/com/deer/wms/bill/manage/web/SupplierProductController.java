package com.deer.wms.bill.manage.web;

import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.SupplierStorageInfo;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
* Created by mt on 2018/12/30.
*/

@Api(description = "供应商产品接口")
@RestController
@RequestMapping("/mt/alone/product/dets")
public class SupplierProductController {

    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;
    @Autowired
    private MtAloneProductService mtAloneProductService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "按照供应商code查询对应产品明细", type = "查询")
    @ApiOperation(value = "按照供应商code查询对应产品明细", notes = "按照供应商code查询对应产品明细")
    @GetMapping("/proDetList")
    public Result proDetList(SupplierManageCriteria criteria) {
        List<MtAloneProductDet> list = mtAloneProductDetService.findProDetListBySupCode(criteria);
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "按照供应商code获取仓储级联结构", type = "查询")
    @ApiOperation(value = "按照供应商code获取仓储级联结构", notes = "按照供应商code获取仓储级联结构")
    @GetMapping("/storageList")
    public Result storageList(SupplierManageCriteria criteria) {
        List<SupplierStorageInfo> list = mtAloneProductDetService.findStorageListBySupCode(criteria);
        return ResultGenerator.genSuccessResult(list);
    }

}
