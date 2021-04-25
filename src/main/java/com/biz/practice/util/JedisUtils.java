package com.biz.practice.util;

import com.biz.practice.entity.Consumer;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

/**
 * @projectName: Week01
 * @className: LoginLogJedisUtils
 * @description:
 * @author: xy
 * @time: 2021/4/23 9:59
 */
public class JedisUtils {

    /**
     * 也可以从配置文件中读取
     */
    private static final Jedis jedis = new Jedis("localhost");

    private JedisUtils() {
    }

    /**
     * 根据传入用户名写登录日志
     *
     * @param name
     */
    public static void writeLoginLog(String name) {
        jedis.lpush("LOGIN_LOG_" + name.toUpperCase(), name + "/" + DateTimeUtils.formatDateToString(new Date()));
    }

    /**
     * 根据传入用户名返回登录日志
     *
     * @param name
     * @return
     */
    public static List<String> readLoginLog(String name) {
        return jedis.lrange("LOGIN_LOG_" + name.toUpperCase(), 0, -1);
    }


    /**
     *  将对象序列化并存入redis
     * @param consumer
     */
    public static void writeConsumer(Consumer consumer){
        // 执行此方法对象需要实现Serializable接口
        jedis.set((consumer.getId() + "").getBytes(), SerializeUtils.serialize(consumer));
        // 设置 redis 缓存过期时间 30分钟
        jedis.expire((consumer.getId() + "").getBytes(),60*60*30);
    }

    /**
     * 根据key 返回byte[]
     * 如果等于null 说明redis无相应数据，需要从mysql中读取
     * 如过不等于null 说明redis有数据，可用SerializeUtils.unSerialize将byte[]转化对象
     * @param id
     * @return
     */
    public static byte[] readConsumer(Long id){
        return jedis.get((id + "").getBytes());
    }
}
