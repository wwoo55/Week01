package priv.xy.week01.service;

import priv.xy.week01.domain.Province;

import java.util.List;

public interface IProvinceService {

    /**
     * 返回province集合
     *
     * @return
     */
    List<Province> listProvince();
}
