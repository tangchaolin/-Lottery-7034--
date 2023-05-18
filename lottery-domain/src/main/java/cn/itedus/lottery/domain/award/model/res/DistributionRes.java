package cn.itedus.lottery.domain.award.model.res;

/**
 * @description: 商品配送结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DistributionRes {

    /**
     * 用户id
     */

    private String uId;
    /**
     * 中奖的状态，Constants。awardState。Success.getCode
     */
    private Integer code;
    /**
     * 描述
     */
    private String info;
    /**
     * 结算单id ，如；发券有券码，发货后有单号，用于存根查询。
     */
    private String statementId;

    public DistributionRes(){}

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }

    public DistributionRes(String uId, Integer code, String info, String statementId) {
        this.uId = uId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }
}
