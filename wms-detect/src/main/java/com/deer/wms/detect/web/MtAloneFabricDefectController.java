package com.deer.wms.detect.web;

import com.deer.wms.detect.model.MtAloneFabricDefect;
import com.deer.wms.detect.model.MtAloneFabricDefectCriteria;
import com.deer.wms.detect.service.MtAloneFabricDefectService;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



/**
* Created by guo on 2018/12/15.
*/
@Api(description = "质量检测瑕疵点基础管理接口")
@RestController
@RequestMapping("/mt/alone/fabric/defect")
public class MtAloneFabricDefectController {

    @Autowired
    private MtAloneFabricDefectService mtAloneFabricDefectService;

	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加瑕疵信息", type = "增加")
    @PostMapping("/add")
    @ApiOperation(value="添加瑕疵信息",notes="添加瑕疵信息")
    public Result add(@RequestBody MtAloneFabricDefect mtAloneFabricDefect) {
		mtAloneFabricDefect.setAddtime(new Date());
		mtAloneFabricDefect.setUpdateTime(new Date());
		mtAloneFabricDefect.setDeletestatus(0);
        mtAloneFabricDefectService.save(mtAloneFabricDefect);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "删除瑕疵信息", type = "删除")
    @GetMapping("/delete")
    @ApiOperation(value="删除瑕疵信息",notes="删除瑕疵信息")
    public Result delete( Integer mtAloneFabricDefectId) {
        mtAloneFabricDefectService.deleteById(mtAloneFabricDefectId);
        return ResultGenerator.genSuccessResult();
    } 
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "更新瑕疵信息", type = "更新")
    @PostMapping("/update")
    @ApiOperation(value="更新瑕疵信息",notes="更新瑕疵信息")
    public Result update(@RequestBody MtAloneFabricDefect mtAloneFabricDefect) {
		mtAloneFabricDefect.setUpdateTime(new Date());
        mtAloneFabricDefectService.update(mtAloneFabricDefect);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据瑕疵ID获取单条瑕疵信息", type = "查询")
    @GetMapping("/{id}")
    @ApiOperation(value="获取单条瑕疵信息",notes="获取单条瑕疵信息")
    public Result detail(@PathVariable Integer id) {
        MtAloneFabricDefect mtAloneFabricDefect = mtAloneFabricDefectService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneFabricDefect);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据瑕疵名称模糊查找瑕疵信息", type = "查询")
    @GetMapping("/listByFabricName")
    @ApiOperation(value="根据瑕疵名称模糊查找瑕疵信息",notes="根据瑕疵名称模糊查找瑕疵信息")
    public Result list(MtAloneFabricDefectCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneFabricDefect> list = mtAloneFabricDefectService.findDefectByName(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "获取所有瑕疵信息", type = "查询")
    @GetMapping("/fabricList")
    @ApiOperation(value="获取所有瑕疵信息",notes="获取所有瑕疵信息")
    public Result fabricList(MtAloneFabricDefectCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneFabricDefect> list = mtAloneFabricDefectService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
