package com.deer.wms.workflow.dto;

import lombok.Data;
import org.flowable.form.api.FormInfo;

import java.util.Date;

/**
 * FormResultDTO
 * 表单信息
 *
 * @author luxin.yan
 * @date 2019/4/30
 **/
@Data
public class FormResultDTO {
    private String taskId;
    /**
     * 任务名称
     */
    private String taskName;
    private String userId;
    /**
     * 用户名称
     **/
    private String userName;

    private FormInfo formInfo;
    /**
     * 处理时间
     */
    private Date endDate;
}
