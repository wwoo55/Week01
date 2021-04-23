package priv.xy.week01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.xy.week01.domain.City;
import priv.xy.week01.service.ICityService;

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
