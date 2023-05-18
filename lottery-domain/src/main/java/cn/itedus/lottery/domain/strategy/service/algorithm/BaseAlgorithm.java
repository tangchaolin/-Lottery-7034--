package cn.itedus.lottery.domain.strategy.service.algorithm;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;


import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/*
 * @description: 抽奖算法的基础功能，比如实现了initRateTuple，和isExistRateTuple,并且实现了随机抽奖需要的hashIdx和生成随机数的功能。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
/**
 * @description: 抽奖算法的抽象类，实现了基础的方法，如初始化概率数组，判断是否存在策略id，生成idx，和生成安全的1-100的随机数用于抽奖。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public abstract class BaseAlgorithm implements IDrawAlgorithm{

    private final int HASH_INCREMENT=0x61c88647;

    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    private final int RATE_TUPLE_LENGHTH=128;


    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();






    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {

        //保存奖品概率信息

        awardRateInfoMap.put(strategyId, awardRateInfoList);

        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGHTH]);

        int cursorVal =0;

        for (AwardRateInfo info : awardRateInfoList) {

            int rateVal =info.getAwardRate().multiply(new BigDecimal(100)).intValue();

            for (int i = cursorVal + 1; i <= cursorVal + rateVal; i++) {
                int idx = hashIdx(i);
                rateTuple[idx]=info.getAwardId();
            }

            cursorVal+=rateVal;


        }

    }

    protected int hashIdx(int val){
        int hashCode=val*HASH_INCREMENT+HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGHTH - 1);
    }

    /**
     * 判断抽奖的策略id是否已经初始化。
     * @param StrategyId
     * @return
     */
    @Override
    public boolean isExistRateTuple(Long StrategyId) {
        return rateTupleMap.containsKey(StrategyId);
    }


    protected int generateSecureRandomIntCode(int bound) {
        return new SecureRandom().nextInt(bound)+1;
    }

}
