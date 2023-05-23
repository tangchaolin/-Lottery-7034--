package cn.itedus.lottery.domain.activity.model.vo;

/**
 * @description: 用户领取活动记录
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class UserTakeActivityVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动领取ID
     */
    private Long takeId;


    /**
     * 策略ID
     */
    private Long strategyId;


    /**
     * 活动单使用状态 0：未使用 1：已使用 Constants.TaskState
     */
    private Integer state;


    public UserTakeActivityVO() {
    }

    public UserTakeActivityVO(Long activityId, Long takeId, Long strategyId, Integer state) {
        this.activityId = activityId;
        this.takeId = takeId;
        this.strategyId = strategyId;
        this.state = state;
    }

    /**
     * 获取
     * @return activityId
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置
     * @param activityId
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取
     * @return takeId
     */
    public Long getTakeId() {
        return takeId;
    }

    /**
     * 设置
     * @param takeId
     */
    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    /**
     * 获取
     * @return strategyId
     */
    public Long getStrategyId() {
        return strategyId;
    }

    /**
     * 设置
     * @param strategyId
     */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * 获取
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public String toString() {
        return "UserTakeActivityVO{activityId = " + activityId + ", takeId = " + takeId + ", strategyId = " + strategyId + ", state = " + state + "}";
    }
}
