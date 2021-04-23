package priv.xy.week01.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.xy.week01.domain.City;

import java.util.List;

@Mapper
public interface ICityMapper {

    /**
     * 通过pid查找一个省所拥有的所有城市
     *
     * @param pid
     * @return
     */
    List<City> selectByPid(Long pid);

    /**
     * 根据cid查找对应的市
     *
     * @param cityId
     * @return
     */
    City selectByCid(Long cityId);
}
