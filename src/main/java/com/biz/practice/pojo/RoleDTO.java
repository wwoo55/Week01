package com.biz.practice.pojo;

import javax.persistence.Column;

/**
 * @projectName: Week01
 * @className: RoleDTO
 * @description: Role 返回页面的对象
 * @author: xy
 * @time: 2021/4/26 9:00
 */
public class RoleDTO {
    private Long id;
    private String encode;
    private String name;
    /**
     * 0:禁用
     * 1;启用
     */
    private Integer status;
    private String statusStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
