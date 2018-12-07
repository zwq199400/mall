package com.mall.controller;

import com.mall.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 导入商品数据到索引库
 * @author zwq
 */
@Controller
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping("/index/item/import")
	@ResponseBody
	public String importItemList() {
		String result = searchItemService.importAllItems();
		return result;
		
	}
}
