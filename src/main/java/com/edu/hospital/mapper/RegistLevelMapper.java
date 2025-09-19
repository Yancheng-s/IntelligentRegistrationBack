package com.edu.hospital.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegistLevelMapper {
	//得到所有挂号级别
	List<Map<String,Object>> getRegistLevelList();

	String getRegistNameById(@Param("registLevelId") Integer registLevelId);

}
