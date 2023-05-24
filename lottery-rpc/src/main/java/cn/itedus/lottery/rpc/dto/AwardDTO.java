package cn.itedus.lottery.rpc.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 奖品信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class AwardDTO implements Serializable {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 奖品ID
     */
    private String awardId;


    /**
     * 奖品类型
     */
    private Integer awardType;


    /**
     * 奖品名称
     */
    private String awardName;


    /**
     * 奖品内容
     */

    private String awardContent;

    /**
     * 策略方式 1:单项概率 2：总体概率
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式  1：即时 2：定时 3：人工
     */
    private Integer grantType;

    /**
     * 发奖时间
     */
    private Date grantDate;


    public AwardDTO() {
    }

    public AwardDTO(String userId, Long activityId, String awardId, Integer awardType, String awardName, String awardContent, Integer strategyMode, Integer grantType, Date grantDate) {
        this.userId = userId;
        this.activityId = activityId;
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.strategyMode = strategyMode;
        this.grantType = grantType;
        this.grantDate = grantDate;
    }

    /**
     * 获取
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return awardId
     */
    public String getAwardId() {
        return awardId;
    }

    /**
     * 设置
     * @param awardId
     */
    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    /**
     * 获取
     * @return awardType
     */
    public Integer getAwardType() {
        return awardType;
    }

    /**
     * 设置
     * @param awardType
     */
    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    /**
     * 获取
     * @return awardName
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * 设置
     * @param awardName
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /**
     * 获取
     * @return awardContent
     */
    public String getAwardContent() {
        return awardContent;
    }

    /**
     * 设置
     * @param awardContent
     */
    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    /**
     * 获取
     * @return strategyMode
     */
    public Integer getStrategyMode() {
        return strategyMode;
    }

    /**
     * 设置
     * @param strategyMode
     */
    public void setStrategyMode(Integer strategyMode) {
        this.strategyMode = strategyMode;
    }

    /**
     * 获取
     * @return grantType
     */
    public Integer getGrantType() {
        return grantType;
    }

    /**
     * 设置
     * @param grantType
     */
    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    /**
     * 获取
     * @return grantDate
     */
    public Date getGrantDate() {
        return grantDate;
    }

    /**
     * 设置
     * @param grantDate
     */
    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public String toString() {
        return "AwardDTO{userId = " + userId + ", activityId = " + activityId + ", awardId = " + awardId + ", awardType = " + awardType + ", awardName = " + awardName + ", awardContent = " + awardContent + ", strategyMode = " + strategyMode + ", grantType = " + grantType + ", grantDate = " + grantDate + "}";
    }
}
