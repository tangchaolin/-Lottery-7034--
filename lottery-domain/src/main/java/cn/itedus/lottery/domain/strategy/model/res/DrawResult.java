package cn.itedus.lottery.domain.strategy.model.res;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;

public class DrawResult {
    /**
     * 用户id
     */

    private String uId;
    /**
     * 策略id
     */
    private Long StrategyId;
    /**
     * 中奖状态 0 未中奖 1 中奖 2 兜底奖
     */
    private Integer drawState= Constants.DrawState.FAIL.getCode();
    /**
     * 中奖信息，包含奖品id和奖品名称。
     */

    private DrawAwardInfo drawAwardInfo;


    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.StrategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawResult() {

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

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
