package com.edu.hospital.service.registration.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.edu.hospital.service.registration.RegistLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hospital.mapper.EmployeeMapper;
import com.edu.hospital.service.registration.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private RegistLevelService registLevelService;

	@Override
	public List<Map<String, Object>> getRegistDoctorList(String deptmentId, String registLevelId) {
		return this.getWorkDoctorList(deptmentId,registLevelId);
	}
	//根据医生的排班情况和当前的系统日期，进行比较，得到当天及午别出诊的医生列表
	private List<Map<String, Object>> getWorkDoctorList(String deptmentId, String registLevelId){
		//根据部门名称和挂号级别，得到满足条件的医生列表
		List<Map<String, Object>> list = employeeMapper.getRegistDoctorList(deptmentId,registLevelId);
		//得到系统时间
		Calendar c = Calendar.getInstance();
		//获得从第几位截取医生的排班信息，从星期日作为字符串的第0位
		int ruleDay = (c.get(Calendar.DAY_OF_WEEK)-1)*2;
		//获得系统时间是上午还是下午（上午：0，下午：1）
		int amOrPm = c.get(Calendar.AM_PM);
//		String ampm = amOrPm == 0 ? "上午":"下午";
		//新创建一个List，保存符合条件的医生信息
		List<Map<String, Object>> docs = new ArrayList<>();
		//遍历获得的医生列表
		for(Map<String,Object> emp : list) {
			//得到排班规则
			String weekRule = (String)emp.get("week_rule");
			//是否上班
			char cc = weekRule.charAt(ruleDay + amOrPm);
			if(cc == '1') {
				docs.add(emp);
			}
		}
//		System.out.println(docs);
		return docs;
	}
	@Override
	public List<Map<String, Object>> getDoctorListWithRegistName(String realname) {
		// 查询医生列表
		List<Map<String, Object>> doctorList = employeeMapper.getDoctorListByName(realname);

		// 假设 doctorList 是从数据库中获取的医生列表
		for (Map<String, Object> doctor : doctorList) {
			Object registLevelIdObj = doctor.get("regist_level_id");
			if (registLevelIdObj != null && registLevelIdObj instanceof Integer) {
				try {
					// 获取挂号级别 ID
					Integer registLevelId = (Integer) registLevelIdObj;
					// 调用 RegistLevelService 查询挂号级别名称
					String registName = registLevelService.getRegistNameById(registLevelId);
					// 替换 regist_level_id 为挂号级别名称
					doctor.put("regist_level_id", registName);
				} catch (Exception e) {
					// 如果查询失败，保留原值或记录日志
					System.err.println("Failed to fetch regist_name for regist_level_id: " + registLevelIdObj);
				}
			}
		}

		return doctorList;
	}

}
