package priv.xy.week01.service;

import priv.xy.week01.domain.City;

import java.util.List;

public interface ICityService {
    /**
     * 把相应省市包含的城市全部查出来
     *
     * @param pid
     * @return
     */
    List<City> listCity(Long pid);
}
