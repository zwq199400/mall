package com.mall.content.service;

import com.mall.pojo.TbContent;

import java.util.List;
/**
 * @author zwq
 * @date 2018/11/8 17:08
 */
public interface ContentService {

	String addContent(TbContent content);

	/**
	 * 根据内容分类id查询内容列表
	 * @param cid 内容分类id
	 * @return
	 */
	List<TbContent> getContentListByCid(long cid);
}
