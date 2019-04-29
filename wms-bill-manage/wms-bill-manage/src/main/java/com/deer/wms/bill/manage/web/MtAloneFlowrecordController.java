package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.service.MtAloneFlowrecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;


/**
* Created by  on 2018/12/11.
*/
@RestController
@RequestMapping("/mt/alone/flowrecords")
public class MtAloneFlowrecordController {

    @Autowired
    private MtAloneFlowrecordService mtAloneFlowrecordService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneFlowrecord mtAloneFlowrecord) {
        mtAloneFlowrecordService.save(mtAloneFlowrecord);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneFlowrecordId) {
        mtAloneFlowrecordService.deleteById(mtAloneFlowrecordId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneFlowrecord mtAloneFlowrecord) {
        mtAloneFlowrecordService.update(mtAloneFlowrecord);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneFlowrecord mtAloneFlowrecord = mtAloneFlowrecordService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneFlowrecord);
    }

    @GetMapping("/list")
    public Result list(MtAloneFlowrecordCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneFlowrecord> list = mtAloneFlowrecordService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
