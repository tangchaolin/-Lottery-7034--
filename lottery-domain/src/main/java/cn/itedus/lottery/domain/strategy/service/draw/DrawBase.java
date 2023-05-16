package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Component("drawBase")
public class DrawBase extends DrawConfig {

    public void checkAndInitRateTuple(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {

//        if (1!=strategyMode){return;}

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean isExistRateTuple = drawAlgorithm.isExistRateTuple(strategyId);

        if (isExistRateTuple){return;}
        List<AwardRateInfo> list = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            list.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId,list);

    }


}
