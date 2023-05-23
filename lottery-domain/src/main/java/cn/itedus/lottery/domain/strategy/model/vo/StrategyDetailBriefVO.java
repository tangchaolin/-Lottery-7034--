package cn.itedus.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @description: 策略明细简要信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StrategyDetailBriefVO {
    private Long StrategyId;

    private String awardId;

    private String awardName;

    private String awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;

    public Long getStrategyId() {
        return StrategyId;
    }

    public void setStrategyId(Long strategyId) {
        StrategyId = strategyId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(String awardCount) {
        this.awardCount = awardCount;
    }

    public Integer getAwardSurplusCount() {
        return awardSurplusCount;
    }

    public void setAwardSurplusCount(Integer awardSurplusCount) {
        this.awardSurplusCount = awardSurplusCount;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    @Override
    public String toString() {
        return "StrategyDetailBriefVO{" +
                "StrategyId=" + StrategyId +
                ", awardId='" + awardId + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardCount='" + awardCount + '\'' +
                ", awardSurplusCount='" + awardSurplusCount + '\'' +
                ", awardRate=" + awardRate +
                '}';
    }
}
