package cn.itedus.lottery.domain.rule.model.vo;

/**
 * @description: 规则树线信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class TreeNodeLineVO {
    /** 节点From */
    private Long nodeIdFrom;
    /** 节点To */
    private Long nodeIdTo;
    /** 限定类型  1:== 2:> 3:>= 4:<= 5:enum */
    private Integer ruleLimitType;
    /** 限定值 */
    private String ruleLimitValue;


    public TreeNodeLineVO() {
    }

    public TreeNodeLineVO(Long nodeIdFrom, Long nodeIdTo, Integer ruleLimitType, String ruleLimitValue) {
        this.nodeIdFrom = nodeIdFrom;
        this.nodeIdTo = nodeIdTo;
        this.ruleLimitType = ruleLimitType;
        this.ruleLimitValue = ruleLimitValue;
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
        return "TreeNodeLineVO{nodeIdFrom = " + nodeIdFrom + ", nodeIdTo = " + nodeIdTo + ", ruleLimitType = " + ruleLimitType + ", ruleLimitValue = " + ruleLimitValue + "}";
    }
}
