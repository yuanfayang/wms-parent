package com.deer.wms.workflow.model;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义任务模型
 *
 * @author luxin.yan
 * @date 2019/2/12
 */
public class TaskModel implements Serializable {
    private String id;//任务ID
    private String doUserId;//任务的处理人
    private String name;//任务的名称
    private List<TaskModel> appendTaskList;//追加任务,同级为并行任务，字级为串行任务

    public TaskModel(String id, String doUserId, String name) {
        this.id = id;
        this.doUserId = doUserId;
        this.name = name;
    }

    public TaskModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoUserId() {
        return doUserId;
    }

    public void setDoUserId(String doUserId) {
        this.doUserId = doUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<TaskModel> getAppendTaskList() {
        return appendTaskList;
    }

    public void setAppendTaskList(List<TaskModel> appendTaskList) {
        this.appendTaskList = appendTaskList;
    }

    public void setIdBydefultId(String defultId) {
        this.id = defultId;
        int index = 0;
        if (this.appendTaskList != null) {
            for (TaskModel taskModel : this.appendTaskList) {
                taskModel.setIdBydefultId(defultId + index);
                index++;
            }
        }
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id='" + id + '\'' +
                ", doUserId='" + doUserId + '\'' +
                ", name='" + name + '\'' +
                ", appendTaskList=" + appendTaskList +
                '}';
    }
}
