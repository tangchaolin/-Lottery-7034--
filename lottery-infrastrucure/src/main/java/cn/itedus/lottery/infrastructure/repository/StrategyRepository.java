package cn.itedus.lottery.infrastructure.repository;

import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVo;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.itedus.lottery.infrastructure.dao.IAwardDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        //查询strategy信息
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);

        StrategyBriefVO strategyBriefVO =new StrategyBriefVO();
        BeanUtils.copyProperties(strategy,strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            StrategyDetailBriefVO strategyDetailBriefVO =new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail,strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        }
        return new StrategyRich(strategyId,strategyBriefVO,strategyDetailBriefVOList);
    }

    @Override
    public AwardBriefVo queryAwardInfo(String awardId) {
        Award award = awardDao.queryAwardInfo(awardId);
        AwardBriefVo awardBriefVo =new AwardBriefVo();

        awardBriefVo.setAwardId(award.getAwardId());
        awardBriefVo.setAwardName(award.getAwardName());
        awardBriefVo.setAwardType(award.getAwardType());
        awardBriefVo.setAwardContent(award.getAwardContent());
        return awardBriefVo;
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
