package com.edu.hospital.service.registration.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hospital.mapper.RegistLevelMapper;
import com.edu.hospital.service.registration.RegistLevelService;

@Service
public class RegistLevelServiceImpl implements RegistLevelService{
	@Autowired
	private RegistLevelMapper registLevelMapper;

	//得到所有挂号级别
	public List<Map<String,Object>> getRegistLevelList(){
		return registLevelMapper.getRegistLevelList();
	}

	@Override
	public String getRegistNameById(Integer registLevelId) {
		if (registLevelId == null) {
			throw new IllegalArgumentException("挂号级别ID不能为空");
		}
		return registLevelMapper.getRegistNameById(registLevelId);
	}

}
