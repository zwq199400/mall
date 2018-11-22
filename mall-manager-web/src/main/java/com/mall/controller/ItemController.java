package com.mall.controller;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TreeNode;
import com.mall.pojo.TbItem;
import com.mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.mall.service.ItemService;

import java.util.List;

/**
 * @author zwq
 * @date 2018/11/8 17:08
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    private TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }


    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //调用服务查询商品列表
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    /**
     * 商品添加功能
     */
    @RequestMapping(value="/item/save", method=RequestMethod.POST)
    @ResponseBody
    public String addItem(TbItem item, String desc) {
        return itemService.addItem(item, desc);
    }


}
