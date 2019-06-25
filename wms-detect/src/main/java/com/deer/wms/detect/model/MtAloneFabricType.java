package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_fabric_type")
public class MtAloneFabricType {
    /**
     * 瑕疵种类id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 瑕疵种类名称
     */
    @Column(name = "fabric_type_name")
    private String fabricTypeName;

    /**
     * 状态  normal-正常
     */
    private String state;

    /**
     * 备注
     */
    private String memo;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取瑕疵种类id
     *
     * @return id - 瑕疵种类id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置瑕疵种类id
     *
     * @param id 瑕疵种类id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取瑕疵种类名称
     *
     * @return fabric_type_name - 瑕疵种类名称
     */
    public String getFabricTypeName() {
        return fabricTypeName;
    }

    /**
     * 设置瑕疵种类名称
     *
     * @param fabricTypeName 瑕疵种类名称
     */
    public void setFabricTypeName(String fabricTypeName) {
        this.fabricTypeName = fabricTypeName;
    }

    /**
     * 获取状态  normal-正常
     *
     * @return state - 状态  normal-正常
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态  normal-正常
     *
     * @param state 状态  normal-正常
     */
    public void setState(String state) {
        this.state = state;
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

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}