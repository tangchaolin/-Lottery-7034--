package cn.itedus.lottery.domain.strategy.model.repository.impl;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.infrastructure.dao.IAwardDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
/**
 * @description: 为策略模式提供策略数据支持服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    IStrategyDao strategyDao;

    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Resource
    IAwardDao awardDao;


    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
//        StrategyRich strategyRich =
        StrategyRich strategyRich = new StrategyRich();

        strategyRich.setStrategyId(strategyId);
        //查询到的策略配置信息
        strategyRich.setStrategy(strategyDao.queryStrategy(strategyId));

        //查询到的策略明细信息
        strategyRich.setStrategyDetailList(strategyDetailDao.queryStrategyDetailList(strategyId));



        return strategyRich;
    }

    @Override
    public Award queryAwardInfo(String awardId) {

        return awardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
//        strategyDetailDao.

        return null;
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetailreq=new StrategyDetail();
        strategyDetailreq.setStrategyId(strategyId);
        strategyDetailreq.setAwardId(awardId);

        int count=strategyDetailDao.deductStock(strategyDetailreq);

        return count==1;
    }

}
