package com.deer.wms.bill.manage.model;

/*
 * 统计不同状态货位数
 */

public class MtAloneCellStateDto {

    private int sumCells;//货位总数

	private int countInStock;//有货货位数

	private int countNoStock;//无货货位数

    private int countLock;//锁定货位数

    private int countFault;//故障货位数

    public int getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(int countInStock) {
        this.countInStock = countInStock;
    }

    public int getCountNoStock() {
        return countNoStock;
    }

    public void setCountNoStock(int countNoStock) {
        this.countNoStock = countNoStock;
    }

    public int getCountLock() {
        return countLock;
    }

    public void setCountLock(int countLock) {
        this.countLock = countLock;
    }

    public int getCountFault() {
        return countFault;
    }

    public void setCountFault(int countFault) {
        this.countFault = countFault;
    }

    public int getSumCells() {
        return sumCells;
    }

    public void setSumCells(int sumCells) {
        this.sumCells = sumCells;
    }

}
