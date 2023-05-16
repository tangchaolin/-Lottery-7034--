package cn.itedus.lottery.domain.strategy.model.vo;

//奖品概率区间值
public class AwardRateIntervalVal {

    private String awardId;
    //区间开始值
    private int begin;
    //区间结束值
    private int end;


    public AwardRateIntervalVal(String awardId, int begin, int end) {
        this.awardId = awardId;
        this.begin = begin;
        this.end = end;
    }

    public AwardRateIntervalVal() {

    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
