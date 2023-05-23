package cn.itedus.lottery.domain.rule.service.logic;

import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/**
 * @description: 规则器过滤接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue 决策值
     * @param treeNodeLineInfoList 决策节点
     * @return 下一个节点ID
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     * 获取决策值
     * @param decisionMatterReq
     * @return
     */
    String matterValue(DecisionMatterReq decisionMatterReq);

}
