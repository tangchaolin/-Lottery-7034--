package cn.itedus.lottery.domain.award.service.goods;

import cn.itedus.lottery.domain.award.model.req.GoodsReq;
import cn.itedus.lottery.domain.award.model.res.DistributionRes;

/**
 * @description: 抽奖，抽象出配送货物接口，把各类奖品模拟成货物，配送代表着发货，包括虚拟奖品和实物奖品。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IDistributionGoods {
    /**
     * 奖品配送的接口，奖品类型（1；文字描述 2：兑换码  3：优惠券  4：实物奖品）
     * @param req
     * @return 返回配送的结果 （1.uId 2.code 3.info 4.statementId）
     */
    DistributionRes doDistribution(GoodsReq req);


}
