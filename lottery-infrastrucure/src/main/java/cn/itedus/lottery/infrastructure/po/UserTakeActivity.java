package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

/**
 * @description: 用户领取活动表
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class UserTakeActivity {
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 用户id
     */
    private String uId;
    /**
     * 活动领取id
     */
    private Long takeId;
    /**
     * 活动Id
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 领取日期
     */
    private Date takeDate;
    /**
     * 领取次数
     */
    private Integer takeCount;
    /**
     * 防重id
     */
    private String uuid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新日期
     */
    private Date updateTime;
    /**
     * 活动单状态 0未使用 1 已使用
     */
    private Integer state;

    private Long strategyId;


    public UserTakeActivity() {
    }

    public UserTakeActivity(Long id, String uId, Long takeId, Long activityId, String activityName, Date takeDate, Integer takeCount, String uuid, Date createTime, Date updateTime, Integer state, Long strategyId) {
        this.id = id;
        this.uId = uId;
        this.takeId = takeId;
        this.activityId = activityId;
        this.activityName = activityName;
        this.takeDate = takeDate;
        this.takeCount = takeCount;
        this.uuid = uuid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.state = state;
        this.strategyId = strategyId;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return takeDate
     */
    public Date getTakeDate() {
        return takeDate;
    }

    /**
     * 设置
     * @param takeDate
     */
    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
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
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String toString() {
        return "UserTakeActivity{id = " + id + ", uId = " + uId + ", takeId = " + takeId + ", activityId = " + activityId + ", activityName = " + activityName + ", takeDate = " + takeDate + ", takeCount = " + takeCount + ", uuid = " + uuid + ", createTime = " + createTime + ", updateTime = " + updateTime + ", state = " + state + ", strategyId = " + strategyId + "}";
    }
}
