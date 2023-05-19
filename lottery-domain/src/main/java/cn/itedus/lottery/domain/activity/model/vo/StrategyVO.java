package cn.itedus.lottery.domain.activity.model.vo;

import java.util.Date;
import java.util.List;

/**
 * @description: 策略VO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StrategyVO {
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 策略模式 1.总体概率 2.单一概率
     */
    private Integer strategyMode;
    /**
     * 策略描述
     */
    private String strategyDesc;
    /**
     * 发放方式  1.即时发放 2.定时发放 3，人工发放
     */
    private Integer grantType;
    /**
     * 发放奖品日期
     */
    private Date  grantDate;
    /**
     * 扩展信息
     */
    private String extInfo;
    /**
     * 策略详情配置
     */
    private List<StrategyDetailVO> strategyDetailList;


    public StrategyVO() {
    }

    public StrategyVO(Long strategyId, Integer strategyMode, String strategyDesc, Integer grantType, Date grantDate, String extInfo, List<StrategyDetailVO> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategyMode = strategyMode;
        this.strategyDesc = strategyDesc;
        this.grantType = grantType;
        this.grantDate = grantDate;
        this.extInfo = extInfo;
        this.strategyDetailList = strategyDetailList;
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
     * @return strategyMode
     */
    public Integer getStrategyMode() {
        return strategyMode;
    }

    /**
     * 设置
     * @param strategyMode
     */
    public void setStrategyMode(Integer strategyMode) {
        this.strategyMode = strategyMode;
    }

    /**
     * 获取
     * @return strategyDesc
     */
    public String getStrategyDesc() {
        return strategyDesc;
    }

    /**
     * 设置
     * @param strategyDesc
     */
    public void setStrategyDesc(String strategyDesc) {
        this.strategyDesc = strategyDesc;
    }

    /**
     * 获取
     * @return grantType
     */
    public Integer getGrantType() {
        return grantType;
    }

    /**
     * 设置
     * @param grantType
     */
    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    /**
     * 获取
     * @return grantDate
     */
    public Date getGrantDate() {
        return grantDate;
    }

    /**
     * 设置
     * @param grantDate
     */
    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
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

    /**
     * 获取
     * @return strategyDetailList
     */
    public List<StrategyDetailVO> getStrategyDetailList() {
        return strategyDetailList;
    }

    /**
     * 设置
     * @param strategyDetailList
     */
    public void setStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }

    public String toString() {
        return "StrategyVO{strategyId = " + strategyId + ", strategyMode = " + strategyMode + ", strategyDesc = " + strategyDesc + ", grantType = " + grantType + ", grantDate = " + grantDate + ", extInfo = " + extInfo + ", strategyDetailList = " + strategyDetailList + "}";
    }
}
