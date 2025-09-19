package com.edu.hospital.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.hospital.service.registration.EmployeeService;

/**
 * 挂号所需
 */
@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("getRegistDoctorList")
	public List<Map<String,Object>> getRegistDoctorList(
			@RequestParam("deptment_id")String deptmentId,@RequestParam("regist_level_id")String registLevelId){
		return employeeService.getRegistDoctorList(deptmentId,registLevelId);
	}

	@RequestMapping("/getDoctorListWithRegistName")
	public List<Map<String, Object>> getDoctorListWithRegistName(
			@RequestParam(value = "realname", required = false) String realname) {
		return employeeService.getDoctorListWithRegistName(realname);
	}

}
