package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 规则树配置DAO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface RuleTreeDao {
    /**
     * 规则树查询
     * @param id ID
     * @return 规则树
     */
    RuleTree queryRuleTreeByTreeId(Long id);

    /**
     * 规则树简要信息查询
     * @param treeId 规则树ID
     * @return 规则树
     */
    RuleTree queryTreeSummaryInfo(Long treeId);

}
