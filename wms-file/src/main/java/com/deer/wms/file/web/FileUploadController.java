package com.deer.wms.file.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.deer.wms.file.model.FileInfo;
import com.deer.wms.file.service.FileService;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;

/**
 * Description:
 * 
 * @author gtt
 * @date 2019年2月1日
 * @version 1.0
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private FileService fileService;

	@PostMapping("/upload")
	@ResponseBody
	public Result<?> upload(@RequestParam("file") MultipartFile file) {
		LOGGER.info("=================file=====================");
		if (file.isEmpty()) {
			return ResultGenerator.genFailResult(CommonCode.UPLOAD_FILE_ERROR);
		}
		LOGGER.info("[文件类型] - [{}]", file.getContentType());
		LOGGER.info("[文件名称] - [{}]", file.getOriginalFilename());
		LOGGER.info("[文件大小] - [{}]", file.getSize());
		String filePath = "";
		FileInfo dest = fileService.createFile(file, filePath, true);
		LOGGER.info("上传成功");
		return ResultGenerator.genSuccessResult(dest);
	}

}
