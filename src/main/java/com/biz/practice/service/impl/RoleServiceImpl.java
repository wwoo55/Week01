package com.biz.practice.service.impl;

import com.biz.practice.dao.IRoleDao;
import com.biz.practice.entity.Role;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.pojo.RoleDTO;
import com.biz.practice.pojo.RoleVo;
import com.biz.practice.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: Week01
 * @className: RoleServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/4/25 20:34
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired(required = false)
    private IRoleDao roleDao;

    @Override
    public PageResponseDTO<RoleDTO> listRole(String key, Integer page, Integer limit) {
        PageResponseDTO<RoleDTO> responseDTO = new PageResponseDTO<>();

        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%" + key + "%");
        PageHelper.startPage(page, limit);
        List<Role> list = this.roleDao.selectByExample(example);

        // 当无数据时
        if (CollectionUtils.isEmpty(list)) {
            // code:1 表示失败
            responseDTO.setCode(1);
            responseDTO.setMsg("抱歉没有找到与之相关的角色");
            return responseDTO;
        }
        // Role->RoleDTO
        List<RoleDTO> collect = list.stream().map(item -> {
            RoleDTO dto = new RoleDTO();
            BeanUtils.copyProperties(item, dto);
            dto.setStatusStr(item.getStatus() == 1 ? "启用" : "禁用");
            return dto;
        }).collect(Collectors.toList());

        PageInfo<Role> pageInfo = new PageInfo<>(list);
        PageInfo<RoleDTO> roleDTOPageInfo = new PageInfo<>(collect);

        responseDTO.setCode(0);
        responseDTO.setCount((int) pageInfo.getTotal());
        responseDTO.setData(roleDTOPageInfo.getList());
        return responseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRole(Role role) {
        return this.roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int banRole(Long id) {
        Role role = this.roleDao.selectByPrimaryKey(id);
        int flag = 0;
        if (role != null) {
            if (role.getStatus() == 0) {
                flag = 1;
            }
            // 重新new个对象避免sql更新所有字段
            Role roleA = new Role();
            roleA.setId(role.getId());
            roleA.setStatus(flag);
            return this.roleDao.updateByPrimaryKeySelective(roleA);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertRole(RoleVo roleVo) {
        if (roleVo.getStatusHas() != null) {
            // 选择 启用
            roleVo.setStatus(1);
        }
        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        return this.roleDao.insertSelective(role);
    }
}
