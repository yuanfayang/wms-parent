package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneBarcodeCriteria;
import com.deer.wms.bill.manage.service.MtAloneBarcodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneBarcode;


/**
* Created by  on 2019/03/13.
*/
@RestController
@RequestMapping("/mt/alone/barcodes")
public class MtAloneBarcodeController {

    @Autowired
    private MtAloneBarcodeService mtAloneBarcodeService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneBarcode mtAloneBarcode) {
        mtAloneBarcodeService.save(mtAloneBarcode);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneBarcodeId) {
        mtAloneBarcodeService.deleteById(mtAloneBarcodeId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneBarcode mtAloneBarcode) {
        mtAloneBarcodeService.update(mtAloneBarcode);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneBarcode mtAloneBarcode = mtAloneBarcodeService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneBarcode);
    }

    @GetMapping("/list")
    public Result list(MtAloneBarcodeCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneBarcode> list = mtAloneBarcodeService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
