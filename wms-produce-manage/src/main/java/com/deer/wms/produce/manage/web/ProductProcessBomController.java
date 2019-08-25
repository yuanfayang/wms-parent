package com.deer.wms.produce.manage.web;

import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.model.ProductProcessBom;
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
@Api(description = "xxx接口")
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

    @GetMapping("/list")
    public Result list(ProductProcessBomParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<ProductProcessBom> list = productProcessBomService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
