package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

/**
 * @description: 规则树
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class RuleTree {

    private Long id;

    private String treeName;

    private String treeDesc;

    private Long treeRootNodeId;

    private Date createTime;

    private Date updateTime;


    public RuleTree() {
    }

    public RuleTree(Long id, String treeName, String treeDesc, Long treeRootNodeId, Date createTime, Date updateTime) {
        this.id = id;
        this.treeName = treeName;
        this.treeDesc = treeDesc;
        this.treeRootNodeId = treeRootNodeId;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    /**
     * 获取
     * @return treeDesc
     */
    public String getTreeDesc() {
        return treeDesc;
    }

    /**
     * 设置
     * @param treeDesc
     */
    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
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
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return "RuleTree{id = " + id + ", treeName = " + treeName + ", treeDesc = " + treeDesc + ", treeRootNodeId = " + treeRootNodeId + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}
