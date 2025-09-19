package com.edu.hospital.controller.registration;

import com.edu.hospital.service.registration.SearchDoctorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用于挂号页面搜索医生信息
 * 数据格式：
 * {
 * "deptName" : "科室名称",
 * "schedulingId" : "排班序号",
 * }
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SearchDoctorInformationController {

    @Autowired
    private SearchDoctorInformationService searchDoctorInformationService;

    @PostMapping("/searchDoctorInformation")
    public List<Map<String, Object>> searchDoctorInformation(@RequestBody Map<String, Object> requestMap) {
        String deptName = (String) requestMap.get("deptName");
        List<String> schedulingIds = (List<String>) requestMap.get("schedulingId");
        System.out.println(searchDoctorInformationService.searchDoctorsByDeptAndSchedule(deptName, schedulingIds));
        return searchDoctorInformationService.searchDoctorsByDeptAndSchedule(deptName, schedulingIds);
    }
}
