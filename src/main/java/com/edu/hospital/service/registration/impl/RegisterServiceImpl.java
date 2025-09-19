package com.edu.hospital.service.registration.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hospital.bean.RestBean;
import com.edu.hospital.mapper.RegisterMapper;
import com.edu.hospital.service.registration.RegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterMapper registerMapper;

	// 添加挂号信息
	@Override
	public String addRegister(Map<String, Object> map) {
		// 处理 noon 字段：AM -> 上午，PM -> 下午
		String noon = (String) map.get("noon");
		if ("AM".equals(noon)) {
			map.put("noon", "上午");
		} else if ("PM".equals(noon)) {
			map.put("noon", "下午");
		}

		// 处理 is_book 字段
		String isBook = (String) map.get("is_book");
		if ("true".equals(isBook)) {
			map.put("is_book", "是");
		} else if ("false".equals(isBook)) {
			map.put("is_book", "否");
		}

		// 处理 visit_date 字段：确保包含时间部分
		String visitDate = (String) map.get("visit_date");
		if (visitDate != null && visitDate.length() == 10) {
			map.put("visit_date", visitDate + " 00:00:00");
		}

		// 设置默认值
		if (map.get("visit_state") == null) {
			map.put("visit_state", 2); // 默认状态为已挂号
		}
		if (map.get("is_book") == null) {
			map.put("is_book", "否"); // 默认不要病历本
		}
		if (map.get("regist_method") == null) {
			map.put("regist_method", "微信"); // 默认收费方式为微信
		}

		// 修改字段名称：将 department_name 改为 department_id，doctor_name 改为 doctor_id
		if (map.containsKey("department_name")) {
			map.put("deptment_id", map.remove("department_name"));
		}
		if (map.containsKey("doctor_name")) {
			map.put("employee_id", map.remove("doctor_name"));
		}

		// 插入数据库
		int num = registerMapper.addRegister(map);

//		System.out.println("插入数据：" + map);

		if (num > 0) {
			return "添加成功";
		} else {
			return "添加失败";
		}
	}





	@Override
	public String getAlreadyRegisterCount(String visitDate, String noon, String employeeId) {
		return registerMapper.getAlreadyRegisterCount(visitDate,noon,employeeId);
	}

	// RegisterServiceImpl.java
	@Override
	public List<Map<String, Object>> getAlreadyRegisterPatients(String realName) {
		if (realName == null || realName.isEmpty()) {
			throw new IllegalArgumentException("real_name 参数不能为空");
		}
		return registerMapper.getAlreadyRegisterPatients(realName);
	}


	// 得到最大病例号
	@Override
	public String getMaxCaseNumber() {
		return registerMapper.getMaxCaseNumber();
	}

	// 得到退号患者信息（所有已经挂号状态为1的患者信息，分页）
	@Override
	public RestBean getRecordRefundPatient(String case_number, String real_name
			, Integer nowPageNumber,Integer pageSize) {
		RestBean rest = new RestBean();
		rest.setList(registerMapper.getPagePatientByState(case_number,real_name,nowPageNumber,pageSize,2));
		rest.setTotalCount(registerMapper.getPagePatientByStateCount(case_number,real_name,2));
		return rest;
	}

	// 退号
	@Override
	public RestBean refundMedicalRecord(Integer id) {
		int n = registerMapper.updateStateById(id,4);
		RestBean rest = new RestBean();
		rest.setMsg("退号成功");
		return rest;
	}

	@Override
	public String saveAppointment(Map<String, Object> order) {
		if (order == null || !order.containsKey("patient") || !(order.get("patient") instanceof Map)) {
			return "请求参数错误：缺少 patient 信息";
		}

		Map<String, Object> patient = (Map<String, Object>) order.get("patient");
		if (patient.isEmpty()) {
			return "请求参数错误：patient 信息为空";
		}

		// 提取 appointment 数据并进行非空校验
		if (!order.containsKey("appointment") || !(order.get("appointment") instanceof Map)) {
			return "请求参数错误：缺少 appointment 信息";
		}
		Map<String, Object> appointment = (Map<String, Object>) order.get("appointment");

		// 构建 Register 对象所需的数据
		Map<String, Object> registerData = new HashMap<>();
		registerData.put("case_number", "待生成"); // 病历号可以从 getMaxCaseNumber 获取后填充
		registerData.put("real_name", patient.get("realName")); // 姓名
		registerData.put("gender", ""); // 性别需要根据身份证号解析
		registerData.put("card_number", patient.get("idCard")); // 身份证号
		registerData.put("birthday", parseBirthdayFromIdCard((String) patient.get("idCard"))); // 出生日期
		registerData.put("age", calculateAgeFromIdCard((String) patient.get("idCard"))); // 年龄
		registerData.put("age_type", "年"); // 年龄类型
		registerData.put("home_address", patient.get("address")); // 家庭住址
		registerData.put("visit_date", appointment.get("appointmentDate")); // 就诊日期
		registerData.put("noon", appointment.get("period")); // 午别
		registerData.put("department_id", getDepartmentIdByName((String) appointment.get("department"))); // 科室 ID
		registerData.put("employee_id", getDoctorIdByName((String) appointment.get("doctor"))); // 医生 ID
		registerData.put("regist_level_id", getRegistLevelIdByType((String) appointment.get("type"))); // 挂号级别 ID
		registerData.put("settle_category_id", 1); // 结算类别 ID，默认值
		registerData.put("is_book", "是"); // 是否要病历本
		registerData.put("regist_method", "微信"); // 收费方式，默认微信
		registerData.put("visit_state", 2); // 挂号状态，2 表示已挂号
		registerData.put("regist_money", appointment.get("price")); // 挂号金额

		// 调用 Mapper 插入数据
		int result = registerMapper.addRegister(registerData);
		if (result > 0) {
			return "预约成功";
		} else {
			return "预约失败";
		}
	}


	// 辅助方法：从身份证号解析出生日期
	private String parseBirthdayFromIdCard(String idCard) {
		return idCard.substring(6, 10) + "-" + idCard.substring(10, 12) + "-" + idCard.substring(12, 14);
	}

	// 辅助方法：从身份证号计算年龄
	private Integer calculateAgeFromIdCard(String idCard) {
		int birthYear = Integer.parseInt(idCard.substring(6, 10));
		int currentYear = java.time.LocalDate.now().getYear();
		return currentYear - birthYear;
	}

	// 辅助方法：根据科室名称获取科室 ID（假设有一个方法）
	private Integer getDepartmentIdByName(String departmentName) {
		// TODO: 查询科室 ID 的逻辑
		return 1; // 示例返回值
	}

	// 辅助方法：根据医生名称获取医生 ID（假设有一个方法）
	private Integer getDoctorIdByName(String doctorName) {
		// TODO: 查询医生 ID 的逻辑
		return 1; // 示例返回值
	}

	// 辅助方法：根据挂号类型获取挂号级别 ID（假设有一个方法）
	private Integer getRegistLevelIdByType(String registType) {
		// TODO: 查询挂号级别 ID 的逻辑
		return 1; // 示例返回值
	}

	@Override
	public String refundByName(String realName) {
		if (realName == null || realName.isEmpty()) {
			throw new IllegalArgumentException("就诊人名字不能为空");
		}

		// 调用 Mapper 更新 visit_state 为 4
		int result = registerMapper.updateStateByRealName(realName, 4);

		if (result > 0) {
			return "退号成功";
		} else {
			return "未找到对应的挂号记录";
		}
	}

	/**
	 * 查询今天的所有挂号记录
	 * @return 挂号记录列表
	 */
	@Override
	public List<Map<String, Object>> getTodayRegisterRecords() {
		return registerMapper.getTodayRegisterRecords();
	}

	@Override
	public List<Map<String, Object>> getRegisterListByCondition(
			String search,
			Integer visitState,
			String startDate,
			String endDate) {

		return registerMapper.getRegisterListByCondition(search, visitState, startDate, endDate);
	}


}
