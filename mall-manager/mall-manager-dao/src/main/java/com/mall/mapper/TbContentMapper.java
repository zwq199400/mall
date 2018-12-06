package com.mall.mapper;

import com.mall.pojo.TbContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zwq
 */
public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);

    /**
     * 根据内容分类id查询内容列表
     * @param cid 内容分类id
     * @return
     */
    List<TbContent> selectByCid(Long cid);
}