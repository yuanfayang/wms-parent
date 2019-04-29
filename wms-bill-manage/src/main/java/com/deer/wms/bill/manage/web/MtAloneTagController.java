package com.deer.wms.bill.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.bill.manage.model.MtAloneTag;
import com.deer.wms.bill.manage.model.MtAloneTagAndField;
import com.deer.wms.bill.manage.model.MtAloneTagCriteria;
import com.deer.wms.bill.manage.model.MtAloneTagField;
import com.deer.wms.bill.manage.service.MtAloneTagFieldService;
import com.deer.wms.bill.manage.service.MtAloneTagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneTag;


/**
* Created by  on 2018/12/30.
*/
@Api(description = "自定义标签接口")
@RestController
@RequestMapping("/mt/alone/tags")
public class MtAloneTagController {

    @Autowired
    private MtAloneTagService mtAloneTagService;
    @Autowired
    private MtAloneTagFieldService mtAloneTagFieldService;
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "保存标签模板", type = "增加")
    @ApiOperation(value = "保存标签模板", notes = "保存标签模板")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneTagAndField mtAloneTagAndField) {
    	MtAloneTag mtAloneTag=mtAloneTagAndField.getMtAloneTag();
    	Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	String bach1 = sdf1.format(date);
    	String tagCode=bach1+RandomUtil.generateString(5);
    	mtAloneTag.setTagCode(tagCode);
    	mtAloneTag.setIsDefault(0);
        mtAloneTagService.save(mtAloneTag);
        
        List<MtAloneTagField> tagFieldList=mtAloneTagAndField.getTagFieldList();
        for(int i=0;i<tagFieldList.size();i++) {
        	tagFieldList.get(i).setTagCode(tagCode);
        }
        mtAloneTagFieldService.save(tagFieldList);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据模板编号删除标签模板", type = "删除")
    @ApiOperation(value = "根据模板编号删除标签模板", notes = "根据模板编号删除标签模板")
    @GetMapping("/delete")
    public Result delete( MtAloneTagCriteria criteria) {
        mtAloneTagService.deleteByTagCode(criteria);
        mtAloneTagFieldService.deleteByTagCode(criteria);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改标签模板", type = "更新")
    @ApiOperation(value = "修改标签模板", notes = "修改标签模板")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneTagAndField mtAloneTagAndField) {
    	MtAloneTag mtAloneTag=mtAloneTagAndField.getMtAloneTag();
        List<MtAloneTagField> tagFieldList=mtAloneTagAndField.getTagFieldList();
        mtAloneTagService.update(mtAloneTag);
        for(int i=0;i<tagFieldList.size();i++) {
        	mtAloneTagFieldService.update(tagFieldList.get(i));
        }
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "设置新的默认标签模板", type = "更新")
    @ApiOperation(value = "设置新的默认模板", notes = "设置新的默认模板")
    @PostMapping("/setDefaultTag")
    public Result setDefaultTag(@RequestBody MtAloneTag mtAloneTag) {
    	MtAloneTagCriteria criteria=new MtAloneTagCriteria();
    	criteria.setTagType(mtAloneTag.getTagType());
    	MtAloneTag mtAloneTagOld = mtAloneTagService.findDefaultTag(criteria);
    	if(mtAloneTagOld!=null) {
        	mtAloneTagOld.setIsDefault(0);
        	mtAloneTagService.update(mtAloneTagOld);
    	}
    	mtAloneTagService.update(mtAloneTag);
        return ResultGenerator.genSuccessResult();
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "获得某一标签类型下的所有模板", type = "查询")
    @ApiOperation(value = "获得某一标签类型下的所有模板", notes = "获得某一标签类型的所有模板")
    @GetMapping("/tagList")
    public Result tagList(MtAloneTagCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneTag> list = null ;
        if(criteria.getTagType()!=null) {
           list = mtAloneTagService.findList(criteria);
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据标签类型查询该标签下的可选字段", type = "查询")
    @ApiOperation(value = "根据标签类型查询该标签下的可选字段", notes = "根据标签类型查询该标签下的可选字段")
    @GetMapping("/columnListByLabelType")
    public Result columnListByLabelType(MtAloneTagCriteria criteria) {
    	criteria.setTagCode(String.valueOf(criteria.getTagType()));
        List<MtAloneTagField> list = mtAloneTagFieldService.findColumnListByLabelType(criteria);
        return ResultGenerator.genSuccessResult(list);
    }
	@ApiImplicitParams({
		@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "根据模板编号(类型)获取该模板的所有字段", type = "查询")
    @ApiOperation(value = "根据模板编号(类型)获取该模板的所有字段", notes = "根据模板编号（类型）获取该模板的所有字段")
    @GetMapping("/columnListByTagCode")
    public Result columnList(MtAloneTagCriteria criteria) {
        List<MtAloneTagField> list =null;
    	if(criteria.getTagCode()!=null) {
            list = mtAloneTagFieldService.findColumnListByLabelType(criteria);
    	}

        if(criteria.getTagType()!=null&&criteria.getTagType()!=0) {
            MtAloneTag mtAloneTag=mtAloneTagService.findDefaultTag(criteria);
            criteria.setTagCode(mtAloneTag.getTagCode());
            list = mtAloneTagFieldService.findColumnListByLabelType(criteria);
        }
        return ResultGenerator.genSuccessResult(list);
    }

}
