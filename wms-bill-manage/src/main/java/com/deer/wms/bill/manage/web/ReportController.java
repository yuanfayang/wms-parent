package com.deer.wms.bill.manage.web;

import com.deer.wms.bill.manage.model.MtAloneProductDetDto;
import com.deer.wms.bill.manage.model.StockReportCriteria;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
* Created by mt on 2018/12/30.
*/

@Api(description = "报表接口")
@RestController
@RequestMapping("/mt/alone/report")
public class ReportController {

    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;
    @Autowired
    private MtAloneProductService mtAloneProductService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "按照时间段， 供应商，料号，产品名称查询包含产品信息的明细", type = "查询")
    @ApiOperation(value = "按照时间段， 供应商，料号，产品名称查询包含产品信息的明细", notes = "按照时间段， 供应商，料号，产品名称查询包含产品信息的明细")
    @GetMapping("/proDetList")
    public Result proDetList(StockReportCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneProductDetDto> list = mtAloneProductDetService.findProDetListByCriteria(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
