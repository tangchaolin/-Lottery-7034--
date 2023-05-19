package cn.itedus.lottery.domain.activity.service.deploy.impl;

import cn.itedus.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.itedus.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AwardVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyVO;
import cn.itedus.lottery.domain.activity.repository.IActivityRepository;
import cn.itedus.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 部署活动配置服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class ActivitydeployImpl implements IActivityDeploy {
    private Logger logger = LoggerFactory.getLogger(ActivitydeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始,activityId:{}", req.getActivityId());
        ActivityConfigRich activityConfigRich=req.getActivityConfigRich();
        try{
            // 添加活动配置
            ActivityVO activity=activityConfigRich.getActivity();
            activityRepository.addActivity(activity);
            //添加奖品配置

            List<AwardVO> list =activityConfigRich.getAwardList();
            activityRepository.addAward(list);
            //添加策略配置
            StrategyVO strategy=activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            //添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = strategy.getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);
        }
        catch (DuplicateKeyException e){
            logger.error("创建活动配置失败，唯一索引冲突 activityId:{} reqJson:{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        //TODO:非核心功能后续补充。
    }
}
