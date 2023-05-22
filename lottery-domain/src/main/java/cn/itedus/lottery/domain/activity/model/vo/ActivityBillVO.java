package cn.itedus.lottery.domain.activity.model.vo;

import java.util.Date;

/**
 * @description: 活动账单、状态、日期、个人参与次数
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class ActivityBillVO {
    /**
     * 用户id
     */
    private  String uId;
    /**
     * 活动Id
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 开始日期
     */
    private Date beginDateTime;
    /**
     * 结束日期
     */
    private Date endDateTime;
    /**
     * 活动库存剩余
     */
    private Integer stockSurplusCount;
    /**
     * 活动状态 ：1.编辑 2.提审 3.撤审 4.通过 5.运行（审核通过后worker扫描进行状态） 6、拒绝 7.关闭 8.开启
     */

    private Integer state;
    /**
     * 策略id
     */
    private Long strategyId;
    /**
     * 每人可参与次数
     */
    private Integer takeCount;
    /**
     * 已领取次数
     */
    private Integer userTakeLeftCount;


    public ActivityBillVO() {
    }

    public ActivityBillVO(String uId, Long activityId, String activityName, Date beginDateTime, Date endDateTime, Integer stockSurplusCount, Integer state, Long strategyId, Integer takeCount, Integer userTakeLeftCount) {
        this.uId = uId;
        this.activityId = activityId;
        this.activityName = activityName;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.stockSurplusCount = stockSurplusCount;
        this.state = state;
        this.strategyId = strategyId;
        this.takeCount = takeCount;
        this.userTakeLeftCount = userTakeLeftCount;
    }

    /**
     * 获取
     * @return uId
     */
    public String getUId() {
        return uId;
    }

    /**
     * 设置
     * @param uId
     */
    public void setUId(String uId) {
        this.uId = uId;
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
     * @return activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置
     * @param activityName
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * 获取
     * @return beginDateTime
     */
    public Date getBeginDateTime() {
        return beginDateTime;
    }

    /**
     * 设置
     * @param beginDateTime
     */
    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    /**
     * 获取
     * @return endDateTime
     */
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * 设置
     * @param endDateTime
     */
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * 获取
     * @return stockSurplusCount
     */
    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    /**
     * 设置
     * @param stockSurplusCount
     */
    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
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
     * @return takeCount
     */
    public Integer getTakeCount() {
        return takeCount;
    }

    /**
     * 设置
     * @param takeCount
     */
    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    /**
     * 获取
     * @return userTakeLeftCount
     */
    public Integer getUserTakeLeftCount() {
        return userTakeLeftCount;
    }

    /**
     * 设置
     * @param userTakeLeftCount
     */
    public void setUserTakeLeftCount(Integer userTakeLeftCount) {
        this.userTakeLeftCount = userTakeLeftCount;
    }

    public String toString() {
        return "ActivityBillVO{uId = " + uId + ", activityId = " + activityId + ", activityName = " + activityName + ", beginDateTime = " + beginDateTime + ", endDateTime = " + endDateTime + ", stockSurplusCount = " + stockSurplusCount + ", state = " + state + ", strategyId = " + strategyId + ", takeCount = " + takeCount + ", userTakeLeftCount = " + userTakeLeftCount + "}";
    }
}
