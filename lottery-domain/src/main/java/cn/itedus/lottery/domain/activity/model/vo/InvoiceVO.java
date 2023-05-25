package cn.itedus.lottery.domain.activity.model.vo;

import cn.itedus.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @description: 中奖物品发送单，用于发送MQ消息，异步触达发货奖品给用户
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class InvoiceVO {

    /** 用户ID */

    private String uId;

    /** 抽奖单号 ID */
    private Long orderId;

    /** 奖品ID */
    private String awardId;

    /** 奖品类型  1：文字描述2：兑换码 3：优惠券 4.实物奖品*/
    private Integer awardType;

    /** 奖品名称 */
    private String awardName;

    /** 奖品内容 */
    private String awardContent;

    /** 四级地址 （只有实物商品需要地址）*/
    private ShippingAddress shippingAddress;
    /** 扩展信息 */
    private String extInfo;


    public InvoiceVO() {
    }

    public InvoiceVO(String uId, Long orderId, String awardId, Integer awardType, String awardName, String awardContent, ShippingAddress shippingAddress, String extInfo) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardType = awardType;
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
     * @return awardType
     */
    public Integer getAwardType() {
        return awardType;
    }

    /**
     * 设置
     * @param awardType
     */
    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
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
        return "InvoiceVO{uId = " + uId + ", orderId = " + orderId + ", awardId = " + awardId + ", awardType = " + awardType + ", awardName = " + awardName + ", awardContent = " + awardContent + ", shippingAddress = " + shippingAddress + ", extInfo = " + extInfo + "}";
    }
}
