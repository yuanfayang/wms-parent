package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetCriteria;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneProductDet;


/**
* Created by  on 2019/03/02.
*/
@RestController
@RequestMapping("/mt/alone/product/dets")
public class MtAloneProductDetController {

    @Autowired
    private MtAloneProductDetService mtAloneProductDetService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneProductDet mtAloneProductDet) {
        mtAloneProductDetService.save(mtAloneProductDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneProductDetId) {
        mtAloneProductDetService.deleteById(mtAloneProductDetId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneProductDet mtAloneProductDet) {
        mtAloneProductDetService.update(mtAloneProductDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneProductDet mtAloneProductDet = mtAloneProductDetService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneProductDet);
    }

    @GetMapping("/list")
    public Result list(MtAloneProductDetCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneProductDet> list = mtAloneProductDetService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
