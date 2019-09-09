package com.deer.wms.produce.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MachiningProduct;
import com.deer.wms.produce.manage.model.MachiningProductParams;
import com.deer.wms.produce.manage.service.MachiningProductService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List; 



/**
* Created by  on 2019/09/09.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/machining/products")
public class MachiningProductController {

    @Autowired
    private MachiningProductService machiningProductService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MachiningProduct machiningProduct, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 machiningProduct.setCreateTime(new Date());
		 machiningProduct.setCompanyId(currentUser.getCompanyId());
        machiningProductService.save(machiningProduct);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        machiningProductService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MachiningProduct machiningProduct) {
        machiningProduct.setUpdateTime(new Date());
        machiningProductService.update(machiningProduct);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MachiningProduct machiningProduct = machiningProductService.findById(id);
        return ResultGenerator.genSuccessResult(machiningProduct);
    }

    @GetMapping("/list")
    public Result list(MachiningProductParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MachiningProduct> list = machiningProductService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
