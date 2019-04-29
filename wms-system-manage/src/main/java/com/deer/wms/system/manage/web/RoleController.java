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
import com.deer.wms.system.manage.model.permission.PermissionTreeModel;
import com.deer.wms.system.manage.model.role.*;
import com.deer.wms.system.manage.service.PermissionService;
import com.deer.wms.system.manage.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by WUXB on 2017/10/07.
 */
@Api(description = "角色信息api接口")
@Authority
@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 添加角色信息
	 *
	 * @param create
	 * @param currentUser
	 * @return
	 */
	@PostMapping
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "添加角色信息", type = "增加")
	public Result save(@RequestBody RoleCreate create, @ApiIgnore @User CurrentUser currentUser) {
//		create.setRoleLevel(2);//默认角色级别为2
//		create.setCompanyId(currentUser.getCompanyId());
		roleService.addRole(create, currentUser);
		return ResultGenerator.genSuccessResult();
	}

	/**
	 * 修改角色信息
	 *
	 * @param modify
	 *            角色信息
	 * @param currentUser
	 *            当前操作用户信息
	 * @return
	 */
	@ApiOperation(value = "修改角色信息", notes = "修改角色基本信息和权限信息")
	@PutMapping("/{roleId}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@OperateLog(description = "修改角色基本信息和权限信息", type = "更新")
	public Result modify(@PathVariable Integer roleId, @RequestBody RoleModify modify,
			@ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}

		RoleDetailVO vo = roleService.findRoleByRoleId(roleId);
		// if(currentUser.getRoleName().trim().equals(vo.getRoleName().trim())){
		// return ResultGenerator.genFailResult(
		// CommonCode.SERVICE_ERROR,"无法修改自身角色权限",null );
		// }
		if (currentUser.getRoleLevel()>vo.getRoleLevel()) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "无法修改更高級別角色", null);
		}
		modify.setRoleId(roleId);
		roleService.modifyRole(modify, currentUser);
		return ResultGenerator.genSuccessResult();
	}

	/**
	 * 获取角色详细信息
	 *
	 * @param roleId
	 *            角色信息id
	 * @return
	 */
	@ApiOperation(value = "获取角色详细信息", notes = "获取角色详细信息，包括角色基本信息和具有的权限信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true),
			@ApiImplicitParam(name = "roleId", value = "角色信息id", paramType = "path", dataType = "int", defaultValue = "1", required = true) })
	@GetMapping("/{roleId}")
	@OperateLog(description = "获取角色详细信息，包括角色基本信息和具有的权限信息", type = "查询")
	public Result detail(@PathVariable Integer roleId) {
		RoleDetailVO vo = roleService.findRoleByRoleId(roleId);
		return ResultGenerator.genSuccessResult(vo);
	}

	/**
	 * 获取角色详细信息(新)
	 *
	 * @param roleId
	 *            角色信息id
	 * @return
	 */
	@ApiOperation(value = "获取角色详细信息", notes = "获取角色详细信息，包括角色基本信息和具有的权限信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true),
			@ApiImplicitParam(name = "roleId", value = "角色信息id", paramType = "path", dataType = "int", defaultValue = "1", required = true) })
	@GetMapping("/{roleId}/detail/new")
	@OperateLog(description = "获取角色详细信息，包括角色基本信息和具有的权限信息", type = "查询")
	public Result detailNew(@PathVariable Integer roleId, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		RoleParams params = new RoleParams();
		params.setRoleId(roleId);
		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}
		RoleDetailVO vo = roleService.findRoleDetailNew(params);
		return ResultGenerator.genSuccessResult(vo);
	}

	/**
	 * 获取指定角色的权限信息
	 *
	 * @return 角色权限信息
	 */
	@GetMapping("/{roleId}/permission")
	@OperateLog(description = "获取指定角色的权限信息", type = "查询")
	public Result getRolePermission(@PathVariable Integer roleId) {
		List<PermissionTreeModel> treeModels = permissionService.findPermissionRangeTreeFormListByRoleId(roleId);
		return ResultGenerator.genSuccessResult(treeModels);
	}

	/**
	 * 获取角色信息
	 *
	 * @param criteria
	 *            查询条件
	 * @return
	 */
	@ApiOperation(value = "获取角色信息", notes = "获取角色信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/list")
	@OperateLog(description = "查询角色列表", type = "查询")
	public Result list(RoleCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
		System.out.println("====================获取角色信息===================================");
		// 判断当前人员是否运营商，如果不是则查询当前人员所属的角色信息
		boolean isOperate = currentUser.getCompanyType() == SystemManageConstant.COMPANY_TYPE_OPERATE;
		criteria.setUserId(isOperate ? null : currentUser.getUserId());

		List<RoleListVO> list = roleService.findRoleFormList(criteria);
		return ResultGenerator.genSuccessResult(list);
	}

	/**
	 * 分页获取角色信息
	 *
	 * @param criteria
	 *            查询条件
	 * @return
	 */
	@ApiOperation(value = "分页获取角色信息", notes = "分页获取角色信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页码", paramType = "path", dataType = "int", defaultValue = "1"),
			@ApiImplicitParam(name = "pageSize", value = "每页显示的条数", paramType = "path", dataType = "int", defaultValue = "20") })
	@GetMapping
	@OperateLog(description = "分页获取角色信息", type = "查询")
	public Result pagingList(RoleCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
		System.out.println("====================分页获取角色信息111===================================");
		System.out.println(criteria);
		StringUtil.trimObjectStringProperties(criteria);

		// 判断当前人员是否运营商，如果不是则查询当前人员所属的角色信息
		// boolean isOperate = currentUser.getCompanyType() ==
		// SystemManageConstant.COMPANY_TYPE_OPERATE;
		// criteria.setUserId(isOperate ? null : currentUser.getUserId());

		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<RoleListVO> list = roleService.findRoleFormList(criteria);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiOperation(value = "分页获取角色信息new", notes = "分页获取角色信息new")
	@GetMapping("/list/new")
	@OperateLog(description = "分页获取角色信息", type = "查询")
	public Result listNew(RoleParams params, @ApiIgnore @User CurrentUser currentUser) {
		System.out.println("====================分页获取角色信息new==================================");
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
		}
		StringUtil.trimObjectStringProperties(params);

		if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
			params.setCompanyId(currentUser.getCompanyId());
		} else {
			params.setCompanyId(null);
		}

		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<RoleListVO> list = roleService.findRoleListNew(params);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
}
