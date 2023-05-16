package cn.itedus.lottery.domain.strategy.service.draw.impl;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.service.draw.DrawBase;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("drawExec")
public class DrawExecImpl implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource(name = "drawBase")
    private DrawBase drawBase;

    @Resource
    private IStrategyRepository strategyRepository;
    @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("开始执行抽奖,抽奖策略为{},抽奖的用户id为{}",req.getStrategyId(),req.getuId());

        //获取抽奖策略配置数据

        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());

        Strategy strategy =strategyRich.getStrategy();

        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        //校验和初始化数据
        drawBase.checkAndInitRateTuple(strategy.getStrategyId(),strategy.getStrategyMode(),strategyDetailList);

        //获取抽奖算法，单一概率还是总体概率
        IDrawAlgorithm drawAlgorithm=DrawBase.drawAlgorithmMap.get(strategy.getStrategyMode());

        //根据抽奖的策略,返回奖品的id
        String awardId = drawAlgorithm.randomDraw(strategy.getStrategyId(),null);

        //获取奖品的信息
        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("执行抽奖策略完成，中奖用户为{},奖品ID为{},奖品名称为{}",req.getuId(),awardId,award.getAwardName());


        //封装结果
        return new DrawResult(req.getuId(),strategy.getStrategyId(),award.getAwardId(),award.getAwardName());

    }
}
