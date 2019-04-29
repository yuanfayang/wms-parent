package com.deer.wms.base.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "shelf_info")
public class ShelfInfo {
    /**
     * 货架ID
     */
    @Id
    @Column(name = "shelf_id")
    private Integer shelfId;

    /**
     * 货区编码
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 货架编码
     */
    @Column(name = "shelf_code")
    private String shelfCode;

    /**
     * 货架名
     */
    @Column(name = "shelf_name")
    private String shelfName;

    /**
     * 货区列
     */
    @Column(name = "a_column")
    private Integer aColumn;

    /**
     * 货区行
     */
    @Column(name = "a_row")
    private Integer aRow;

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
     * 货区创建标志
     */
    @Column(name = "cell_create_flag")
    private Integer cellCreateFlag;

    @Column(name = "shelf_row")
    private Integer shelfRow;

    @Column(name = "shelf_column")
    private Integer shelfColumn;

    @Column(name = "priority_level")
    private Integer priorityLevel;

    /**
     * ABC分类法
     */
    @Column(name = "abc_class")
    private String abcClass;

    /**
     * 路径优先级
     */
    @Column(name = "order_no")
    private Integer orderNo;

    /**
     * 1-行优先  2-列优先
     */
    @Column(name = "r_c_order")
    private Integer rCOrder;

    /**
     * 1-下优先 2-上优先
     */
    @Column(name = "r_order")
    private Integer rOrder;

    /**
     * 1-左优先 2-右优先
     */
    @Column(name = "c_order")
    private Integer cOrder;

    /**
     * 货架长度,米
     */
    @Column(name = "shelf_l")
    private Float shelfL;

    /**
     * 货架宽度,米
     */
    @Column(name = "shelf_w")
    private Float shelfW;

    /**
     * 货架高度,米
     */
    @Column(name = "shelf_h")
    private Float shelfH;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 获取货架ID
     *
     * @return shelf_id - 货架ID
     */
    public Integer getShelfId() {
        return shelfId;
    }

    /**
     * 设置货架ID
     *
     * @param shelfId 货架ID
     */
    public void setShelfId(Integer shelfId) {
        this.shelfId = shelfId;
    }

    /**
     * 获取货区编码
     *
     * @return area_code - 货区编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置货区编码
     *
     * @param areaCode 货区编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
     * 获取货架名
     *
     * @return shelf_name - 货架名
     */
    public String getShelfName() {
        return shelfName;
    }

    /**
     * 设置货架名
     *
     * @param shelfName 货架名
     */
    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    /**
     * 获取货区列
     *
     * @return a_column - 货区列
     */
    public Integer getaColumn() {
        return aColumn;
    }

    /**
     * 设置货区列
     *
     * @param aColumn 货区列
     */
    public void setaColumn(Integer aColumn) {
        this.aColumn = aColumn;
    }

    /**
     * 获取货区行
     *
     * @return a_row - 货区行
     */
    public Integer getaRow() {
        return aRow;
    }

    /**
     * 设置货区行
     *
     * @param aRow 货区行
     */
    public void setaRow(Integer aRow) {
        this.aRow = aRow;
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
     * 获取货区创建标志
     *
     * @return cell_create_flag - 货区创建标志
     */
    public Integer getCellCreateFlag() {
        return cellCreateFlag;
    }

    /**
     * 设置货区创建标志
     *
     * @param cellCreateFlag 货区创建标志
     */
    public void setCellCreateFlag(Integer cellCreateFlag) {
        this.cellCreateFlag = cellCreateFlag;
    }

    /**
     * @return shelf_row
     */
    public Integer getShelfRow() {
        return shelfRow;
    }

    /**
     * @param shelfRow
     */
    public void setShelfRow(Integer shelfRow) {
        this.shelfRow = shelfRow;
    }

    /**
     * @return shelf_column
     */
    public Integer getShelfColumn() {
        return shelfColumn;
    }

    /**
     * @param shelfColumn
     */
    public void setShelfColumn(Integer shelfColumn) {
        this.shelfColumn = shelfColumn;
    }

    /**
     * @return priority_level
     */
    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * @param priorityLevel
     */
    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * 获取ABC分类法
     *
     * @return abc_class - ABC分类法
     */
    public String getAbcClass() {
        return abcClass;
    }

    /**
     * 设置ABC分类法
     *
     * @param abcClass ABC分类法
     */
    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
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
     * 获取1-行优先  2-列优先
     *
     * @return r_c_order - 1-行优先  2-列优先
     */
    public Integer getrCOrder() {
        return rCOrder;
    }

    /**
     * 设置1-行优先  2-列优先
     *
     * @param rCOrder 1-行优先  2-列优先
     */
    public void setrCOrder(Integer rCOrder) {
        this.rCOrder = rCOrder;
    }

    /**
     * 获取1-下优先 2-上优先
     *
     * @return r_order - 1-下优先 2-上优先
     */
    public Integer getrOrder() {
        return rOrder;
    }

    /**
     * 设置1-下优先 2-上优先
     *
     * @param rOrder 1-下优先 2-上优先
     */
    public void setrOrder(Integer rOrder) {
        this.rOrder = rOrder;
    }

    /**
     * 获取1-左优先 2-右优先
     *
     * @return c_order - 1-左优先 2-右优先
     */
    public Integer getcOrder() {
        return cOrder;
    }

    /**
     * 设置1-左优先 2-右优先
     *
     * @param cOrder 1-左优先 2-右优先
     */
    public void setcOrder(Integer cOrder) {
        this.cOrder = cOrder;
    }

    /**
     * 获取货架长度,米
     *
     * @return shelf_l - 货架长度,米
     */
    public Float getShelfL() {
        return shelfL;
    }

    /**
     * 设置货架长度,米
     *
     * @param shelfL 货架长度,米
     */
    public void setShelfL(Float shelfL) {
        this.shelfL = shelfL;
    }

    /**
     * 获取货架宽度,米
     *
     * @return shelf_w - 货架宽度,米
     */
    public Float getShelfW() {
        return shelfW;
    }

    /**
     * 设置货架宽度,米
     *
     * @param shelfW 货架宽度,米
     */
    public void setShelfW(Float shelfW) {
        this.shelfW = shelfW;
    }

    /**
     * 获取货架高度,米
     *
     * @return shelf_h - 货架高度,米
     */
    public Float getShelfH() {
        return shelfH;
    }

    /**
     * 设置货架高度,米
     *
     * @param shelfH 货架高度,米
     */
    public void setShelfH(Float shelfH) {
        this.shelfH = shelfH;
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