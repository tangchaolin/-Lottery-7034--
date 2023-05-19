package cn.itedus.lottery.domain.activity.service.stateflow;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;

/**
 * @description: 状态处理接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IStateHandler {

    /**
     * 活动提审
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核通过
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核拒绝
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核撤销
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动关闭
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动开启
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动执行
     * @param activityId
     * @param currentState
     * @return 审核结果
     */
    Result doing(Long activityId, Enum<Constants.ActivityState> currentState);



}
