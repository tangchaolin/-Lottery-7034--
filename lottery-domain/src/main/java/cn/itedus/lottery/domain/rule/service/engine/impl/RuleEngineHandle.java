package cn.itedus.lottery.domain.rule.service.engine.impl;

import cn.itedus.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.res.EngineResult;
import cn.itedus.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.itedus.lottery.domain.rule.repository.IRuleRepository;
import cn.itedus.lottery.domain.rule.service.engine.EngineBase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 规则引擎处理器
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    public EngineResult process(DecisionMatterReq matter) {
        //决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is Null");
        }
        // 决策节点
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);

        //决策结果
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId()
        ,treeNodeInfo.getNodeValue());

    }

}
