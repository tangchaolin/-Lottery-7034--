package cn.itedus.lottery.domain.strategy.service.algorithm.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
/*
 * @description: 必中奖概率算法，排掉已经中奖的概率，重新计算中奖范围。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */


@Component("entiretyRateRandomDrawAlgorithm")
//必中奖策略抽奖，排除掉已经中将的概率，重新计算中奖范围。
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator =BigDecimal.ZERO;

        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();

//        List<AwardRateInfo> awardRateIntervalList =;

        for (AwardRateInfo info : awardRateInfoMap.get(strategyId)) {
            if(!ObjectUtil.isNull(excludeAwardIds)&&!ObjectUtil.isEmpty(excludeAwardIds)) {
                if (excludeAwardIds.contains(info.getAwardId())) {
                    continue;
                }
            }
            differenceAwardRateList.add(info);

            differenceDenominator = differenceDenominator.add(info.getAwardRate());

        }
        //如果没奖品了，，那就不用抽了，，回家洗洗睡吧。
        //只有一个奖品了，因为是必中奖，所以直接给你了。
        if (differenceAwardRateList.size() == 0) {
            return "";
        }
        if (differenceAwardRateList.size()==1) {
            return differenceAwardRateList.get(0).getAwardId();
        }

        int random= new SecureRandom().nextInt(100)+1;

        int cursorVal=0;

        for (AwardRateInfo info : differenceAwardRateList) {
            int newRate = info.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();

            if (random<=cursorVal+newRate) {
                return info.getAwardId();
            }
            cursorVal=cursorVal+newRate;
        }

        return null;
    }
}
