package com.deer.wms.system.manage.web;

import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.StringUtil;
import com.deer.wms.system.manage.constant.SystemManageConstant;
import com.deer.wms.system.manage.model.resource.Resource;
import com.deer.wms.system.manage.model.resource.ResourceCriteria;
import com.deer.wms.system.manage.model.resource.ResourceParams;
import com.deer.wms.system.manage.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by WUXB on 2017/10/08.
 */
@Api(description = "资源管理api接口")
@RestController
@Authority
@RequestMapping("/resources")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@PostMapping("/save")
	@OperateLog(description = "添加菜单信息", type = "增加")
	public Result add(@RequestBody Resource resource) {
		resourceService.save(resource);
		return ResultGenerator.genSuccessResult();
	}

	@DeleteMapping("/{id}")
	@OperateLog(description = "删除菜单信息", type = "删除")
	public Result delete(@PathVariable Integer id) { 
		resourceService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	@OperateLog(description = "更新菜单信息", type = "更新")
	public Result update(@RequestBody Resource resource) {
		resourceService.update(resource);
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/{id}")
	@OperateLog(description = "获取某个菜单信息", type = "查询")
	public Result detail(@PathVariable Integer id) {
		Resource resource = resourceService.findById(id);
		return ResultGenerator.genSuccessResult(resource);
	}

	@ApiOperation(value = "获取资源信息", notes = "获取资源信息列表")
	@OperateLog(description = "获取菜单列表", type = "查询")
	@GetMapping
	public Result list(ResourceCriteria criteria) {
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<Resource> list = resourceService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@PostMapping("/findResourceByParentId")
	@OperateLog(description = "根据父类id查询菜单列表", type = "查询")
	public Result findResourceByParentId(@RequestBody Resource resource) {
		System.out.println("parentId=" + resource.getParentId());
		List<Resource> list = resourceService.findResourceByParentId(resource.getParentId());
		return ResultGenerator.genSuccessResult(list);
	}

	@PostMapping("/findResourceByParentName")
	@OperateLog(description = "根据父类名称查询菜单列表", type = "查询")
	public Result findResourceByParentKeyword(@RequestBody Resource resource) {
		List<Resource> list = resourceService.findResourceByParentName(resource.getResourceName());
		return ResultGenerator.genSuccessResult(list);
	}

	@ApiOperation(value = "根据菜单名称获取菜单", notes = "根据菜单名称获取菜单")
	@GetMapping("/findReourceByName")
	@OperateLog(description = "根据菜单名称查询菜单列表", type = "查询")
	public Result findReourceByName(ResourceCriteria criteria) {
		System.out.println("getResourceName=" + criteria.getResourceName());
		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<Resource> list = resourceService.findReourceByName(criteria);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);  
	}
	
	
	@ApiOperation(value = "根据菜单關鍵字获取菜单", notes = "根据菜单关键字获取菜单")
	@GetMapping("/listByKeywords")
	@OperateLog(description = "根据菜单名称查询菜单列表", type = "查询")
	public Result listByKeywords(ResourceParams params) {
		System.out.println("getKeywords=" + params.getKeywords());
		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<Resource> list = resourceService.listByKeywords(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);  
	}


    @ApiOperation(value = "根据菜单關鍵字获取菜单", notes = "根据菜单关键字获取菜单")
    @GetMapping("/list/new")
    @OperateLog(description = "根据菜单名称查询菜单列表", type = "查询")
    public Result listNew(ResourceParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);

        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
            params.setCompanyId(currentUser.getCompanyId());
        }else{
            params.setCompanyId(null);
        }

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Resource> list = resourceService.listByKeywords(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
