package cn.itedus.lottery.interfaces.test.domain;

import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.res.EngineResult;
import cn.itedus.lottery.domain.rule.service.engine.EngineFilter;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description: 规则引擎测试
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleTest {

    @Resource
    private EngineFilter engineFilter;


    private Logger logger = LoggerFactory.getLogger(RuleTest.class);

    @Test
    public void test_process() {
        DecisionMatterReq req = new DecisionMatterReq();
        req.setTreeId(2110081902L);
        req.setUserId("小林哥");
        req.setValMap(new HashMap<String,Object>(){{
            put("gender", "man");
            put("age", "25");

            }});
        EngineResult res = engineFilter.process(req);

        logger.info("请求参数：{}", JSON.toJSONString(req));
        logger.info("测试结果：{}",JSON.toJSONString(res));


    }




}
