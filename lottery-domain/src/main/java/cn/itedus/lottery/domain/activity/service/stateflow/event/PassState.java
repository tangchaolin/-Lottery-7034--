package cn.itedus.lottery.domain.activity.service.stateflow.event;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @description: 审核通过状态
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class PassState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"已审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {

        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"已审核状态不可重复审核");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.REFUSE);

        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动审核拒绝完成"):
                Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"审核通过不可撤审（可先拒绝审核）");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.CLOSE);

        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动审核关闭完成"):
                Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR,"非关闭活动不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSucess = activityRepository.alterStatus(activityId,currentState,Constants.ActivityState.DOING);

        return isSucess?Result.buildResult(Constants.ResponseCode.SUCCESS,"活动变更活动中成功"):
                Result.buildErrorResult("活动状态变更失败");
    }




}
