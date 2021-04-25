package com.biz.practice.dao;

import org.apache.ibatis.annotations.Mapper;
import com.biz.practice.entity.Consumer;

import java.util.List;

@Mapper
public interface IConsumerDao {

    /**
     * 插入新客户
     *
     * @param consumer
     * @return
     */
    int insert(Consumer consumer);

    /**
     * 验证consumer密码是否正确
     *
     * @param consumer
     * @return
     */
    Consumer selectCheck(Consumer consumer);

    /**
     * 根据key模糊查询
     *
     * @param key
     * @return
     */
    List<Consumer> selectByKey(String key);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 返回指定id的用户
     *
     * @param id
     * @return
     */
    Consumer selectById(Long id);

    /**
     * 更新用户
     *
     * @param consumer
     * @return
     */
    int update(Consumer consumer);
}
