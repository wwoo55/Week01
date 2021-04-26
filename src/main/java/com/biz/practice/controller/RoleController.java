package com.biz.practice.controller;

import com.biz.practice.entity.Role;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.pojo.ResultInfoDTO;
import com.biz.practice.pojo.RoleDTO;
import com.biz.practice.pojo.RoleVo;
import com.biz.practice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

/**
 * @projectName: Week01
 * @className: RoleController
 * @description:
 * @author: xy
 * @time: 2021/4/26 8:56
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 返回 角色list
     *
     * @param key   角色名
     * @param page  页数
     * @param limit 每页几条
     * @return
     */
    @GetMapping("/listRole")
    public PageResponseDTO<RoleDTO> listRole(@RequestParam(name = "key", required = false) String key,
                                             @RequestParam(name = "page", required = false) Integer page,
                                             @RequestParam(name = "limit", required = false) Integer limit) {
        if (StringUtils.isEmpty(key)) {
            key = "";
        }
        if (page == null) {
            // 默认页数
            page = 1;
        }
        if (limit == null) {
            // 默认一页条数
            limit = 3;
        }
        return this.roleService.listRole(key, page, limit);
    }

    /**
     * 插入角色
     *
     * @param roleVo
     * @return
     */
    @PostMapping("/common")
    public ResultInfoDTO insertRole(RoleVo roleVo) {
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        int resultNum = this.roleService.insertRole(roleVo);
        infoDTO.setFlag(resultNum == 1);
        return infoDTO;
    }

    /**
     * 编辑角色
     *
     * @param role
     * @return
     */
    @PutMapping("/common")
    public ResultInfoDTO updateRole(Role role) {
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        int resultNum = this.roleService.updateRole(role);
        infoDTO.setFlag(resultNum == 1);
        return infoDTO;
    }

    /**
     * 禁用指定id角色
     */
    @PutMapping("/ban/{id}")
    public ResultInfoDTO banRole(@PathVariable(name = "id") Long id) {
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        int resultNum = this.roleService.banRole(id);
        infoDTO.setFlag(resultNum == 1);
        return infoDTO;
    }
}
