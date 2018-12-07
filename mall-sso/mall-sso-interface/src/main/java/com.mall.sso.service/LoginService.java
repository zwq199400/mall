package com.mall.sso.service;


public interface LoginService {
	/**
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 结果
	 */
	String userLogin(String username, String password);
}
