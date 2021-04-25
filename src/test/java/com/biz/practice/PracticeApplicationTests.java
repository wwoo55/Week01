package com.biz.practice;

import com.biz.practice.entity.Consumer;
import com.biz.practice.util.SerializeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PracticeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJedis() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");

        /*jedis.lpush("LOGIN_LOG","xx" + DateTimeUtils.formatDateToString(new Date()));
        jedis.lpush("LOGIN_LOG","xx"+ DateTimeUtils.formatDateToString(new Date()));*/

        List<String> list = jedis.lrange("LOGIN_LOG", 0, -1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    @Test
    public void objJedis() {
        Consumer consumer = new Consumer();
        consumer.setId(1L);
        consumer.setName("admin");
        consumer.setPassword("123");
        consumer.setAddress("xxxxx");
        consumer.setEmail("111@qq.com");
        consumer.setHobby("打羽毛球/看书");
        consumer.setGmtCreate(new Date());
        consumer.setGmtModified(consumer.getGmtCreate());

        Jedis jedis = new Jedis("localhost");
        // 执行此方法对象需要实现Serializable接口
        jedis.set((consumer.getId() + "").getBytes(), SerializeUtils.serialize(consumer));
        // 设置 redis 缓存过期时间
        jedis.expire((consumer.getId() + "").getBytes(),60*60*30);
        byte[] bytes = jedis.get((1 + "").getBytes());
        System.out.println(bytes);
        System.out.println(bytes==null);
        System.out.println(SerializeUtils.unSerialize(bytes));
    }

}
