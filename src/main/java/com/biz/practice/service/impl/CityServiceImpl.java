package com.biz.practice.service.impl;

import com.biz.practice.entity.City;
import com.biz.practice.dao.ICityDao;
import com.biz.practice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: Week01
 * @className: CityServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/4/20 17:56
 */
@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityDao iCityDao;

    @Override
    public List<City> listCity(Long pid) {
        return this.iCityDao.selectByPid(pid);
    }
}
