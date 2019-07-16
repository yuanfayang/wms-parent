package com.deer.wms.system.manage.model.department;

import javax.persistence.*;

@Table(name = "mt_alone_group_operator")
public class MtAloneGroupOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组名称
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 组成员id，关联人员表user_info
     */
    @Column(name = "woker_id")
    private Integer wokerId;

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
     * 获取组名称
     *
     * @return group_id - 组名称
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置组名称
     *
     * @param groupId 组名称
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取组成员id，关联人员表user_info
     *
     * @return woker_id - 组成员id，关联人员表user_info
     */
    public Integer getWokerId() {
        return wokerId;
    }

    /**
     * 设置组成员id，关联人员表user_info
     *
     * @param wokerId 组成员id，关联人员表user_info
     */
    public void setWokerId(Integer wokerId) {
        this.wokerId = wokerId;
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