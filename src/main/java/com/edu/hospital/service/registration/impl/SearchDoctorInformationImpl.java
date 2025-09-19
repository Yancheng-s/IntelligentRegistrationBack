package com.edu.hospital.service.registration.impl;

import com.edu.hospital.mapper.RegisterMapper;
import com.edu.hospital.pojo.Employee;
import com.edu.hospital.service.registration.SearchDoctorInformationService;
import com.edu.hospital.tools.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchDoctorInformationImpl implements SearchDoctorInformationService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public List<Map<String, Object>> searchDoctorsByDeptAndSchedule(String deptName, List<String> schedulingIds) {
        Map<String, Object> result = findDoctorIdAndStrongPointByDeptName(deptName);
        Integer doctorId = (Integer) result.get("doctor_id");
        String strongPoint = (String) result.get("strong_point");

        if (doctorId == null || schedulingIds == null || schedulingIds.isEmpty()) {
            return Collections.emptyList();
        }

        List<Map<String, Object>> resultList = new ArrayList<>();

        for (String schedulingId : schedulingIds) {
            int scheduleNumber = DateConversion.convertChineseToScheduleNumber(schedulingId);
            Employee doc = findDoctorInfoByDoctorIdAndSchedulingId(doctorId, scheduleNumber);

            if (doc != null) {
                doc.setStrongPoint(strongPoint);
                resultList.add(convertEmployeeToMap(doc));
            }
        }

        return resultList;
    }

    @Override
    public Map<String, Object> findDoctorIdAndStrongPointByDeptName(String deptName) {
        return registerMapper.findDoctorIdAndStrongPointByDeptName(deptName);
    }

    @Override
    public Employee findDoctorInfoByDoctorIdAndSchedulingId(Integer doctorId, Integer schedulingId) {
        return registerMapper.findDoctorInfoByDoctorIdAndSchedulingId(doctorId, schedulingId);
    }

    private Map<String, Object> convertEmployeeToMap(Employee doc) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", doc.getId());
        map.put("realname", doc.getRealname());
        map.put("password", doc.getPassword());
        map.put("deptmentId", doc.getDeptmentId());
        map.put("registLevelId", doc.getRegistLevelId());
        map.put("schedulingId", doc.getSchedulingId());
        map.put("delmark", doc.getDelmark());
        map.put("num", doc.getNum());
        map.put("strongPoint", doc.getStrongPoint());
        return map;
    }
}
