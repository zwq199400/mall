package com.mall.content.service.impl;

import java.util.Date;
import java.util.List;

import com.mall.content.service.ContentService;
import com.mall.mapper.TbContentMapper;
import com.mall.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 内容管理Service
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public String addContent(TbContent content) {
		//将内容数据插入到内容表
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入到数据库
		contentMapper.insert(content);
		return "success";
	}

	@Override
	public List<TbContent> getContentListByCid(long cid) {
		//执行查询
		List<TbContent> list = contentMapper.selectByCid(cid);
		return list;
	}

}
