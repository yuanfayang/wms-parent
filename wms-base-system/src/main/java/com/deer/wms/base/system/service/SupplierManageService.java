package com.deer.wms.base.system.service;
import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.base.system.model.SupplierManageParams;
import com.deer.wms.project.seed.core.service.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Created by  on 2018/07/04.
 */
public interface SupplierManageService extends Service<SupplierManage, Integer> {
    void  deleteByCodeAndCom(SupplierManageCriteria criteria);
    List<SupplierManage> findList(SupplierManageCriteria criteria);

    List<SupplierManage> findListNew(SupplierManageParams params);

    void deleteByIdAndCom(SupplierManageParams params);

    Integer countRelProducts(SupplierManageParams params);

    Integer listExcelImport(String fileName, MultipartFile file) throws Exception;

}
