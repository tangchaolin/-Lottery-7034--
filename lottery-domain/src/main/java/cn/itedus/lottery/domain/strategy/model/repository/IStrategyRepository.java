package cn.itedus.lottery.domain.strategy.model.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVo;

import java.util.List;
/**
 * @description: 为抽奖策略提供仓储服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IStrategyRepository {
    /**
     * 用于查询策略的详细信息。
     * @param strategyId
     * @return
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 用于查询奖品的信息
     * @param awardId
     * @return
     */
    AwardBriefVo queryAwardInfo(String awardId);


    /**
     *用于查询抽奖策略中库存为0的奖品id
     * @param strategyId
     * @return
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 抽奖以后，策略详情表相应奖品库存-1.
     * @param StrategyId
     * @param awardId
     * @return
     */
    boolean deductStock(Long StrategyId, String awardId);


}
