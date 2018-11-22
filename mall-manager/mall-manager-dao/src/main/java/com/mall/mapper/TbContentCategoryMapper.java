package com.mall.mapper;

import com.mall.pojo.TbContentCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);

    /**
     * 根据parentId查询
     * @param parentId 父ID
     * @return
     */
    List<TbContentCategory> selectByParentId(@Param("parentId") long parentId);
}