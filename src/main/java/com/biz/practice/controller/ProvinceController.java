package com.biz.practice.controller;

import com.biz.practice.entity.Province;
import com.biz.practice.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName: Week01
 * @className: ProvinceController
 * @description:
 * @author: xy
 * @time: 2021/4/20 19:01
 */
@RestController
public class ProvinceController {

    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping("/province")
    public List<Province> listProvince() {
        return this.iProvinceService.listProvince();
    }
}
