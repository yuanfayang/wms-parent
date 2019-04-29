package com.deer.wms.system.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_route")
public class MtAloneRoute {
    /**
     * 主键id
     */
    @Id
    @Column(name = "route_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    /**
     * 父类id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 关联菜单id
     */
    @Column(name = "resource_id")
    private Integer resourceId;

    /**
     * 编号
     */
    @Column(name = "route_code")
    private String routeCode;

    /**
     * 跳转路径
     */
    @Column(name = "route_path")
    private String routePath;

    /**
     * 组件名称
     */
    @Column(name = "component_name")
    private String componentName;

    /**
     * 组件路径
     */
    @Column(name = "component_path")
    private String componentPath;
    
    
    /**
     * 组件中文名
     */
    @Column(name = "label")
    private String label;

    /**
     * 重定向路径
     */
    @Column(name = "route_redirect")
    private String routeRedirect;

    /**
     * 分组号
     */
    @Column(name = "group_type")
    private String groupType;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 创建人
     */
    @Column(name = "create_man_id")
    private Integer createManId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态:normal/delete
     */
    private String state;

    /**
     * 获取主键id
     *
     * @return route_id - 主键id
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * 设置主键id
     *
     * @param routeId 主键id
     */
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    /**
     * 获取父类id
     *
     * @return parent_id - 父类id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父类id
     *
     * @param parentId 父类id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取关联菜单id
     *
     * @return resource_id - 关联菜单id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 设置关联菜单id
     *
     * @param resourceId 关联菜单id
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取编号
     *
     * @return route_code - 编号
     */
    public String getRouteCode() {
        return routeCode;
    }

    /**
     * 设置编号
     *
     * @param routeCode 编号
     */
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    /**
     * 获取跳转路径
     *
     * @return route_path - 跳转路径
     */
    public String getRoutePath() {
        return routePath;
    }

    /**
     * 设置跳转路径
     *
     * @param routePath 跳转路径
     */
    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    /**
     * 获取组件名称
     *
     * @return component_name - 组件名称
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * 设置组件名称
     *
     * @param componentName 组件名称
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * 获取组件路径
     *
     * @return component_path - 组件路径
     */
    public String getComponentPath() {
        return componentPath;
    }

    /**
     * 设置组件路径
     *
     * @param componentPath 组件路径
     */
    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }

    public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/**
     * 获取重定向路径
     *
     * @return route_redirect - 重定向路径
     */
    public String getRouteRedirect() {
        return routeRedirect;
    }

    /**
     * 设置重定向路径
     *
     * @param routeRedirect 重定向路径
     */
    public void setRouteRedirect(String routeRedirect) {
        this.routeRedirect = routeRedirect;
    }

    /**
     * 获取分组号
     *
     * @return group_type - 分组号
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * 设置分组号
     *
     * @param groupType 分组号
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    /**
     * 获取排序号
     *
     * @return sort - 排序号
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序号
     *
     * @param sort 排序号
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建人
     *
     * @return create_man_id - 创建人
     */
    public Integer getCreateManId() {
        return createManId;
    }

    /**
     * 设置创建人
     *
     * @param createManId 创建人
     */
    public void setCreateManId(Integer createManId) {
        this.createManId = createManId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态:normal/delete
     *
     * @return state - 状态:normal/delete
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态:normal/delete
     *
     * @param state 状态:normal/delete
     */
    public void setState(String state) {
        this.state = state;
    }
}