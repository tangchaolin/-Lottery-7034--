package cn.itedus.lottery.common;

public class Constants{
/*
 * @description: 枚举信息的定义
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/16 0016
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */


    public enum ResponseCode {
        SUCCESS("0000", "成功"),
        UN_ERROR("0001","未知失败"),
        ILLEGAL_PARAMETER("0002","非法参数"),
        INDEX_DUP("0003","主键冲突");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }

    /**
     * 抽奖策略模式：单项概率和总体概率
     * 场景：两种抽奖算法，场景A20%，B30%，C50%。
     * 单项概率：概率一旦确定，如果某个奖品抽完了，任然有机会抽到，但是一旦抽到该随机数，就是显示未中奖。
     * 总体概率：如果某一个奖品抽完，那么剩下的奖品的概率按照0.2+0.3/0.5的策略重新计算概率值。
     */
    public enum StrategeMode {
        SINGLE(1, "单项概率"),

        ENTIRETY(2,"总体概率");

        StrategeMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        private Integer code;

        private String info;

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
    }

    /**
     * 执行draw 以后返回的DrawResult中将会使用到该枚举。
     */
    public enum DrawState {
        FAIL(0,"未中奖"),

        SUCCESS(1, "中奖"),

        Cover(2, "兜底奖");

        private Integer code;

        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }



}


