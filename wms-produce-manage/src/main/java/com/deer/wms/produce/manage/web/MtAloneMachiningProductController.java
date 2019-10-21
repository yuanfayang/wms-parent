package com.deer.wms.produce.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MtAloneMachiningProduct;
import com.deer.wms.produce.manage.model.MtAloneMachiningProductParams;
import com.deer.wms.produce.manage.service.MtAloneMachiningProductService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List; 



/**
* Created by  on 2019/09/19.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/machining/products")
public class MtAloneMachiningProductController {

    @Autowired
    private MtAloneMachiningProductService mtAloneMachiningProductService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneMachiningProduct mtAloneMachiningProduct, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneMachiningProduct.setCreateTime(new Date());
		 mtAloneMachiningProduct.setCompanyId(currentUser.getCompanyId());
        mtAloneMachiningProductService.save(mtAloneMachiningProduct);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * author:caixiang
     **/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)
    })
    @ApiOperation(value = "查询各种类下材料", notes = "查询各种类下材料")
    @PostMapping("/selectMaterialByType")
    public Result selectMaterialByType(@RequestBody MtAloneMachiningProduct mtAloneMachiningProduct, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        List<MtAloneMachiningProduct> mtAloneMachiningProduct1 = mtAloneMachiningProductService.findListByClothAttr(mtAloneMachiningProduct);
        return ResultGenerator.genSuccessResult().setData(mtAloneMachiningProduct1);
    }

    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer Id) {
        mtAloneMachiningProductService.deleteById(Id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneMachiningProduct mtAloneMachiningProduct) {
        mtAloneMachiningProduct.setUpdateTime(new Date());
        mtAloneMachiningProductService.update(mtAloneMachiningProduct);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneMachiningProduct mtAloneMachiningProduct = mtAloneMachiningProductService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneMachiningProduct);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true)
    })
    @GetMapping("/list")
    public Result list(MtAloneMachiningProductParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneMachiningProduct> list = mtAloneMachiningProductService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
