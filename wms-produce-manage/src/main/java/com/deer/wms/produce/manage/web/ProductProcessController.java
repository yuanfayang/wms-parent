package com.deer.wms.produce.manage.web;

import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.produce.manage.constant.ProduceManagePublicMethod;
import com.deer.wms.produce.manage.model.ProcessBom;
import com.deer.wms.produce.manage.model.ProductProcess;
import com.deer.wms.produce.manage.model.ProductProcessParams;
import com.deer.wms.produce.manage.service.ProcessBomService;
import com.deer.wms.produce.manage.service.ProductProcessBomService;
import com.deer.wms.produce.manage.service.ProductProcessService;
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
* Created by hy on 2019/07/19.
*/
@Api(description = "生产计划接口")
@RestController
@RequestMapping("/product/processs")
public class ProductProcessController {

    @Autowired
    private ProductProcessService productProcessService;

    @Autowired
    private ProcessBomService processBomService;

    /**
     * 生成某种产品的生产计划,产品由产品表而来
     * 需要生成对应的生产bom
     * @param productProcess
     * @param currentUser
     * @return
     */
    @OperateLog(description = "添加生产计划", type = "增加")
    @ApiOperation(value = "添加生产计划", notes = "添加生产计划")
    @PostMapping("/add")
    public Result add(@RequestBody ProductProcess productProcess, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        Date date = new Date();
        productProcess.setCode(ProduceManagePublicMethod.creatUniqueCode("SCJH"));
        productProcess.setCreateTime(date);
        productProcess.setOperatorId(currentUser.getUserId());
        productProcess.setUpdateTime(date);
        productProcess.setVersion("1.1");
        productProcess.setStatus(ProduceManageConstant.STATUS_AVAILABLE);
        productProcess.setCompanyId(currentUser.getCompanyId());
        productProcess.setReviewStatus(ProduceManageConstant.REVIEW_STATUS_FORREVIEW);
        productProcess.setProductBomId(ProductProcessBomService.getProductBomIdByProductId());//该方法待完善···
        productProcessService.save(productProcess);

        //判断bom表中是否有同种产品的生产bom，如果没有生产相应产品的生产bom
        ProcessBom processBom = processBomService.findBy("productId", productProcess.getProductId());
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
