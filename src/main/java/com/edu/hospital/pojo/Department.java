package com.edu.hospital.pojo;

import lombok.Data;

@Data
public class Department {
    private Integer id; // ID主键
    private String deptCode; // 科室编码
    private String deptName; // 科室名称
    private String deptType; // 科室类型（门诊、检查、检验、处置）
    private Integer delmark; // 生效标记
    private Integer doctorId; // 医生id
    private String strongPoint; // 特长点
}
