package com.deer.wms.produce.manage.web;

import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessBomDto;
import com.deer.wms.produce.manage.model.ProductProcessBomParams;
import com.deer.wms.produce.manage.service.ProductProcessBomService;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;


/**
* Created by guo on 2019/07/18.
*/
@Api(description = "产品bom接口")
@RestController
@RequestMapping("/product/process/boms")
public class ProductProcessBomController {

    @Autowired
    private ProductProcessBomService productProcessBomService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody ProductProcessBom mtAloneProductProcessBom, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneProductProcessBom.setCreateTime(new Date());
        mtAloneProductProcessBom.setCompanyId(currentUser.getCompanyId());
        productProcessBomService.save(mtAloneProductProcessBom);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        productProcessBomService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody ProductProcessBom mtAloneProductProcessBom) {
        mtAloneProductProcessBom.setUpdateTime(new Date());
        productProcessBomService.update(mtAloneProductProcessBom);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        ProductProcessBom productProcessBom = productProcessBomService.findById(id);
        return ResultGenerator.genSuccessResult(productProcessBom);
    }

    //仅获取所有产品Bom名称、产品名称、公司名称，用于新建加工单页面产品下拉框，该下拉框中的产品是已有bom的产品
    @GetMapping("/proBomAndProList")
    public Result proBomAndProList(ProductProcessBomParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<ProductProcessBomDto> list = productProcessBomService.findProBomAndProList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


}
