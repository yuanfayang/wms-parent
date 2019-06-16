package com.deer.wms.workflow.flowable.bpmn.model;

import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.UserTask;

/**
 * CustomUserTask
 *
 * @author luxin.yan
 * @date 2019/2/18
 **/
public class CustomUserTask extends UserTask {
    protected boolean dynamic = false;//是否动态节点
    protected FlowElement srcFlowElement;//如果是动态节点保存从哪个节点跳转过来的

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public FlowElement getSrcFlowElement() {
        return srcFlowElement;
    }

    public void setSrcFlowElement(FlowElement srcFlowElement) {
        this.srcFlowElement = srcFlowElement;
    }

    @Override
    public UserTask clone() {
        return super.clone();
    }
}
