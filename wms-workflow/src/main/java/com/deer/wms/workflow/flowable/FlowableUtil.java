package com.deer.wms.workflow.flowable;

import com.deer.wms.workflow.common.SpringContextUtil;

/**
 * FlowableUtil
 *
 * @author luxin.yan
 * @date 2019/1/24
 **/
public class FlowableUtil {

    private static CustomFlowableProperties customFlowableProperties;

    public static CustomFlowableProperties getCustomFlowableProperties() {
        if (customFlowableProperties == null) {
            customFlowableProperties = (CustomFlowableProperties) SpringContextUtil.getBean("customFlowableProperties");
        }
        return customFlowableProperties;
    }
}
