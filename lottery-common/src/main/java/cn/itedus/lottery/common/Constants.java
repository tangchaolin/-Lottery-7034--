package cn.itedus.lottery.common;

public class Constants{
    /**
     * 枚举信息的定义
     */

    public enum ResponseCode {
        /**
         * 相应成功
         */
        SUCCESS("0000", "成功"),
        UN_ERROR("0001","未知失败"),
        ILLEGAL_PARAMETER("0002","非法参数"),
        INDEX_DUP("0003","主键冲突"),
        NO_UPDATE("0004","SQL操作无更新"),

        LOSING_DRAW("D001", "未中奖"),

        RULE_ERR("D002", "量化人群规则执行失败"),

        NOT_CONSUMED_TAKE("D003","未消费活动领取记录"),

        OUT_OF_STOCK("D004","活动无库存"),

        ERR_TOKEN("D005", "分布式锁失败");



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
        /**
         * 策略mode
         */
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

        /** 各种id生成策略 */
        SnowFlake,
        ShortCode,
        RandomNumeric;

    }
    public enum TaskState{
        /**
         * 活动单状态，使用以及未使用。
         */
        NO_USED(0, "未使用"),
        USED(1, "已使用");

        private Integer code;
        private String info;


        TaskState() {
        }

        TaskState( Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        /**
         * 获取
         * @return code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * 设置
         * @param code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * 获取
         * @return info
         */
        public String getInfo() {
            return info;
        }

        /**
         * 设置
         * @param info
         */
        public void setInfo(String info) {
            this.info = info;
        }

        public String toString() {
            return "TaskState{NO_USED = " + NO_USED + ", USED = " + USED + ", code = " + code + ", info = " + info + "}";
        }


    }

    public enum GrantState {
        /**
         * 发奖状态 0.初始 1.完成 2.失败
         */
        INIT(0,"初始"),
        COMPLETE(1,"完成"),
        FAIL(2, "失败");

        private Integer code;
        private String info;

        GrantState() {
        }

        GrantState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        /**
         * 获取
         * @return code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * 设置
         * @param code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * 获取
         * @return info
         */
        public String getInfo() {
            return info;
        }

        /**
         * 设置
         * @param info
         */
        public void setInfo(String info) {
            this.info = info;
        }

        public String toString() {
            return "GrantState{code = " + code + ", info = " + info + "}";
        }
    }

    /**
     * 全局属性
     */
    public  static final class Global{
        /* 空节点值 */
        public static final Long TREE_NULL_NODE=0L;
    }
    /**
     * 决策树节点
     */
    public static final class NodeType{
        /** 树茎 */
        public static final Integer STEM=1;
        /** 果实 */
        public static final Integer FRUIT=2;

    }

    /**
     * 规则限定类型
     */
    public static final class RuleLimitType{
        /** 等于 */
        public static final int EQUAL=1;

        /** 大于 */
        public static final int GT=2;
        /** 小于 */
        public static final int LT=3;
        /** 大于等于 */
        public static final int GE=4;
        /** 小于等于 */
        public static final int LE=5;
        /** 枚举 */
        public static final int ENUM=6;

    }

    /**
     * 消息发送状态 0 未发送 1.发送成功 2.发送失败
     */
    public  enum MQState{
        INIT(0, "初始"),
        COMPLETE(1, "完成"),
        FAIL(2, "失败");
        private Integer code;

        private String info;


        MQState() {
        }

        MQState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        /**
         * 获取
         * @return code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * 设置
         * @param code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * 获取
         * @return info
         */
        public String getInfo() {
            return info;
        }

        /**
         * 设置
         * @param info
         */
        public void setInfo(String info) {
            this.info = info;
        }

        public String toString() {
            return "MQState{code = " + code + ", info = " + info + "}";
        }
    }


    public static final class RedisKey {
        //抽奖活动库存 Key
        private static final String LOTTERY_ACTIVITY_STOCK_COUNT = "lottery_activity_stock_count_";

        public static String KEY_LOTTERY_ACTIVITY_STOCK_COUNT(Long activityId) {
            return LOTTERY_ACTIVITY_STOCK_COUNT+activityId;
        }

        private static final String LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN = "lottery_activity_stock_count_token_";

        public static String KEY_LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN(Long activityId, Integer stockUsedCount) {
            return LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN+activityId+'_'+stockUsedCount;
        }


    }




}


