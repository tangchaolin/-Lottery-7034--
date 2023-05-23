package cn.itedus.lottery.domain.rule.model.vo;

/**
 * @description: 树根信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class TreeRootVO {
    /** 规则树ID */
    private Long treeId;
    /** 规则树根ID */
    private Long treeRootNodeId;
    /** 规则树的名称 */
    private String treeName;


    public TreeRootVO() {
    }

    public TreeRootVO(Long treeId, Long treeRootNodeId, String treeName) {
        this.treeId = treeId;
        this.treeRootNodeId = treeRootNodeId;
        this.treeName = treeName;
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
     * @return treeRootNodeId
     */
    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    /**
     * 设置
     * @param treeRootNodeId
     */
    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    /**
     * 获取
     * @return treeName
     */
    public String getTreeName() {
        return treeName;
    }

    /**
     * 设置
     * @param treeName
     */
    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String toString() {
        return "TreeRootVO{treeId = " + treeId + ", treeRootNodeId = " + treeRootNodeId + ", treeName = " + treeName + "}";
    }
}
