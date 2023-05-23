package cn.itedus.lottery.domain.activity.model.vo;

import java.util.Date;

/**
 * @description: 活动表VO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class ActivityVO {
    private Long activityId;

    private String activityName;

    private String activityDesc;

    private Date  beginDateTime;

    private Date endDateTime;

    private Integer stockCount;

    private Integer takeCount;

    private Long strategyId;

    private Integer state;

    private String creator;

    public ActivityVO() {
    }

    public ActivityVO(Long activityId, String activityName, String activityDesc, Date beginDateTime, Date endDateTime, Integer stockCount, Integer takeCount, Long strategyId, Integer state, String creator) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityDesc = activityDesc;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.stockCount = stockCount;
        this.takeCount = takeCount;
        this.strategyId = strategyId;
        this.state = state;
        this.creator = creator;
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
     * @return activityDesc
     */
    public String getActivityDesc() {
        return activityDesc;
    }

    /**
     * 设置
     * @param activityDesc
     */
    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
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
     * @return stockCount
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 设置
     * @param stockCount
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
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

    /**
     * 获取
     * @return creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String toString() {
        return "ActivityVO{activityId = " + activityId + ", activityName = " + activityName + ", activityDesc = " + activityDesc + ", beginDateTime = " + beginDateTime + ", endDateTime = " + endDateTime + ", stockCount = " + stockCount + ", takeCount = " + takeCount + ", strategyId = " + strategyId + ", state = " + state + ", creator = " + creator + "}";
    }
}
