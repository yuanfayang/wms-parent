package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneDetectDet;
import com.deer.wms.bill.manage.model.MtAloneDetectDetCriteria;
import com.deer.wms.bill.manage.service.MtAloneDetectDetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDetectDet;


/**
* Created by  on 2019/03/14.
*/
@RestController
@RequestMapping("/mt/alone/detect/dets")
public class MtAloneDetectDetController {

    @Autowired
    private MtAloneDetectDetService mtAloneDetectDetService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneDetectDet mtAloneDetectDet) {
        mtAloneDetectDetService.save(mtAloneDetectDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneDetectDetId) {
        mtAloneDetectDetService.deleteById(mtAloneDetectDetId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneDetectDet mtAloneDetectDet) {
        mtAloneDetectDetService.update(mtAloneDetectDet);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneDetectDet mtAloneDetectDet = mtAloneDetectDetService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneDetectDet);
    }

    @GetMapping("/list")
    public Result list(MtAloneDetectDetCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneDetectDet> list = mtAloneDetectDetService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
