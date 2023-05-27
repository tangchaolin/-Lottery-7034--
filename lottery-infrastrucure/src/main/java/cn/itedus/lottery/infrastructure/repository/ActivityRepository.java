package cn.itedus.lottery.infrastructure.repository;

import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.StockResult;
import cn.itedus.lottery.domain.activity.model.vo.*;
import cn.itedus.lottery.domain.activity.repository.IActivityRepository;
import cn.itedus.lottery.infrastructure.dao.*;
import cn.itedus.lottery.infrastructure.po.*;
import cn.itedus.lottery.infrastructure.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(ActivityRepository.class);
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

    @Resource
    RedisUtil redisUtil;
    @Override
    public void addActivity(ActivityVO activity) {
        Activity activity1=new Activity();
        BeanUtils.copyProperties(activity,activity1);
        activityDao.insert(activity1);
        //设置活动库存 KEY
        redisUtil.set(Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(activity.getActivityId()), 0);
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

        //从缓存中获取库存数量
        Object usedStockCountObj = redisUtil.get(Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(req.getActivityId()));
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
        //剩余库存数量，当在缓存中查到活动已使用号时候，用库存-已经使用活动数等于剩余库存，当缓存中没有key时，直接使用数据库中查到的剩余库存。
        activityBillVO.setStockSurplusCount(null == usedStockCountObj ? activity.getStockSurplusCount() : activity.getStockCount()-Integer.parseInt(String.valueOf(usedStockCountObj)));
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(null==userTakeActivityCount?null:userTakeActivityCount.getLeftCount());
        activityBillVO.setStockCount(activity.getStockCount());
        return activityBillVO;
    }

    @Override
    public int subtractionActivityStock(Long activityId) {


        return activityDao.subtractionActivityStock(activityId);
    }


    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        List<Activity> activityList = activityDao.scanToDoActivityList(id);
        List<ActivityVO> activityVOList = new ArrayList<>(activityList.size());
        for (Activity activity : activityList) {
            ActivityVO activityVO=new ActivityVO();
            activityVO.setActivityId(activity.getActivityId());
            activityVO.setId(activity.getId());
            activityVO.setActivityName(activity.getActivityName());
            activityVO.setBeginDateTime(activity.getBeginDateTime());
            activityVO.setEndDateTime(activity.getEndDateTime());
            activityVO.setState(activity.getState());
            activityVO.setCreator(activity.getCreator());
            activityVOList.add(activityVO);
        }
        return activityVOList;
    }

    @Override
    public StockResult subtractionActivityStockByRedis(String uId, Long activityId, Integer stockCount) {
        //1.获取抽奖活动库存 key
        String stockKey = Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(activityId);

        //2.扣减库存，目前占用库存数
        Integer stockUsedCount = (int) redisUtil.incr(stockKey, 1);
        //3.超出库存判断，进行恢复原始库存
        if (stockUsedCount > stockCount) {
            redisUtil.decr(stockKey, 1);
            return new StockResult(Constants.ResponseCode.OUT_OF_STOCK.getCode(), Constants.ResponseCode.OUT_OF_STOCK.getInfo());
        }
        //4.以活动库存占用为编号，生成对应加锁Key，细化锁的颗粒度。
        String stockTokenKey = Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN(activityId, stockUsedCount);

        //5.使用Redis.setNx加一个分布式锁
        boolean lockToken = redisUtil.setNx(stockTokenKey, 350L);
        if (!lockToken) {
            logger.info("抽奖活动{}用户秒杀{]扣减库存，分布式锁失败",activityId,uId,stockTokenKey);

            return new StockResult(Constants.ResponseCode.ERR_TOKEN.getCode(), Constants.ResponseCode.ERR_TOKEN.getInfo());
        }

        return new StockResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), stockTokenKey, stockCount - stockUsedCount);



    }

    @Override
    public void recoverActivityCacheStockByRedis(Long activityId, String tokenKey, String code) {

        //删除分布式锁Key
        redisUtil.del(tokenKey);
    }
}
