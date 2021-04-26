package com.biz.practice.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @projectName: Week01
 * @className: Permission
 * @description:
 * @author: xy
 * @time: 2021/4/25 20:26
 */
@Table(name = "permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "encode")
    private String encode;
    @Column(name = "name")
    private String name;

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
}
