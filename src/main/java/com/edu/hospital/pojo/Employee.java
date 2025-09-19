package com.edu.hospital.pojo;

import lombok.Data;

@Data
public class Employee {
    private String strongPoint;

    public String getStrongPoint() {
        return strongPoint;
    }

    public void setStrongPoint(String strongPoint) {
        this.strongPoint = strongPoint;
    }

    private Integer id; // 主键ID
    private String realname; // 真实姓名
    private String password; // 密码
    private Integer deptmentId; // 所在科室ID
    private Integer registLevelId; // 挂号级别ID
    private Integer schedulingId; // 排班ID
    private Integer delmark; // 生效标记
    private Integer num; // 历史预约人数
}

