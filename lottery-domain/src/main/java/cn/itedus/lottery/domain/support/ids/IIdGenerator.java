package cn.itedus.lottery.domain.support.ids;

/**
 * @description: 生成ID接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/19 0019
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IIdGenerator {
    /**
     * 获取Id，目前有两种实现方式
     * 1.雪花算法，用于生成单号
     * 2.日期算法，用于生成活动编号类，特性是生成数字串较短，但指定时间不能生成太多
     * 3.随机算法，用于生成策略ID
     * @return ID
     */

    long nextId();



}
