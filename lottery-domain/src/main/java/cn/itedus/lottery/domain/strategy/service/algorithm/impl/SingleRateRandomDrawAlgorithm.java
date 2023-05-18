package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
/**
 * @description: 单项随机抽奖概率，抽到一个已经排除的奖品则未中奖。继承自BaseAlgorithm。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    /**
     * 根据策略id进行抽奖，根据情况传入排除的奖品的id。
     * @param strategyId
     * @param excludeAwardIds
     * @return
     */
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] rateTuple = rateTupleMap.get(strategyId);
        assert rateTuple!=null;

        //随机1-100.
        int random = generateSecureRandomIntCode(100);
        //获取到了idx。
        int idx = hashIdx(random);

        //在rateTuple中寻找awardId。在排除的奖品id里面则未中奖。返回null。
        if (!ObjectUtil.isNull(excludeAwardIds)&&(!ObjectUtil.isEmpty(excludeAwardIds))){
            if (excludeAwardIds.contains(rateTuple[idx])){
                return null;}
        }
        //返回获取的奖品的id。
        return rateTuple[idx];

    }
}
