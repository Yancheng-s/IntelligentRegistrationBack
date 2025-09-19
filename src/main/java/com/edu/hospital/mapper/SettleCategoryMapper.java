package com.edu.hospital.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SettleCategoryMapper {

	public List<Map<String, Object>> getSettleCategory() ;

}
