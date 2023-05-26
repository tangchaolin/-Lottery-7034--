package cn.itedus.lottery.interfaces.test.infrastructure;

import cn.itedus.lottery.infrastructure.util.RedisUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.xml.bind.util.JAXBSource;

/**
 * @description: Redis 使用测试
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/26 0026
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
    private Logger logger = LoggerFactory.getLogger(RedisUtilTest.class);
    @Resource
    private RedisUtil redisUtil;
    @Test
    public void test_set() {
        redisUtil.set("lottery_user_key", "xiaolinge");
    }
    @Test
    public void test_get() {
        Object user=redisUtil.get("lottery_user_key");
        logger.info(JSON.toJSONString(user));

    }


}
