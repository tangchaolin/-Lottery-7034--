package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
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
            return buildPartakeResult(userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId());
        }

        //2.查询活动账单
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        //3.活动信息校验处理【活动库存、状态、日期、个人参与次数】
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }
        //4.扣减活动库存【目前为直接对配置库中的lottery.activity 直接操作表扣减库存，后续优化为Redis扣减】
        Result subtractionActivityStockResult = this.subtractionActivityStock(req);

        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityStockResult.getCode())) {
            return new PartakeResult(subtractionActivityStockResult.getCode(), subtractionActivityStockResult.getInfo());
        }
        //5.插入领取活动信息 ,领取活动信息【用户把活动信息写入到用户表】
        Long takeId=idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();

        Result grabResult = this.grabActivity(req, activityBillVO,takeId);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }
        //6.封装结果【返回的策略ID，用于继续完成抽奖步骤】
        return buildPartakeResult(activityBillVO.getStrategyId(),takeId);

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


    private PartakeResult buildPartakeResult(Long strategyId,Long takeId) {

        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());

        partakeResult.setTakeId(takeId);
        partakeResult.setStrategyId(strategyId);
        return partakeResult;
    }

}
