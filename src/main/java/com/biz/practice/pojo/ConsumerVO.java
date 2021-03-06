package com.biz.practice.pojo;

import java.util.Arrays;
import java.util.Date;

/**
 * @projectName: Week01
 * @className: ConsumerVo
 * @description:
 * @author: xy
 * @time: 2021/4/21 13:43
 */
public class ConsumerVO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String[] hobby;
    private Date gmtCreate;
    private Date gmtModified;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    private Long provinceId;
    private Long cityId;

    // login 字段
    private String verify;

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "ConsumerVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", verify='" + verify + '\'' +
                '}';
    }
}
