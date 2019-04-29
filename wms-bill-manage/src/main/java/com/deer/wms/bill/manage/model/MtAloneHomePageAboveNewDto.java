package com.deer.wms.bill.manage.model;

/**
 * 首页面上面统计数量
 */

public class MtAloneHomePageAboveNewDto {

    private double todayInBoundMiles;//今日入库米数

    private double todayOutBoundMiles;//今日出库米数

    private double totalOutBoundMiles;//年累计出库米数

    private double remainMiles;//剩余米数

    private int remainPieces;//剩余匹数

    private int finishedPieces;//成品匹数

    private double finishedMiles;//成品米数

    private int rawPieces;//坯布匹数

    private double rawMiles;//坯布米数

    public double getTodayInBoundMiles() {
        return todayInBoundMiles;
    }

    public void setTodayInBoundMiles(double todayInBoundMiles) {
        this.todayInBoundMiles = todayInBoundMiles;
    }

    public double getTodayOutBoundMiles() {
        return todayOutBoundMiles;
    }

    public void setTodayOutBoundMiles(double todayOutBoundMiles) {
        this.todayOutBoundMiles = todayOutBoundMiles;
    }

    public double getTotalOutBoundMiles() {
        return totalOutBoundMiles;
    }

    public void setTotalOutBoundMiles(double totalOutBoundMiles) {
        this.totalOutBoundMiles = totalOutBoundMiles;
    }

    public double getRemainMiles() {
        return remainMiles;
    }

    public void setRemainMiles(double remainMiles) {
        this.remainMiles = remainMiles;
    }

    public int getRemainPieces() {
        return remainPieces;
    }

    public void setRemainPieces(int remainPieces) {
        this.remainPieces = remainPieces;
    }

    public int getFinishedPieces() {
        return finishedPieces;
    }

    public void setFinishedPieces(int finishedPieces) {
        this.finishedPieces = finishedPieces;
    }

    public double getFinishedMiles() {
        return finishedMiles;
    }

    public void setFinishedMiles(double finishedMiles) {
        this.finishedMiles = finishedMiles;
    }

    public int getRawPieces() {
        return rawPieces;
    }

    public void setRawPieces(int rawPieces) {
        this.rawPieces = rawPieces;
    }

    public double getRawMiles() {
        return rawMiles;
    }

    public void setRawMiles(double rawMiles) {
        this.rawMiles = rawMiles;
    }
}
