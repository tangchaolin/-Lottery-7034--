package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AwardVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyDetailVO;

import java.util.List;

/**
 * @description: 实现了活动的仓储服务的接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IActivityRepository {

    void addActivity(ActivityVO activity);

    void addAward(List<AwardVO> awardList);

    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

//    boolean alterStatus(Long activityId,Enum<>)

}
