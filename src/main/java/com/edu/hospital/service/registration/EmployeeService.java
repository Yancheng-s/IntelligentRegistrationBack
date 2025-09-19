package com.edu.hospital.service.registration;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

public interface EmployeeService {

	List<Map<String, Object>> getRegistDoctorList(String deptmentId, String registLevelId);


	List<Map<String, Object>> getDoctorListWithRegistName(String realname);

}
