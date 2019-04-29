package com.deer.wms.bill.manage.model;

/**
 * 首页面上面统计数量
 */

public class MtAloneHomePageAboveDto  {

    private int countProForReview;//待审核产品个数

    private int countProReviewed;//已审核产品个数

    private int countProDetForOnShelf;//待上架明细卷数

    private double proDetForOnShelfMiles;//待上架明细米数

    private int countProDetOnShelf;//已上架明细卷数

    private double proDetOnShelfMiles;//已上架明细米数

    public int getCountProForReview() {
        return countProForReview;
    }

    public void setCountProForReview(int countProForReview) {
        this.countProForReview = countProForReview;
    }

    public int getCountProReviewed() {
        return countProReviewed;
    }

    public void setCountProReviewed(int countProReviewed) {
        this.countProReviewed = countProReviewed;
    }

    public int getCountProDetForOnShelf() {
        return countProDetForOnShelf;
    }

    public void setCountProDetForOnShelf(int countProDetForOnShelf) {
        this.countProDetForOnShelf = countProDetForOnShelf;
    }

    public double getProDetForOnShelfMiles() {
        return proDetForOnShelfMiles;
    }

    public void setProDetForOnShelfMiles(double proDetForOnShelfMiles) {
        this.proDetForOnShelfMiles = proDetForOnShelfMiles;
    }

    public int getCountProDetOnShelf() {
        return countProDetOnShelf;
    }

    public void setCountProDetOnShelf(int countProDetOnShelf) {
        this.countProDetOnShelf = countProDetOnShelf;
    }

    public double getProDetOnShelfMiles() {
        return proDetOnShelfMiles;
    }

    public void setProDetOnShelfMiles(double proDetOnShelfMiles) {
        this.proDetOnShelfMiles = proDetOnShelfMiles;
    }
}
