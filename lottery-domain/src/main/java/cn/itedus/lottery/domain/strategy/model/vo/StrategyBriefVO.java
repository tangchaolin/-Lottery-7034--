package cn.itedus.lottery.domain.strategy.model.vo;

import java.util.Date;

/**
 * @description: 策略简要信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StrategyBriefVO {
    private  Long strategyId;

    private String strategyDesc;

    private Integer strategyMode;

    private Integer grantType;

    private Date grantDate;

    private String extInfo;

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyDesc() {
        return strategyDesc;
    }

    public void setStrategyDesc(String strategyDesc) {
        this.strategyDesc = strategyDesc;
    }

    public Integer getStrategyMode() {
        return strategyMode;
    }

    public void setStrategyMode(Integer strategyMode) {
        this.strategyMode = strategyMode;
    }

    public Integer getGrantType() {
        return grantType;
    }

    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return "StrategyBriefVO{" +
                "strategyId=" + strategyId +
                ", strategyDesc='" + strategyDesc + '\'' +
                ", strategyMode='" + strategyMode + '\'' +
                ", grantType=" + grantType +
                ", grantDate=" + grantDate +
                ", extInfo='" + extInfo + '\'' +
                '}';
    }
}
