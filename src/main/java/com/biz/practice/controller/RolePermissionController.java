package com.biz.practice.controller;

import com.biz.practice.entity.Permission;
import com.biz.practice.pojo.ResultInfoDTO;
import com.biz.practice.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

/**
 * @projectName: Week01
 * @className: RolePermissionController
 * @description: 负责RolePermission中间表的控制器
 * @author: xy
 * @time: 2021/4/26 17:49
 */
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {

    @Autowired
    private IRolePermissionService rolePermissionService;

    /**
     * 返回指定RoleId的listPermission
     * 用于页面的初始化
     *
     * @param id
     * @return
     */
    @GetMapping("/list")
    public ResultInfoDTO listPermissionByRoleId(@RequestParam(name = "rid") Long id) {
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        List<Permission> list = this.rolePermissionService.listPermissionByRoleId(id);
        if (!CollectionUtils.isEmpty(list)) {
            infoDTO.setFlag(true);
            infoDTO.setData(list);
            return infoDTO;
        }
        infoDTO.setFlag(false);
        return infoDTO;
    }

    /**
     * 更改指定rid的权限
     *
     * @param rid
     * @param pids
     * @return
     */
    @PutMapping("/common")
    public ResultInfoDTO updateRolePermission(@RequestParam(name = "roleId") Long rid,
                                              @RequestParam(name = "permissionId") Long[] pids) {
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        int resultNum = this.rolePermissionService.updateRolePermission(rid, pids);
        infoDTO.setFlag(resultNum != 0);
        return infoDTO;
    }
}
