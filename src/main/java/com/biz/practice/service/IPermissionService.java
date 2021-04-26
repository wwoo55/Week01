package com.biz.practice.service;

import com.biz.practice.entity.Permission;
import com.biz.practice.pojo.PageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface IPermissionService {

    /**
     * 返回权限list
     *
     * @param key
     * @param page
     * @param limit
     * @return
     */
    PageResponseDTO<Permission> listPermission(String key, Integer page, Integer limit);

    /**
     * 添加一个权限
     *
     * @param permission
     * @return
     */
    int insertPermission(Permission permission);

    /**
     * 更新一个权限
     *
     * @param permission
     * @return
     */
    int updatePermission(Permission permission);
}
