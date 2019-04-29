package com.deer.wms.workflow.model;

import java.io.Serializable;

/**
 * ProcessDefinitionVO
 *
 * @author luxin.yan
 * @date 2019/3/2
 **/
public class ProcessDefinitionVO implements Serializable {
    private String id;
    private String key;
    private int version;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProcessDefinitionVO{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }
}
