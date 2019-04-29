package com.deer.wms.system.manage.model.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * 根據parent_id查詢的樹形類
 * 
 * @author guotuanting
 *
 */
public class ResourceParentVo {
	
	private String id;
	private String title;//resourceName
	private boolean loading = false;
	private List<ResourceParentVo> children = new ArrayList<ResourceParentVo>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isLoading() {
		return loading;
	}
	public void setLoading(boolean loading) {
		this.loading = loading;
	}
	public List<ResourceParentVo> getChildren() {
		return children;
	}
	public void setChildren(List<ResourceParentVo> children) {
		this.children = children;
	}
}
