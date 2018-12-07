package com.mall.sso.service;


import com.mall.pojo.TbUser;

/**
 * 根据token查询用户信息
 * @author zwq
 */
public interface TokenService {

	/**
	 * 根据token判断用户
	 * @param token
	 * @return
	 */
	Object getUserByToken(String token);
}
