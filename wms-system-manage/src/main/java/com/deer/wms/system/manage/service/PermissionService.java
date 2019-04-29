package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.MtAloneRoute;
import com.deer.wms.system.manage.model.permission.Menu;
import com.deer.wms.system.manage.model.permission.Permission;
import com.deer.wms.project.seed.core.service.Service;
import com.deer.wms.system.manage.model.permission.PermissionTreeModel;
import com.deer.wms.system.manage.model.role.RoleParams;

import java.util.List;

/**
 * Created by WUXB on 2017/10/07.
 */
public interface PermissionService extends Service<Permission, Integer> {
    /**
     * 清空指定角色的所有权限
     *
     * @param roleId 角色id
     */
    void emptyPermissionByRoleId(Integer roleId);

    void deleteByRoleId(Integer roleId);

    /**
     * 查找指定用户权限范围内的资源代码数组
     *
     * @param userId
     * @return
     */
    List<String> findPermissionCodeByUserId(Integer userId);

    /**
     * 查找指定用户权限范围内的所有资源地址
     *
     * @param userId
     * @return
     */
    List<String> findPermissionUrlByUserId(Integer userId);

    /**
     * 查询指定用户权限范围内的菜单信息列表
     *
     * @param userId 用户id
     * @return 菜单信息列表
     */
    List<Menu> findPermissionMenuByUserId(Integer userId);

    /**
     * 查询指定角色的权限树形列表
     *
     * @param roleId 角色id
     * @return 角色的权限树形列表
     */
    List<PermissionTreeModel> findPermissionTreeFormListByRoleId(Integer roleId);

    /**
     * 查询指定角色权限范围内的权限树形结构列表
     *
     * @param roleId 角色id
     * @return 角色的权限树形列表
     */
    List<PermissionTreeModel> findPermissionRangeTreeFormListByRoleId(Integer roleId);

    /**
     * 根据用户获取路由权限
     * @param userId
     * @return
     */
	List<MtAloneRoute> findPermissionRoutesByUserId(Integer userId);

    List<PermissionTreeModel> findPermissionTreeFormListRoleDetailNew(RoleParams params);
}
