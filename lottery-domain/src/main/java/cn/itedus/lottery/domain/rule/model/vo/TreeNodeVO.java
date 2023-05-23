package cn.itedus.lottery.domain.rule.model.vo;

import java.util.List;

/**
 * @description: 树节点信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class TreeNodeVO {
    /** 规则树ID */
    private Long treeId;

    /** 规则树节点ID */

    private Long TreeNodeId;

    /** 节点类型 1：子叶 2：果实 */

    private Integer nodeType;
    /** 节点值【nodeType=2】；果实值*/
    private  String nodeValue;
    /** 规则Key */
    private String ruleKey;
    /** 规则描述 */
    private String ruleDesc;

    /** 节点链路 */
    private List<TreeNodeLineVO> treeNodeLineInfoList;


    public TreeNodeVO() {
    }

    public TreeNodeVO(Long treeId, Long TreeNodeId, Integer nodeType, String nodeValue, String ruleKey, String ruleDesc, List<TreeNodeLineVO> treeNodeLineInfoList) {
        this.treeId = treeId;
        this.TreeNodeId = TreeNodeId;
        this.nodeType = nodeType;
        this.nodeValue = nodeValue;
        this.ruleKey = ruleKey;
        this.ruleDesc = ruleDesc;
        this.treeNodeLineInfoList = treeNodeLineInfoList;
    }

    /**
     * 获取
     * @return treeId
     */
    public Long getTreeId() {
        return treeId;
    }

    /**
     * 设置
     * @param treeId
     */
    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    /**
     * 获取
     * @return TreeNodeId
     */
    public Long getTreeNodeId() {
        return TreeNodeId;
    }

    /**
     * 设置
     * @param TreeNodeId
     */
    public void setTreeNodeId(Long TreeNodeId) {
        this.TreeNodeId = TreeNodeId;
    }

    /**
     * 获取
     * @return nodeType
     */
    public Integer getNodeType() {
        return nodeType;
    }

    /**
     * 设置
     * @param nodeType
     */
    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * 获取
     * @return nodeValue
     */
    public String getNodeValue() {
        return nodeValue;
    }

    /**
     * 设置
     * @param nodeValue
     */
    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    /**
     * 获取
     * @return ruleKey
     */
    public String getRuleKey() {
        return ruleKey;
    }

    /**
     * 设置
     * @param ruleKey
     */
    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    /**
     * 获取
     * @return ruleDesc
     */
    public String getRuleDesc() {
        return ruleDesc;
    }

    /**
     * 设置
     * @param ruleDesc
     */
    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    /**
     * 获取
     * @return treeNodeLineInfoList
     */
    public List<TreeNodeLineVO> getTreeNodeLineInfoList() {
        return treeNodeLineInfoList;
    }

    /**
     * 设置
     * @param treeNodeLineInfoList
     */
    public void setTreeNodeLineInfoList(List<TreeNodeLineVO> treeNodeLineInfoList) {
        this.treeNodeLineInfoList = treeNodeLineInfoList;
    }

    public String toString() {
        return "TreeNodeVO{treeId = " + treeId + ", TreeNodeId = " + TreeNodeId + ", nodeType = " + nodeType + ", nodeValue = " + nodeValue + ", ruleKey = " + ruleKey + ", ruleDesc = " + ruleDesc + ", treeNodeLineInfoList = " + treeNodeLineInfoList + "}";
    }
}
