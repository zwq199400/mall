package com.mall.sso.service.impl;

import com.mall.mapper.TbUserMapper;
import com.mall.pojo.TbUser;
import com.mall.sso.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户注册处理Service
 * @author zwq
 */

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private TbUserMapper userMapper;

	private final static String IF_FLAG = "false";

	@Override
	public String checkData(String param, int type) {
		List<TbUser> list = new ArrayList<>();
		//根据不同的type生成不同的查询条件
		//1：用户名 2：手机号 3：邮箱
		String result;
		if(param != null && param.length() > 0){
			if (type == 1) {
				result = "username = " + param;
				list = userMapper.checkByParam(result);
			} else if (type == 2) {
				result = "phone = " + param;
				list = userMapper.checkByParam(result);
			} else if (type == 3) {
				result = "email = " + param;
				list = userMapper.checkByParam(result);
			} else {
				return "数据类型错误";
			}
		}
		//判断结果中是否包含数据
		if (list != null && list.size()>0) {
			//如果有数据返回false
			return "false";
		}
		//如果没有数据返回true
		return "success";
	}

	@Override
	public String register(TbUser user) {
		//数据有效性校验
		if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()) 
				|| StringUtils.isBlank(user.getPhone())) {
			return "用户数据不完整，注册失败";
		}
		//1：用户名 2：手机号 3：邮箱
		String result = checkData(user.getUsername(), 1);
		if (IF_FLAG.equals(result)) {
			return "此用户名已经被占用";
		}
		result = checkData(user.getPhone(), 2);
		if (IF_FLAG.equals(result)) {
			return "手机号已经被占用";
		}
		//补全pojo的属性
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//对密码进行md5加密
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		//把用户数据插入到数据库中
		userMapper.insert(user);
		//返回添加成功
		return "success";
	}

	

}
