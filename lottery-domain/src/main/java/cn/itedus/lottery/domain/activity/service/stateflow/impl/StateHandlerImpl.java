package cn.itedus.lottery.domain.activity.service.stateflow.impl;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.service.stateflow.IStateHandler;
import cn.itedus.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Component;

/**
 * @description: 状态处理服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class StateHandlerImpl extends StateConfig implements IStateHandler {


    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).arraignment(activityId,currentState);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).checkPass(activityId,currentState);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).checkRefuse(activityId,currentState);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).checkRevoke(activityId,currentState);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).close(activityId,currentState);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).open(activityId,currentState);
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).doing(activityId,currentState);
    }
}
