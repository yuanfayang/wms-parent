package com.deer.wms.detect.model;

/**
* Created by guo on 2018/12/15.
*/
public class MtAloneFabricDefectCriteria  {
	private String defectName;
    /**
     * 页码
     */
    private Integer pageNum =1;

    /**
     * 每页显示的条数
     */
    private Integer pageSize =199999;

    private Integer fabricTypeId=1;

    public Integer getFabricTypeId() {
        return fabricTypeId;
    }

    public void setFabricTypeId(Integer fabricTypeId) {
        this.fabricTypeId = fabricTypeId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	/**
	 * @return the defectName
	 */
	public String getDefectName() {
		return defectName;
	}

	/**
	 * @param defectName the defectName to set
	 */
	public void setDefectName(String defectName) {
		this.defectName = defectName;
	}
}
