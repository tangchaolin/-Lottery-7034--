package cn.itedus.lottery.domain.strategy.model.req;
/**
 * @description: 抽奖的请求包装类
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawReq {
    private String uId;

    private Long strategyId;

    private String uuid;

    public DrawReq() {
    }

    public DrawReq(String uId, Long strategyId, String uuid) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
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
     * @return strategyId
     */
    public Long getStrategyId() {
        return strategyId;
    }

    /**
     * 设置
     * @param strategyId
     */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * 获取
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String toString() {
        return "DrawReq{uId = " + uId + ", strategyId = " + strategyId + ", uuid = " + uuid + "}";
    }
}
