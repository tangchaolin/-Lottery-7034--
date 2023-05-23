package cn.itedus.lottery.domain.activity.model.req;

import java.util.Date;

/**
 * @description: 参与活动请求
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class PartakeReq {

    /**
     * 用户ID
     */
    private String uId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动领取时间
     */
    private Date partakeDate;


    public PartakeReq() {
    }

    public PartakeReq(String uId, Long activityId, Date partakeDate) {
        this.uId = uId;
        this.activityId = activityId;
        this.partakeDate = partakeDate;
    }
    public PartakeReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
        this.partakeDate = new Date();
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
     * @return partakeDate
     */
    public Date getPartakeDate() {
        return partakeDate;
    }

    /**
     * 设置
     * @param partakeDate
     */
    public void setPartakeDate(Date partakeDate) {
        this.partakeDate = partakeDate;
    }

    public String toString() {
        return "PartakeReq{uId = " + uId + ", activityId = " + activityId + ", partakeDate = " + partakeDate + "}";
    }
}
