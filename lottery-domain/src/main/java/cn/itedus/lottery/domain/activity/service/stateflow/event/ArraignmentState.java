package cn.itedus.lottery.domain.activity.service.stateflow.event;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.service.stateflow.AbstractState;
import cn.itedus.lottery.domain.strategy.service.draw.AbstractDrawBase;
import org.springframework.stereotype.Component;

/**
 * @description: 提审状态
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class ArraignmentState extends AbstractState {


    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.PASS);

        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动审核通过完成"):
                Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.REFUSE);
        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动审核拒绝完成"):
                Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.EDIT);
        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动审核撤销回到编辑中"):
                Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.CLOSE);
        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动审核关闭完成"):
                Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"非关闭状态不可打开");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"待审核状态不可执行活动中变更");
    }
}
