package com.deer.wms.produce.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_process")
public class MtAloneProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作员id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 版本号 默认为 1.1
     */
    private Integer version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 工序名称
     */
    @Column(name = "process_name")
    private String processName;

    /**
     * 产品生产过程id，关联表：mt_alone_product_process
     */
    @Column(name = "product_process_id")
    private Integer productProcessId;

    /**
     * 工序编码，编码规则：GX+日期
     */
    private String code;

    /**
     * 规格型号
     */
    private String specification;

    /**
     * 工序来源：0本厂加工，1外厂协作，2外购
     */
    @Column(name = "process_source")
    private Integer processSource;

    /**
     * 加工价格 元
     */
    @Column(name = "process_price")
    private Float processPrice;

    /**
     * 加工单价 元/米
     */
    @Column(name = "process_unit_price")
    private Float processUnitPrice;

    /**
     * 原先长度，单位米
     */
    @Column(name = "original_len")
    private Float originalLen;

    /**
     * 损耗%比
     */
    private Float loss;

    /**
     * 加工后长度，单位米
     */
    @Column(name = "after_len")
    private Float afterLen;

    /**
     * 加工描述内容
     */
    @Column(name = "process_content")
    private String processContent;

    /**
     * 加工商id，关联表供应商表：supplier_manage
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    /**
     * 工序步骤，从第一步开始，依次增加
     */
    @Column(name = "process_step")
    private Integer processStep;

    /**
     * 跟单员id，关联表员工表：user_info
     */
    @Column(name = "merchandiser_id")
    private Integer merchandiserId;

    /**
     * 附件code，关联附件表：mt_alone_accessory
     */
    @Column(name = "product_annex_code")
    private String productAnnexCode;

    /**
     * 备注
     */
    private String memo;

    @Column(name = "company_id")
    private Integer companyId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作员id
     *
     * @return operator_id - 操作员id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员id
     *
     * @param operatorId 操作员id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取版本号 默认为 1.1
     *
     * @return version - 版本号 默认为 1.1
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1.1
     *
     * @param version 版本号 默认为 1.1
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取状态		0使用，1禁用
     *
     * @return status - 状态		0使用，1禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0使用，1禁用
     *
     * @param status 状态		0使用，1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取工序名称
     *
     * @return process_name - 工序名称
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 设置工序名称
     *
     * @param processName 工序名称
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 获取产品生产过程id，关联表：mt_alone_product_process
     *
     * @return product_process_id - 产品生产过程id，关联表：mt_alone_product_process
     */
    public Integer getProductProcessId() {
        return productProcessId;
    }

    /**
     * 设置产品生产过程id，关联表：mt_alone_product_process
     *
     * @param productProcessId 产品生产过程id，关联表：mt_alone_product_process
     */
    public void setProductProcessId(Integer productProcessId) {
        this.productProcessId = productProcessId;
    }

    /**
     * 获取工序编码，编码规则：GX+日期
     *
     * @return code - 工序编码，编码规则：GX+日期
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置工序编码，编码规则：GX+日期
     *
     * @param code 工序编码，编码规则：GX+日期
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取规格型号
     *
     * @return specification - 规格型号
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置规格型号
     *
     * @param specification 规格型号
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 获取工序来源：0本厂加工，1外厂协作，2外购
     *
     * @return process_source - 工序来源：0本厂加工，1外厂协作，2外购
     */
    public Integer getProcessSource() {
        return processSource;
    }

    /**
     * 设置工序来源：0本厂加工，1外厂协作，2外购
     *
     * @param processSource 工序来源：0本厂加工，1外厂协作，2外购
     */
    public void setProcessSource(Integer processSource) {
        this.processSource = processSource;
    }

    /**
     * 获取加工价格 元
     *
     * @return process_price - 加工价格 元
     */
    public Float getProcessPrice() {
        return processPrice;
    }

    /**
     * 设置加工价格 元
     *
     * @param processPrice 加工价格 元
     */
    public void setProcessPrice(Float processPrice) {
        this.processPrice = processPrice;
    }

    /**
     * 获取加工单价 元/米
     *
     * @return process_unit_price - 加工单价 元/米
     */
    public Float getProcessUnitPrice() {
        return processUnitPrice;
    }

    /**
     * 设置加工单价 元/米
     *
     * @param processUnitPrice 加工单价 元/米
     */
    public void setProcessUnitPrice(Float processUnitPrice) {
        this.processUnitPrice = processUnitPrice;
    }

    /**
     * 获取原先长度，单位米
     *
     * @return original_len - 原先长度，单位米
     */
    public Float getOriginalLen() {
        return originalLen;
    }

    /**
     * 设置原先长度，单位米
     *
     * @param originalLen 原先长度，单位米
     */
    public void setOriginalLen(Float originalLen) {
        this.originalLen = originalLen;
    }

    /**
     * 获取损耗%比
     *
     * @return loss - 损耗%比
     */
    public Float getLoss() {
        return loss;
    }

    /**
     * 设置损耗%比
     *
     * @param loss 损耗%比
     */
    public void setLoss(Float loss) {
        this.loss = loss;
    }

    /**
     * 获取加工后长度，单位米
     *
     * @return after_len - 加工后长度，单位米
     */
    public Float getAfterLen() {
        return afterLen;
    }

    /**
     * 设置加工后长度，单位米
     *
     * @param afterLen 加工后长度，单位米
     */
    public void setAfterLen(Float afterLen) {
        this.afterLen = afterLen;
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
     * 获取加工商id，关联表供应商表：supplier_manage
     *
     * @return supplier_id - 加工商id，关联表供应商表：supplier_manage
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 设置加工商id，关联表供应商表：supplier_manage
     *
     * @param supplierId 加工商id，关联表供应商表：supplier_manage
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 获取工序步骤，从第一步开始，依次增加
     *
     * @return process_step - 工序步骤，从第一步开始，依次增加
     */
    public Integer getProcessStep() {
        return processStep;
    }

    /**
     * 设置工序步骤，从第一步开始，依次增加
     *
     * @param processStep 工序步骤，从第一步开始，依次增加
     */
    public void setProcessStep(Integer processStep) {
        this.processStep = processStep;
    }

    /**
     * 获取跟单员id，关联表员工表：user_info
     *
     * @return merchandiser_id - 跟单员id，关联表员工表：user_info
     */
    public Integer getMerchandiserId() {
        return merchandiserId;
    }

    /**
     * 设置跟单员id，关联表员工表：user_info
     *
     * @param merchandiserId 跟单员id，关联表员工表：user_info
     */
    public void setMerchandiserId(Integer merchandiserId) {
        this.merchandiserId = merchandiserId;
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
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}