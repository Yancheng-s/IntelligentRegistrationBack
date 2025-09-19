package com.edu.hospital.service.userLogin.impl;

import com.edu.hospital.mapper.UserLoginMapper;
import com.edu.hospital.pojo.User;
import com.edu.hospital.service.userLogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public void saveUser(User user) {
        userLoginMapper.insertUser(user);
    }

    @Override
    public Map<String, Object> loginByPhone(String userPhone) {
        List<User> users = userLoginMapper.findByUserPhone(userPhone);
        Map<String, Object> result = new HashMap<>();

        // 如果查询到用户列表不为空且包含至少一个用户，返回成功状态和用户名
        if (users != null && !users.isEmpty()) {
            result.put("status", 0); // 登录成功
            result.put("username", users.get(0).getUsername()); // 返回第一个用户的用户名
            result.put("user", users.get(0)); // 返回完整的用户信息
        } else {
            result.put("status", 1); // 登录失败
        }

        return result;
    }

    @Override
    public Map<String, Object> updateUserNameAndLocalByPhone(User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 检查用户是否存在
            List<User> existingUsers = userLoginMapper.findByUserPhone(user.getPhoneNumber());
            if (existingUsers == null || existingUsers.isEmpty()) {
                result.put("status", 1); // 更新失败
                result.put("message", "用户不存在");
                return result;
            }

            // 更新用户名和地址
            userLoginMapper.updateUserNameAndLocalByPhone(user);
            result.put("status", 0); // 更新成功
            result.put("message", "用户信息更新成功");
        } catch (Exception e) {
            result.put("status", 1); // 更新失败
            result.put("message", "用户信息更新失败: " + e.getMessage());
        }
        return result;
    }
}
