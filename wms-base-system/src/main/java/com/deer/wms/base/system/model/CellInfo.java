package com.deer.wms.base.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cell_info")
public class CellInfo {
    /**
     * 货位ID
     */
    @Id
    @Column(name = "cell_id")
    private Integer cellId;

    /**
     * 货架编码
     */
    @Column(name = "shelf_code")
    private String shelfCode;

    /**
     * 货位编码
     */
    @Column(name = "cell_code")
    private String cellCode;

    /**
     * 货位名称
     */
    @Column(name = "cell_name")
    private String cellName;


    /**
     * 货位别名
     */
    @Column(name = "cell_alias")
    private String cellAlias;
    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private String addTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 货位二维码
     */
    @Column(name = "cell_bar_code")
    private String cellBarCode;

    @Column(name = "s_row")
    private Integer sRow;

    @Column(name = "s_column")
    private Integer sColumn;

    /**
     * 0-无货；1-有货；2-锁定；3-故障
     */
    private Integer state;

    /**
     * 路径优先级
     */
    @Column(name = "order_no")
    private Integer orderNo;

    /**
     * 货位长度，米
     */
    @Column(name = "cell_l")
    private Float cellL;

    /**
     * 货位宽度，米
     */
    @Column(name = "cell_w")
    private Float cellW;

    /**
     * 货位高度，米
     */
    @Column(name = "cell_h")
    private Float cellH;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 获取货位ID
     *
     * @return cell_id - 货位ID
     */
    public Integer getCellId() {
        return cellId;
    }

    /**
     * 设置货位ID
     *
     * @param cellId 货位ID
     */
    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }

    /**
     * 获取货架编码
     *
     * @return shelf_code - 货架编码
     */
    public String getShelfCode() {
        return shelfCode;
    }

    /**
     * 设置货架编码
     *
     * @param shelfCode 货架编码
     */
    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }

    /**
     * 获取货物编码
     *
     * @return cell_code - 货物编码
     */
    public String getCellCode() {
        return cellCode;
    }

    /**
     * 设置货物编码
     *
     * @param cellCode 货物编码
     */
    public void setCellCode(String cellCode) {
        this.cellCode = cellCode;
    }

    /**
     * 获取货位名称
     *
     * @return cell_name - 货位名称
     */
    public String getCellName() {
        return cellName;
    }
    /**
     * 设置货位名称
     *
     * @param cellName 货位名称
     */
    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    /**
     * 获取货位别名
     *
     * @return cell_alias - 货位别名
     */
    public String getCellAlias() {
        return cellAlias;
    }

    /**
     * 设置货位名称
     *
     * @param cell_alias 货位别名
     */
    public void setCellAlias(String cellAlias) {
        this.cellAlias = cellAlias;
    }


    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取货位二维码
     *
     * @return cell_bar_code - 货位二维码
     */
    public String getCellBarCode() {
        return cellBarCode;
    }

    /**
     * 设置货位二维码
     *
     * @param cellBarCode 货位二维码
     */
    public void setCellBarCode(String cellBarCode) {
        this.cellBarCode = cellBarCode;
    }

    /**
     * @return s_row
     */
    public Integer getsRow() {
        return sRow;
    }

    /**
     * @param sRow
     */
    public void setsRow(Integer sRow) {
        this.sRow = sRow;
    }

    /**
     * @return s_column
     */
    public Integer getsColumn() {
        return sColumn;
    }

    /**
     * @param sColumn
     */
    public void setsColumn(Integer sColumn) {
        this.sColumn = sColumn;
    }

    /**
     * 获取0-无货；1-有货；2-锁定；3-故障
     *
     * @return state - 0-无货；1-有货；2-锁定；3-故障
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0-无货；1-有货；2-锁定；3-故障
     *
     * @param state 0-无货；1-有货；2-锁定；3-故障
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取路径优先级
     *
     * @return order_no - 路径优先级
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 设置路径优先级
     *
     * @param orderNo 路径优先级
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取货位长度，米
     *
     * @return cell_l - 货位长度，米
     */
    public Float getCellL() {
        return cellL;
    }

    /**
     * 设置货位长度，米
     *
     * @param cellL 货位长度，米
     */
    public void setCellL(Float cellL) {
        this.cellL = cellL;
    }

    /**
     * 获取货位宽度，米
     *
     * @return cell_w - 货位宽度，米
     */
    public Float getCellW() {
        return cellW;
    }

    /**
     * 设置货位宽度，米
     *
     * @param cellW 货位宽度，米
     */
    public void setCellW(Float cellW) {
        this.cellW = cellW;
    }

    /**
     * 获取货位高度，米
     *
     * @return cell_h - 货位高度，米
     */
    public Float getCellH() {
        return cellH;
    }

    /**
     * 设置货位高度，米
     *
     * @param cellH 货位高度，米
     */
    public void setCellH(Float cellH) {
        this.cellH = cellH;
    }

    /**
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}