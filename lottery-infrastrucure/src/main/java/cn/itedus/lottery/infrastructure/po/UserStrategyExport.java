package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

/**
 * @description: 用户策略计算结果表
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class UserStrategyExport {
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
     * 订单id
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
     * 发放方式 （1.及时发放 2.定时（含活动结束） 3。人工）
     */
    private Integer grantType;
    /**
     * 发奖日期
     */
    private Date grantDate;
    /**
     * 发奖状态
     */
    private Integer grantState;
    /**
     * 发奖id
     */
    private  String awardId;
    /**
     * 奖品类型（1：文字描述 2：兑换码 3.优惠券 4.实物奖品）
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
     * 防止重复id
     */

    private String uuid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /** 消息发送状态 0：未发送 1：发送成功 2：发送失败 */
    private Integer MqState;

    public UserStrategyExport() {
    }

    public UserStrategyExport(Long id, String uId, Long activityId, Long orderId, Long strategyId, Integer strategyMode, Integer grantType, Date grantDate, Integer grantState, String awardId, Integer awardType, String awardName, String awardContent, String uuid, Date createTime, Date updateTime, Integer MqState) {
        this.id = id;
        this.uId = uId;
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
        this.uuid = uuid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.MqState = MqState;
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
     * @return MqState
     */
    public Integer getMqState() {
        return MqState;
    }

    /**
     * 设置
     * @param MqState
     */
    public void setMqState(Integer MqState) {
        this.MqState = MqState;
    }

    public String toString() {
        return "UserStrategyExport{id = " + id + ", uId = " + uId + ", activityId = " + activityId + ", orderId = " + orderId + ", strategyId = " + strategyId + ", strategyMode = " + strategyMode + ", grantType = " + grantType + ", grantDate = " + grantDate + ", grantState = " + grantState + ", awardId = " + awardId + ", awardType = " + awardType + ", awardName = " + awardName + ", awardContent = " + awardContent + ", uuid = " + uuid + ", createTime = " + createTime + ", updateTime = " + updateTime + ", MqState = " + MqState + "}";
    }
}
