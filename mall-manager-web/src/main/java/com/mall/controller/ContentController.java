package com.mall.controller;

import com.mall.content.service.ContentService;
import com.mall.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 内容管理Controller
 * @author zwq
 * @date 2018/11/8 17:08
 */
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;

	@RequestMapping(value="/content/save", method=RequestMethod.POST)
	@ResponseBody
	public String addContent(TbContent content) {
		//调用服务把内容数据保存到数据库
		String result = contentService.addContent(content);
		return result;
	}
}
