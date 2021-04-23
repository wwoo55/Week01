package priv.xy.week01.util;

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
public class LoginLogJedisUtils {

    /**
     * 也可以从配置文件中读取
     */
    private static final Jedis jedis = new Jedis("localhost");

    private LoginLogJedisUtils() {
    }

    /**
     * 根据传入用户名写登录日志
     *
     * @param name
     */
    public static void writeLoginLog(String name) {
        jedis.lpush("LOGIN_LOG_"+name.toUpperCase(), name + "/" + DateTimeUtils.formatDateToString(new Date()));
    }

    public static List<String> readLoginLog(String name){
        return jedis.lrange("LOGIN_LOG_"+name.toUpperCase(), 0 ,-1);
    }
}
