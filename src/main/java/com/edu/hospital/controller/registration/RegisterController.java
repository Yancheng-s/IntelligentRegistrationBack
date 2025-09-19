package com.edu.hospital.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.hospital.bean.RestBean;
import com.edu.hospital.service.registration.RegisterService;

/**
 * 挂号所需
 */
@RestController
@CrossOrigin
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	// 挂号
	@PostMapping("/addRegister")
	@ResponseBody
	public void addRegister(@RequestBody Map<String,Object> map) {
//		System.out.println("接收到的数据：" + map);
		try {
			registerService.addRegister(map); // 只执行插入操作
		} catch (Exception e) {
			System.err.println("挂号失败: " + e.getMessage());
			throw new RuntimeException("挂号失败"); // 让全局异常处理器处理
		}
	}

	// 得到最大病例号
	@RequestMapping("getMaxCaseNumber")
	public String getMaxCaseNumber(){
		String rest = registerService.getMaxCaseNumber();
		return rest;
	}

	@RequestMapping("getAlreadyRegisterCount")
	public String getAlreadyRegisterCount(String visitDate,String noon,String employeeId) {
		return registerService.getAlreadyRegisterCount(visitDate,noon,employeeId);
	}

	// 获取已挂号患者详细信息
	@PostMapping("getAlreadyRegisterPatients")
	public List<Map<String, Object>> getAlreadyRegisterPatients(
			@RequestBody Map<String, Object> body) {

		// 提取 real_name 参数
		String realName = (String) body.get("real_name");
		if (realName == null || realName.isEmpty()) {
			throw new IllegalArgumentException("real_name 参数不能为空");
		}

		// 调用 Service 层方法
		return registerService.getAlreadyRegisterPatients(realName);
	}


	// 得到退号患者信息（所有已经挂号状态为2的患者信息，分页）
	@RequestMapping("getRecordRefundPatient")
	public RestBean getRecordRefundPatient(String case_number
			,String real_name,Integer nowPageNumber,Integer pageSize) {
		return registerService.getRecordRefundPatient(case_number
				,real_name,nowPageNumber,pageSize);
	}

	// 退号
	@RequestMapping("refundMedicalRecord")
	public RestBean refundMedicalRecord(Integer id) {
		return registerService.refundMedicalRecord(id);
	}

	// 新增接口方法
	@PostMapping("saveAppointment")
	public String saveAppointment(@RequestBody Map<String, Object> order) {
		return registerService.saveAppointment(order);
	}

	// 退号
	@GetMapping("/refundByName")
	public String refundByName(@RequestParam("realName") String realName) {
		try {
			// 调用 Service 层方法，更新 visit_state 为 4
			registerService.refundByName(realName);
			return "退号成功";
		} catch (Exception e) {
			System.err.println("退号失败: " + e.getMessage());
			throw new RuntimeException("退号失败"); // 让全局异常处理器处理
		}
	}

	/**
	 * 查询今天的所有挂号记录
	 * @return 挂号记录列表
	 */
	@GetMapping("/getTodayRegisterRecords")
	public List<Map<String, Object>> getTodayRegisterRecords() {
		return registerService.getTodayRegisterRecords();
	}

	/**
	 * 查询全部挂号记录（无条件）
	 */
	/**
	 * 查询部分条件的挂号记录
	 */
	@GetMapping("/getRegisterList")
	public List<Map<String, Object>> getRegisterList(
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "visitState", required = false) Integer visitState,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {

		// 如果所有参数都为空，则视为查询全部
		if (search == null && visitState == null && startDate == null && endDate == null) {
			return registerService.getRegisterListByCondition(null, null, null, null);
		}

		// 否则按条件查询
		return registerService.getRegisterListByCondition(search, visitState, startDate, endDate);
	}


}
