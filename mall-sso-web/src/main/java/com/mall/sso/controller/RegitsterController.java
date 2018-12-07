package com.mall.sso.controller;

import com.mall.pojo.TbUser;
import com.mall.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册功能Controller
 * @author zwq
 */
@Controller
public class RegitsterController {
	
	@Autowired
	private RegisterService registerService;

	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public String checkData(@PathVariable String param, @PathVariable Integer type) {
		String result = registerService.checkData(param, type);
		return result;
	}
	
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public String register(TbUser user) {
		String result = registerService.register(user);
		return result;
	}
}
