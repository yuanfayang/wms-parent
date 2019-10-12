package com.deer.wms.produce.manage.constant;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;

import java.text.DecimalFormat;

/**
 * @Author: weihongyang
 * @Date: 2019/10/12 13:51
 * @Version 1.0
 */
public class ExcelUtils {
    /**
     *对excel单元格数据进行类型匹配
     */
    private String getCellValue(Cell cell){
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                cellValue =cell.getRichStringCellValue().getString().trim();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                cellValue =df.format(cell.getNumericCellValue()).toString();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue =String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellValue =cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }
}
