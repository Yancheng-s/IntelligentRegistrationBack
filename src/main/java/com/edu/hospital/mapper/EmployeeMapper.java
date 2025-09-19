package com.edu.hospital.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {

	List<Map<String, Object>> getRegistDoctorList(String deptmentId, String registLevelId);

	List<Map<String, Object>> getEmployeeAndDeptByNamePass(String realname, String password);

	List<Map<String, Object>> getDoctorListByName(@Param("realname") String realname);

}
