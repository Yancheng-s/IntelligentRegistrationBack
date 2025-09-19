package com.edu.hospital.mapper;

import com.edu.hospital.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserLoginMapper {
    @Insert("INSERT INTO user_info(user_name, user_phone) VALUES(#{userName}, #{userPhone})")
    void insertUser(User user);

    @Select("SELECT id, user_name as userName, user_phone as userPhone FROM user_info WHERE user_phone = #{userPhone}")
    List<User> findByUserPhone(String userPhone);

    // 添加更新用户名和地址的SQL（通过手机号查找用户）
    @Update("UPDATE user_info SET user_name = #{userName}, user_local = #{userLocal} WHERE user_phone = #{userPhone}")
    void updateUserNameAndLocalByPhone(User user);
}
