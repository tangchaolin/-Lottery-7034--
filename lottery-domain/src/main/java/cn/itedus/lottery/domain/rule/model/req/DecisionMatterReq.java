package cn.itedus.lottery.domain.rule.model.req;

import java.util.Map;

/**
 * @description: 决策物料
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/23 0023
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DecisionMatterReq {

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 决策值
     */
    private Map<String,Object> valMap;


    public DecisionMatterReq() {
    }

    public DecisionMatterReq(Long treeId, String userId, Map<String, Object> valMap) {
        this.treeId = treeId;
        this.userId = userId;
        this.valMap = valMap;
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
     * @return valMap
     */
    public Map<String, Object> getValMap() {
        return valMap;
    }

    /**
     * 设置
     * @param valMap
     */
    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

    public String toString() {
        return "DecisionMatterReq{treeId = " + treeId + ", userId = " + userId + ", valMap = " + valMap + "}";
    }
}
