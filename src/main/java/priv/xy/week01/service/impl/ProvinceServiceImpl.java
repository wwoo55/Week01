package priv.xy.week01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.xy.week01.domain.Province;
import priv.xy.week01.mapper.IProvinceMapper;
import priv.xy.week01.service.IProvinceService;

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
    private IProvinceMapper iProvinceMapper;


    @Override
    public List<Province> listProvince() {
        return iProvinceMapper.selectAll();
    }
}
