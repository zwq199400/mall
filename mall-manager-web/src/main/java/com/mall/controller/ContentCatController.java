package com.mall.controller;

import java.util.List;

import com.mall.common.pojo.TreeNode;
import com.mall.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容分类管理Controller
 * @author zwq
 * @date 2018/11/8 17:08
 */
@Controller
public class ContentCatController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> getContentCatList(
			@RequestParam(name="id", defaultValue="0")Long parentId) {
		List<TreeNode> list = contentCategoryService.getContentCatList(parentId);
		return list;
	}
	
	/**
	 * 添加分类节点
	 */
	@RequestMapping(value="/content/category/create", method=RequestMethod.POST)
	@ResponseBody
	public String createContentCategory(Long parentId, String name) {
		//调用服务添加节点
		String result = contentCategoryService.addContentCategory(parentId, name);
		return result;
	}
	
	
}
