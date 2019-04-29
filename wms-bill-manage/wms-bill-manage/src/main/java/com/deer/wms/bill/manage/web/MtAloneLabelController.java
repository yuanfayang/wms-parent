package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneLabel;
import com.deer.wms.bill.manage.model.MtAloneLabelCriteria;
import com.deer.wms.bill.manage.service.MtAloneLabelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneLabel;


/**
* Created by  on 2018/12/25.
*/
@RestController
@RequestMapping("/mt/alone/labels")
public class MtAloneLabelController {

    @Autowired
    private MtAloneLabelService mtAloneLabelService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneLabel mtAloneLabel) {
        mtAloneLabelService.save(mtAloneLabel);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneLabelId) {
        mtAloneLabelService.deleteById(mtAloneLabelId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneLabel mtAloneLabel) {
        mtAloneLabelService.update(mtAloneLabel);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneLabel mtAloneLabel = mtAloneLabelService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneLabel);
    }

    @GetMapping("/list")
    public Result list(MtAloneLabelCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneLabel> list = mtAloneLabelService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
