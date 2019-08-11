package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneUserTask;
import com.deer.wms.bill.manage.model.MtAloneUserTaskParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneUserTaskMapper extends Mapper<MtAloneUserTask> {
    List<MtAloneUserTask> findList(MtAloneUserTaskParams params);
}