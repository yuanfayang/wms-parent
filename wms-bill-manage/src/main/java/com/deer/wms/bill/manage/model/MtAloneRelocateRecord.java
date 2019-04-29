package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_relocate_record")
public class MtAloneRelocateRecord {
    /**
     * 记录Id
     */
    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    /**
     * 移库时间
     */
    @Column(name = "relocate_time")
    private Date relocateTime;

    /**
     * 移库前仓位
     */
    @Column(name = "before_cell_code")
    private String beforeCellCode;

    /**
     * 移库后仓位
     */
    @Column(name = "after_cell_code")
    private String afterCellCode;

    /**
     * 明细条形码
     */
    @Column(name = "detection_barcode")
    private String detectionBarcode;

    /**
     * 获取记录Id
     *
     * @return record_id - 记录Id
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * 设置记录Id
     *
     * @param recordId 记录Id
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取移库时间
     *
     * @return relocate_time - 移库时间
     */
    public Date getRelocateTime() {
        return relocateTime;
    }

    /**
     * 设置移库时间
     *
     * @param relocateTime 移库时间
     */
    public void setRelocateTime(Date relocateTime) {
        this.relocateTime = relocateTime;
    }

    /**
     * 获取移库前仓位
     *
     * @return before_cell_code - 移库前仓位
     */
    public String getBeforeCellCode() {
        return beforeCellCode;
    }

    /**
     * 设置移库前仓位
     *
     * @param beforeCellCode 移库前仓位
     */
    public void setBeforeCellCode(String beforeCellCode) {
        this.beforeCellCode = beforeCellCode;
    }

    /**
     * 获取移库后仓位
     *
     * @return after_cell_code - 移库后仓位
     */
    public String getAfterCellCode() {
        return afterCellCode;
    }

    /**
     * 设置移库后仓位
     *
     * @param afterCellCode 移库后仓位
     */
    public void setAfterCellCode(String afterCellCode) {
        this.afterCellCode = afterCellCode;
    }

    /**
     * 获取明细条形码
     *
     * @return detection_barcode - 明细条形码
     */
    public String getDetectionBarcode() {
        return detectionBarcode;
    }

    /**
     * 设置明细条形码
     *
     * @param detectionBarcode 明细条形码
     */
    public void setDetectionBarcode(String detectionBarcode) {
        this.detectionBarcode = detectionBarcode;
    }
}