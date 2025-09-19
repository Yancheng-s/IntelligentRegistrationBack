package com.edu.hospital.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 科室操作
 * @author 东软教育
 *
 */
@Mapper
public interface DepartmentMapper {
	//得到所有科室
	List<Map<String,Object>> getAllDeptList();

	/**
	 * 分页查询科室信息
	 * @param deptId 科室编号（可选）
	 * @param deptName 科室名称（可选）
	 * @param nowPageNumber 当前页码
	 * @param pageSize 每页记录数
	 * @return 科室信息列表
	 */
	List<Map<String, Object>> getDeptListByPage(
			@Param("deptId") String deptId,  // 改为 String 类型
			@Param("deptName") String deptName,
			@Param("nowPageNumber") Integer nowPageNumber,
			@Param("pageSize") Integer pageSize
	);

	/**
	 * 查询总记录数
	 * @param deptId 科室编号（可选）
	 * @param deptName 科室名称（可选）
	 * @return 总记录数
	 */
	int getDeptListCount(@Param("deptId") String deptId, @Param("deptName") String deptName);

	/**
	 * 新增科室
	 * @param deptCode 科室编号
	 * @param deptName 科室名称
	 * @param deptType 科室类型
	 * @param strongPoint 特色诊疗
	 */
	void insertDepartment(
			@Param("deptCode") String deptCode,
			@Param("deptName") String deptName,
			@Param("deptType") String deptType,
			@Param("strongPoint") String strongPoint
	);

	/**
	 * 更新科室信息
	 */
	void updateDepartment(
			@Param("id") Integer id,
			@Param("deptCode") String deptCode,
			@Param("deptName") String deptName,
			@Param("deptType") String deptType,
			@Param("strongPoint") String strongPoint
	);

	/**
	 * 根据科室编号删除科室（逻辑删除）
	 */
	void deleteDepartmentByCode(@Param("deptCode") String deptCode);

}
