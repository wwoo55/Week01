package priv.xy.week01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import priv.xy.week01.domain.Province;
import priv.xy.week01.service.IProvinceService;

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
