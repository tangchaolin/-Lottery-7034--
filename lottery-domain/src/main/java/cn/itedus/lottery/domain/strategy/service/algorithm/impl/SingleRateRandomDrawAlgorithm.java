package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
//推荐 单项随机概率抽奖，抽到了一个已经排掉的奖品则未中将。。
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {


    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] rateTuple = rateTupleMap.get(strategyId);
        assert rateTuple!=null;

        //随机1-100.
        int random =new SecureRandom().nextInt(100)+1;
        //获取到了idx。
        int idx = hashIdx(random);
        if ((!ObjectUtil.isNull(excludeAwardIds))&&!(excludeAwardIds.isEmpty())){
            if (excludeAwardIds.contains(rateTuple[idx])){
                return "未中奖！";}
        }
        //返回获取的奖品的id，你很成功哦。
        return rateTuple[idx];

    }
}
