package com.deer.wms.produce.manage.model;

import lombok.Data;

/**
 * @Author: weihongyang
 * @Date: 2019/9/9 15:22
 * @Version 1.0
 */
@Data
public class MtAloneStockProductVo extends MtAloneStockProduct{
    /**
     * 物料类型名称
     */
    private String itemTypeName;

    /**
     * 物料品种名称
     */
    private String itemVarietyName;

    /**
     * 采购员名字
     */
    private String purchaserName;

    /**
     *销售员名字
     */
    private String sellerName;

    /**
     * 供应商代号
     */
    private String supplierCodeName;
}
