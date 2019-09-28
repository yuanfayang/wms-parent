package com.deer.wms.produce.manage.web;

import com.deer.wms.base.system.model.ItemType;
import com.deer.wms.base.system.model.MtAloneColor;
import com.deer.wms.base.system.model.MtAloneColorParams;
import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.base.system.service.ItemTypeService;
import com.deer.wms.base.system.service.SupplierManageService;
import com.deer.wms.produce.manage.model.MtAloneStockProductVo;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MtAloneStockProduct;
import com.deer.wms.produce.manage.model.MtAloneStockProductParams;
import com.deer.wms.produce.manage.service.MtAloneStockProductService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List; 



/**
* Created by  on 2019/09/06.
*/
@Api(description = "货物供应信息接口")
@RestController
@RequestMapping("/mt/alone/stock/products")
public class MtAloneStockProductController {

    @Autowired
    private MtAloneStockProductService mtAloneStockProductService;

    @Autowired
    private SupplierManageService supplierManageService;

    @Autowired
    private ItemTypeService itemTypeService;


    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneStockProduct mtAloneStockProduct, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        mtAloneStockProduct.setCreateTime(new Date());
        mtAloneStockProduct.setCompanyId(currentUser.getCompanyId());
        mtAloneStockProductService.save(mtAloneStockProduct);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneStockProductService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneStockProduct mtAloneStockProduct) {
        mtAloneStockProduct.setUpdateTime(new Date());
        mtAloneStockProductService.update(mtAloneStockProduct);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneStockProduct mtAloneStockProduct = mtAloneStockProductService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneStockProduct);
    }

    @GetMapping("/list")
    public Result list(MtAloneStockProductParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

    	if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
    		params.setCompanyId(currentUser.getCompanyId());
		}else{
			params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneStockProduct> list = mtAloneStockProductService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list/part")
    public Result listPart(MtAloneStockProductParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
            params.setCompanyId(currentUser.getCompanyId());
        }else{
            params.setCompanyId(null);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneStockProduct> list = mtAloneStockProductService.findListPart(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * excel数据导入数据库
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/ptList/excel/import")
    public Result ptListExcelImport(@ApiIgnore @User CurrentUser currentUser,@RequestParam("file") MultipartFile file) throws Exception{

        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        String fileName = file.getOriginalFilename().substring(begin, last);
        InputStream input = file.getInputStream();

//        Workbook workbook = null;
//        if(fileName.endsWith(".xls")){
//            workbook = new HSSFWorkbook(input);
//        }else if(fileName.endsWith(".xlsx")){
//            workbook = new XSSFWorkbook(input);
//        }

        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(input);
        } catch (Exception ex) {
            workbook = new HSSFWorkbook(input);
        }


        //获取sheet页
        Sheet sheet = workbook.getSheetAt(0);

        int firstRowNum = 1;

        int lastRowNum = sheet.getLastRowNum();

        List<MtAloneStockProductVo> stockProductVoList = new ArrayList<>();
        for (int i=firstRowNum ; i<lastRowNum +1; i++) {
            Row row = sheet.getRow(i);
            //获取当前最后单元格列号
            int lastCellNum = row.getLastCellNum();
            MtAloneStockProductVo mtAloneStockProductVo = new MtAloneStockProductVo();
            mtAloneStockProductVo.setCompanyId(currentUser.getCompanyId());
            for (int j=0 ; j<lastCellNum; j++) {
                Cell cell = row.getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (j == 0 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setFirstLargeClass(cell.getStringCellValue());
                }else if (j == 1 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setItemCode(cell.getStringCellValue());
                }else if (j == 2 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setProductCode(cell.getStringCellValue());
                }else if (j == 3 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setStockProduct(cell.getStringCellValue());
                }else if (j == 4 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setProductChaName(cell.getStringCellValue());
                }else if (j == 5 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setSort(cell.getStringCellValue());
                }else if (j == 6 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setWareNum(cell.getStringCellValue());
                }else if (j == 7 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setFactureInventory(cell.getStringCellValue());
                }else if (j == 8 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setLarghezza(cell.getStringCellValue());
                }else if (j == 9 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setCostPrice(cell.getStringCellValue());
                }else if (j == 10 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setMarketPrice(cell.getStringCellValue());
                }else if (j == 11 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setDominant(cell.getStringCellValue());
                }else if (j == 12 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setDensity(cell.getStringCellValue());
                }else if (j == 13 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setSpecification(cell.getStringCellValue());
                }else if (j == 14 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setTissue(cell.getStringCellValue());
                }else if (j == 15 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setProcessingMode(cell.getStringCellValue());
                }else if (j == 16 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setColorCode(cell.getStringCellValue());
                }else if (j == 17 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setSupplierCodename(cell.getStringCellValue());
                }else if (j == 18 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setSupplierName(cell.getStringCellValue());
                }else if (j == 19 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setSupplierContacts(cell.getStringCellValue());
                }else if (j == 20 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setSupplierPhone(cell.getStringCellValue());
                }else if (j == 21 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setDeveloper(cell.getStringCellValue());
                }else if (j == 22 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneStockProductVo.setRemark(cell.getStringCellValue());
                }
            }
            stockProductVoList.add(mtAloneStockProductVo);
        }
        /*List<SupplierManage> supplierManageList = supplierManageService.findAll();
        for (MtAloneStockProductVo mtAloneStockProductVo:stockProductVoList) {
            boolean b = false;
            for (SupplierManage supplierManage:supplierManageList) {
                if (mtAloneStockProductVo.getSupplierName().equals(supplierManage.getSupplierName())) {
                    b=true;
                    mtAloneStockProductVo.setSupplierId(supplierManage.getSupplierId());
                }
            }
            if (!b) {
                SupplierManage supplierManage1 = new SupplierManage();
                supplierManage1.setSupplierName(mtAloneStockProductVo.getSupplierName());
                supplierManageService.save(supplierManage1);
                mtAloneStockProductVo.setSupplierId(supplierManage1.getSupplierId());
            }
        }
        List<ItemType> itemTypeList = itemTypeService.findAll();
        for (MtAloneStockProductVo mtAloneStockProductVo:stockProductVoList) {
            boolean b = false;
            for (ItemType itemType:itemTypeList) {
                if (mtAloneStockProductVo.getItemTypeName().equals(itemType.getItemTypeName())) {
                    b = true;
                    mtAloneStockProductVo.setProductTypeId(itemType.getItemTypeId());
                }
            }
            if (!b) {
                ItemType itemType1 = new ItemType();
                itemType1.setItemTypeName(mtAloneStockProductVo.getItemTypeName());
                itemTypeService.save(itemType1);
                mtAloneStockProductVo.setProductTypeId(itemType1.getItemTypeId());
            }
            boolean c = false;
            for (ItemType itemType:itemTypeList) {
                if (mtAloneStockProductVo.getPurchaserName().equals(itemType.getItemTypeName())) {
                    c = true;
                    mtAloneStockProductVo.setProductVarietyId(itemType.getItemTypeId());
                }
            }
            if (!b) {
                ItemType itemType1 = new ItemType();
                itemType1.setItemTypeName(mtAloneStockProductVo.getPurchaserName());
                itemTypeService.save(itemType1);
                mtAloneStockProductVo.setProductVarietyId(itemType1.getItemTypeId());
            }
        }
*/
        List<MtAloneStockProduct> aloneStockProductList = new ArrayList<>();
        aloneStockProductList.addAll(stockProductVoList);
        mtAloneStockProductService.save(aloneStockProductList);
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/list/excel")
    public Result listExcel(@RequestBody MtAloneStockProductParams params, @ApiIgnore @User CurrentUser currentUser,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{

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

        System.out.println(titles.size());
        System.out.println(titles);
        for (int i=0;i<titles.size();i++){
            Cell cell = headRow.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(cellStyleHead);
        }

        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        List<MtAloneStockProduct> list = mtAloneStockProductService.findList(params);
        List<List<String>> data = new ArrayList<>();
        for (MtAloneStockProduct mtAloneStockProduct:list){
            List<String> stringList = new ArrayList<>();
            for (int i = 0 ; i < params.getHeadersName().size() ; i++){
                if (params.getHeadersName().get(i).equals("日期")) {
                    stringList.add(mtAloneStockProduct.getCreateTime().toString());
                }else if (params.getHeadersName().get(i).equals("一阶大类")) {
                    stringList.add(mtAloneStockProduct.getFirstLargeClass());
                }else if (params.getHeadersName().get(i).equals("料号")) {
                    stringList.add(mtAloneStockProduct.getItemCode());
                }else if (params.getHeadersName().get(i).equals("品号")) {
                    stringList.add(mtAloneStockProduct.getProductCode());
                }else if (params.getHeadersName().get(i).equals("原料")) {
                    stringList.add(mtAloneStockProduct.getStockProduct());
                }else if (params.getHeadersName().get(i).equals("中文品名")) {
                    stringList.add(mtAloneStockProduct.getProductChaName());
                }else if (params.getHeadersName().get(i).equals("分类")) {
                    stringList.add(mtAloneStockProduct.getSort());
                }else if (params.getHeadersName().get(i).equals("仓库数量")) {
                    stringList.add(mtAloneStockProduct.getWareNum());
                }else if (params.getHeadersName().get(i).equals("厂商库存")) {
                    stringList.add(mtAloneStockProduct.getFactureInventory());
                }else if (params.getHeadersName().get(i).equals("门幅/克重")) {
                    stringList.add(mtAloneStockProduct.getLarghezza());
                }else if (params.getHeadersName().get(i).equals("材料成本价")) {
                    stringList.add(mtAloneStockProduct.getCostPrice());
                }else if (params.getHeadersName().get(i).equals("市场报价")) {
                    stringList.add(mtAloneStockProduct.getMarketPrice());
                }else if (params.getHeadersName().get(i).equals("优势等级")) {
                    stringList.add(mtAloneStockProduct.getDominant());
                }else if (params.getHeadersName().get(i).equals("密度")) {
                    stringList.add(mtAloneStockProduct.getDensity());
                }else if (params.getHeadersName().get(i).equals("规格")) {
                    stringList.add(mtAloneStockProduct.getSpecification());
                }else if (params.getHeadersName().get(i).equals("组织")) {
                    stringList.add(mtAloneStockProduct.getTissue());
                }else if (params.getHeadersName().get(i).equals("加工方式")) {
                    stringList.add(mtAloneStockProduct.getProcessingMode());
                }else if (params.getHeadersName().get(i).equals("颜色")) {
                    stringList.add(mtAloneStockProduct.getColorCode());
                }else if (params.getHeadersName().get(i).equals("厂商编码")) {
                    stringList.add(mtAloneStockProduct.getSupplierCodename());
                }else if (params.getHeadersName().get(i).equals("厂商")) {
                    stringList.add(mtAloneStockProduct.getSupplierName());
                }else if (params.getHeadersName().get(i).equals("联系人")) {
                    stringList.add(mtAloneStockProduct.getSupplierContacts());
                }else if (params.getHeadersName().get(i).equals("联系电话")) {
                    stringList.add(mtAloneStockProduct.getSupplierPhone());
                }else if (params.getHeadersName().get(i).equals("开发人")) {
                    stringList.add(mtAloneStockProduct.getDeveloper());
                }else if (params.getHeadersName().get(i).equals("备注")) {
                    stringList.add(mtAloneStockProduct.getRemark());
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
        String fileName = "供应物Excel.xlsx";


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


    /**
     * excel模板
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value = "导出excel模板", notes = "导出excel模板")
    @PostMapping("/list/excel/model")
    public Result listExcelModel(@ApiIgnore @User CurrentUser currentUser,HttpServletRequest request,HttpServletResponse response) throws Exception{
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        List<String> titles = new ArrayList<>();
        titles.add("一阶大类");
        titles.add("料号");
        titles.add("品号");
        titles.add("原料");
        titles.add("中文品名");
        titles.add("分类");
        titles.add("仓库数量");
        titles.add("厂商库存");
        titles.add("门幅/克重");
        titles.add("材料成本");
        titles.add("市场报价");
        titles.add("优势等级");
        titles.add("密度");
        titles.add("规格");
        titles.add("组织");
        titles.add("加工方式");
        titles.add("颜色");
        titles.add("厂商编码");
        titles.add("厂商");
        titles.add("联系人");
        titles.add("联系电话");
        titles.add("开发人");
        //创建poi导出数据对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();

        //创建sheet页
        SXSSFSheet sheet = sxssfWorkbook.createSheet("sheet1");

        //创建表头
        SXSSFRow headRow = sheet.createRow(0);

        for (int i=0;i<titles.size();i++){
            Cell cell = headRow.createCell(i);
            cell.setCellValue(titles.get(i));
        }

        // 下载导出
        String fileName = "Excel.xlsx";


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


        //写入数据
        sxssfWorkbook.write(outputStream);

        // 关闭
        outputStream.close();
        sxssfWorkbook.close();

        return ResultGenerator.genSuccessResult();
    }

}
