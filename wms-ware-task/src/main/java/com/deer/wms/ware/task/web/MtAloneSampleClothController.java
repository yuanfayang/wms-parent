package com.deer.wms.ware.task.web;

import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.ware.task.model.MtAloneSampleCloth;
import com.deer.wms.ware.task.model.MtAloneSampleClothCriteria;
import com.deer.wms.ware.task.model.MtAloneSampleClothDto;
import com.deer.wms.ware.task.service.MtAloneSampleClothService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
* Created by  on 2019/03/21.
*/
@RestController
@RequestMapping("/mt/alone/sample/cloths")
public class MtAloneSampleClothController {

    @Autowired
    private MtAloneSampleClothService mtAloneSampleClothService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneSampleCloth mtAloneSampleCloth) {
        mtAloneSampleClothService.save(mtAloneSampleCloth);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneSampleClothId) {
        mtAloneSampleClothService.deleteById(mtAloneSampleClothId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneSampleCloth mtAloneSampleCloth) {
        mtAloneSampleClothService.update(mtAloneSampleCloth);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneSampleCloth mtAloneSampleCloth = mtAloneSampleClothService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneSampleCloth);
    }

    @GetMapping("/list")
    public Result list(MtAloneSampleClothCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneSampleClothDto> list = mtAloneSampleClothService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
