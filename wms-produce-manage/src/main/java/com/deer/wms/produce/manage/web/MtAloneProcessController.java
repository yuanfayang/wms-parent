package com.deer.wms.produce.manage.web;

import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.model.MtAloneProcess;
import com.deer.wms.produce.manage.model.MtAloneProcessParams;
import com.deer.wms.produce.manage.service.MtAloneProcessService;
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
@Api(description = "xxx接口")
@RestController
@RequestMapping("/mt/alone/processs")
public class MtAloneProcessController {

    @Autowired
    private MtAloneProcessService mtAloneProcessService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneProcess mtAloneProcess, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 mtAloneProcess.setCreateTime(new Date());
		 mtAloneProcess.setCompanyId(currentUser.getCompanyId());
        mtAloneProcessService.save(mtAloneProcess);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneProcessService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneProcess mtAloneProcess) {
        mtAloneProcess.setUpdateTime(new Date());
        mtAloneProcessService.update(mtAloneProcess);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneProcess mtAloneProcess = mtAloneProcessService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneProcess);
    }

    //@GetMapping("/list")
    //public Result list(MtAloneProcessParams params, @ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser==null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
    //    }
    //
    //	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    //		params.setCompanyId(currentUser.getCompanyId());
		//}else{
		//	params.setCompanyId(null);
    //    }
    //    PageHelper.startPage(params.getPageNum(), params.getPageSize());
    //    List<MtAloneProcess> list = mtAloneProcessService.findList(params);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

}
