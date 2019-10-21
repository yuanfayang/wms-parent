package com.deer.wms.produce.manage.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: 蔡翔
 * @Date: 2019/9/29 14:16
 * @Version 1.0
 */
public class MtAloneProductProcessBomVO extends MtAloneMachiningProduct {


    /**
     * 产品加工总名称
     */
    private String productProcessName;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 产品id，关联表：mt_alone_machining_product
     */
    private Integer productId;


    /**
     * 加工描述内容
     */
    private String processContent;

    /**
     * 备注
     */
    private String memo;

    /**
     * 附件code，关联附件表：mt_alone_accessory
     */
    private String productAnnexCode;

    /**
     * 获取产品加工总名称
     *
     * @return product_process_name - 产品加工总名称
     */
    public String getProductProcessName() {
        return productProcessName;
    }

    /**
     * 设置产品加工总名称
     *
     * @param productProcessName 产品加工总名称
     */
    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取产品id，关联表：mt_alone_machining_product
     *
     * @return product_id - 产品id，关联表：mt_alone_machining_product
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id，关联表：mt_alone_machining_product
     *
     * @param productId 产品id，关联表：mt_alone_machining_product
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }




    /**
     * 获取加工描述内容
     *
     * @return process_content - 加工描述内容
     */
    public String getProcessContent() {
        return processContent;
    }

    /**
     * 设置加工描述内容
     *
     * @param processContent 加工描述内容
     */
    public void setProcessContent(String processContent) {
        this.processContent = processContent;
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
     * 获取附件code，关联附件表：mt_alone_accessory
     *
     * @return product_annex_code - 附件code，关联附件表：mt_alone_accessory
     */
    public String getProductAnnexCode() {
        return productAnnexCode;
    }

    /**
     * 设置附件code，关联附件表：mt_alone_accessory
     *
     * @param productAnnexCode 附件code，关联附件表：mt_alone_accessory
     */
    public void setProductAnnexCode(String productAnnexCode) {
        this.productAnnexCode = productAnnexCode;
    }


}
