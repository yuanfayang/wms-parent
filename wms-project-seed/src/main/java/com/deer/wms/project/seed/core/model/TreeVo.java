package com.deer.wms.project.seed.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 根據parent_id查詢的樹形類
 * 
 * @author guotuanting
 *
 */
public class TreeVo {
	
	private String id;
	private String title;//name
	private boolean loading = false;
	private List<TreeVo> children = new ArrayList<TreeVo>();
	
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
	public List<TreeVo> getChildren() {
		return children;
	}
	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}
}
