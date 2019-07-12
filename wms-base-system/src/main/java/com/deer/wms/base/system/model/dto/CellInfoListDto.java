package com.deer.wms.base.system.model.dto;

import com.deer.wms.base.system.model.CellInfo;

import java.util.List;

public class CellInfoListDto {

    private List<CellInfo> cellInfos;

    public List<CellInfo> getCellInfos() {
        return cellInfos;
    }

    public void setCellInfos(List<CellInfo> cellInfos) {
        this.cellInfos = cellInfos;
    }
}
