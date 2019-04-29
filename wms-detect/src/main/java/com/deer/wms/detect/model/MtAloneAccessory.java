package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_accessory")
public class MtAloneAccessory {
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
    private Integer version;

    /**
     * 状态		0处理中，1处理完成
     */
    private Integer status;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    private String ext;

    private String info;

    private String name;

    private String path;

    private Float size;
    
    private String url;
    
    @Column(name = "content_type")
    private String contentType;

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name = "annex_code")
    private String annexCode;

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
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1
     *
     * @param version 版本号 默认为 1
     */
    public void setVersion(Integer version) {
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
     * @return ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return size
     */
    public Float getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Float size) {
        this.size = size;
    }

    /**
     * @return annex_code
     */
    public String getAnnexCode() {
        return annexCode;
    }

    /**
     * @param annexCode
     */
    public void setAnnexCode(String annexCode) {
        this.annexCode = annexCode;
    }
}