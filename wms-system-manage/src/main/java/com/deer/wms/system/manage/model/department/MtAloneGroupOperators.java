package com.deer.wms.system.manage.model.department;

import java.util.List;

public class MtAloneGroupOperators {

    private List<MtAloneGroupOperator> mtAloneGroupOperators;

    private Integer groupId;

    public List<MtAloneGroupOperator> getMtAloneGroupOperators() {
        return mtAloneGroupOperators;
    }

    public void setMtAloneGroupOperators(List<MtAloneGroupOperator> mtAloneGroupOperators) {
        this.mtAloneGroupOperators = mtAloneGroupOperators;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
