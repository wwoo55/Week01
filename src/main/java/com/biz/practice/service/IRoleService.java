package com.biz.practice.service;

import com.biz.practice.entity.Role;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.pojo.RoleDTO;
import com.biz.practice.pojo.RoleVo;

public interface IRoleService {
    /**
     * 返回角色列表
     * @param key
     * @param page
     * @param limit
     * @return
     */
    PageResponseDTO<RoleDTO> listRole(String key, Integer page, Integer limit);

    /**
     * 更新角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 禁用角色
     * @param id
     * @return
     */
    int banRole(Long id);

    /**
     * 插入新角色
     * @param roleVo
     * @return
     */
    int insertRole(RoleVo roleVo);
}
