package cn.itedus.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;
import sun.nio.ch.Net;

import javax.annotation.PostConstruct;

/**
 * @description: 工具包下的雪花算法，15位雪花算法推荐
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/19 0019
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class SnowFlake implements IIdGenerator {
    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        long workerId;

        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());

        }catch (Exception e){
            workerId=NetUtil.getLocalhostStr().hashCode();
        }
        workerId=workerId>>16&31;

        long dataCenterId=1L;
        snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
    }



    @Override
    public synchronized long nextId() {
        return snowflake.nextId();
    }
}
