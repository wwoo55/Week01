package com.biz.practice.service.impl;

import com.biz.practice.dao.IPermissionDao;
import com.biz.practice.entity.Permission;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @projectName: Week01
 * @className: PermissionServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/4/25 20:32
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired(required = false)
    private IPermissionDao permissionDao;

    @Override
    public PageResponseDTO<Permission> listPermission(String key, Integer page, Integer limit) {
        PageResponseDTO<Permission> responseDTO = new PageResponseDTO<>();

        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%" + key + "%");
        PageHelper.startPage(page, limit);
        List<Permission> list = this.permissionDao.selectByExample(example);

        // 当无数据时
        if (CollectionUtils.isEmpty(list)) {
            // code:1 表示失败
            responseDTO.setCode(1);
            responseDTO.setMsg("抱歉没有找到与之相关的权限");
            return responseDTO;
        }

        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        responseDTO.setCode(0);
        responseDTO.setCount((int) pageInfo.getTotal());
        responseDTO.setData(pageInfo.getList());
        return responseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPermission(Permission permission) {
        return this.permissionDao.insertSelective(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePermission(Permission permission) {
        return this.permissionDao.updateByPrimaryKeySelective(permission);
    }

    @Override
    public List<Permission> listPermissionAll() {
        return this.permissionDao.selectAll();
    }
}
