package cn.itedus.lottery.domain.strategy.service.draw.impl;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.service.draw.AbstractDrawBase;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*
 * @description: 抽奖过程方法的实现
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);



    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList=strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("执行抽奖策略 strategyId：{} ,无库存排除奖品列表id集合：{}",strategyId,awardList);
        return awardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        //执行抽奖
        String awardId=drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        if (null == awardId) {
            return  null;
        }
        /**
         * 扣减库存，暂时采用数据库行级锁的方式进行扣减库存，后续优化为 redis分布式锁扣减 decr/incr
         * 注意：通常数据库直接锁行记录的方法不能支持大体量的并发，但此种方式需要了解，因为在分库分表下的正常数据流量的个人数据
         * 是可以使用行级锁的，因为他只影响自己的记录。
         */
        boolean isSucess=strategyRepository.deductStock(strategyId, awardId);
        //返回结果，如果扣减库存成功，则返回奖品的awardId否则返回null，在业务中，如果库存为空，则会发放兜底奖品， 比如优惠券。
        return isSucess?awardId:null;
    }
}
