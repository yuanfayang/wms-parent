package com.deer.wms.workflow.command;

import org.flowable.engine.impl.persistence.entity.ExecutionEntity;

/**
 * LoopVariableUtili
 *
 * @author luxin.yan
 * @date 2019/1/12
 **/
public class LoopVariableUtili {

    public static void setLoopVariable(ExecutionEntity executionEntity, String variableName, Object value) {
        ExecutionEntity parentE = executionEntity.getParent();
        parentE.setVariable(variableName, value);
    }

    public static Integer getLoopVariable(ExecutionEntity executionEntity, String variableName) {
        Object value = executionEntity.getVariable(variableName);
        ExecutionEntity parentE = executionEntity.getParent();
        while (value != null && parentE != null) {
            value = parentE.getVariable(variableName);
            parentE = parentE.getParent();
        }
        return (Integer) (value != null ? value : 0);
    }
}
