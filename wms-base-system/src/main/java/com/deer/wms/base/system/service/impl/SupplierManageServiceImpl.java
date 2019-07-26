package com.deer.wms.base.system.service.impl;

import com.deer.wms.base.system.dao.SupplierManageMapper;
import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.base.system.model.SupplierManageParams;
import com.deer.wms.base.system.service.SupplierManageService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created by  on 2018/07/04.
 */
@Service
@Transactional
public class SupplierManageServiceImpl extends AbstractService<SupplierManage, Integer> implements SupplierManageService {

    @Autowired
    private SupplierManageMapper supplierManageMapper;

    @Override
    public void deleteByCodeAndCom(SupplierManageCriteria criteria) {
        supplierManageMapper.deleteByCodeAndCom(criteria);
    }

    @Override
    public List<SupplierManage> findList(SupplierManageCriteria criteria) {
        return supplierManageMapper.findList(criteria);
    }

    @Override
    public List<SupplierManage> findListNew(SupplierManageParams params) {
        return supplierManageMapper.findListNew(params);
    }

    @Override
    public void deleteByIdAndCom(SupplierManageParams params) {
        supplierManageMapper.deleteByIdAndCom(params);
    }

    @Override
    public Integer countRelProducts(SupplierManageParams params) {
        return supplierManageMapper.countRelProducts(params);
    }

    @Override
    public Integer listExcelImport(String fileName, MultipartFile file) throws Exception{
        boolean notNull = false;
        Integer status = 1;
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            String error = "上传文件格式不正确";
            status = 0;
            return status;
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
        for (int r = 1; r < sheet.getLastRowNum()-1; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//设置读取转String类型
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
        }
        return null;
    }
}
