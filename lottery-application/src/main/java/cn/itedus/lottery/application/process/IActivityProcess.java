package cn.itedus.lottery.application.process;

import cn.itedus.lottery.application.process.req.DrawProcessReq;
import cn.itedus.lottery.application.process.res.DrawProcessResult;

/**
 * @description: 活动抽奖流程编排接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/22 0022
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IActivityProcess {
    /**
     * 执行抽奖流程
     * @param req
     * @return 返回抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);


}
