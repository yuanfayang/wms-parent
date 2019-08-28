package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_sample_cloth_det")
public class MtAloneSampleClothDet {
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
     * 创建人id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private Integer updaterId;

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
    private Integer companyId;

    /**
     * 样布id
     */
    @Column(name = "sample_cloth_id")
    private Integer sampleClothId;

    /**
     * 附件code， 关联附件表：mt_alone_accessory
     */
    @Column(name = "annex_code")
    private String annexCode;

    /**
     * 单价(每米/元)
     */
    @Column(name = "sample_cloth_price")
    private Float sampleClothPrice;

    /**
     * 长度
     */
    @Column(name = "sample_cloth_length")
    private Float sampleClothLength;

    /**
     * 仓库id
     */
    @Column(name = "ware_info_id")
    private Integer wareInfoId;

    /**
     * 区域名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 库位名称
     */
    @Column(name = "location_name")
    private String locationName;

    /**
     * 备注1
     */
    private String remark1;

    /**
     * 备注2
     */
    private String remark2;

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
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取更新人id
     *
     * @return updater_id - 更新人id
     */
    public Integer getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新人id
     *
     * @param updaterId 更新人id
     */
    public void setUpdaterId(Integer updaterId) {
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
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置绑定公司id
     *
     * @param companyId 绑定公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取样布id
     *
     * @return sample_cloth_id - 样布id
     */
    public Integer getSampleClothId() {
        return sampleClothId;
    }

    /**
     * 设置样布id
     *
     * @param sampleClothId 样布id
     */
    public void setSampleClothId(Integer sampleClothId) {
        this.sampleClothId = sampleClothId;
    }

    /**
     * 获取附件code， 关联附件表：mt_alone_accessory
     *
     * @return annex_code - 附件code， 关联附件表：mt_alone_accessory
     */
    public String getAnnexCode() {
        return annexCode;
    }

    /**
     * 设置附件code， 关联附件表：mt_alone_accessory
     *
     * @param annexCode 附件code， 关联附件表：mt_alone_accessory
     */
    public void setAnnexCode(String annexCode) {
        this.annexCode = annexCode;
    }

    /**
     * 获取单价(每米/元)
     *
     * @return sample_cloth_price - 单价(每米/元)
     */
    public Float getSampleClothPrice() {
        return sampleClothPrice;
    }

    /**
     * 设置单价(每米/元)
     *
     * @param sampleClothPrice 单价(每米/元)
     */
    public void setSampleClothPrice(Float sampleClothPrice) {
        this.sampleClothPrice = sampleClothPrice;
    }

    /**
     * 获取长度
     *
     * @return sample_cloth_length - 长度
     */
    public Float getSampleClothLength() {
        return sampleClothLength;
    }

    /**
     * 设置长度
     *
     * @param sampleClothLength 长度
     */
    public void setSampleClothLength(Float sampleClothLength) {
        this.sampleClothLength = sampleClothLength;
    }

    /**
     * 获取仓库id
     *
     * @return ware_info_id - 仓库id
     */
    public Integer getWareInfoId() {
        return wareInfoId;
    }

    /**
     * 设置仓库id
     *
     * @param wareInfoId 仓库id
     */
    public void setWareInfoId(Integer wareInfoId) {
        this.wareInfoId = wareInfoId;
    }

    /**
     * 获取区域名称
     *
     * @return area_name - 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名称
     *
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取库位名称
     *
     * @return location_name - 库位名称
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置库位名称
     *
     * @param locationName 库位名称
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 获取备注1
     *
     * @return remark1 - 备注1
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 设置备注1
     *
     * @param remark1 备注1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    /**
     * 获取备注2
     *
     * @return remark2 - 备注2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 设置备注2
     *
     * @param remark2 备注2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}