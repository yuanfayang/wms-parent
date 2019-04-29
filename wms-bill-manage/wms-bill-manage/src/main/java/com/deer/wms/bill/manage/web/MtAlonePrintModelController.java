package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAlonePrintModel;
import com.deer.wms.bill.manage.model.MtAlonePrintModelCriteria;
import com.deer.wms.bill.manage.service.MtAlonePrintModelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAlonePrintModel;


/**
* Created by  on 2019/02/21.
*/
@RestController
@RequestMapping("/mt/alone/print/models")
public class MtAlonePrintModelController {

    @Autowired
    private MtAlonePrintModelService mtAlonePrintModelService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAlonePrintModel mtAlonePrintModel) {
        mtAlonePrintModelService.save(mtAlonePrintModel);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAlonePrintModelId) {
        mtAlonePrintModelService.deleteById(mtAlonePrintModelId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAlonePrintModel mtAlonePrintModel) {
        mtAlonePrintModelService.update(mtAlonePrintModel);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAlonePrintModel mtAlonePrintModel = mtAlonePrintModelService.findById(id);
        return ResultGenerator.genSuccessResult(mtAlonePrintModel);
    }

    @GetMapping("/list")
    public Result list(MtAlonePrintModelCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAlonePrintModel> list = mtAlonePrintModelService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
