package com.edu.hospital.service.registration;

import com.edu.hospital.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface SearchDoctorInformationService {

    /**
     * 根据科室名称和排班时间搜索医生信息
     * @param deptName 科室名称
     * @param schedulingIds 排班时间列表
     * @return 医生信息列表
     */
    List<Map<String, Object>> searchDoctorsByDeptAndSchedule(String deptName, List<String> schedulingIds);

    /**
     * 根据科室名称查找医生ID和专长
     * @param deptName 科室名称
     * @return 包含医生ID和专长的Map
     */
    Map<String, Object> findDoctorIdAndStrongPointByDeptName(String deptName);

    /**
     * 根据医生ID和排班ID查找医生信息
     * @param doctorId 医生ID
     * @param schedulingId 排班ID
     * @return 医生信息
     */
    Employee findDoctorInfoByDoctorIdAndSchedulingId(Integer doctorId, Integer schedulingId);
}
