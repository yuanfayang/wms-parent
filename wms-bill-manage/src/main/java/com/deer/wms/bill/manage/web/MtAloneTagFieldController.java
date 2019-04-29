package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneTagField;
import com.deer.wms.bill.manage.model.MtAloneTagFieldCriteria;
import com.deer.wms.bill.manage.service.MtAloneTagFieldService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTagField;


/**
* Created by  on 2018/12/30.
*/
@RestController
@RequestMapping("/mt/alone/tag/fields")
public class MtAloneTagFieldController {

    @Autowired
    private MtAloneTagFieldService mtAloneTagFieldService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneTagField mtAloneTagField) {
        mtAloneTagFieldService.save(mtAloneTagField);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneTagFieldId) {
        mtAloneTagFieldService.deleteById(mtAloneTagFieldId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneTagField mtAloneTagField) {
        mtAloneTagFieldService.update(mtAloneTagField);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneTagField mtAloneTagField = mtAloneTagFieldService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneTagField);
    }

    @GetMapping("/list")
    public Result list(MtAloneTagFieldCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneTagField> list = mtAloneTagFieldService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
