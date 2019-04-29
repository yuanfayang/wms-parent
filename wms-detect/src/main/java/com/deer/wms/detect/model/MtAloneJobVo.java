package com.deer.wms.detect.model;

import java.util.Date;

/**
 * Description:
 * 
 * @author gtt
 * @date 2019年4月10日
 * @version 1.0
 */
public class MtAloneJobVo extends MtAloneJob {
	private String craftType;
	private String craftUnit;
	private String taskName;
	private String taskKey;
	/**
	 * 发起时间
	 */
	private Date startTime;

	/**
	 * @return the craftType
	 */
	public String getCraftType() {
		return craftType;
	}

	/**
	 * @param craftType
	 *            the craftType to set
	 */
	public void setCraftType(String craftType) {
		this.craftType = craftType;
	}

	/**
	 * @return the craftUnit
	 */
	public String getCraftUnit() {
		return craftUnit;
	}

	/**
	 * @param craftUnit
	 *            the craftUnit to set
	 */
	public void setCraftUnit(String craftUnit) {
		this.craftUnit = craftUnit;
	}

	public String getTaskKey() {
		return taskKey;
	}

	public void setTaskKey(String taskKey) {
		this.taskKey = taskKey;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}
