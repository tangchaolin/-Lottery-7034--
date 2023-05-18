package cn.itedus.lottery.domain.award.service.facotory;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.award.service.goods.DistributionBase;
import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import cn.itedus.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.itedus.lottery.domain.award.service.goods.impl.DescGoods;
import cn.itedus.lottery.domain.award.service.goods.impl.PhysicalGoods;
import cn.itedus.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 各类发奖奖品配置类 在这里初始化了相应的服务。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class GoodsConfig {

    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();
    @Resource
    private Map<String,IDistributionGoods> beanNameMap;

    @PostConstruct
    public void init() {
        beanNameMap.entrySet().forEach(entry->{
            goodsMap.put(entry.getValue().getDistributionGoodsName(), entry.getValue());
        });

    }


}
