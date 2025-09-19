// TreatmentGroupMapper.java
package com.edu.hospital.mapper;

import com.edu.hospital.pojo.TreatmentGroups;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TreatmentGroupMapper {

    @Insert("INSERT INTO treatment_groups (real_name, treatment_name, id_card, phone, address) VALUES (#{realName}, #{treatmentName}, #{idCard}, #{phone}, #{address})")
    @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTreatmentGroup(TreatmentGroups treatmentGroups);

    @Select("SELECT * FROM treatment_groups WHERE real_name = #{realName}")
    java.util.List<TreatmentGroups> selectByRealName(String realName);

    @Select("SELECT * FROM treatment_groups WHERE id = #{id}")
    TreatmentGroups selectById(Integer id);

    @Delete("DELETE FROM treatment_groups WHERE treatment_name = #{treatmentName}")
    void deleteByRealName(@Param("treatmentName") String treatmentName);
}
