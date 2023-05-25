package cn.itedus.lottery.domain.award.model.req;

import cn.itedus.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @description: 奖品发货信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class GoodsReq {

    private String uId;

    private Long orderId;

    private String awardId;

    private String awardName;

    private String awardContent;

    private ShippingAddress shippingAddress;

    private String extInfo;

    public GoodsReq() {
    }

    public GoodsReq(String uId, Long orderId, String awardId, String awardName, String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }
    public GoodsReq(String uId, Long orderId, String awardId, String awardName, String awardContent, ShippingAddress shippingAddress, String extInfo) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.shippingAddress = shippingAddress;
        this.extInfo = extInfo;
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
     * @return orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取
     * @return awardId
     */
    public String getAwardId() {
        return awardId;
    }

    /**
     * 设置
     * @param awardId
     */
    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    /**
     * 获取
     * @return awardName
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * 设置
     * @param awardName
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /**
     * 获取
     * @return awardContent
     */
    public String getAwardContent() {
        return awardContent;
    }

    /**
     * 设置
     * @param awardContent
     */
    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    /**
     * 获取
     * @return shippingAddress
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * 设置
     * @param shippingAddress
     */
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * 获取
     * @return extInfo
     */
    public String getExtInfo() {
        return extInfo;
    }

    /**
     * 设置
     * @param extInfo
     */
    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public String toString() {
        return "GoodsReq{uId = " + uId + ", orderId = " + orderId + ", awardId = " + awardId + ", awardName = " + awardName + ", awardContent = " + awardContent + ", shippingAddress = " + shippingAddress + ", extInfo = " + extInfo + "}";
    }
}
