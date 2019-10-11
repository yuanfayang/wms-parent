package com.deer.wms.produce.manage.web;

import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.produce.manage.constant.ProduceManagePublicMethod;
import com.deer.wms.produce.manage.model.ProcessBom;
import com.deer.wms.produce.manage.model.ProductProcess;
import com.deer.wms.produce.manage.model.ProductProcessDto;
import com.deer.wms.produce.manage.model.ProductProcessParams;
import com.deer.wms.produce.manage.service.ProcessBomService;
import com.deer.wms.produce.manage.service.ProductProcessService;
import com.deer.wms.project.seed.annotation.OperateLog;
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
* Created by hy on 2019/07/19.
*/
@Api(description = "生产加工接口")
@RestController
@RequestMapping("/product/processs")
public class ProductProcessController {

    @Autowired
    private ProductProcessService productProcessService;

    @Autowired
    private ProcessBomService processBomService;

    /**
     * 生成某种产品某一批次的生产加工单
     * 需要调用对应产品的生产bom
     * @param productProcessDto
     * @param currentUser
     * @return
     */
    @OperateLog(description = "添加生产加工单", type = "增加")
    @ApiOperation(value = "添加生产加工单", notes = "添加生产加工单")
    @PostMapping("/add")
    public Result add(@RequestBody ProductProcessDto productProcessDto, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        productProcessService.save(productProcessDto, currentUser);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        productProcessService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody ProductProcess productProcess) {
        productProcessService.update(productProcess);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        ProductProcess productProcess = productProcessService.findById(id);
        return ResultGenerator.genSuccessResult(productProcess);
    }

    @OperateLog(description = "生产计划分页查询", type = "查询")
    @ApiOperation(value = "生产计划列表分页", notes = "生产计划列表分页")
    @GetMapping("/list")
    public Result list(ProductProcessParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        params.setCompanyId(currentUser.getCompanyId());
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<ProductProcess> list = productProcessService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
