package com.mall.service;

import com.mall.common.pojo.TreeNode;
import com.mall.mapper.TbItemCatMapper;
import com.mall.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwq
 * @date 2018/11/12 14:29
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private TbItemCatMapper itemCatMapper;


    @Override
    public List<TreeNode> getCatList(long parentId) {
        List<TbItemCat> list = itemCatMapper.selectByParentId(parentId);
        // 2、转换成EasyUITreeNode列表。
        List<TreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            TreeNode node = new TreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            //添加到列表
            resultList.add(node);
        }
        // 3、返回。
        return resultList;

    }
}
