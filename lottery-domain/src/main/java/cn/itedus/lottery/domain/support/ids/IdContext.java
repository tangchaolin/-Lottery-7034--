package cn.itedus.lottery.domain.support.ids;

import cn.hutool.core.lang.Snowflake;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.support.ids.policy.RandomNumeric;
import cn.itedus.lottery.domain.support.ids.policy.ShortCode;
import cn.itedus.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Id 策略模式上下文配置【在正式的完整的系统架构中，ID的生成会有单独的服务来文成，其他的服务来调用ID生成接口即可]
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/19 0019
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Configuration
public class IdContext {
    /**
     * 创建ID 生成策略对象，属于策略设计模式的使用方式
     * @param snowFlake 雪花算法，长码，大量
     * @param randomNumeric 随机算法，短码，大量，全局唯一需要自己保证。
     * @param shortCode 日期算法，短码，全局唯一需要自己保证
     * @return
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, RandomNumeric randomNumeric, ShortCode shortCode){
        Map<Constants.Ids, IIdGenerator> map = new HashMap<>();
        map.put(Constants.Ids.SnowFlake,snowFlake);
        map.put(Constants.Ids.RandomNumeric, randomNumeric);
        map.put(Constants.Ids.ShortCode, shortCode);
        return map;
    }


}
