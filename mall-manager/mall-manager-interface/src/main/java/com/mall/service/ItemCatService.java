package com.mall.service;

import com.mall.common.pojo.TreeNode;

import java.util.List;

/**
 * @author zwq
 * @date 2018/11/12 14:27
 */
public interface ItemCatService {

    /**
     * 根据ID获取
     * @param parentId 查询ID
     * @return
     */
    List<TreeNode> getCatList(long parentId);
}
