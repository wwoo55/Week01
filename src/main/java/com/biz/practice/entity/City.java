package com.biz.practice.entity;

import java.io.Serializable;

/**
 * @projectName: Week01
 * @className: city
 * @description:
 * @author: xy
 * @time: 2021/4/20 17:13
 */
public class City implements Serializable {

    private Long id;
    private Long cid;
    private String name;
    private Long pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
