package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

/**
 * @description: 用户参与活动次数表
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class UserTakeActivityCount {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 用户id
     */
    private String uId;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 可领取次数
     */
    private Integer totalCount;
    /**
     * 已领取次数
     */
    private Integer leftCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public UserTakeActivityCount() {
    }

    public UserTakeActivityCount(Long id, String uId, Long activityId, Integer totalCount, Integer leftCount, Date createTime, Date updateTime) {
        this.id = id;
        this.uId = uId;
        this.activityId = activityId;
        this.totalCount = totalCount;
        this.leftCount = leftCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
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
     * @return totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置
     * @param totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取
     * @return leftCount
     */
    public Integer getLeftCount() {
        return leftCount;
    }

    /**
     * 设置
     * @param leftCount
     */
    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
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

    public String toString() {
        return "UserTakeActivityCount{id = " + id + ", uId = " + uId + ", activityId = " + activityId + ", totalCount = " + totalCount + ", leftCount = " + leftCount + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}
