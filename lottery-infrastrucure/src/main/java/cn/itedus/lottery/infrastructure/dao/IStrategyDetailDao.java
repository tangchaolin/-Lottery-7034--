package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @description: 策略明细表DAO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */


@Mapper
public interface IStrategyDetailDao {
    /**
     * 查询策略配置
     * @param strategyId 策略id
     * @return 一组与策略id相关的策略明细表，包含了相应的奖品。
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

    /**
     * 插入策略配置详情列表
     * @param list 详情列表
     */
    void insertList(List<StrategyDetail> list);

}
