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
    public enum StrategyMode {
        SINGLE(1, "单项概率"),

        ENTIRETY(2,"总体概率");

        StrategyMode(Integer code, String info) {
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
        /**
         * 未中奖
         */
        FAIL(0,"未中奖"),
        /**
         * 中奖
         */
        SUCCESS(1, "中奖"),
        /**
         * 兜底奖
         */
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

    public enum AwardState {
        /**
         * 等待发奖
         */
        WAIT(0, "等待发奖"),
        /**
         * 发奖成功
         */
        SUCESS(1, "发奖成功"),
        /**
         * 发奖失败
         */
        FAILURE(2,"发奖失败");


        private Integer code;

        private String info;

        AwardState(Integer code, String info) {
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


    public enum AwardType {

        /**
         * 文字描述
         */
        DESC(0, "文字描述"),
        /**
         * 兑换码
         */
        RedeemCodeGoods(1, "兑换码"),

        /**
         * 优惠券
         */
        CouponGoods(2, "优惠券"),

        /**
         * 实物奖品
         */
        PhysicalGoods(3, "实物奖品");


        private Integer code;

        private String info;

        AwardType(Integer code, String info) {
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

    /**
     * 活动状态，1编辑 2.提审 3.撤审 4.通过 5.运行（审核通过后worker扫描状态） 6.拒绝 7.关闭 8.开启
     */
    public  enum ActivityState{
        /**
         * 编辑状态
         */
            EDIT(1, "编辑"),
        /**
         * 提审状态
         */
            ARRAIGNMENT(2, "提审"),
        /**
         * 撤审状态
         */
            REVOKE(3, "撤审"),
        /**
         * 通过状态
         */
            PASS(4, "通过"),
        /**
         * 活动中状态
         */
            DOING(5, "运行(活动中)"),
        /**
         * 拒绝状态
         */
            REFUSE(6, "拒绝"),
        /**
         * 关闭状态
         */
            CLOSE(7, "关闭"),
        /**
         * 开启状态
         */
            OPEN(8, "开启");

            private Integer code;

            private String info;

            ActivityState(Integer code, String info) {
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
    public enum Ids{

        /** 雪花算法 */
        SnowFlake,
        ShortCode,
        RandomNumeric;

    }






}


