package com.biz.practice.dao;

import org.apache.ibatis.annotations.Mapper;
import com.biz.practice.entity.Province;

import java.util.List;

@Mapper
public interface IProvinceDao {
    /**
     * 查询所有省
     *
     * @return
     */
    List<Province> selectAll();

    /**
     * 根据pid查找省
     *
     * @param provinceId
     * @return
     */
    Province selectByPid(Long provinceId);
}
