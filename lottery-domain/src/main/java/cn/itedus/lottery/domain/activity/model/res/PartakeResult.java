package cn.itedus.lottery.domain.activity.model.res;

import cn.itedus.lottery.common.Result;

/**
 * @description: 活动参与结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;


    public PartakeResult() {
        super();
    }

    public PartakeResult(String code, String info) {
        super(code,info);
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

    public String toString() {
        return "PartakeResult{strategyId = " + strategyId + "}";
    }
}
