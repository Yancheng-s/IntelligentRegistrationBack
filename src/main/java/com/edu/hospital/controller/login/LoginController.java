package com.edu.hospital.controller.login;

import com.edu.hospital.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 权限管理：登录管理
 */
@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginService;
//	@RequestMapping("login")
//	public List<Map<String ,Object>> login(String username,String password){
//		return loginService.login(username,password);
//	}
	@RequestMapping("login")
	public List<Map<String, Object>> login(String username, String password) {
		// 模拟返回登录成功的用户信息（测试用）
		List<Map<String, Object>> userInfoList = new ArrayList<>();

		Map<String, Object> user = new HashMap<>();
		user.put("realname", "系统管理员"); // 前端会显示：欢迎 系统管理员 登录成功
		user.put("username", username);
		user.put("role", "root");
		user.put("id", 1);

		userInfoList.add(user);

		return userInfoList;
	}
}
