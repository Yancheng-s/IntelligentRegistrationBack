package com.edu.hospital.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.hospital.service.registration.RegistLevelService;

/**
 * 挂号所需
 */
@RestController
@CrossOrigin
public class RegistLevelController {
	@Autowired
	private RegistLevelService registLevelService;
	//得到所有挂号级别
	@RequestMapping("/getRegistLevelList")
	public List<Map<String,Object>> getRegistLevelList() {
		return registLevelService.getRegistLevelList();
	}

	// 新增方法：通过 regist_level_id 查询 regist_name
	@GetMapping("/getRegistNameById/{registLevelId}")
	public String getRegistNameById(@PathVariable("registLevelId") Integer registLevelId) {
		return registLevelService.getRegistNameById(registLevelId);
	}
}
