package com.mall.content.controller;

import java.util.List;

import com.mall.content.service.ContentService;
import com.mall.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页展示Controller
 * @author zwq
 * @date 2018/11/8 17:08
 */
@Controller
public class IndexController {
	
	@Value("${CONTENT_LUNBO_ID}")
	private Long contentID;
	
	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		//查询内容列表
		List<TbContent> ad1List = contentService.getContentListByCid(contentID);
		// 把结果传递给页面
		model.addAttribute("ad1List", ad1List);
		return "index";
	}
}
