package cn.itedus.lottery.interfaces.test;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.award.model.req.GoodsReq;
import cn.itedus.lottery.domain.award.model.res.DistributionRes;
import cn.itedus.lottery.domain.award.service.facotory.DistributionGoodsFactory;
import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import cn.itedus.lottery.infrastructure.dao.IAwardDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import com.alibaba.fastjson.JSON;
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
/*
 * @description: spirngboot单元测试
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;


    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);
    @Resource
    private IActivityDao activityDao ;

    @Resource
    IStrategyDao strategyDao;

    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Resource
    IAwardDao awardDao;

    @Resource(name = "drawExec")
    IDrawExec drawExec;

    @Resource(name = "singleRateRandomDrawAlgorithm")
    BaseAlgorithm algorithm;
    @Test
    public void testRandomDrawAlgorithm() {
        List<AwardRateInfo> list = new ArrayList<>();
        list.add(new AwardRateInfo("一等奖：特斯拉model3", new BigDecimal("0.2")));
        list.add(new AwardRateInfo("二等奖：华菱空调", new BigDecimal("0.3")));
        list.add(new AwardRateInfo("三等奖:小米手机", new BigDecimal("0.5")));

        algorithm.initRateTuple(100001L,list);

        for (int i = 1; i <= 100; i++) {
            logger.info("我使用抽奖策略为100001L进行抽奖，抽到了一个{}",algorithm.randomDraw(100001L,null));
        }
    }


    @Test
    public void testQueryStrategy() {

        Strategy strategy= strategyDao.queryStrategy(10001L);
        logger.info(JSON.toJSONString(strategy));

    }
@Test
    public void testQueryStrategyDetail() {
        List<StrategyDetail> strategyDetailList=strategyDetailDao.queryStrategyDetailList(10001L);
        logger.info(JSON.toJSONString(strategyDetailList));

    }

    @Test
    public void testQueryAwardInfo() {
        Award award = awardDao.queryAwardInfo("1");
        logger.info(JSON.toJSONString(award));

    }

    @Test
    public void testDrawExec() {
        DrawReq req = new DrawReq("1", 10001L);
        for (int i = 1; i <= 20; i++) {
//            logger.info(JSON.toJSONString(drawExec.doDrawExec(req)));
            drawExec.doDrawExec(req);
        }


    }

    @Test
    public void testDistributionGoods() {
        //执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("小林哥", 10001L));

        //判断抽奖结果
        if (Constants.DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            logger.info("未中奖，DrawAwardInfo is null");
            return ;
        }
        //封装发奖参数，orderId;2109313442431为模拟id,需要在用户参数领奖活动中生成
        DrawAwardInfo drawAwardInfo =drawResult.getDrawAwardInfo();

        GoodsReq req = new GoodsReq(drawResult.getuId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        IDistributionGoods distributionGoods = distributionGoodsFactory.getDistributionService(drawAwardInfo.getAwardType());

        DistributionRes distributionRes = distributionGoods.doDistribution(req);

        logger.info(JSON.toJSONString(distributionRes));



    }





}
