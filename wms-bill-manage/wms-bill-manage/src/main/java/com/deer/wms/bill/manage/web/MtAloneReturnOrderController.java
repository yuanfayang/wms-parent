package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;
import com.deer.wms.bill.manage.service.MtAloneReturnOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;


/**
* Created by  on 2018/12/11.
*/
@RestController
@RequestMapping("/mt/alone/return/orders")
public class MtAloneReturnOrderController {

    @Autowired
    private MtAloneReturnOrderService mtAloneReturnOrderService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneReturnOrder mtAloneReturnOrder) {
        mtAloneReturnOrderService.save(mtAloneReturnOrder);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneReturnOrderId) {
        mtAloneReturnOrderService.deleteById(mtAloneReturnOrderId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneReturnOrder mtAloneReturnOrder) {
        mtAloneReturnOrderService.update(mtAloneReturnOrder);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneReturnOrder mtAloneReturnOrder = mtAloneReturnOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneReturnOrder);
    }

    @GetMapping("/list")
    public Result list(MtAloneReturnOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneReturnOrder> list = mtAloneReturnOrderService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
