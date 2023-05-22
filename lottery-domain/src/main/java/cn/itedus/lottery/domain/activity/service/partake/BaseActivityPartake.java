package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;

/**
 * @description: 活动领取模板抽象类
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake{


    @Override
    public PartakeResult doPartake(PartakeReq req) {
        //查询活动账单
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        //活动信息校验处理【活动库存、状态、日期、个人参与次数】
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }
        //扣减活动库存【目前为直接对配置库中的lottery.activity 直接操作表扣减库存，后续优化为Redis扣减】
        Result subtractionActivityStockResult = this.subtractionActivityStock(req);

        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityStockResult.getCode())) {
            return new PartakeResult(subtractionActivityStockResult.getCode(), subtractionActivityStockResult.getInfo());
        }
        //领取活动信息【用户把活动信息写入到用户表】
        Result grabResult = this.grabActivity(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }
        /**
         * 封装结果【返回的策略ID，用于继续完成抽奖步骤】
         */
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStrategyId());
        return partakeResult;

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

    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill);

}
