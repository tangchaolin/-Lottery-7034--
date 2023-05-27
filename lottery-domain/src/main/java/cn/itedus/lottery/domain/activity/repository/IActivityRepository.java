package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.StockResult;
import cn.itedus.lottery.domain.activity.model.vo.*;

import java.util.List;

/**
 * @description: 实现了活动的仓储服务的接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IActivityRepository {
    /**
     * 添加活动配置
     * @param activity
     */
    void addActivity(ActivityVO activity);

    /**
     * 添加奖品配置集合
     * @param awardList
     */
    void addAward(List<AwardVO> awardList);

    /**
     * 添加策略配置
     *
     * @param strategy
     */
    void addStrategy(StrategyVO strategy);
    /**
     * 添加策略明细配置
     * @param strategyDetailList
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    /**
     * 变更活动状态
     * @param activityId
     * @param beforeState
     * @param afterState
     * @return
     */
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);

    /**
     * 岔村活动账单信息【库存、状态、日期、个人参与次数】
     * @param req
     * @return 返回活动账单信息
     */
    ActivityBillVO queryActivityBill(PartakeReq req);

    /**
     * 扣减活动库存
     * @param activityId
     * @return 扣减结果
     */
    int subtractionActivityStock(Long activityId);

    /**
     * 扫描待处理的活动列表，状态为：通过、活动中。
     * @param id ID
     * @return 待处理的活动集合
     */
    List<ActivityVO> scanToDoActivityList(Long id);

    /**
     * 扣减活动库存，通过Redis
     * @param uId 用户ID
     * @param activityId 活动ID
     * @param stockCount 活动库存
     * @return 扣减结果
     */

    StockResult subtractionActivityStockByRedis(String uId, Long activityId, Integer stockCount);

    /**
     * 恢复活动库存，通过Redis【如果非常异常，则需要进行缓存库存恢复，只保证不超卖，所以不保证一定能恢复占用库存，另外最终可以由任务进行补偿库存。
     * @param activityId 活动ID
     * @param tokenKey 分布式KEY用于清理
     * @param code 状态
     */
    void recoverActivityCacheStockByRedis(Long activityId, String tokenKey, String code);


}
