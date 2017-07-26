package com.ssh.lose.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssh.lose.comman.Constant;
import com.ssh.lose.po.Letter;
import com.ssh.lose.po.Shop;
import com.ssh.lose.service.LetterService;
import com.ssh.lose.service.ShopService;

@Controller
public class HomeAction extends BaseAction {

	@Autowired
	private LetterService letterService;
	@Autowired
	private ShopService shopService;

	public String home() {
		// ��л��
		List<Letter> letterList = letterService.load();
		getRequest().setAttribute("letterList", letterList);
		// ����

		// ʧ����Ϣ / ������Ϣ
		List<Shop> shops = shopService.load();
		System.out.println("shopSize::"+shops.size());
		List<Shop> loseList = new ArrayList<Shop>();
		List<Shop> takeList = new ArrayList<Shop>();
		for (Shop s : shops) {
			if (s.getType().equals(Constant.SHOP_TYPE_LOSE)) {// ʧ����Ϣ
				loseList.add(s);
			}
			if (s.getType().equals(Constant.SHOP_TYPE_TAKE)) {// ������Ϣ
				takeList.add(s);
			}
		}
		getRequest().setAttribute("loses", loseList);
		getRequest().setAttribute("takes", takeList);
		return "home";
	}
}
