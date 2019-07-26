package com.deer.wms.base.system.web;

import com.deer.wms.base.system.constant.BaseSystemConstant;
import com.deer.wms.base.system.model.*;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomUtil;
import com.deer.wms.base.system.service.MtAloneColorService;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;



/**
* Created by  on 2018/11/18.
*/
@Api(description = "颜色管理接口")
@RestController
@RequestMapping("/mt/alone/colors")
public class MtAloneColorController {

    @Autowired
    private MtAloneColorService mtAloneColorService;


    @OperateLog(description = "添加颜色信息", type = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="添加颜色信息",notes="添加颜色信息")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneColor mtAloneColor,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        mtAloneColor.setCompanyId(currentUser.getCompanyId());

    	//产品条形码
    	String colorCodeRondom=RandomUtil.generateString(6);
    	mtAloneColor.setColorCode(colorCodeRondom);
        mtAloneColorService.save(mtAloneColor);
        return ResultGenerator.genSuccessResult();
    }


    //@OperateLog(description = "删除颜色信息", type = "删除")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@ApiOperation(value="删除颜色信息",notes="删除颜色信息")
    //@GetMapping("/delete")
    //public Result delete( String colorCode) {
    //    mtAloneColorService.deleteByCode(colorCode);
    //    return ResultGenerator.genSuccessResult();
    //}

    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "colorId", value = "颜色id", paramType="path", dataType="Integer", required = true)
    })
    @ApiOperation(value="删除颜色信息",notes="删除颜色信息")
    @DeleteMapping("/delete/{colorId}")
    @OperateLog(description = "删除颜色", type = "删除")
    public Result delete(@PathVariable Integer colorId, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        MtAloneColorParams params = new MtAloneColorParams();
        params.setColorId(colorId);
        params.setCompanyId(currentUser.getCompanyId());

        Integer countRelProducts = mtAloneColorService.countRelProducts(params);
        if(countRelProducts!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该颜色下有关联的货物，无法删除！",null);
        }

        mtAloneColorService.deleteByIdParams(params);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "更新颜色信息", type = "更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="更新颜色信息",notes="更新颜色信息")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneColor mtAloneColor,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        mtAloneColorService.update(mtAloneColor);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "根据ID查询颜色信息", type = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="单个颜色查询",notes="单个颜色查询")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneColor mtAloneColor = mtAloneColorService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneColor);
    }

    //@OperateLog(description = "查询颜色列表", type = "查询")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@ApiOperation(value="颜色查询列表",notes="颜色查询列表")
    //@GetMapping("/list")
    //public Result list(MtAloneColorCriteria criteria) {
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<MtAloneColor> list = mtAloneColorService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @OperateLog(description = "查询颜色列表", type = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @ApiOperation(value="颜色查询列表",notes="颜色查询列表")
    @GetMapping("/ptList")
    public Result list(MtAloneColorParams params, @ApiIgnore @User CurrentUser currentUser) {

        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneColor> list = mtAloneColorService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/ptList/excel")
    public Result listExcel(@RequestBody MtAloneColorParams params, @ApiIgnore @User CurrentUser currentUser,
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

        for (int i=0;i<titles.size();i++){
            Cell cell = headRow.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(cellStyleHead);
        }

        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        List<MtAloneColor> list = mtAloneColorService.findListNew(params);
        List<List<String>> data = new ArrayList<>();
        for (MtAloneColor mtAloneColor:list){
            List<String> stringList = new ArrayList<>();
            for (int i = 0 ; i < params.getHeadersName().size() ; i++){
                if (params.getHeadersName().get(i).equals("潘通色号")){
                    stringList.add(mtAloneColor.getPantoneCode());
                }else if (params.getHeadersName().get(i).equals("中文名称")) {
                    stringList.add(mtAloneColor.getColorNameCh());
                }else if (params.getHeadersName().get(i).equals("英文名称")) {
                    stringList.add(mtAloneColor.getColorName());
                }else if (params.getHeadersName().get(i).equals("HEX")) {
                    stringList.add(mtAloneColor.getRgbHex());
                }else if (params.getHeadersName().get(i).equals("颜色")) {
                    stringList.add(mtAloneColor.getRgbHex());
                }else if (params.getHeadersName().get(i).equals("备注")) {
                    stringList.add(mtAloneColor.getMemo());
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
        String fileName = "颜色Excel.xlsx";


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
    @PostMapping("/ptList/excel/import")
    public Result ptListExcelImport(@ApiIgnore @User CurrentUser currentUser,@RequestParam("file") MultipartFile file) throws Exception{

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

        List<MtAloneColor> list = new ArrayList<>();
        for (int i=firstRowNum ; i<lastRowNum +1; i++) {
            Row row = sheet.getRow(i);
            //获取当前最后单元格列号
            int lastCellNum = row.getLastCellNum();
            MtAloneColor mtAloneColor = new MtAloneColor();
            mtAloneColor.setCompanyId(currentUser.getCompanyId());
            mtAloneColor.setColorCode(RandomUtil.generateString(6));
            for (int j=0 ; j<lastCellNum; j++) {
                Cell cell = row.getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (j == 0 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneColor.setColorName(cell.getStringCellValue());
                }else if (j == 1 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneColor.setRgbHex(cell.getStringCellValue());
                }else if (j == 2 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneColor.setColorNameCh(cell.getStringCellValue());
                }else if (j == 3 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneColor.setPantoneCode(cell.getStringCellValue());
                }else if (j == 4 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
                    mtAloneColor.setMemo(cell.getStringCellValue());
                }else {

                }
            }
            list.add(mtAloneColor);
        }

        mtAloneColorService.save(list);

        return ResultGenerator.genSuccessResult();
    }

    //@OperateLog(description = "根据潘通色号查颜色列表", type = "查询")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@ApiOperation(value="根据潘通色号查颜色列表",notes="根据潘通色号查颜色列表")
    //@GetMapping("/ptList")
    //public Result findListByPTCode(MtAloneColorCriteria criteria) {
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<MtAloneColor> list = mtAloneColorService.findListByPTCode(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}
}
