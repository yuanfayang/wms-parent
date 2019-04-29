package com.deer.wms.system.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_log")
public class MtAloneLog {
    /**
     * 主键id
     */
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @Column(name = "operate_user_id")
    private Integer operateUserId;

    /**
     * 日志类型
     */
    @Column(name = "log_type")
    private String logType;

    /**
     * 操作用户名字
     */
    @Column(name = "operate_user_name")
    private String operateUserName;

    /**
     * 日志信息
     */
    @Column(name = "log_description")
    private String logDescription;

    /**
     * 返回结果
     */
    private String result;

    /**
     * 调用的接口url
     */
    @Column(name = "action_url")
    private String actionUrl;

    /**
     * 操作客户端IP
     */
    @Column(name = "operate_ip")
    private String operateIp;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 请求时长
     */
    private Float duration;

    /**
     * 备注
     */
    private String notes;
    
    /**
     * 操作系统
     */
    private String os;
    
    /**
     * 浏览器
     */
    private String browser;
    
    /**
     * 位置
     */
    private String location;

    /**
     * 获取主键id
     *
     * @return log_id - 主键id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置主键id
     *
     * @param logId 主键id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * @return operate_user_id
     */
    public Integer getOperateUserId() {
        return operateUserId;
    }

    /**
     * @param operateUserId
     */
    public void setOperateUserId(Integer operateUserId) {
        this.operateUserId = operateUserId;
    }

    /**
     * 获取日志类型
     *
     * @return log_type - 日志类型
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 设置日志类型
     *
     * @param logType 日志类型
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * 获取操作用户名字
     *
     * @return operate_user_name - 操作用户名字
     */
    public String getOperateUserName() {
        return operateUserName;
    }

    /**
     * 设置操作用户名字
     *
     * @param operateUserName 操作用户名字
     */
    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName;
    }

    /**
     * 获取日志信息
     *
     * @return log_description - 日志信息
     */
    public String getLogDescription() {
        return logDescription;
    }

    /**
     * 设置日志信息
     *
     * @param logDescription 日志信息
     */
    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    /**
     * 获取返回结果
     *
     * @return result - 返回结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置返回结果
     *
     * @param result 返回结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取调用的接口url
     *
     * @return action_url - 调用的接口url
     */
    public String getActionUrl() {
        return actionUrl;
    }

    /**
     * 设置调用的接口url
     *
     * @param actionUrl 调用的接口url
     */
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    /**
     * 获取操作客户端IP
     *
     * @return operate_ip - 操作客户端IP
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置操作客户端IP
     *
     * @param operateIp 操作客户端IP
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * 获取操作时间
     *
     * @return operate_time - 操作时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置操作时间
     *
     * @param operateTime 操作时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取请求时长
     *
     * @return duration - 请求时长
     */
    public Float getDuration() {
        return duration;
    }

    /**
     * 设置请求时长
     *
     * @param duration 请求时长
     */
    public void setDuration(Float duration) {
        this.duration = duration;
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
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}