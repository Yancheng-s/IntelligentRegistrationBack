package com.edu.hospital.controller.registration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edu.hospital.bean.RestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.hospital.service.registration.DepartmentService;

/**
 * 挂号所需
 */
@RestController
@CrossOrigin
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/getAllDeptList")
	public List<Map<String, Object>> getAllDeptList() {
		return departmentService.getAllDeptList();
	}

	/**
	 * 分页查询科室信息
	 * @param deptId 科室编号（可选）
	 * @param deptName 科室名称（可选）
	 * @param nowPageNumber 当前页码
	 * @param pageSize 每页记录数
	 * @return 包含分页数据的结果
	 */
	@GetMapping("/getDeptListByPage")
	public RestBean getDeptListByPage(
			@RequestParam(value = "deptId", required = false) String deptId,  // 改为 String
			@RequestParam(value = "deptName", required = false) String deptName,
			@RequestParam("nowPageNumber") Integer nowPageNumber,
			@RequestParam("pageSize") Integer pageSize
	) {
		return departmentService.getDeptListByPage(deptId, deptName, nowPageNumber, pageSize);
	}

	@PostMapping("/addDepartment")
	public RestBean addDepartment(@RequestBody Map<String, Object> deptData) {
		// 调用服务层添加科室
		departmentService.addDepartment(deptData);
		return null;
	}

	// 编辑科室信息
	@PutMapping("/updateDepartment")
	public Map<String, Object> updateDepartment(@RequestBody Map<String, Object> deptData) {
		Map<String, Object> response = new HashMap<>();
		try {
			departmentService.updateDepartment(deptData);
			response.put("success", true);
		} catch (Exception e) {
			response.put("success", false);
			response.put("error", e.getMessage());
		}
		return response;
	}


	// 删除科室信息
	@DeleteMapping("/deleteDepartment/{deptCode}")
	public Map<String, Object> deleteDepartment(@PathVariable("deptCode") String deptCode) {
		Map<String, Object> response = new HashMap<>();
		try {
			departmentService.deleteDepartmentByCode(deptCode);
			response.put("success", true);
		} catch (Exception e) {
			response.put("success", false);
			response.put("error", e.getMessage());
		}
		return response;
	}


}
