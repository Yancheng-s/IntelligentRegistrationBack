package com.edu.hospital.service.registration;

import java.util.List;
import java.util.Map;

public interface RegistLevelService {
	//得到所有挂号级别
	public List<Map<String,Object>> getRegistLevelList();

	String getRegistNameById(Integer registLevelId);

}
