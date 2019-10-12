package com.deer.wms.produce.manage.model;

import java.util.List;

/**
 * @Author: weihongyang
 * @Date: 2019/10/9 9:57
 * @Version 1.0
 */
public class ProcessBomVo extends ProcessBom{

    private List<ProcessMaterialsBom> list;

    public List<ProcessMaterialsBom> getList() {
        return list;
    }

    public void setList(List<ProcessMaterialsBom> list) {
        this.list = list;
    }
}
