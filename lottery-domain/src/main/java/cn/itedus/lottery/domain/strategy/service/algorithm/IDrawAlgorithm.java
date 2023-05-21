package cn.itedus.lottery.domain.strategy.service.algorithm;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/*
 * @description: 抽奖算法的接口。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IDrawAlgorithm {

    /**
     * 初始化概率元祖，在初始化完成后使用过程中不允许修改元祖数据
     *
     * 元祖数据作用在于讲百分比内(0.2、0.3、0.5)的数据，转换为一整条数组上分区数据，如下；
     * 0.2 = 0 ~ 0.2
     * 0.3 = 0 + 0.2 ~ 0.2 + 0.3 = 0.2 ~ 0.5
     * 0.5 = 0.5 ~ 1 （计算方式同上）
     *
     * 通过数据拆分为整条后，再根据0-100中各个区间的奖品信息，使用斐波那契散列计算出索引位置，把奖品数据存放到元祖中。比如：
     *
     * 1. 把 0.2 转换为 20
     * 2. 20 对应的斐波那契值哈希值：（20 * HASH_INCREMENT + HASH_INCREMENT）= -1549107828 HASH_INCREMENT = 0x61c88647
     * 3. 再通过哈希值计算索引位置：hashCode & (rateTuple.length - 1) = 12
     * 4. 那么tup[14] = 0.2 中奖概率对应的奖品
     * 5. 当后续通过随机数获取到1-100的值后，可以直接定位到对应的奖品信息，通过这样的方式把轮训算奖的时间复杂度从O(n) 降低到 0(1)
     *
     * @param strategyId         策略ID
     * @param awardRateInfoList  奖品概率配置集合 「值示例：AwardRateInfo.awardRate = 0.04」
     */
    void initRateTuple(Long strategyId, Integer strategyMode,List<AwardRateInfo> awardRateInfoList);

    /**
     * 抽奖算法核心，输入抽奖策略id和要排除的奖品的id，进行抽奖。
     * @param strategyId
     * @param excludeAwardIds
     * @return 中奖的结果，中奖就是奖品的id，未中奖就是“未中奖"
     */
    String randomDraw(Long strategyId,List<String> excludeAwardIds);

    /**
     * 判断该策略id是否已经初始化。
     * @param StrategyId
     * @return
     */
    boolean isExist(Long StrategyId);
    
    


}
