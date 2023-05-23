package cn.itedus.lottery.domain.rule.model.res;

/**
 * @description: 决策结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class EngineResult {
    /** 决策结果 */
    private boolean isSuccess;
    /** 用户ID */
    private String userId;

    /** 规则树ID */
    private Long treeId;

    /**　果实节点ID */
    private Long nodeId;
    /** 果实节点值 */
    private String nodeValue;


    public EngineResult() {
    }

    public EngineResult(boolean isSuccess, String userId, Long treeId, Long nodeId, String nodeValue) {
        this.isSuccess = isSuccess;
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }
    public EngineResult(String userId, Long treeId, Long nodeId, String nodeValue) {
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }

    /**
     * 获取
     * @return isSuccess
     */
    public boolean isIsSuccess() {
        return isSuccess;
    }

    /**
     * 设置
     * @param isSuccess
     */
    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * 获取
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return nodeId
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * 设置
     * @param nodeId
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
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

    public String toString() {
        return "EngineResult{isSuccess = " + isSuccess + ", userId = " + userId + ", treeId = " + treeId + ", nodeId = " + nodeId + ", nodeValue = " + nodeValue + "}";
    }
}
