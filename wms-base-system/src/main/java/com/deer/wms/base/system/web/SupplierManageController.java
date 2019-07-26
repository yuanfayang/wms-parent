package com.deer.wms.base.system.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.base.system.model.SupplierManageParams;
import com.deer.wms.base.system.service.SupplierManageService;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.DateUtils;
import com.deer.wms.project.seed.util.RandomNo;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

/**
* Created by  on 2018/07/04.
*/
@RestController
@Api(description = "供应商管理接口")
@RequestMapping("/supplier/manages")
public class SupplierManageController {

    @Autowired
    private SupplierManageService supplierManageService;

    @PostMapping("/insert")
    @ApiOperation(value="添加供应商信息",notes="添加供应商信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    public Result add(@RequestBody SupplierManage supplierManage,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        Integer companyId    = currentUser.getCompanyId();
        supplierManage.setCompanyId(companyId);

        String  supplierCode="GYS"+currentUser.getCompanyId()+RandomNo.createTimeString().substring(2,14);
        supplierManage.setSupplierCode(supplierCode);
        String nowDate = DateUtils.getNowDateTimeString();
        supplierManage.setCreateTime(nowDate);
        supplierManageService.save(supplierManage);
        return ResultGenerator.genSuccessResult();
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/delete")
    //@ApiOperation(value="删除供应商信息",notes="删除供应商信息")
    //public Result delete( String supplierCode,@ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    Integer companyId ;
    //    SupplierManageCriteria criteria = new SupplierManageCriteria();
    //    criteria.setSupplierCode(supplierCode);
    //    if(currentUser.getCompanyType() != -1){
    //        companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    supplierManageService.deleteByCodeAndCom(criteria);
    //    return ResultGenerator.genSuccessResult();
    //}

    /**
     * 只能删除无货的供应商
     * @param supplierId
     * @param currentUser
     * @return
     */
    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "supplierId", value = "供应商id", paramType="path", dataType="Integer", required = true)
    })
    @DeleteMapping("/delete/{supplierId}")
    @ApiOperation(value="删除供应商信息",notes="删除供应商信息")
    @OperateLog(description = "删除供应商", type = "删除")
    public Result delete( @PathVariable Integer supplierId, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        SupplierManageParams params = new SupplierManageParams();
        params.setSupplierId(supplierId);
        params.setCompanyId(currentUser.getCompanyId());
        Integer countRelProducts = supplierManageService.countRelProducts(params);//统计关联产品数
        if(countRelProducts!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该供应商有货，无法删除！",null);
        }

        supplierManageService.deleteByIdAndCom(params);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/update")
    @ApiOperation(value="更新供应商信息",notes="更新供应商信息")
    public Result update(@RequestBody SupplierManage supplierManage, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        supplierManage.setCompanyId(currentUser.getCompanyId());
        supplierManageService.update(supplierManage);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/detail")
    @ApiOperation(value="单供应商信息查询",notes="单供应商信息查询")
    public Result detail( Integer id, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        SupplierManage supplierManage = supplierManageService.findById(id);
        return ResultGenerator.genSuccessResult(supplierManage);
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/list")
    //@ApiOperation(value="供应商信息查询列表",notes="供应商信息查询列表")
    //public Result list(SupplierManageCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
    //
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    if(currentUser.getCompanyType() != -1){
    //        Integer companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<SupplierManage> list = supplierManageService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/list")
    @ApiOperation(value="供应商信息查询列表",notes="供应商信息查询列表")
    public Result listNew(SupplierManageParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<SupplierManage> list = supplierManageService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/list/excel")
    public Result listNewExcel(@RequestBody SupplierManageParams params, @ApiIgnore @User CurrentUser currentUser,
                               HttpServletRequest request, HttpServletResponse response) throws  Exception{
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        List<String> titles = params.getHeadersName();

        //创建poi导出数据对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();

        //创建sheet页
        SXSSFSheet sheet = sxssfWorkbook.createSheet("sheet1");

        CellStyle cellStyle = sxssfWorkbook.createCellStyle();
        //设置居中
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        //设置边框
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框

        CellStyle cellStyleHead = sxssfWorkbook.createCellStyle();
        //设置居中
        cellStyleHead.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        //设置边框
        cellStyleHead.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
        cellStyleHead.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
        cellStyleHead.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
        cellStyleHead.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框

        XSSFFont font = (XSSFFont)sxssfWorkbook.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 这是字体加粗
        cellStyleHead.setFont(font);

        //创建表头
        SXSSFRow headRow = sheet.createRow(0);

        for (int i=0;i<titles.size();i++){
            Cell cell = headRow.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(cellStyleHead);
        }


        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        List<SupplierManage> list = supplierManageService.findListNew(params);
        List<List<String>> data = new ArrayList<>();
        for (SupplierManage supplierManage:list){
            List<String> stringList = new ArrayList<>();
            for (int i = 0 ; i < params.getHeadersName().size() ; i++){
                if (params.getHeadersName().get(i).equals("名称")){
                    stringList.add(supplierManage.getSupplierName());
                }else if (params.getHeadersName().get(i).equals("联系人")) {
                    stringList.add(supplierManage.getSupplierContacts());
                }else if (params.getHeadersName().get(i).equals("电话")) {
                    stringList.add(supplierManage.getSupplierPhone());
                }else if (params.getHeadersName().get(i).equals("地址")) {
                    stringList.add(supplierManage.getSupplierSite());
                }else if (params.getHeadersName().get(i).equals("邮箱")) {
                    stringList.add(supplierManage.getSupplierEmail());
                }else if (params.getHeadersName().get(i).equals("传真")) {
                    stringList.add(supplierManage.getSupplierFax());
                }else if (params.getHeadersName().get(i).equals("创建时间")) {
                    stringList.add(supplierManage.getCreateTime());
                }else {

                }
            }
            data.add(stringList);
        }
        Cell cell = null;
        if(!CollectionUtils.isEmpty(data)){
            for (int i=0;i<data.size();i++) {
                //填充数据
                SXSSFRow dataRow = sheet.createRow(i + 1);
                for (int j=0;j<titles.size();j++) {
                    cell = dataRow.createCell(j);
                    cell.setCellValue(data.get(i).get(j));
                    cell.setCellStyle(cellStyle); // 单元格的样式
                }
            }
        }

        // 下载导出
        String fileName = "供应商Excel.xlsx";


        // 解决文件乱码
        final String userAgent = request.getHeader("user-agent");
        if (userAgent != null && userAgent.indexOf("Firefox") >= 0
                || userAgent.indexOf("Chrome") >= 0 || userAgent.indexOf("Safari") >= 0) {
            fileName = new String(fileName.getBytes(), "ISO8859-1");
        } else {
            fileName = URLEncoder.encode(fileName, "UTF8"); // 其他浏览器
        }

        // 设置头信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);


        //创建一个输出流
        ServletOutputStream outputStream = response.getOutputStream();

        response.flushBuffer();

        //写入数据
        sxssfWorkbook.write(outputStream);

        // 关闭
        outputStream.close();
        sxssfWorkbook.close();

        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/list/excel/import")
    public Result listExcelImport(@ApiIgnore @User CurrentUser currentUser,@RequestParam("file") MultipartFile file) throws Exception{

        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        String fileName = file.getOriginalFilename().substring(begin, last);
        InputStream input = file.getInputStream();

        Workbook workbook = null;
        if(fileName.endsWith(".xls")){
            workbook = new HSSFWorkbook(input);
        }else if(fileName.endsWith(".xlsx")){
            workbook = new XSSFWorkbook(input);
        }


        //获取sheet页
        Sheet sheet = workbook.getSheetAt(0);

        int firstRowNum = 1;

        int lastRowNum = sheet.getLastRowNum();

        List<SupplierManage> list = new ArrayList<>();
        for (int i=firstRowNum ; i<lastRowNum +1 ; i++) {
            Row row = sheet.getRow(i);
            //获取当前最后单元格列号
//            List<String> list = new ArrayList<>();
            int lastCellNum = row.getLastCellNum();
            SupplierManage supplierManage = new SupplierManage();
            supplierManage.setCompanyId(currentUser.getCompanyId());
            supplierManage.setSupplierCode("GYS"+currentUser.getCompanyId()+RandomNo.createTimeString().substring(2,14));
            supplierManage.setCreateTime(DateUtils.getNowDateTimeString());
            for (int j=0 ; j<lastCellNum ; j++) {
                Cell cell = row.getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (j == 0 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierName(cell.getStringCellValue());
                }else if (j == 1 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierEmail(cell.getStringCellValue());
                }else if (j == 2 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierSite(cell.getStringCellValue());
                }else if (j == 3 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierFax(cell.getStringCellValue());
                }else if (j == 4 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierContacts(cell.getStringCellValue());
                }else if (j == 5 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setMemo(cell.getStringCellValue());
                }else if (j == 6 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierPhone(cell.getStringCellValue());
                }else if (j == 7 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    supplierManage.setSupplierCodeName(cell.getStringCellValue());
                }
            }
            list.add(supplierManage);
        }

        supplierManageService.save(list);

        return ResultGenerator.genSuccessResult();
    }

}
