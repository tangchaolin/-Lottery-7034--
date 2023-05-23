package cn.itedus.lottery.infrastructure.po;

/**
 * @description: 规则树节点连线
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class RuleTreeNodeLine {

    /** 主键ID */
    private Long id;

    /** 规则树ID */
    private Long treeId;

    /** 节点From */
    private Long nodeIdFrom;

    /** 节点To */
    private Long nodeIdTo;

    /** 限定类型 */
    private Integer ruleLimitType;
    /** 限定值 */
    private String ruleLimitValue;


    public RuleTreeNodeLine() {
    }

    public RuleTreeNodeLine(Long id, Long treeId, Long nodeIdFrom, Long nodeIdTo, Integer ruleLimitType, String ruleLimitValue) {
        this.id = id;
        this.treeId = treeId;
        this.nodeIdFrom = nodeIdFrom;
        this.nodeIdTo = nodeIdTo;
        this.ruleLimitType = ruleLimitType;
        this.ruleLimitValue = ruleLimitValue;
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
     * @return nodeIdFrom
     */
    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    /**
     * 设置
     * @param nodeIdFrom
     */
    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    /**
     * 获取
     * @return nodeIdTo
     */
    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    /**
     * 设置
     * @param nodeIdTo
     */
    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    /**
     * 获取
     * @return ruleLimitType
     */
    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    /**
     * 设置
     * @param ruleLimitType
     */
    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    /**
     * 获取
     * @return ruleLimitValue
     */
    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    /**
     * 设置
     * @param ruleLimitValue
     */
    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }

    public String toString() {
        return "RuleTreeNodeLine{id = " + id + ", treeId = " + treeId + ", nodeIdFrom = " + nodeIdFrom + ", nodeIdTo = " + nodeIdTo + ", ruleLimitType = " + ruleLimitType + ", ruleLimitValue = " + ruleLimitValue + "}";
    }
}
