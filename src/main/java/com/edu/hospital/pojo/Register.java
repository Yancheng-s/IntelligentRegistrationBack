package com.edu.hospital.pojo;

import lombok.Data;

@Data
public class Register {
    private Integer id;                    // 主键ID
    private String caseNumber;             // 病历号
    private String realName;               // 姓名
    private String gender;                 // 性别（男、女）
    private String cardNumber;             // 身份证号
    private String birthday;               // 出生日期
    private Integer age;                   // 年龄
    private String ageType;                // 年龄类型（年、天）
    private String homeAddress;            // 家庭住址
    private String visitDate;              // 本次就诊日期
    private String noon;                   // 午别（上午、下午）
    private Integer departmentId;          // 本次挂号科室id
    private Integer employeeId;            // 本次挂号医生id
    private Integer registLevelId;         // 本次挂号级别id
    private Integer settleCategoryId;      // 结算类别id
    private String isBook;                // 病历本要否（是、否）
    private String registMethod;           // 收费方式（现金、银行卡、微信、医保卡、支付宝）
    private Integer visitState;            // 本次看诊状态（1-已挂号2-医生接诊3-看诊结束4-已退号）
    private Double registMoney;            // 挂号金额
}
