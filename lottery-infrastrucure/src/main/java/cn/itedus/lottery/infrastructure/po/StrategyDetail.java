package cn.itedus.lottery.infrastructure.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 策略明细
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StrategyDetail {


    /**
     * 自增id
     */
    private Long id;

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品库存
     */
    private String awardCount;

    /**
     * 奖品的剩余的库存
     */
    private Integer awardSurplusCount;

    /**
     * 奖品的概率
     */
    private BigDecimal awardRate;

    /**
     * 创建的时间
     */
    private Date createTime;

    /**
     * 修改的时间
     */
    private Date updateTime;

    public StrategyDetail() {
    }

    public StrategyDetail(Long id, Long strategyId, String awardId, String awardName, String awardCount, Integer awardSurplusCount, BigDecimal awardRate, Date createTime, Date updateTime) {
        this.id = id;
        this.strategyId = strategyId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardCount = awardCount;
        this.awardSurplusCount = awardSurplusCount;
        this.awardRate = awardRate;
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
    public String getAwardCount() {
        return awardCount;
    }

    /**
     * 设置
     * @param awardCount
     */
    public void setAwardCount(String awardCount) {
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
        return "StrategyDetail{id = " + id + ", strategyId = " + strategyId + ", awardId = " + awardId + ", awardName = " + awardName + ", awardCount = " + awardCount + ", awardSurplusCount = " + awardSurplusCount + ", awardRate = " + awardRate + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}
