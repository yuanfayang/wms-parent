package com.deer.wms.bill.manage.model;

import java.util.ArrayList;

/**
 * 供应商货物对应的仓储级联结构
 * 表示供应商产品接口中查询返回的仓储结果
 */
public class SupplierStorageInfo {
    private String label;//名称

    private String value;//code

    private ArrayList<SupplierStorageInfo> children = new ArrayList<SupplierStorageInfo>();//下级SupplierStorageInfo

    private String parentValue;//上级code

    public ArrayList<SupplierStorageInfo> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<SupplierStorageInfo> children) {
        this.children = children;
    }

    public String getParentValue() {
        return parentValue;
    }

    public void setParentValue(String parentValue) {
        this.parentValue = parentValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
