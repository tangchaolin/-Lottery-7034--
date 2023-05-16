package cn.itedus.lottery.domain.strategy.model.res;

public class DrawResult {


    private String uId;

    private Long StrategyId;

    private String awardId;

    private String awardName;

    public DrawResult(String uId, Long strategyId, String awardId, String awardName) {
        this.uId = uId;
        StrategyId = strategyId;
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

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
}
