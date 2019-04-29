package com.deer.wms.bill.manage.web;

import com.deer.wms.base.system.model.CellInfo;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.service.CellItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by guo on 2018/07/19.
*/
@RestController
@RequestMapping("/cell/items")
public class CellItemController {

    @Autowired
    private CellItemService cellItemService;
    @Autowired
    private CellInfoService cellInfoService;

    @PostMapping("/insert")
    public Result add(@RequestBody List<CellItem> cellItems) {
        for(CellItem cellItem:cellItems){
            CellItemCriteria criteria = new CellItemCriteria();
            criteria.setCellCode(cellItem.getCellCode());
            criteria.setItemCode(cellItem.getItemCode());
            List<CellItemDto> list = cellItemService.findList(criteria);
            if(list.size()==0){
                CellInfo cellInfo = cellInfoService.findBy("cellCode",cellItem.getCellCode());
                cellInfo.setState(1);
                cellInfoService.update(cellInfo);
                cellItemService.save(cellItem);
            }else {
                CellItem newCellItem = list.get(0);
                newCellItem.setQuantity(newCellItem.getQuantity()+cellItem.getQuantity());
                cellItemService.update(newCellItem);
            }

        }

        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer id) {
        cellItemService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CellItem cellItem) {
        cellItemService.update(cellItem);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CellItem cellItem = cellItemService.findById(id);
        return ResultGenerator.genSuccessResult(cellItem);
    }

    @GetMapping("/list")
    public Result list(CellItemCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<CellItemDto> list = cellItemService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/noUpShelf/list")
    public Result list2(NoUpShelfCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<NoUpShelf> list = cellItemService.findNoUpShelfList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
