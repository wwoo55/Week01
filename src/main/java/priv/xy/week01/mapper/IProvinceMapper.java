package priv.xy.week01.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.xy.week01.domain.Province;

import java.util.List;

@Mapper
public interface IProvinceMapper {
    /**
     * 查询所有省
     *
     * @return
     */
    List<Province> selectAll();

    /**
     * 根据pid查找省
     *
     * @param provinceId
     * @return
     */
    Province selectByPid(Long provinceId);
}
