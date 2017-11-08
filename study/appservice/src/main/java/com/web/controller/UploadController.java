package com.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.base.model.AjaxJson;

/**
 * 
 * @Title: UploadController.java
 * @Package com.web.controller
 * @Description: 文件上传
 * @author xsx
 * @date 2017年10月27日 下午4:40:40
 * @version V1.0
 */
//TODO
@Controller
@RequestMapping("/upload")
public class UploadController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("manager/upload/index");
	}
	
	@RequestMapping("/uploadUI")
	public ModelAndView uploadUI() {
		return new ModelAndView("manager/upload/edit");
	}

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
		AjaxJson json = new AjaxJson();
		// 保存路径
		String path = "C:\\report";
		if (file != null) {
			String oldFileName = file.getOriginalFilename();
			File targetFile = new File(path, oldFileName);
			try {
				file.transferTo(targetFile);
				json.setMessage("upload success...");
				json.setSuccess(true);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				json.setMessage("upload fail...");
				json.setSuccess(false);
				e.printStackTrace();
			}
		}
		return json;
	}
}
