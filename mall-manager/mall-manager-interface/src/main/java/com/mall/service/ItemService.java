package com.mall.service;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemDesc;

/**
 * @author zwq
 * @date 2018/11/8 17:01
 */
public interface ItemService {

    public TbItem getItemById(long id);

    /**
     * 获取列表
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGridResult getItemList(int page, int rows);

    /**
     * 添加
     * @param item
     * @param desc
     * @return
     */
    String addItem(TbItem item, String desc);

    TbItemDesc getItemDescById(long itemId);

}
