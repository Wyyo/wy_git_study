package com.qs;

import com.qs.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;


public class JedisTest {
    @Test
    public void testJedis(){
//        1.连接
//        Jedis jedis = new Jedis("192.168.226.128", 6379);
        Jedis jedis = JedisUtils.getJedis();
//        2.操作
        String set = jedis.set("name", "wuyi");
        String name = jedis.get("name");
        System.out.println("name=" + name);
        jedis.set("nickname", "汉三");
        System.out.println(jedis.get("nickname"));
//        3.关闭
        jedis.close();
    }

}
