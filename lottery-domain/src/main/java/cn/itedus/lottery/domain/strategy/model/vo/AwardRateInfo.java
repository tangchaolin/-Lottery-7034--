package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AwardRateInfo {
    private String awardId;

    private BigDecimal awardRate;

    public AwardRateInfo(){

    }

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}
