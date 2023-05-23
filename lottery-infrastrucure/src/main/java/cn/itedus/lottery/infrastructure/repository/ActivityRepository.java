package cn.itedus.lottery.infrastructure.repository;

import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.vo.*;
import cn.itedus.lottery.domain.activity.repository.IActivityRepository;
import cn.itedus.lottery.infrastructure.dao.*;
import cn.itedus.lottery.infrastructure.po.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @description: 活动仓储服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/19 0019
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Repository
public class ActivityRepository implements IActivityRepository {
    @Resource
    IActivityDao activityDao;

    @Resource
    IUserTakeActivityCountDao userTakeActivityCountDao;

    @Resource
    IAwardDao awardDao;

    @Resource
    IStrategyDao strategyDao;

    @Resource
    IStrategyDetailDao strategyDetailDao;
    @Override
    public void addActivity(ActivityVO activity) {
        Activity activity1=new Activity();
        BeanUtils.copyProperties(activity,activity1);
        activityDao.insert(activity1);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> awards=new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award=new Award();
            BeanUtils.copyProperties(awardVO,award);
            awards.add(award);
        }
        awardDao.insertList(awards);

    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy strategy1=new Strategy();
        BeanUtils.copyProperties(strategy,strategy1);
        strategyDao.insert(strategy1);

    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> strategyDetailList1 = new ArrayList<>();

        for (StrategyDetailVO strategyDetailVO:strategyDetailList){
            StrategyDetail strategyDetail=new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO,strategyDetail);
            strategyDetailList1.add(strategyDetail);
        }

        strategyDetailDao.insertList(strategyDetailList1);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId, ((Constants.ActivityState) beforeState).getCode(), ((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq req) {

        //查询活动信息
        Activity activity = activityDao.queryActivityById(req.getActivityId());
        //查询领取次数
        UserTakeActivityCount userTakeActivityCountReq = new UserTakeActivityCount();

        userTakeActivityCountReq.setActivityId(req.getActivityId());
        userTakeActivityCountReq.setUId(req.getUId());
        UserTakeActivityCount userTakeActivityCount = userTakeActivityCountDao.queryUserActivityCount(userTakeActivityCountReq);

        //封装结果信息
        ActivityBillVO activityBillVO=new ActivityBillVO();
        activityBillVO.setUId(req.getUId());
        activityBillVO.setActivityId(req.getActivityId());
        activityBillVO.setActivityName(activity.getActivityName());
        activityBillVO.setBeginDateTime(activity.getBeginDateTime());
        activityBillVO.setEndDateTime(activity.getEndDateTime());
        activityBillVO.setTakeCount(activity.getTakeCount());
        activityBillVO.setStockSurplusCount(activity.getStockSurplusCount());
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(null==userTakeActivityCount?null:userTakeActivityCount.getLeftCount());
        return activityBillVO;
    }

    @Override
    public int subtractionActivityStock(Long activityId) {


        return activityDao.subtractionActivityStock(activityId);
    }
}
