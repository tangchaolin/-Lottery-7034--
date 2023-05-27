package cn.itedus.lottery.domain.activity.model.vo;

/**
 * @description: 活动参与记录
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/26 0026
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class ActivityPartakeRecordVO {
    /**
     * 用户ID
      */
    private String uId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动库存
     */
    private Integer stockCount;
    /**
     * 活动剩余库存
     */
    private Integer stockSurplusCount;


    public ActivityPartakeRecordVO() {
    }

    public ActivityPartakeRecordVO(String uId, Long activityId, Integer stockCount, Integer stockSurplusCount) {
        this.uId = uId;
        this.activityId = activityId;
        this.stockCount = stockCount;
        this.stockSurplusCount = stockSurplusCount;
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
     * @return activityId
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置
     * @param activityId
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取
     * @return stockCount
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 设置
     * @param stockCount
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * 获取
     * @return stockSurplusCount
     */
    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    /**
     * 设置
     * @param stockSurplusCount
     */
    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

    public String toString() {
        return "ActivityPartakeRecordVO{uId = " + uId + ", activityId = " + activityId + ", stockCount = " + stockCount + ", stockSurplusCount = " + stockSurplusCount + "}";
    }
}
