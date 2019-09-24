package com.deer.wms.detect.model;

import java.util.List;

public class MtAloneFabricTypeVO {

    private Integer fabricTypeId;
    private String fabricTypeName;
    private List<MtAloneFabricDefectVO> fabricDefectVOList;

    public Integer getFabricTypeId() {
        return fabricTypeId;
    }

    public void setFabricTypeId(Integer fabricTypeId) {
        this.fabricTypeId = fabricTypeId;
    }

    public String getFabricTypeName() {
        return fabricTypeName;
    }

    public void setFabricTypeName(String fabricTypeName) {
        this.fabricTypeName = fabricTypeName;
    }

    public List<MtAloneFabricDefectVO> getFabricDefectVOList() {
        return fabricDefectVOList;
    }

    public void setFabricDefectVOList(List<MtAloneFabricDefectVO> fabricDefectVOList) {
        this.fabricDefectVOList = fabricDefectVOList;
    }
}
