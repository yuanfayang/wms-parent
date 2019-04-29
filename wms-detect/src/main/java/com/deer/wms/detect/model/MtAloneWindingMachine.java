package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_winding_machine")
public class MtAloneWindingMachine {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态		0表示可用，1作废，2冻结
     */
    private Integer state;

    /**
     * 设备名称
     */
    @Column(name = "winding_machine_name")
    private String windingMachineName;

    /**
     * 设备code
     */
    @Column(name = "machine_code")
    private String machineCode;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String notes;

    /**
     * 创建人id
     */
    @Column(name = "create_man_id")
    private Integer createManId;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 版本号
     */
    private String version;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取状态		0表示可用，1作废，2冻结
     *
     * @return state - 状态		0表示可用，1作废，2冻结
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态		0表示可用，1作废，2冻结
     *
     * @param state 状态		0表示可用，1作废，2冻结
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取设备名称
     *
     * @return winding_machine_name - 设备名称
     */
    public String getWindingMachineName() {
        return windingMachineName;
    }

    /**
     * 设置设备名称
     *
     * @param windingMachineName 设备名称
     */
    public void setWindingMachineName(String windingMachineName) {
        this.windingMachineName = windingMachineName;
    }

    /**
     * 获取设备code
     *
     * @return machine_code - 设备code
     */
    public String getMachineCode() {
        return machineCode;
    }

    /**
     * 设置设备code
     *
     * @param machineCode 设备code
     */
    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
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
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取创建人id
     *
     * @return create_man_id - 创建人id
     */
    public Integer getCreateManId() {
        return createManId;
    }

    /**
     * 设置创建人id
     *
     * @param createManId 创建人id
     */
    public void setCreateManId(Integer createManId) {
        this.createManId = createManId;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }
}