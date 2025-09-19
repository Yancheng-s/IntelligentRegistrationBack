package com.edu.hospital.mapper;

import com.edu.hospital.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegisterMapper {
	// 添加注册信息
	int addRegister(Map<String, Object> map);

	// 已挂号数量统计 按照日期 午别 医生 统计 visit_state状态为 1、2、3
	String getAlreadyRegisterCount(String visitDate, String noon, String employeeId);

	// 根据条件获取已挂号患者详细信息
	// RegisterMapper.java
	List<Map<String, Object>> getAlreadyRegisterPatients(@Param("realName") String realName);

	// 根据id更改患者挂号状态
	int updateStateById(Integer id, Integer visit_state);

	// 得到最大病例号
	String getMaxCaseNumber();

	// 得到退号患者信息（所有已经挂号状态为1的患者信息，分页）
	List<Map<String, Object>> getPagePatientByState(String case_number, String real_name,
													Integer nowPageNumber, Integer pageSize,Integer visit_state);
	int getPagePatientByStateCount(String case_number, String real_name,Integer visit_state);

	@Select("SELECT doctor_id, strong_point FROM department WHERE dept_name = #{deptName}")
	Map<String, Object> findDoctorIdAndStrongPointByDeptName(@Param("deptName") String deptName);

	@Select("SELECT id, realname, password, deptment_id, regist_level_id, scheduling_id, delmark, num " +
			"FROM employee " +
			"WHERE id = #{doctorId} AND scheduling_id = #{schedulingId}")
	@Results({
			@Result(property = "deptmentId", column = "deptment_id"),
			@Result(property = "registLevelId", column = "regist_level_id"),
			@Result(property = "schedulingId", column = "scheduling_id")
	})
	Employee findDoctorInfoByDoctorIdAndSchedulingId(
			@Param("doctorId") Integer doctorId,
			@Param("schedulingId") Integer schedulingId
	);

	// 根据就诊人名字删除挂号记录
	int updateStateByRealName(@Param("realName") String realName, @Param("visitState") Integer visitState);

	List<Map<String, Object>> getTodayRegisterRecords();

	// 根据条件查询挂号记录（支持模糊搜索、状态、时间范围）
	List<Map<String, Object>> getRegisterListByCondition(
			@Param("search") String search,
			@Param("visitState") Integer visitState,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate
	);

}


