package com.mall.content;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author zwq
 * @date 2018/11/23 14:35
 */
public class JedisTest {

    @Test
    public void testJedis() throws Exception {
        // 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 第二步：使用Jedis对象操作数据库，每个redis命令对应一个方法。
        String result = jedis.get("hello");
        // 第三步：打印结果。
        System.out.println(result);
        // 第四步：关闭Jedis
        jedis.close();
    }

}
