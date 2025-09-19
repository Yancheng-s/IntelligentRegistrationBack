package com.edu.hospital.controller.login;

import com.edu.hospital.pojo.User;
import com.edu.hospital.service.userLogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/FirstLogin")
    public User FirstLogin(@RequestBody Map<String, Object> requestMap) {
        Object userObj = requestMap.get("user");

        // 解析userObj并保存用户名和电话
        if (userObj instanceof Map) {
            Map<String, Object> userMap = (Map<String, Object>) userObj;

            User user = new User();
            user.setUsername((String) userMap.get("username"));
            user.setPhoneNumber((String) userMap.get("phoneNumber"));

            // 保存用户信息
            userLoginService.saveUser(user);

            return user;
        }

        return null;
    }

    @PostMapping("/UserLogin")
    public Map<String, Object> login(@RequestBody Map<String, String> requestMap) {
        String phoneNumber = requestMap.get("phoneNumber");
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
//            System.out.println("Phone number: " + phoneNumber);
            return userLoginService.loginByPhone(phoneNumber);
        }

        // 返回登录失败的结果
        Map<String, Object> result = new HashMap<>();
        result.put("status", 1);
        return result;
    }

    // 添加更新用户名和地址的接口（根据手机号）
    @PostMapping("/UpdateUserInfo")
    public Map<String, Object> updateUserInfo(@RequestBody User user) {
//        System.out.println(user);
        return userLoginService.updateUserNameAndLocalByPhone(user);
    }

}
