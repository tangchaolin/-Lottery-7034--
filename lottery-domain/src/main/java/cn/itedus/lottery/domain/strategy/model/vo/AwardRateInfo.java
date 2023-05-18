package cn.itedus.lottery.domain.strategy.model.vo;



import java.math.BigDecimal;

/**
 * @description: 奖品信息，记录了奖品的id和抽中的概率。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

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
