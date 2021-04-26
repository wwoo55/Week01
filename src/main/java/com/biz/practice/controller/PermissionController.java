package com.biz.practice.controller;

import com.biz.practice.entity.Permission;
import com.biz.practice.entity.Role;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.pojo.ResultInfoDTO;
import com.biz.practice.pojo.RoleDTO;
import com.biz.practice.pojo.RoleVo;
import com.biz.practice.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: Week01
 * @className: PermissionController
 * @description:
 * @author: xy
 * @time: 2021/4/26 16:30
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 返回权限列表
     * @param key 搜索关键字
     * @param page 页数
     * @param limit 一页条数
     * @return
     */
    @GetMapping("/listPermission")
    public PageResponseDTO<Permission> listPermission(@RequestParam(name = "key", required = false) String key,
                                                @RequestParam(name = "page", required = false) Integer page,
                                                @RequestParam(name = "limit", required = false) Integer limit){
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
        return this.permissionService.listPermission(key,page,limit);
    }

    /**
     * 插入新权限
     * @param permission
     * @return
     */
    @PostMapping("/common")
    public ResultInfoDTO insertPermission(Permission permission){
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        int resultNum = this.permissionService.insertPermission(permission);
        infoDTO.setFlag(resultNum==1);
        return infoDTO;
    }

    /**
     * 编辑权限
     * @param permission
     * @return
     */
    @PutMapping("/common")
    public ResultInfoDTO updatePermission(Permission permission){
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        int resultNum = this.permissionService.updatePermission(permission);
        infoDTO.setFlag(resultNum==1);
        return infoDTO;
    }
}
