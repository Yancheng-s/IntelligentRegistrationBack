package com.edu.hospital.service.registration;

import com.edu.hospital.bean.RestBean;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
	//得到所有科室
	public List<Map<String,Object>> getAllDeptList();

	RestBean getDeptListByPage(String deptId, String deptName, Integer nowPageNumber, Integer pageSize);

	void addDepartment(Map<String, Object> deptData);

	void updateDepartment(Map<String, Object> deptData);

	void deleteDepartmentByCode(String deptCode);


}
