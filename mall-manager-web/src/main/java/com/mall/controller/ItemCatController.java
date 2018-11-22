package com.mall.controller;

import com.mall.common.pojo.TreeNode;
import com.mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zwq
 * @date 2018/11/8 17:08
 */
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {

        List<TreeNode> list = itemCatService.getCatList(parentId);
        return list;
    }


}
