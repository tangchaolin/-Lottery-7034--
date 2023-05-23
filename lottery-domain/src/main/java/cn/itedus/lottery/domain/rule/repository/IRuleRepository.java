package cn.itedus.lottery.domain.rule.repository;

import cn.itedus.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @description: 规则信息仓储服务接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IRuleRepository {

    /**
     * 查询规则决策树的配置
     * @param treeId 规则树的ID
     * @return 返回决策树的配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);

}
