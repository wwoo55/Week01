package com.biz.practice.pojo;

/**
 * @projectName: Week01
 * @className: RoleVo
 * @description: 封装前端来的数据Role
 * @author: xy
 * @time: 2021/4/26 14:01
 */
public class RoleVo {
    private Long id;
    private String encode;
    private String name;
    /**
     * 0:禁用
     * 1;启用
     */
    private Integer status;
    /**
     * on:启用
     * null:禁用
     */
    private String statusHas;

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

    public String getStatusHas() {
        return statusHas;
    }

    public void setStatusHas(String statusHas) {
        this.statusHas = statusHas;
    }
}
