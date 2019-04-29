package com.deer.wms.workflow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TaskForm
 *
 * @author luxin.yan
 * @date 2019/1/11
 **/
@ApiModel(description = "查询可接收的任务")
public class TaskForm extends BaseForm {
    @ApiModelProperty(value = "用户ID")
    private String usreId;

    @ApiModelProperty(value = "任务ID")
    private String taskId;


    public String getUsreId() {
        return usreId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setUsreId(String usreId) {
        this.usreId = usreId;
    }
}
