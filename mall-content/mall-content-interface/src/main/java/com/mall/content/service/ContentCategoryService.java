package com.mall.content.service;

import com.mall.common.pojo.TreeNode;

import java.util.List;

/**
 * @author zwq
 * @date 2018/11/8 17:08
 */
public interface ContentCategoryService {

	List<TreeNode> getContentCatList(long parentId);
	String addContentCategory(long parentId, String name);
}
