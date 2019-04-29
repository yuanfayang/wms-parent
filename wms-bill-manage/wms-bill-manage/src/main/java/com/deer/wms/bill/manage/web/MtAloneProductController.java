package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductCriteria;
import com.deer.wms.bill.manage.service.MtAloneProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneProduct;


/**
* Created by  on 2019/03/01.
*/
@RestController
@RequestMapping("/mt/alone/products")
public class MtAloneProductController {

    @Autowired
    private MtAloneProductService mtAloneProductService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneProduct mtAloneProduct) {
        mtAloneProductService.save(mtAloneProduct);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneProductId) {
        mtAloneProductService.deleteById(mtAloneProductId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneProduct mtAloneProduct) {
        mtAloneProductService.update(mtAloneProduct);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneProduct mtAloneProduct = mtAloneProductService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneProduct);
    }

    @GetMapping("/list")
    public Result list(MtAloneProductCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneProduct> list = mtAloneProductService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
