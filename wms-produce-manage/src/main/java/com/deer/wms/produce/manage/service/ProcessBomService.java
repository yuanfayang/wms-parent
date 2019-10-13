package com.deer.wms.produce.manage.service;


import com.deer.wms.produce.manage.model.ProcessBom;
import com.deer.wms.produce.manage.model.ProcessBomParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guo on 2019/07/18.
 */
public interface ProcessBomService extends Service<ProcessBom, Integer> {
    List<ProcessBom> findList(ProcessBomParams params);

    List<ProcessBom> findListById(ProcessBomParams params);

    void addProcessToProduct(ProcessBomParams params);

    List<ProcessBom> findListByProductBomId(ProcessBomParams params);
}
