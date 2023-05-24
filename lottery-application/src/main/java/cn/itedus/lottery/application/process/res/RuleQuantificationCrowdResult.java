package cn.itedus.lottery.application.process.res;

import cn.itedus.lottery.common.Result;

/**
 * @description: 采用规则量化人群抽取活动的抽奖结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class RuleQuantificationCrowdResult extends Result {

    /** 活动ID */
    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code,info);
    }


    public RuleQuantificationCrowdResult() {
    }

    public RuleQuantificationCrowdResult(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取
     * @return activityId
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置
     * @param activityId
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String toString() {
        return "RuleQuantificationCrowdResult{activityId = " + activityId + "}";
    }



}
