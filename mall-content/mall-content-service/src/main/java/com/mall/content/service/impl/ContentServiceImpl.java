package com.mall.content.service.impl;

import java.util.Date;
import java.util.List;

import com.mall.common.jedis.JedisClient;
import com.mall.common.utils.JsonUtils;
import com.mall.content.service.ContentService;
import com.mall.mapper.TbContentMapper;
import com.mall.pojo.TbContent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * 内容管理Service
 * @author zwq
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;

	@Value("${CONTENT_LIST}")
	private String contentList;
	
	@Override
	public String addContent(TbContent content) {
		//将内容数据插入到内容表
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入到数据库
		contentMapper.insert(content);
		//缓存同步,删除缓存中对应的数据。
		jedisClient.hdel(contentList, content.getCategoryId().toString());
		return "success";
	}

	@Override
	public List<TbContent> getContentListByCid(long cid) {
		//查询缓存
		try {
			//如果缓存中有直接响应结果
			String json = jedisClient.hget(contentList, cid + "");
			if (StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//执行查询
		List<TbContent> list = contentMapper.selectByCid(cid);
		//把结果添加到缓存
		try {
			jedisClient.hset(contentList, cid + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
