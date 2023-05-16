package cn.itedus.lottery.domain.strategy.service.algorithm;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateIntervalVal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class BaseAlgorithm implements IDrawAlgorithm{

    private final int HASH_INCREMENT=0x61c88647;

    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    private final int RATE_TUPLE_LENGHTH=128;


    private Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();






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

}
