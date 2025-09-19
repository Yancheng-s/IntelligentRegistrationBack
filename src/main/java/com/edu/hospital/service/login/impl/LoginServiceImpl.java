package com.edu.hospital.service.login.impl;

import com.edu.hospital.mapper.EmployeeMapper;
import com.edu.hospital.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<Map<String, Object>> login(String username, String password) {
		return employeeMapper.getEmployeeAndDeptByNamePass(username,password);
	}
}
