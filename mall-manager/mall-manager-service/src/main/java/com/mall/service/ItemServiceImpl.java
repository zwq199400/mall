package com.mall.service;

import com.mall.common.jedis.JedisClient;
import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.utils.IDUtils;
import com.mall.common.utils.JsonUtils;
import com.mall.mapper.TbItemDescMapper;
import com.mall.mapper.TbItemMapper;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemDesc;

import javax.jms.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zwq
 * @date 2018/11/8 17:02
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicDestination;
    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_ITEM_PRE}")
    private String redisItemPre;
    @Value("${ITEM_CACHE_EXPIRE}")
    private Integer itemCacheExpire;

    @Override
    public TbItem getItemById(long id) {
        //查询缓存
        try {
            String json = jedisClient.get(redisItemPre + ":" + id + ":BASE");
            if(StringUtils.isNotBlank(json)) {
                TbItem tbItem = JsonUtils.jsonToPojo(json, TbItem.class);
                return tbItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbItem item = itemMapper.selectByPrimaryKey(id);
        if (item != null) {
            //把结果添加到缓存
            try {
                jedisClient.set(redisItemPre + ":" + id + ":BASE", JsonUtils.objectToJson(item));
                //设置过期时间
                jedisClient.expire(redisItemPre + ":" + id + ":BASE", itemCacheExpire);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return item;
        }
        return null;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        List<TbItem> totalList = itemMapper.selectAll(0,0);
        List<TbItem> list = itemMapper.selectAll(page-1,rows);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(totalList.size());
        return result;
    }

    @Override
    public String addItem(TbItem item, String desc) {
        //生成商品id
        final long itemId = IDUtils.genItemId();
        //补全item的属性
        item.setId(itemId);
        //1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表插入数据
        itemMapper.insert(item);
        //创建一个商品描述表对应的pojo对象。
        TbItemDesc itemDesc = new TbItemDesc();
        //补全属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        //发送商品添加消息
        jmsTemplate.send(topicDestination, new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(itemId + "");
                return textMessage;
            }
        });
        return "success";
    }

    @Override
    public TbItemDesc getItemDescById(long itemId) {
        //查询缓存
        try {
            String json = jedisClient.get(redisItemPre + ":" + itemId + ":DESC");
            if(StringUtils.isNotBlank(json)) {
                TbItemDesc tbItemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
                return tbItemDesc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        //把结果添加到缓存
        try {
            jedisClient.set(redisItemPre + ":" + itemId + ":DESC", JsonUtils.objectToJson(itemDesc));
            //设置过期时间
            jedisClient.expire(redisItemPre + ":" + itemId + ":DESC", itemCacheExpire);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemDesc;
    }

}
