package cn.itedus.lottery.domain.rule.model.aggregates;

import cn.itedus.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.itedus.lottery.domain.rule.model.vo.TreeRootVO;

import java.util.Map;

/**
 * @description: 规则树聚合
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class TreeRuleRich {

    /** 树根信息 */
    private TreeRootVO treeRoot;

    private Map<Long, TreeNodeVO> treeNodeMap;


    public TreeRuleRich() {
    }

    public TreeRuleRich(TreeRootVO treeRoot, Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    /**
     * 获取
     * @return treeRoot
     */
    public TreeRootVO getTreeRoot() {
        return treeRoot;
    }

    /**
     * 设置
     * @param treeRoot
     */
    public void setTreeRoot(TreeRootVO treeRoot) {
        this.treeRoot = treeRoot;
    }

    /**
     * 获取
     * @return treeNodeMap
     */
    public Map<Long, TreeNodeVO> getTreeNodeMap() {
        return treeNodeMap;
    }

    /**
     * 设置
     * @param treeNodeMap
     */
    public void setTreeNodeMap(Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }

    public String toString() {
        return "TreeRuleRich{treeRoot = " + treeRoot + ", treeNodeMap = " + treeNodeMap + "}";
    }
}
