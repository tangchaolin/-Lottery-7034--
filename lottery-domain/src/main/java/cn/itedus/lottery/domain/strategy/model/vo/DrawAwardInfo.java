package cn.itedus.lottery.domain.strategy.model.vo;

/**
 * @description: 抽奖奖品的信息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawAwardInfo {
    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;



    public DrawAwardInfo(String awardId, String awardName) {
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
