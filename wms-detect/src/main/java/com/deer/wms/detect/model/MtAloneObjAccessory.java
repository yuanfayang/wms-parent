package com.deer.wms.detect.model;

import javax.persistence.*;

@Table(name = "mt_alone_obj_accessory")
public class MtAloneObjAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品或者其他id
     */
    @Column(name = "obj_id")
    private Integer objId;

    /**
     * 附件id
     */
    @Column(name = "accessory_id")
    private Integer accessoryId;

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
     * 获取产品或者其他id
     *
     * @return obj_id - 产品或者其他id
     */
    public Integer getObjId() {
        return objId;
    }

    /**
     * 设置产品或者其他id
     *
     * @param objId 产品或者其他id
     */
    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    /**
     * 获取附件id
     *
     * @return accessory_id - 附件id
     */
    public Integer getAccessoryId() {
        return accessoryId;
    }

    /**
     * 设置附件id
     *
     * @param accessoryId 附件id
     */
    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }
}