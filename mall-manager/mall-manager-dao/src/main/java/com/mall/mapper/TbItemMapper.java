package com.mall.mapper;

import com.mall.pojo.TbItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zwq
 */
public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    List<TbItem> selectAll(@Param("page") int page,@Param("rows") int rows);
}