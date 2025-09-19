package com.edu.hospital.service.registration.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hospital.mapper.SettleCategoryMapper;
import com.edu.hospital.service.registration.SettleCategoryService;
@Service
public class SettleCategoryServiceImpl implements SettleCategoryService {
	@Autowired
	private SettleCategoryMapper settleCategoryMapper;
	@Override
	public List<Map<String, Object>> getSettleCategory() {
		return settleCategoryMapper.getSettleCategory();
	}

}
