package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @description: 为抽奖策略提供数据支持，一些通用的数据服务。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;


    protected StrategyRich queryStrategyRich(Long strategyId) {

        return strategyRepository.queryStrategyRich(strategyId);

    }

    /**
     * 根据奖品的id查询奖品的信息。
     * @param awardId
     * @return 中奖情况
     */
    protected Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}
