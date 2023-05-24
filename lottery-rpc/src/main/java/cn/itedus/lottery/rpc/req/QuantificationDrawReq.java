package cn.itedus.lottery.rpc.req;

import java.io.Serializable;
import java.util.Map;

/**
 * @description: 量化人群抽奖请求参数
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class QuantificationDrawReq implements Serializable {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 规则树ID
     */

    private Long treeId;
    /**
     * 决策值
     */
    private Map<String,Object> valMap;


    public QuantificationDrawReq() {
    }

    public QuantificationDrawReq(String uId, Long treeId, Map<String, Object> valMap) {
        this.uId = uId;
        this.treeId = treeId;
        this.valMap = valMap;
    }

    /**
     * 获取
     * @return uId
     */
    public String getUId() {
        return uId;
    }

    /**
     * 设置
     * @param uId
     */
    public void setUId(String uId) {
        this.uId = uId;
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
        return "QuantificationDrawReq{uId = " + uId + ", treeId = " + treeId + ", valMap = " + valMap + "}";
    }
}
