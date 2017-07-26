package com.ssh.lose.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.ssh.lose.comman.Constant;
import com.ssh.lose.po.Shop;
import com.ssh.lose.po.User;
import com.ssh.lose.util.DateHelper;

@Controller
public class ShopAction extends BaseAction {

	private String type; // 丢失/拾到
	private Shop shop;
	private int id;

	private List<File> file; // 上传的文件
	private List<String> fileFileName;
	private List<String> dataUrl;

	/**
	 * 添加丟失物品信息頁面
	 * 
	 * @return
	 */
	public String addUI() {
		return type;
	}

	/**
	 * 添加丢失物品信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addLose() throws Exception {
		if (shop != null) {
			shop.setState(Constant.SHOP_STATE_OK);
			shop.setCreate_time(DateHelper.getNowDate("yyyy-MM-dd HH:mm:ss"));
			shop.setLast_update_time(DateHelper.getNowDate("yyyy-MM-dd HH:mm:ss"));
			if (file.size() > 0) {
				for (int i = 0; i < file.size(); i++) {
					shop.setPic(upload(i));
				}
			}
			shopService.save(shop);
		} else {
			getRequest().setAttribute("addMsg", "添加失败");
		}
		getRequest().setAttribute("addMsg", "添加成功");
		return "lose";
	}

	/**
	 * 添加拾到物品信息
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String addTake() throws IOException {
		if (shop != null) {
			shop.setState(Constant.SHOP_STATE_OK);
			shop.setCreate_time(DateHelper.getNowDate("yyyy-MM-dd HH:mm:ss"));
			shop.setLast_update_time(DateHelper.getNowDate("yyyy-MM-dd HH:mm:ss"));
			if (file.size() > 0) {
				for (int i = 0; i < file.size(); i++) {
					shop.setPic(upload(i));
				}
			}
			shopService.save(shop);
		} else {
			getRequest().setAttribute("addMsg", "添加失败");
		}
		getRequest().setAttribute("addMsg", "添加成功");
		return "take";
	}

	/**
	 * 查看详细信息
	 * 
	 * @return
	 */
	public String info() {
		Shop shop = shopService.get(id);
		User user = userService.get(shop.getUser_id());
		shop.getExtraInfo().put("user", user);
		getRequest().setAttribute("info", shop);
		return "info";
	}

	/**
	 * 上传图片
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	public String upload(int i) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		File destFile = null;
		try {
			dataUrl = new ArrayList<String>();
			String imgpath = "upload/";// 保存文件的路径
			is = new FileInputStream(file.get(i));
			String path = ServletActionContext.getServletContext().getRealPath("/");
			dataUrl.add(imgpath + this.getFileFileName().get(i));
			destFile = new File(path + imgpath, new Date().getTime() + "_" + this.getFileFileName().get(i));
			os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			is.close();
			os.close();
		}
		return "upload/"+destFile.getName();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<String> getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(List<String> dataUrl) {
		this.dataUrl = dataUrl;
	}

}
