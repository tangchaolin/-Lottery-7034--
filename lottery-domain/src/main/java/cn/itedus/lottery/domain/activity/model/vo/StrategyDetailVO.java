package cn.itedus.lottery.domain.activity.model.vo;

import java.math.BigDecimal;

/**
 * @description: 策略详情配置
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StrategyDetailVO {

    private Long strategyId;

    private String awardId;

    private String awardName;

    private Integer awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;


    public StrategyDetailVO() {
    }

    public StrategyDetailVO(Long strategyId, String awardId, String awardName, Integer awardCount, Integer awardSurplusCount, BigDecimal awardRate) {
        this.strategyId = strategyId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardCount = awardCount;
        this.awardSurplusCount = awardSurplusCount;
        this.awardRate = awardRate;
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
     * @return awardCount
     */
    public Integer getAwardCount() {
        return awardCount;
    }

    /**
     * 设置
     * @param awardCount
     */
    public void setAwardCount(Integer awardCount) {
        this.awardCount = awardCount;
    }

    /**
     * 获取
     * @return awardSurplusCount
     */
    public Integer getAwardSurplusCount() {
        return awardSurplusCount;
    }

    /**
     * 设置
     * @param awardSurplusCount
     */
    public void setAwardSurplusCount(Integer awardSurplusCount) {
        this.awardSurplusCount = awardSurplusCount;
    }

    /**
     * 获取
     * @return awardRate
     */
    public BigDecimal getAwardRate() {
        return awardRate;
    }

    /**
     * 设置
     * @param awardRate
     */
    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    public String toString() {
        return "StrategyDetailVO{strategyId = " + strategyId + ", awardId = " + awardId + ", awardName = " + awardName + ", awardCount = " + awardCount + ", awardSurplusCount = " + awardSurplusCount + ", awardRate = " + awardRate + "}";
    }
}
