package cn.itedus.lottery.domain.award.service.goods.impl;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.award.model.req.GoodsReq;
import cn.itedus.lottery.domain.award.model.res.DistributionRes;
import cn.itedus.lottery.domain.award.service.goods.DistributionBase;
import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description: 优惠券商品
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {


    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        //模拟调用优惠券发送接口
        logger.info("模拟调用优惠券发送接口 uId:{} awardContent:{}",req.getuId(),req.getAwardContent());

        //更新用户领奖结果
        super.updateUserAwardState(req.getuId(), req.getOrderId(),req.getAwardId(), Constants.AwardState.SUCESS.getCode(), Constants.AwardState.SUCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCESS.getCode(), Constants.AwardState.SUCESS.getInfo());

    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}
