package com.mall.mapper;

import com.mall.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zwq
 */
public interface TbUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 用户信息
     */
    List<TbUser> selectByName(@Param("username") String username);

    /**
     * 根据不同的type生成不同的查询条件
     * 1：用户名 2：手机号 3：邮箱
     * @param param 条件
     * @return
     */
    List<TbUser> checkByParam(@Param("param") String result);


}