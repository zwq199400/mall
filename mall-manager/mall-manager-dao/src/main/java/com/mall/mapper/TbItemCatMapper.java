package com.mall.mapper;

import com.mall.pojo.TbItemCat;

import java.util.List;

/**
 * @author zwq
 */
public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);

    /**
     * 查询所有
     * @param parentId 父ID
     * @return TbItemCat集合
     */
    List<TbItemCat> selectByParentId(Long parentId);
}