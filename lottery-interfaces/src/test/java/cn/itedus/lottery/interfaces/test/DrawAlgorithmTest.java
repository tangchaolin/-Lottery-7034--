package cn.itedus.lottery.interfaces.test;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawAlgorithmTest {

    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm drawAlgorithm;


    private Logger logger = LoggerFactory.getLogger(DrawAlgorithmTest.class);


    @Before
    public void init() {

        List<AwardRateInfo> list =new ArrayList<>();

        list.add(new AwardRateInfo("一等奖：特斯拉model3", new BigDecimal("0.05")));

        list.add(new AwardRateInfo("二等奖：iphone",new BigDecimal("0.15")));

        list.add(new AwardRateInfo("三等奖：ipad", new BigDecimal("0.20")));

        list.add(new AwardRateInfo("四等奖：Airpods2", new BigDecimal("0.25")));

        list.add(new AwardRateInfo("五等奖: 北京一环内购房五百优惠券", new BigDecimal("0.35")));

        drawAlgorithm.initRateTuple(100001L, list);
//
//        logger.info(drawAlgorithm.randomDraw(100001L,null));


    }

    @Test
    public void test_randomDrawAlgorithm() {

        List<String> excludeAward=new ArrayList<>();
        excludeAward.add("一等奖：特斯拉model3");

        excludeAward.add("二等奖：iphone");


        for (int i = 1; i <= 100; i++) {

            logger.info(drawAlgorithm.randomDraw(100001L,excludeAward));
        }

    }
}
