package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_stock_provendor")
public class MtStockProvendor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 创建人id
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private Long updaterId;

    /**
     * 版本号 默认为 1
     */
    private String version;

    /**
     * 状态		0处理中，1处理完成
     */
    private Integer status;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 供应商类型，1表示公司，2个人
     */
    @Column(name = "provendor_type")
    private Integer provendorType;

    /**
     * 供应商编码
     */
    @Column(name = "customer_code")
    private String customerCode;

    /**
     * 供应商名称
     */
    @Column(name = "provendor_name")
    private String provendorName;

    /**
     * 供货类型，一级大类下拉框
     */
    @Column(name = "first_large_class")
    private String firstLargeClass;

    /**
     * 传真
     */
    private String fax;

    /**
     * 联系人名称
     */
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 联系人电话
     */
    private String tel;

    /**
     * 单位职务
     */
    private String position;

    /**
     * 性别，单选框
     */
    private String gender;

    /**
     * 联系地址，详细地址
     */
    private String address;

    /**
     * 描述信息，描述供应商一般性信息
     */
    private String description;

    private String remark;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
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
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取更新人id
     *
     * @return updater_id - 更新人id
     */
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新人id
     *
     * @param updaterId 更新人id
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 获取版本号 默认为 1
     *
     * @return version - 版本号 默认为 1
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1
     *
     * @param version 版本号 默认为 1
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取状态		0处理中，1处理完成
     *
     * @return status - 状态		0处理中，1处理完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0处理中，1处理完成
     *
     * @param status 状态		0处理中，1处理完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取绑定公司id
     *
     * @return company_id - 绑定公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置绑定公司id
     *
     * @param companyId 绑定公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取供应商类型，1表示公司，2个人
     *
     * @return provendor_type - 供应商类型，1表示公司，2个人
     */
    public Integer getProvendorType() {
        return provendorType;
    }

    /**
     * 设置供应商类型，1表示公司，2个人
     *
     * @param provendorType 供应商类型，1表示公司，2个人
     */
    public void setProvendorType(Integer provendorType) {
        this.provendorType = provendorType;
    }

    /**
     * 获取供应商编码
     *
     * @return customer_code - 供应商编码
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 设置供应商编码
     *
     * @param customerCode 供应商编码
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * 获取供应商名称
     *
     * @return provendor_name - 供应商名称
     */
    public String getProvendorName() {
        return provendorName;
    }

    /**
     * 设置供应商名称
     *
     * @param provendorName 供应商名称
     */
    public void setProvendorName(String provendorName) {
        this.provendorName = provendorName;
    }

    /**
     * 获取供货类型，一级大类下拉框
     *
     * @return first_large_class - 供货类型，一级大类下拉框
     */
    public String getFirstLargeClass() {
        return firstLargeClass;
    }

    /**
     * 设置供货类型，一级大类下拉框
     *
     * @param firstLargeClass 供货类型，一级大类下拉框
     */
    public void setFirstLargeClass(String firstLargeClass) {
        this.firstLargeClass = firstLargeClass;
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取联系人名称
     *
     * @return contact_name - 联系人名称
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人名称
     *
     * @param contactName 联系人名称
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取联系人电话
     *
     * @return tel - 联系人电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系人电话
     *
     * @param tel 联系人电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取单位职务
     *
     * @return position - 单位职务
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置单位职务
     *
     * @param position 单位职务
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取性别，单选框
     *
     * @return gender - 性别，单选框
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别，单选框
     *
     * @param gender 性别，单选框
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取联系地址，详细地址
     *
     * @return address - 联系地址，详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址，详细地址
     *
     * @param address 联系地址，详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取描述信息，描述供应商一般性信息
     *
     * @return description - 描述信息，描述供应商一般性信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述信息，描述供应商一般性信息
     *
     * @param description 描述信息，描述供应商一般性信息
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}