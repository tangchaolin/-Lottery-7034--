package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;

import java.util.Date;

/**
 * @description: 用户参与活动仓储接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IUserTakeActivityRepository {
    /**
     * 扣减个人活动参与表
     * @param activityId 活动ID
     * @param activityName 活动名称
     * @param takeCount 活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余次数
     * @param uId 用户ID
     * @param partakeDate 领取时间
     * @return
     */
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId,
                             Date partakeDate);

    /**
     * 领取活动
     * @param activityId 活动ID
     * @param activityName 活动名称
     * @param strategyId 策略ID
     * @param takeCount 活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余次数
     * @param uId 用户id
     * @param takeDate 领取时间
     * @param takeId 领取ID
     */

    void takeActivity(Long activityId, String activityName, Long strategyId,Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate
            , Long takeId);

    /**
     * 锁定活动领取记录
     * @param uId 用户ID
     * @param activityId 活动ID
     * @param takeId  领取ID
     * @return 更新结果
     */
    int lockTackActivity(String uId, Long activityId, Long takeId);

    /**
     * 保存抽奖信息
     * @param drawOrderVO 中奖单
     */
    void saveUserStrategyExport(DrawOrderVO drawOrderVO);

    /**
     * 查询是否存在未使用的抽奖领取活动单 【user_take_activity 表中state=0 的，领取了但是抽奖过程失败的，可以直接返回领取结果继续抽奖】
     * @param activityId
     * @param uId
     * @return
     */
    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);

}
