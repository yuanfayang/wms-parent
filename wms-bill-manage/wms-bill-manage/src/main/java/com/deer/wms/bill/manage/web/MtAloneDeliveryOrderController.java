package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.service.MtAloneDeliveryOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;


/**
* Created by  on 2019/03/05.
*/
@RestController
@RequestMapping("/mt/alone/delivery/orders")
public class MtAloneDeliveryOrderController {

    @Autowired
    private MtAloneDeliveryOrderService mtAloneDeliveryOrderService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDeliveryOrder mtAloneDeliveryOrder) {
        mtAloneDeliveryOrderService.save(mtAloneDeliveryOrder);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneDeliveryOrderId) {
        mtAloneDeliveryOrderService.deleteById(mtAloneDeliveryOrderId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDeliveryOrder mtAloneDeliveryOrder) {
        mtAloneDeliveryOrderService.update(mtAloneDeliveryOrder);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDeliveryOrder mtAloneDeliveryOrder = mtAloneDeliveryOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDeliveryOrder);
    }

    @GetMapping("/list")
    public Result list(MtAloneDeliveryOrderCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDeliveryOrder> list = mtAloneDeliveryOrderService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
