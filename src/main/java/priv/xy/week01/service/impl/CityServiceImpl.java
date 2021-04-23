package priv.xy.week01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.xy.week01.domain.City;
import priv.xy.week01.mapper.ICityMapper;
import priv.xy.week01.service.ICityService;

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
    private ICityMapper iCityMapper;

    @Override
    public List<City> listCity(Long pid) {
        return this.iCityMapper.selectByPid(pid);
    }
}
