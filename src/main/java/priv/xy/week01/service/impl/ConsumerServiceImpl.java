package priv.xy.week01.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import priv.xy.week01.domain.City;
import priv.xy.week01.domain.Consumer;
import priv.xy.week01.domain.Province;
import priv.xy.week01.mapper.ICityMapper;
import priv.xy.week01.mapper.IConsumerMapper;
import priv.xy.week01.mapper.IProvinceMapper;
import priv.xy.week01.pojo.ConsumerDTO;
import priv.xy.week01.pojo.ConsumerVO;
import priv.xy.week01.pojo.PageResponseDTO;
import priv.xy.week01.service.IConsumerService;
import priv.xy.week01.util.DateTimeUtils;

import java.beans.Transient;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: Week01
 * @className: ConsumerServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/4/21 14:16
 */
@Service
public class ConsumerServiceImpl implements IConsumerService {

    @Autowired
    private IConsumerMapper iConsumerMapper;
    @Autowired
    private IProvinceMapper iProvinceMapper;
    @Autowired
    private ICityMapper iCityMapper;

    @Override
    @Transactional
    public boolean insertConsumer(ConsumerVO consumerVo) {

        Consumer consumer = new Consumer();
        consumer.setName(consumerVo.getName());
        consumer.setPassword(consumerVo.getPassword());
        consumer.setEmail(consumerVo.getEmail());
        // 拼接地址
        Province province = this.iProvinceMapper.selectByPid(consumerVo.getProvinceId());
        City city = this.iCityMapper.selectByCid(consumerVo.getCityId());
        consumer.setAddress(province.getName() + "/" + city.getName());
        // 拼接爱好
        String[] hobby = consumerVo.getHobby();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : hobby) {
            stringBuilder.append(str).append("/");
        }
        consumer.setHobby(stringBuilder.toString());
        // 时间
        consumer.setGmtCreate(new Date());
        consumer.setGmtModified(consumer.getGmtCreate());

        int result = this.iConsumerMapper.insert(consumer);
        return result == 1;
    }

    @Override
    public Consumer loginConsumer(ConsumerVO consumerVo) {
        Consumer consumer = new Consumer();
        consumer.setName(consumerVo.getName());
        consumer.setPassword(consumerVo.getPassword());
        return this.iConsumerMapper.selectCheck(consumer);
    }

    @Override
    public PageResponseDTO<ConsumerDTO> listConsumer(String key, Integer page, Integer limit) {

        PageResponseDTO<ConsumerDTO> responseDTO = new PageResponseDTO<>();

        PageHelper.startPage(page, limit);
        List<Consumer> list = this.iConsumerMapper.selectByKey(key);

        // BeanUtil 时间格式转换 封装DTO
        List<ConsumerDTO> collect = list.stream().map(item -> {
            ConsumerDTO dto = new ConsumerDTO();
            BeanUtils.copyProperties(item, dto);
            dto.setGmtCreateStr(DateTimeUtils.formatDateToString(item.getGmtCreate()));
            dto.setGmtModifiedStr(DateTimeUtils.formatDateToString(item.getGmtModified()));
            return dto;
        }).collect(Collectors.toList());

        PageInfo<Consumer> pageInfo = new PageInfo<>(list);
        PageInfo<ConsumerDTO> consumerPageInfo = new PageInfo<>(collect);

        // 当无数据时
        if (CollectionUtils.isEmpty(list)) {
            // code:1 表示失败
            responseDTO.setCode(1);
            responseDTO.setMsg("抱歉没有找到与之相关的用户");
        }
        responseDTO.setCode(0);
        responseDTO.setCount((int) pageInfo.getTotal());
        responseDTO.setData(consumerPageInfo.getList());
        return responseDTO;
    }

    @Override
    @Transactional
    public boolean deleteConsumer(Long id) {
        int i = this.iConsumerMapper.delete(id);
        return i == 1;
    }

    @Override
    public Consumer getConsumerById(Long id) {
        return this.iConsumerMapper.selectById(id);
    }

    @Override
    @Transactional
    public boolean updateConsumer(ConsumerVO consumerVo) {
        Consumer consumer = new Consumer();
        consumer.setId(consumerVo.getId());
        consumer.setName(consumerVo.getName());
        consumer.setPassword(consumerVo.getPassword());
        consumer.setEmail(consumerVo.getEmail());
        // 拼接地址
        Province province = this.iProvinceMapper.selectByPid(consumerVo.getProvinceId());
        City city = this.iCityMapper.selectByCid(consumerVo.getCityId());
        consumer.setAddress(province.getName() + "/" + city.getName());
        // 拼接爱好
        String[] hobby = consumerVo.getHobby();
        StringBuilder stringBuilder = new StringBuilder();
        if (hobby != null) {
            for (String str : hobby) {
                stringBuilder.append(str).append("/");
            }
            consumer.setHobby(stringBuilder.toString());
        }
        // 时间
        consumer.setGmtModified(new Date());
        System.out.println(consumer);

        int result = this.iConsumerMapper.update(consumer);
        return result == 1;
    }
}
