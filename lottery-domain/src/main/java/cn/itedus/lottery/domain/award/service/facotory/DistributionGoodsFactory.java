package cn.itedus.lottery.domain.award.service.facotory;

import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @description: 配送商品*简单工厂*，提供获取配送服务。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{
    /**
     * 通过奖品的类型，获取相应的发奖服务
     * @param awardType 奖品类型
     * @return 相应的奖品服务 如PhysicalGoods
     */
    public IDistributionGoods getDistributionService(Integer awardType) {
        return goodsMap.get(awardType);
    }

}
