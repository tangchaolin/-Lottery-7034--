package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.RuleTree;
import cn.itedus.lottery.infrastructure.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 规则树连线DAO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface RuleTreeNodeLineDAO {
    /**
     * 查询规则树节点连线集合
     * @param req
     *
     * @return
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * 查询规则树连线数量
     * @param treeId
     * @return
     */
    int queryTreeNodeLineCount(Long treeId);



}
