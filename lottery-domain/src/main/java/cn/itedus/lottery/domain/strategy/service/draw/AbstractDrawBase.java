package cn.itedus.lottery.domain.strategy.service.draw;

import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.*;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 定义抽奖的过程，使用模板模式。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{
    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        //获取抽奖策略的信息信息
        StrategyRich rich = queryStrategyRich(req.getStrategyId());
        StrategyBriefVO strategy=rich.getStrategy();

        //校验抽奖算法是否已经初始化到内存中。
        checkAndInitRateTuple(req.getStrategyId(),strategy.getStrategyMode(),rich.getStrategyDetailList());
        //获取不在抽奖范围内的列表，包括：奖品库存为空，风控策略，临时调整。
        List<String> excludeAwardIds = queryExcludeAwardIds(strategy.getStrategyId());

        //执行抽奖算法
        String awardId=drawAlgorithm(strategy.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()), excludeAwardIds);




        return buildDrawResult(req.getUId(),req.getStrategyId(),awardId,strategy);
    }

    /**
     * 校验抽奖策略是否初始化到内存中去。
     * @param strategyId
     * @param strategyMode
     * @param strategyDetailList
     */
    protected void checkAndInitRateTuple(Long strategyId,Integer strategyMode,List<StrategyDetailBriefVO> strategyDetailList) {

//        // 非单项概率不必初始化元素
//        if(!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)){
//            return;
//        }
        //*根据策略模式，选择相应的抽奖服务。
        BaseAlgorithm drawAlgorithm = (BaseAlgorithm) drawAlgorithmGroup.get(strategyMode);

        boolean isExist = drawAlgorithm.isExist(strategyId);

        if (isExist){return;}
        List<AwardRateInfo> list = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetailBriefVO strategyDetail : strategyDetailList) {
            list.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId,strategyMode,list);

    }

    /**
     * 构建抽奖的结果
     * @param uId
     * @param strategyId
     * @param awardId
     * @return
     */

    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId,StrategyBriefVO strategy) {

        if (ObjectUtil.isNull(awardId)) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode(), null);
        }
        AwardBriefVo award = queryAwardInfoByAwardId(awardId);

        DrawAwardVO drawAwardVO =new DrawAwardVO(award.getAwardId(),award.getAwardName(),award.getAwardType(),award.getAwardContent(),strategy.getStrategyMode()
        ,strategy.getGrantType(),strategy.getGrantDate(),uId);
        logger.info("执行策略中奖已完成【已中奖】，用户：{} 策略id：{} 奖品id：{} 奖品名称：{}",uId,strategyId,award.getAwardId(),award.getAwardName());

        return new DrawResult(uId,strategyId,Constants.DrawState.SUCCESS.getCode(), drawAwardVO);

    }

    /**
     * 查询排除的奖品id
     * @param strategyId 策略id
     * @return 返回排除的奖品的id
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖动作。返回奖品的id。
     * @param strategyId
     * @param drawAlgorithm
     * @param excludeAwardIds
     * @return
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);






}
