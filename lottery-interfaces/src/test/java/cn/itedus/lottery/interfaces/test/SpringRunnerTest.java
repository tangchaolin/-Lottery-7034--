package cn.itedus.lottery.interfaces.test;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {


    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);
    @Resource
    private IActivityDao activityDao ;

    @Resource
    private IDrawAlgorithm randomDrawAlgorithm;
    @Test
    public void testRandomDrawAlgorithm() {
        List<AwardRateInfo> list = new ArrayList<>();
        list.add(new AwardRateInfo("一等奖：特斯拉model3", new BigDecimal("0.2")));
        list.add(new AwardRateInfo("二等奖：华菱空调", new BigDecimal("0.3")));
        list.add(new AwardRateInfo("三等奖:小米手机", new BigDecimal("0.5")));

        randomDrawAlgorithm.initRateTuple(100001L,list);

        for (int i = 1; i <= 100; i++) {
            logger.info("我使用抽奖策略为100001L进行抽奖，抽到了一个{}",randomDrawAlgorithm.randomDraw(100001L,null));
        }
    }






}
