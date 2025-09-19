package com.edu.hospital.service.registration.impl;

import java.util.List;
import java.util.Map;

import com.edu.hospital.bean.RestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hospital.mapper.DepartmentMapper;
import com.edu.hospital.service.registration.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<Map<String, Object>> getAllDeptList() {
		return departmentMapper.getAllDeptList();
	}

	/**
	 * 分页查询科室信息
	 * @param deptId 科室编号（可选）
	 * @param deptName 科室名称（可选）
	 * @param nowPageNumber 当前页码
	 * @param pageSize 每页记录数
	 * @return 包含分页数据的结果
	 */
	public RestBean getDeptListByPage(String deptId, String deptName, Integer nowPageNumber, Integer pageSize) {
		RestBean rest = new RestBean();
		rest.setList(departmentMapper.getDeptListByPage(deptId, deptName, nowPageNumber, pageSize));
		rest.setTotalCount(departmentMapper.getDeptListCount(deptId, deptName));
		return rest;
	}

	@Override
	public void addDepartment(Map<String, Object> deptData) {
		// 获取参数
		String deptCode = (String) deptData.get("dept_code");
		String deptName = (String) deptData.get("dept_name");
		String deptType = (String) deptData.get("dept_type");
		String strongPoint = (String) deptData.get("strong_point");

		// 验证必填字段
		if (deptCode == null || deptCode.trim().isEmpty()) {
			throw new IllegalArgumentException("科室编号不能为空");
		}
		if (deptName == null || deptName.trim().isEmpty()) {
			throw new IllegalArgumentException("科室名称不能为空");
		}

		// 插入数据库
		departmentMapper.insertDepartment(deptCode, deptName, deptType, strongPoint);
	}

	@Override
	public void updateDepartment(Map<String, Object> deptData) {
		// 获取参数
		Integer id = (Integer) deptData.get("id");
		String deptCode = (String) deptData.get("dept_code");
		String deptName = (String) deptData.get("dept_name");
		String deptType = (String) deptData.get("dept_type");
		String strongPoint = (String) deptData.get("strong_point");

		// 验证必填字段
		if (id == null) {
			throw new IllegalArgumentException("科室ID不能为空");
		}
		if (deptCode == null || deptCode.trim().isEmpty()) {
			throw new IllegalArgumentException("科室编号不能为空");
		}
		if (deptName == null || deptName.trim().isEmpty()) {
			throw new IllegalArgumentException("科室名称不能为空");
		}

		// 更新数据库
		departmentMapper.updateDepartment(id, deptCode, deptName, deptType, strongPoint);
	}

	@Override
	public void deleteDepartmentByCode(String deptCode) {
		if (deptCode == null || deptCode.trim().isEmpty()) {
			throw new IllegalArgumentException("科室编号不能为空");
		}
		departmentMapper.deleteDepartmentByCode(deptCode);
	}


}
