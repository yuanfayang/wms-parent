package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetCriteria;
import com.deer.wms.bill.manage.service.MtAloneDeliveryDetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;


/**
* Created by  on 2019/03/07.
*/
@RestController
@RequestMapping("/mt/alone/delivery/dets")
public class MtAloneDeliveryDetController {

    @Autowired
    private MtAloneDeliveryDetService mtAloneDeliveryDetService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDeliveryDet mtAloneDeliveryDet) {
        mtAloneDeliveryDetService.save(mtAloneDeliveryDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneDeliveryDetId) {
        mtAloneDeliveryDetService.deleteById(mtAloneDeliveryDetId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDeliveryDet mtAloneDeliveryDet) {
        mtAloneDeliveryDetService.update(mtAloneDeliveryDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDeliveryDet mtAloneDeliveryDet = mtAloneDeliveryDetService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDeliveryDet);
    }

    @GetMapping("/list")
    public Result list(MtAloneDeliveryDetCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDeliveryDet> list = mtAloneDeliveryDetService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
