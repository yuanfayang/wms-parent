package com.deer.wms.workflow.model;

import java.io.Serializable;
import java.util.List;

/**
 * TempActivityModel
 * 用于添加动态节点
 *
 * @author luxin.yan
 * @date 2019/2/14
 **/
public class TempActivityModel implements Serializable {
    private String firstNodeId;//在此节点后追加动态节点
    private String lastNodeId;//动态节点执行完后需要跳转的节点
    private String processDefinitionId;
    private List<TaskModel> appendTaskList;

    public TempActivityModel() {
    }

    public TempActivityModel(String nodeId, String processDefinitionId) {
        this.firstNodeId = nodeId;
        this.processDefinitionId = processDefinitionId;
    }

    public String getFirstNodeId() {
        return firstNodeId;
    }

    public void setFirstNodeId(String firstNodeId) {
        this.firstNodeId = firstNodeId;
    }

    public String getLastNodeId() {
        return lastNodeId;
    }

    public void setLastNodeId(String lastNodeId) {
        this.lastNodeId = lastNodeId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public List<TaskModel> getAppendTaskList() {
        return appendTaskList;
    }

    public void setAppendTaskList(List<TaskModel> appendTaskList) {
        this.appendTaskList = appendTaskList;
    }

    /**
     * 初始化任务ID
     */
    public void setTaskModelId() {
        int index = 0;
        for (TaskModel taskModel_1 : appendTaskList) {
            taskModel_1.setIdBydefultId(firstNodeId + index);
            index++;
        }
    }

    @Override
    public String toString() {
        return "TempActivityModel{" +
                "firstNodeId='" + firstNodeId + '\'' +
                ", lastNodeId='" + lastNodeId + '\'' +
                ", processDefinitionId='" + processDefinitionId + '\'' +
                ", appendTaskList=" + appendTaskList +
                '}';
    }
}
