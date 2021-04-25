package com.biz.practice.controller;

import com.biz.practice.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biz.practice.service.ICityService;

import java.util.List;

/**
 * @projectName: Week01
 * @className: CityController
 * @description:
 * @author: xy
 * @time: 2021/4/20 19:07
 */
@RestController
public class CityController {

    @Autowired
    private ICityService iCityService;

    @GetMapping("/city")
    public List<City> listCity(Long pid) {
        return this.iCityService.listCity(pid);
    }
}
