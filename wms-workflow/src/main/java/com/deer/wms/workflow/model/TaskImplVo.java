package com.deer.wms.workflow.model;

import java.io.Serializable;

/**
 * TaskImplVo
 *
 * @author luxin.yan
 * @date 2019/1/28
 **/
public class TaskImplVo implements Serializable {
    private String taskId;
    private String taskName;
    private String formKey;
    private String processInstanceId;
    private String processId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "TaskImplVo{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", formKey='" + formKey + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", processId='" + processId + '\'' +
                '}';
    }
}
