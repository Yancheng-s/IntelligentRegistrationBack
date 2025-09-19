package com.edu.hospital.service.userLogin;

import com.edu.hospital.pojo.User;
import java.util.Map;

public interface UserLoginService {
    void saveUser(User user);

    // 登录方法，返回包含登录状态和用户信息的Map
    Map<String, Object> loginByPhone(String userPhone);

    // 添加修改用户名和地址的方法（根据手机号）
    Map<String, Object> updateUserNameAndLocalByPhone(User user);
}
