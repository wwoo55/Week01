package com.biz.practice.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @projectName: Week01
 * @className: RolePermission
 * @description:
 * @author: xy
 * @time: 2021/4/26 18:37
 */
@Table(name = "role_permission")
public class RolePermission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rid")
    private Long rid;
    @Column(name = "pid")
    private Long pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
