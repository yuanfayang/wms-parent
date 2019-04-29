package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class CellInfoParamsRowColumn extends CellInfoParams{
    private  Integer  rowNum;
    private  Integer  rowSize;
    private  Integer   columnNum;
    private  Integer   columnSize;

    private  Integer  maxRow;
    private  Integer  maxColumn;


    private  Integer beginRow;
    private  Integer endRow;
    private  Integer beginColumn;
    private  Integer endColumn;

    public Integer getBeginRow() {
        return beginRow;
    }
    public void setBeginRow(Integer beginRow) {
        this.beginRow = beginRow;
    }
    public Integer getEndRow() {
        return endRow;
    }
    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }
    public Integer getBeginColumn() {
        return beginColumn;
    }
    public void setBeginColumn(Integer beginColumn) {
        this.beginColumn = beginColumn;
    }
    public Integer getEndColumn() {
        return endColumn;
    }
    public void setEndColumn(Integer endColumn) {
        this.endColumn = endColumn;
    }

    public Integer getMaxRow() {
        return maxRow;
    }
    public void setMaxRow(Integer maxRow) {
        this.maxRow = maxRow;
    }
    public Integer getMaxColumn() {
        return maxColumn;
    }
    public void setMaxColumn(Integer maxColumn) {
        this.maxColumn = maxColumn;
    }
    public Integer getRowNum() {
        return rowNum;
    }
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }
    public Integer getRowSize() {
        return rowSize;
    }
    public void setRowSize(Integer rowSize) {
        this.rowSize = rowSize;
    }
    public Integer getColumnNum() {
        return columnNum;
    }
    public void setColumnNum(Integer columnNum) {
        this.columnNum = columnNum;
    }
    public Integer getColumnSize() {
        return columnSize;
    }
    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }

}
