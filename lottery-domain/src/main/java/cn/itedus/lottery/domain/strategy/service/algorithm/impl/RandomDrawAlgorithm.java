package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
@Component("randomDrawAlgorithm")
public class RandomDrawAlgorithm extends BaseAlgorithm {


    @Override
    public String randomDraw(Long strategyId) {
        String[] rateTuple = rateTupleMap.get(strategyId);
        assert rateTuple!=null;

        //随机1-100.
        int random =new SecureRandom().nextInt(100)+1;
        //获取到了idx。
        int idx = hashIdx(random);

        //返回获取的奖品的id，你很成功哦。
        return rateTuple[idx];
    }
}
