package com.deer.wms.detect.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.bill.manage.constant.BillManageConstant;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.detect.model.MtAloneWindingMachine;
import com.deer.wms.detect.service.MtAloneWindingMachineService;
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

import java.util.Date;
import java.util.List;
import com.deer.wms.detect.model.MtAloneWindingMachineParams;


/**
* Created by guo on 2019/03/21.
*/
@Api(description = "打卷机接口")
@RestController
@RequestMapping("/mt/alone/winding/machines")
public class MtAloneWindingMachineController {

    @Autowired
    private MtAloneWindingMachineService mtAloneWindingMachineService;
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加打卷机", type = "增加")
    @ApiOperation(value = "添加打卷机", notes = "添加打卷机")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneWindingMachine mtAloneWindingMachine, @ApiIgnore @User CurrentUser currentUser) {
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	mtAloneWindingMachine.setCompanyId(currentUser.getCompanyId());
    	String windingMachingCode=BillManagePublicMethod.creatOrderCode(BillManageConstant.WINDING_MACHINE_TYPE); 
    	mtAloneWindingMachine.setCreateManId(currentUser.getUserId());
    	mtAloneWindingMachine.setCreateTime(new Date());
    	mtAloneWindingMachine.setMachineCode(windingMachingCode);
    	mtAloneWindingMachine.setState(0);
        mtAloneWindingMachineService.save(mtAloneWindingMachine);
        return ResultGenerator.genSuccessResult();
    }

	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除打卷机", type = "删除")
    @ApiOperation(value = "删除打卷机", notes = "删除打卷机")
	@DeleteMapping("/delete/{mtAloneWindingMachineId}")
    public Result delete(@PathVariable Integer mtAloneWindingMachineId) {
        mtAloneWindingMachineService.deleteById(mtAloneWindingMachineId);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改打卷机", type = "更新")
    @ApiOperation(value = "修改打卷机", notes = "修改打卷机")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneWindingMachine mtAloneWindingMachine) {
		mtAloneWindingMachine.setUpdateTime(new Date());
        mtAloneWindingMachineService.update(mtAloneWindingMachine);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneWindingMachine mtAloneWindingMachine = mtAloneWindingMachineService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneWindingMachine);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "打卷机列表分页息", type = "查询")
    @ApiOperation(value = "打卷机列表分页", notes = "打卷机列表分页")
    @GetMapping("/list")
    public Result list(MtAloneWindingMachineParams params, @ApiIgnore @User CurrentUser currentUser) {
    	if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        } 
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneWindingMachine> list = mtAloneWindingMachineService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
