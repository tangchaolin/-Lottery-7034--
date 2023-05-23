package cn.itedus.lottery.infrastructure.repository;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.itedus.lottery.domain.rule.model.vo.TreeNodeLineVO;
import cn.itedus.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.itedus.lottery.domain.rule.model.vo.TreeRootVO;
import cn.itedus.lottery.domain.rule.repository.IRuleRepository;
import cn.itedus.lottery.infrastructure.dao.RuleTreeDao;
import cn.itedus.lottery.infrastructure.dao.RuleTreeNodeDao;
import cn.itedus.lottery.infrastructure.dao.RuleTreeNodeLineDAO;
import cn.itedus.lottery.infrastructure.po.RuleTree;
import cn.itedus.lottery.infrastructure.po.RuleTreeNode;
import cn.itedus.lottery.infrastructure.po.RuleTreeNodeLine;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 规则信息仓储服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Repository
public class RuleRepository implements IRuleRepository {
    @Resource
    private RuleTreeDao ruleTreeDao;

    @Resource
    private RuleTreeNodeDao ruleTreeNodeDao;

    @Resource
    private RuleTreeNodeLineDAO ruleTreeNodeLineDAO;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
            //规则树
        RuleTree ruleTree = ruleTreeDao.queryRuleTreeByTreeId(treeId);
        //规则树根
        TreeRootVO treeRoot=new TreeRootVO();
        treeRoot.setTreeId(ruleTree.getId());
        treeRoot.setTreeName(ruleTree.getTreeName());
        treeRoot.setTreeRootNodeId(ruleTree.getTreeRootNodeId());

        //树节点->树连接线
        Map<Long, TreeNodeVO> treeNodeMap=new HashMap<>();

        List<RuleTreeNode> ruleTreeNodeList = ruleTreeNodeDao.queryRuleTreeNodeList(treeId);
        for (RuleTreeNode treeNode : ruleTreeNodeList) {
            List<TreeNodeLineVO> treeNodeLineInfoList = new ArrayList<>();
            if (Constants.NodeType.STEM.equals(treeNode.getNodeType())) {
                RuleTreeNodeLine ruleTreeNodeLine=new RuleTreeNodeLine();
                ruleTreeNodeLine.setNodeIdFrom(treeNode.getId());
                ruleTreeNodeLine.setTreeId(treeNode.getTreeId());
                List<RuleTreeNodeLine> ruleTreeNodeLineList = ruleTreeNodeLineDAO.queryRuleTreeNodeLineList(ruleTreeNodeLine);

                for (RuleTreeNodeLine nodeLine : ruleTreeNodeLineList) {
                    TreeNodeLineVO treeNodeLineVO=new TreeNodeLineVO();
                    treeNodeLineVO.setNodeIdTo(nodeLine.getNodeIdTo());
                    treeNodeLineVO.setNodeIdFrom(nodeLine.getNodeIdFrom());
                    treeNodeLineVO.setRuleLimitType(nodeLine.getRuleLimitType());
                    treeNodeLineVO.setRuleLimitValue(nodeLine.getRuleLimitValue());
                    treeNodeLineInfoList.add(treeNodeLineVO);
                }


            }
            TreeNodeVO treeNodeInfo=new TreeNodeVO();

            treeNodeInfo.setTreeNodeId(treeNode.getId());
            treeNodeInfo.setTreeId(treeNode.getTreeId());
            treeNodeInfo.setNodeType(treeNode.getNodeType());
            treeNodeInfo.setNodeValue(treeNode.getNodeValue());
            treeNodeInfo.setTreeNodeLineInfoList(treeNodeLineInfoList);
            treeNodeInfo.setRuleKey(treeNode.getRuleKey());
            treeNodeInfo.setRuleDesc(treeNode.getRuleDesc());

            treeNodeMap.put(treeNode.getId(), treeNodeInfo);

        }


        TreeRuleRich treeRuleRich = new TreeRuleRich();
        treeRuleRich.setTreeRoot(treeRoot);
        treeRuleRich.setTreeNodeMap(treeNodeMap);


        return treeRuleRich;
    }
}
