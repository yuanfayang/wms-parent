package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.bill.manage.service.MtAloneTagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTag;


/**
* Created by  on 2018/12/30.
*/
@RestController
@RequestMapping("/mt/alone/tags")
public class MtAloneTagController {

    @Autowired
    private MtAloneTagService mtAloneTagService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneTag mtAloneTag) {
        mtAloneTagService.save(mtAloneTag);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneTagId) {
        mtAloneTagService.deleteById(mtAloneTagId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneTag mtAloneTag) {
        mtAloneTagService.update(mtAloneTag);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneTag mtAloneTag = mtAloneTagService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneTag);
    }

    @GetMapping("/list")
    public Result list(MtAloneTagCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneTag> list = mtAloneTagService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
