package com.edu.hospital.pojo;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String userName;
    private String userLocal;
    private String userPhone;
    private String userHeadPortrait;
    private String clientForm;
    private String clientName;
    private String clientCard;
    private String clientIdcard;
    // 添加setter和getter方法
    public void setUsername(String username) {
        this.userName = username;
    }

    public String getUsername() {
        return userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.userPhone = phoneNumber;
    }

    public String getPhoneNumber() {
        return userPhone;
    }

}
