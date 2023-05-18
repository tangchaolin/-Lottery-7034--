package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
/*
 * @description: 执行抽奖的接口，只有一个抽奖的方法，传入req  包含用户的id以及抽奖策略id。
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

/**
 * @description:抽奖接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IDrawExec {
    /**
     * 抽奖方法
     * @param req
     * @return
     */
    public DrawResult doDrawExec(DrawReq req);

}
