package com.deer.wms.workflow.model;

import lombok.Data;

import java.io.Serializable;

/**
 * TaskImplVo
 *
 * @author luxin.yan
 * @date 2019/1/28
 **/
@Data
public class TaskImplVo implements Serializable {
    private String taskId;
    private String taskName;
    private String formKey;
    private String processInstanceId;
    private String processId;
    private String processDefName;

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
