package com.biz.practice.service;

import com.biz.practice.entity.Permission;

import java.util.List;

/**
 * @author xy
 */
public interface IRolePermissionService {
    /**
     * 返回指定RoleId的listPermission
     * @param id
     * @return
     */
    List<Permission> listPermissionByRoleId(Long id);

    /**
     * 更改指定rid的权限
     * 需要先删除再插入
     * @param rid
     * @param pids
     * @return
     */
    int updateRolePermission(Long rid, Long[] pids);
}
