package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*
 * @description: 查询策略表的详细配置
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Mapper
public interface IStrategyDetailDao {
    /**
     * 
     * @param strategyId
     * @return
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * 用于查询无库存的奖品信息，返回为id。
     * @param strategyId
     * @return
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyDetailReq 策略id，奖品id
     * @return 返回结果。
     */
    int deductStock(StrategyDetail strategyDetailReq);


}
