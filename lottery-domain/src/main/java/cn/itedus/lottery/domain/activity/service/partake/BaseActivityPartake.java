package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.res.StockResult;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 活动领取模板抽象类
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake{
    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public PartakeResult doPartake(PartakeReq req) {
        //1.查询是否存在未执行抽奖领取活动单 【user_take_activity 存在state=0的活动单，说明领取了但抽奖过程失败，可以直接返回领取结果继续抽奖】
        UserTakeActivityVO userTakeActivityVO = this.queryNoConsumedTakeActivityOrder(req.getActivityId(), req.getUId());
        if (null != userTakeActivityVO) {
            return buildPartakeResult(userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId(),Constants.ResponseCode.NOT_CONSUMED_TAKE);
        }

        //2.查询活动账单
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        //3.活动信息校验处理【活动库存、状态、日期、个人参与次数】
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }
        //4.扣减活动库存,通过Redis【活动库存扣减编号，作为锁的Key，缩小颗粒度】 Begin
        StockResult subtractionActivityResult = this.subtractionActivityStockByRedis(req.getUId(), req.getActivityId(), activityBillVO.getStockCount());

        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())) {
            this.recoverActivityCacheStockByRedis(req.getActivityId(),subtractionActivityResult.getStockKey(), subtractionActivityResult.getCode());
            return new PartakeResult(subtractionActivityResult.getCode(), subtractionActivityResult.getInfo());
        }
        //5.插入领取活动信息 ,领取活动信息【用户把活动信息写入到用户表】
        Long takeId=idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();

        Result grabResult = this.grabActivity(req, activityBillVO,takeId);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            this.recoverActivityCacheStockByRedis(req.getActivityId(),subtractionActivityResult.getStockKey(),grabResult.getCode());
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }
        //6.删除滑动库存key,通过Redis End
        this.recoverActivityCacheStockByRedis(req.getActivityId(),subtractionActivityResult.getStockKey(),Constants.ResponseCode.SUCCESS.getCode());

        //7.返回成功结果。
        return buildPartakeResult(activityBillVO.getStrategyId(),takeId,activityBillVO.getStockCount(),subtractionActivityResult.getStockSurplusCount(),Constants.ResponseCode.SUCCESS) ;

    }

    /**
     * 活动信息校验，把活动库存、状态、日期、个人参与次数
     * @param req
     * @param bill
     * @return
     */
    protected abstract Result checkActivityBill(PartakeReq req, ActivityBillVO bill);

    /**
     * 扣减活动库存
     * @param req 参与活动请求
     * @return 扣减结果
     */
    protected abstract Result subtractionActivityStock(PartakeReq req);

    /**
     * 扣减活动库存，通过Redis
     * @param uId 用户ID
     * @param activityId 活动号
     * @param stockCount 总库存
     * @return
     */
    protected abstract StockResult subtractionActivityStockByRedis(String uId, Long activityId, Integer stockCount);

    /**
     * 恢复活动库存，通过Redis
     * @param activityId 活动Id
     * @param tokenKey 分布式KEY 用于清理
     * @param code 状态
     */
    protected abstract void recoverActivityCacheStockByRedis(Long activityId, String tokenKey, String code);


    /**
     * 领取活动
     * @param partake
     * @param bill
     * @return 领取结果
     */

    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill,Long takeId);

    /**
     * 查询是否存在未执行的领取活动单
     * @param activityId
     * @param uId
     * @return
     */
    protected abstract UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);

    /**
     *
     * @param strategyId 策略ID
     * @param takeId 领取ID
     * @param code 状态码
     * @return
     */
    private PartakeResult buildPartakeResult(Long strategyId,Long takeId,Constants.ResponseCode code) {

        PartakeResult partakeResult = new PartakeResult(code.getCode(), code.getInfo());

        partakeResult.setTakeId(takeId);
        partakeResult.setStrategyId(strategyId);
        return partakeResult;
    }

    /**
     * 封装结果【返回的策略ID，用于继续完成抽奖步骤】
     * @param strategyId 策略ID
     * @param takeId 领取ID
     * @param stockCount 库存数量
     * @param stockSurplusCount 剩余库存
     * @param code 状态码
     * @return 封装结果
     */
    private PartakeResult buildPartakeResult(Long strategyId, Long takeId, Integer stockCount, Integer stockSurplusCount, Constants.ResponseCode code) {
        PartakeResult partakeResult = new PartakeResult(code.getCode(), code.getInfo());
        partakeResult.setStrategyId(strategyId);
        partakeResult.setTakeId(takeId);
        partakeResult.setStockCount(stockCount);
        partakeResult.setStockSurplusCount(stockSurplusCount);
        return partakeResult;
    }

}
