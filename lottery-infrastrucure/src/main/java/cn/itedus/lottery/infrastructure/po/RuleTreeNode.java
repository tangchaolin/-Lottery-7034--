package cn.itedus.lottery.infrastructure.po;

/**
 * @description: 规则树节点
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class RuleTreeNode {
    /** id */
    private Long id;
    /** 规则树id */
    private Long treeId;
    /** 节点类型  1.子叶 2.果实 */
    private Integer nodeType;
    /** 节点值 【nodeType=2】果实值 */
    private String nodeValue;
    /** 规则key */
    private String ruleKey;
    /** 规则描述 */
    private String ruleDesc;


    public RuleTreeNode() {
    }

    public RuleTreeNode(Long id, Long treeId, Integer nodeType, String nodeValue, String ruleKey, String ruleDesc) {
        this.id = id;
        this.treeId = treeId;
        this.nodeType = nodeType;
        this.nodeValue = nodeValue;
        this.ruleKey = ruleKey;
        this.ruleDesc = ruleDesc;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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

    public String toString() {
        return "RuleTreeNode{id = " + id + ", treeId = " + treeId + ", nodeType = " + nodeType + ", nodeValue = " + nodeValue + ", ruleKey = " + ruleKey + ", ruleDesc = " + ruleDesc + "}";
    }
}
