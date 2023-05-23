package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 规则树节点DAO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface RuleTreeNodeDao {
    /**
     * 查询规则树节点
     * @param treeId 规则树ID
     * @return
     */
    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    /**
     * 查询规则树节点数量
     * @param treeId 规则树ID
     * @return
     */
    int queryTreeNodeCount(Long treeId);

    /**
     * 查询规则树节点
     * @param treeId 规则树ID
     * @return 规则树节点
     */
    List<RuleTreeNode> queryTreeRulePoint(Long treeId);


}
