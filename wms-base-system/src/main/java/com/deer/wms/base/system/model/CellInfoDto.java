package com.deer.wms.base.system.model;

/**
 * Created by Administrator on 2018/6/20.
 */
public class CellInfoDto extends CellInfo {
    private  String  shelfName;
    private  String   areaName;
    private  String   wareName;
    private  String   companyName;
    private  Integer   companyId;
    
    private  Integer  rollNum;
    
	public Integer getRollNum() {
		return rollNum;
	}
	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
