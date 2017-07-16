package com.ssh.lose.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller
public class UploadAction extends BaseAction {

	private String username;

	private String password;

	private List<File> file;

	private List<String> fileFileName;


	private List<String> dataUrl;

	public String upload() throws Exception {
		dataUrl = new ArrayList<String>();
		String imgpath = "upload/";
		for (int i = 0; i < file.size(); ++i) {
			InputStream is = new FileInputStream(file.get(i));

			String path = ServletActionContext.getServletContext().getRealPath("/");
			System.out.println(path);
			// String root = "D:\\";

			dataUrl.add(imgpath + this.getFileFileName().get(i));
			File destFile = new File(path + imgpath, new Date().getTime()+"_"+this.getFileFileName().get(i));
			OutputStream os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		}
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public List<String> getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(List<String> dataUrl) {
		this.dataUrl = dataUrl;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	
}
