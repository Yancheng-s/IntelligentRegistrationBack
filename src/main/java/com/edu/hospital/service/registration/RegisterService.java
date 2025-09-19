package com.edu.hospital.service.registration;

import java.util.List;
import java.util.Map;

import com.edu.hospital.bean.RestBean;

//患者信息
public interface RegisterService {

	String addRegister(Map<String, Object> map);

	String getAlreadyRegisterCount(String visitDate, String noon, String employeeId);

	// 获取已挂号患者详细信息
	// RegisterService.java
	List<Map<String, Object>> getAlreadyRegisterPatients(String realName);

	// 退号
	RestBean refundMedicalRecord(Integer id);

	String getMaxCaseNumber();

	RestBean getRecordRefundPatient(String case_number, String real_name
			, Integer nowPageNumber,Integer pageSize);

	String saveAppointment(Map<String, Object> order);

	// 根据就诊人名字退号
	String refundByName(String realName);

	List<Map<String, Object>> getTodayRegisterRecords();

	// 根据条件查询挂号记录
	List<Map<String, Object>> getRegisterListByCondition(
			String search,
			Integer visitState,
			String startDate,
			String endDate
	);

}
