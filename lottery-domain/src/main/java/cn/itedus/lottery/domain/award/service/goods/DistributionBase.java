package cn.itedus.lottery.domain.award.service.goods;

import cn.itedus.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @description: 配送货物基础共用类
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DistributionBase {
    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);
    @Resource
    private IAwardRepository awardRepository;

    protected  void  updateUserAwardState(String uId,String orderId,String awardId,Integer awardState,String awardStateInfo) {
        //TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态。
    }

}
