package com.mall.sso.service;


import com.mall.pojo.TbUser;

/**
 * @author zwq
 */
public interface RegisterService {

	/**
	 * 检查
	 * @param param 内容
	 * @param type 类型
	 * @return
	 */
	String checkData(String param, int type);

	/**
	 * 注册
	 * @param user 用户信息
	 * @return
	 */
	String register(TbUser user);
}
