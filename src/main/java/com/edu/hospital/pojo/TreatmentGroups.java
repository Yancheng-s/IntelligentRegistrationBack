// TreatmentGroups.java
package com.edu.hospital.pojo;

public class TreatmentGroups {

    private Integer id;
    private String realName;
    private String treatmentName;
    private String idCard;
    private String phone;
    private String address;

    // 默认构造函数
    public TreatmentGroups() {}

    // 带参构造函数
    public TreatmentGroups(Integer id, String realName, String treatmentName, String idCard, String phone, String address) {
        this.id = id;
        this.realName = realName;
        this.treatmentName = treatmentName;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TreatmentGroups{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", treatmentName='" + treatmentName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
