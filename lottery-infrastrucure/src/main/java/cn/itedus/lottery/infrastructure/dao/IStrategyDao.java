package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;
/*
 * @description: 策略信息表DAO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Mapper
public interface IStrategyDao {
    /**
     * 通过策略id查询策略
     * @param strategyId
     * @return 策略
     */
    Strategy queryStrategy(Long strategyId);
}
