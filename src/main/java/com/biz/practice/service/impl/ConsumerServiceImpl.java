package com.biz.practice.service.impl;

import com.biz.practice.entity.City;
import com.biz.practice.entity.Consumer;
import com.biz.practice.entity.Province;
import com.biz.practice.dao.ICityDao;
import com.biz.practice.dao.IConsumerDao;
import com.biz.practice.dao.IProvinceDao;
import com.biz.practice.pojo.ConsumerDTO;
import com.biz.practice.pojo.ConsumerVO;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.service.IConsumerService;
import com.biz.practice.util.JedisUtils;
import com.biz.practice.util.SerializeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.biz.practice.util.DateTimeUtils;

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
    private IConsumerDao iConsumerDao;
    @Autowired
    private IProvinceDao iProvinceDao;
    @Autowired
    private ICityDao iCityDao;

    @Override
    @Transactional
    public boolean insertConsumer(ConsumerVO consumerVo) {

        Consumer consumer = new Consumer();
        consumer.setName(consumerVo.getName());
        consumer.setPassword(consumerVo.getPassword());
        consumer.setEmail(consumerVo.getEmail());
        // 拼接地址
        Province province = this.iProvinceDao.selectByPid(consumerVo.getProvinceId());
        City city = this.iCityDao.selectByCid(consumerVo.getCityId());
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

        int result = this.iConsumerDao.insert(consumer);
        return result == 1;
    }

    @Override
    public Consumer loginConsumer(ConsumerVO consumerVo) {
        Consumer consumer = new Consumer();
        consumer.setName(consumerVo.getName());
        consumer.setPassword(consumerVo.getPassword());
        return this.iConsumerDao.selectCheck(consumer);
    }

    @Override
    public PageResponseDTO<ConsumerDTO> listConsumer(String key, Integer page, Integer limit) {

        PageResponseDTO<ConsumerDTO> responseDTO = new PageResponseDTO<>();

        PageHelper.startPage(page, limit);
        List<Consumer> list = this.iConsumerDao.selectByKey(key);

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
        int i = this.iConsumerDao.delete(id);
        return i == 1;
    }

    @Override
    public Consumer getConsumerById(Long id) {
        // 1.查询redis中有无此对象
        byte[] bytes = JedisUtils.readConsumer(id);
        // 2.如果有，就直接返回对象
        if (bytes!=null){
            return (Consumer) SerializeUtils.unSerialize(bytes);
        }
        // 3.如果没有，从数据库中读取，并在redis中写入
        Consumer consumer = this.iConsumerDao.selectById(id);
        JedisUtils.writeConsumer(consumer);
        return consumer;
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
        Province province = this.iProvinceDao.selectByPid(consumerVo.getProvinceId());
        City city = this.iCityDao.selectByCid(consumerVo.getCityId());
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

        int result = this.iConsumerDao.update(consumer);
        return result == 1;
    }
}
