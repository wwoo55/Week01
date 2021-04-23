package priv.xy.week01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import priv.xy.week01.util.DateTimeUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Week01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");

        /*jedis.lpush("LOGIN_LOG","xx" + DateTimeUtils.formatDateToString(new Date()));
        jedis.lpush("LOGIN_LOG","xx"+ DateTimeUtils.formatDateToString(new Date()));*/

        List<String> list = jedis.lrange("LOGIN_LOG", 0 ,-1);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }

}
