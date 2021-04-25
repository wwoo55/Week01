package com.biz.practice.service.impl;

import com.biz.practice.dao.IProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biz.practice.entity.Province;
import com.biz.practice.service.IProvinceService;

import java.util.List;

/**
 * @projectName: Week01
 * @className: ProvinceServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/4/20 17:21
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private IProvinceDao iProvinceDao;


    @Override
    public List<Province> listProvince() {
        return iProvinceDao.selectAll();
    }
}
