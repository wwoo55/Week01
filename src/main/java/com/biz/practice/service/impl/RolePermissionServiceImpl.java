package com.biz.practice.service.impl;

import com.biz.practice.dao.IPermissionDao;
import com.biz.practice.dao.IRolePermissionDao;
import com.biz.practice.entity.Permission;
import com.biz.practice.entity.RolePermission;
import com.biz.practice.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @projectName: Week01
 * @className: RolePermissionServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/4/26 18:49
 */
@Service
public class RolePermissionServiceImpl implements IRolePermissionService {

    @Autowired(required = false)
    private IRolePermissionDao rolePermissionDao;
    @Autowired(required = false)
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> listPermissionByRoleId(Long id) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRid(id);
        List<RolePermission> list = this.rolePermissionDao.select(rolePermission);
        System.out.println(list);
        return list.stream().map(item -> {
            return this.permissionDao.selectByPrimaryKey(item.getPid());
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRolePermission(Long rid, Long[] pids) {
        // 1.删除rid角色的所有权限
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRid(rid);
        int resultNumA = this.rolePermissionDao.delete(rolePermission);

        // 2.重新为角色添加权限
        // 相当于一个标记判断是否插入成功
        AtomicInteger resultNumB = new AtomicInteger(1);
        List<Long> pidList = Arrays.asList(pids);
        if (!CollectionUtils.isEmpty(pidList)){
            pidList.stream().forEach(item->{
                // 必须重新new对象不然下面插入的id Duplicate for key 'PRIMARY'
                RolePermission rolePermissionTemp = new RolePermission();
                rolePermissionTemp.setRid(rid);
                rolePermissionTemp.setPid(item);
                int resultNumC = this.rolePermissionDao.insertSelective(rolePermissionTemp);
                if (resultNumC == 0){
                    resultNumB.set(0);
                }
            });
        }

        return (0 != resultNumA)&&(1 == resultNumB.intValue())?1:0;
    }
}
