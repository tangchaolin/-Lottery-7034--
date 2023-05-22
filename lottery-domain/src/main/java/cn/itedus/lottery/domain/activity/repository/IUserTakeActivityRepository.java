package cn.itedus.lottery.domain.activity.repository;

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
     * @param takeCount 活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余次数
     * @param uId 用户id
     * @param takeDate 领取时间
     * @param takeId 领取ID
     */

    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate
            , Long takeId);


}
