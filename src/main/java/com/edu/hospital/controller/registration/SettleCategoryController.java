package com.edu.hospital.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.hospital.service.registration.SettleCategoryService;

/**
 * 挂号所需
 */
@RestController
@CrossOrigin
public class SettleCategoryController {
	@Autowired
	private SettleCategoryService settleCategoryService;
	@RequestMapping("getSettleCategory")
	public List<Map<String,Object>> getSettleCategory(){
		return settleCategoryService.getSettleCategory();
	}
}
