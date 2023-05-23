package cn.itedus.lottery.domain.activity.model.vo;

import java.util.Date;

/**
 * @description: 奖品单
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/22 0022
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawOrderVO {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 策略方式  1.单项概率 2.总体概率
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式 1：及时发放 2：定时  3：人工
     */
    private Integer grantType;


    /**
     * 发奖时间
     */
    private Date grantDate;
    /**
     * 发奖状态
     */
    private Integer grantState;

    /**
     * 发奖ID
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


    public DrawOrderVO() {
    }

    public DrawOrderVO(String uId, Long takeId, Long activityId, Long orderId, Long strategyId, Integer strategyMode, Integer grantType, Date grantDate, Integer grantState, String awardId, Integer awardType, String awardName, String awardContent) {
        this.uId = uId;
        this.takeId = takeId;
        this.activityId = activityId;
        this.orderId = orderId;
        this.strategyId = strategyId;
        this.strategyMode = strategyMode;
        this.grantType = grantType;
        this.grantDate = grantDate;
        this.grantState = grantState;
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
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
     * @return orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    /**
     * 获取
     * @return grantState
     */
    public Integer getGrantState() {
        return grantState;
    }

    /**
     * 设置
     * @param grantState
     */
    public void setGrantState(Integer grantState) {
        this.grantState = grantState;
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

    public String toString() {
        return "DrawOrderVO{uId = " + uId + ", takeId = " + takeId + ", activityId = " + activityId + ", orderId = " + orderId + ", strategyId = " + strategyId + ", strategyMode = " + strategyMode + ", grantType = " + grantType + ", grantDate = " + grantDate + ", grantState = " + grantState + ", awardId = " + awardId + ", awardType = " + awardType + ", awardName = " + awardName + ", awardContent = " + awardContent + "}";
    }
}
