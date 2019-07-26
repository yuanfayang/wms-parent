package com.deer.wms.base.system.web;

import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.base.system.model.ClientManage;
import com.deer.wms.base.system.model.ClientManageCriteria;
import com.deer.wms.base.system.model.ClientManageParams;
import com.deer.wms.base.system.service.ClientManageService;
import com.deer.wms.project.seed.util.DateUtils;
import com.deer.wms.project.seed.util.RandomNo;
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
 * Created by on 2018/07/04.
 */
@RestController
@RequestMapping("/client/manages")
@Api(description = "客户管理接口")
public class ClientManageController {

	@Autowired
	private ClientManageService clientManageService;

	@PostMapping("/insert")
	@ApiOperation(value = "添加客户信息", notes = "添加客户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	public Result<?> add(@RequestBody ClientManage clientManage, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}

		Integer companyId = currentUser.getCompanyId();
		clientManage.setCompanyId(companyId);
		clientManage.setState("normal");

		String clientCode = "KH" + currentUser.getCompanyId() + RandomNo.createTimeString().substring(2, 14);
		clientManage.setClientCode(clientCode);
		String nowDate = DateUtils.getNowDateTimeString();
		clientManage.setCreateTime(nowDate);
		clientManageService.save(clientManage);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/delete")
	@ApiOperation(value = "删除客户信息", notes = "删除客户信息")
	public Result<?> delete(String clientCode, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		Integer companyId;
		ClientManageCriteria criteria = new ClientManageCriteria();
		criteria.setClientCode(clientCode);
		if (currentUser.getCompanyType() != -1) {
			companyId = currentUser.getCompanyId();
			criteria.setCompanyId(companyId);
		}
		clientManageService.deleteByCodeAndCom(criteria);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "删除客户信息", notes = "删除客户信息")
	public Result<?> delete(@PathVariable Integer id, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		Integer companyId;
		ClientManageParams params = new ClientManageParams();
		params.setClientId(id);
		companyId = currentUser.getCompanyId();
		params.setCompanyId(companyId);
		clientManageService.deleteByIdAndCom(params);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@PostMapping("/update")
	@ApiOperation(value = "更新客户信息", notes = "更新客户信息")
	public Result<?> update(@RequestBody ClientManage clientManage, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		// if (currentUser.getCompanyType() != -1) {
		// Integer companyId = currentUser.getCompanyId();
		// clientManage.setCompanyId(companyId);
		// }
		clientManageService.update(clientManage);
		return ResultGenerator.genSuccessResult();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/detail")
	@ApiOperation(value = "单客户信息查询", notes = "单客户信息查询")
	public Result<?> detail(Integer id, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		ClientManage clientManage = clientManageService.findById(id);
		return ResultGenerator.genSuccessResult(clientManage);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/list")
	@ApiOperation(value = "客户息查询列表", notes = "客户息查询列表")
	public Result<?> list(ClientManageCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		if (currentUser.getCompanyType() != -1) {
			Integer companyId = currentUser.getCompanyId();
			criteria.setCompanyId(companyId);
		}

		PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
		List<ClientManage> list = clientManageService.findList(criteria);
		PageInfo<ClientManage> pageInfo = new PageInfo<ClientManage>(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@GetMapping("/list/new")
	@ApiOperation(value = "客户息查询列表", notes = "客户息查询列表")
	public Result<?> listNew(ClientManageParams params, @ApiIgnore @User CurrentUser currentUser) {
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
		}
		Integer companyId = currentUser.getCompanyId();
		params.setCompanyId(companyId);

		PageHelper.startPage(params.getPageNum(), params.getPageSize());
		List<ClientManage> list = clientManageService.findListNew(params);
		PageInfo<ClientManage> pageInfo = new PageInfo<ClientManage>(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
	@PostMapping("/list/new/excel")
	public Result<?> listNewExcel(@RequestBody ClientManageParams params, @ApiIgnore @User CurrentUser currentUser,
								  HttpServletRequest request, HttpServletResponse response) throws Exception{
		if (currentUser == null) {
			return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录！", null);
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

		Integer companyId = currentUser.getCompanyId();
		params.setCompanyId(companyId);

		List<ClientManage> list = clientManageService.findListNew(params);
		List<List<String>> data = new ArrayList<>();
		for (ClientManage clientManage:list){
			List<String> stringList = new ArrayList<>();
			for (int i = 0 ; i < params.getHeadersName().size() ; i++){
				if (params.getHeadersName().get(i).equals("客户名称")){
					stringList.add(clientManage.getClientName());
				}else if (params.getHeadersName().get(i).equals("联系人")){
					stringList.add(clientManage.getClientContacts());
				}else if (params.getHeadersName().get(i).equals("电话")){
					stringList.add(clientManage.getContactPhone());
				}else if (params.getHeadersName().get(i).equals("地址")) {
					stringList.add(clientManage.getClientSite());
				}else if (params.getHeadersName().get(i).equals("邮箱")) {
					stringList.add(clientManage.getEmail());
				}else if (params.getHeadersName().get(i).equals("传真")) {
					stringList.add(clientManage.getFax());
				}else if (params.getHeadersName().get(i).equals("创建时间")) {
					stringList.add(clientManage.getCreateTime());
				}else if (params.getHeadersName().get(i).equals("备注")) {
					stringList.add(clientManage.getMemo());
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
		String fileName = "客户Excel.xlsx";


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
	@PostMapping("/list/new/excel/import")
	public Result listNewExcelImport(@ApiIgnore @User CurrentUser currentUser,@RequestParam("file") MultipartFile file) throws Exception{

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

		List<ClientManage> list = new ArrayList<>();
		for (int i=firstRowNum ; i<lastRowNum+1 ; i++) {
			Row row = sheet.getRow(i);
			//获取当前最后单元格列号
			int lastCellNum = row.getLastCellNum();
			ClientManage clientManage = new ClientManage();
			clientManage.setClientCode("KH" + currentUser.getCompanyId() + RandomNo.createTimeString().substring(2, 14));
			clientManage.setCompanyId(currentUser.getCompanyId());
			clientManage.setCreateTime(DateUtils.getNowDateTimeString());
			clientManage.setState("normal");
			for (int j=0 ; j<lastCellNum ; j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (j == 0 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setClientName(cell.getStringCellValue());
				}else if (j == 1 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setEmail(cell.getStringCellValue());
				}else if (j == 2 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setClientSite(cell.getStringCellValue());
				}else if (j == 3 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setFax(cell.getStringCellValue());
				}else if (j == 4 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setClientContacts(cell.getStringCellValue());
				}else if (j == 5 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setMemo(cell.getStringCellValue());
				}else if (j == 6 && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")) {
					clientManage.setContactPhone(cell.getStringCellValue());
				}else {

				}
			}
			list.add(clientManage);
		}

		clientManageService.save(list);

		return ResultGenerator.genSuccessResult();
	}

}
