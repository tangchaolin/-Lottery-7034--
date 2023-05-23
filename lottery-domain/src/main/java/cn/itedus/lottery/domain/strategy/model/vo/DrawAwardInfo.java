package cn.itedus.lottery.domain.strategy.model.vo;

import java.util.Date;

/**
 * @description: 用于抽奖结果包装类使用。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawAwardInfo {
    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品类型   如：Constants.awardType.RedeemCodeGoods.getCode
     */
    private Integer awardType;

    /**
     * 奖品的内容 如奖品的描述，奖品码，sku
     */
    private String awardContent;
    /**
     * 策略方式 1：单项概率 2.总体概率
     */
    private Integer strategyMode;
    /**
     * 发放奖品的方式  1.既时 2.定时【含活动结束】 3.人工
     */
    private Integer grantType;
    /**
     * 发奖日期
     */
    private Date grantDate;


    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String awardId, String awardName, Integer awardType, String awardContent, Integer strategyMode, Integer grantType, Date grantDate) {
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardType = awardType;
        this.awardContent = awardContent;
        this.strategyMode = strategyMode;
        this.grantType = grantType;
        this.grantDate = grantDate;
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
        return "DrawAwardInfo{awardId = " + awardId + ", awardName = " + awardName + ", awardType = " + awardType + ", awardContent = " + awardContent + ", strategyMode = " + strategyMode + ", grantType = " + grantType + ", grantDate = " + grantDate + "}";
    }
}
