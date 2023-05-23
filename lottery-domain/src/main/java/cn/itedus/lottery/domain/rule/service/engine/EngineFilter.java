package cn.itedus.lottery.domain.rule.service.engine;

import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.res.EngineResult;

/**
 * @description: 规则过滤器引擎
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface EngineFilter {
    /**
     * 规则过滤器接口
     * @param req 规则决策物料
     * @return 规则决策结果
     */

    EngineResult process(final DecisionMatterReq req);
}
