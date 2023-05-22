package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.itedus.lottery.infrastructure.po.UserTakeActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户活动参与次数表Dao
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface IUserTakeActivityCountDao {
    /**
     * 查询用户领取次数
     * @param userTakeActivityCountReq
     * @return 领取结果
     */
    @DBRouter
    UserTakeActivityCount queryUserActivityCount(UserTakeActivityCount userTakeActivityCountReq);

    /**
     * 插入领取次数信息
     * @param userTakeActivityCount
     */
    void insert(UserTakeActivityCount userTakeActivityCount);

    /**
     * 更新用户领取次数信息
     * @param userTakeActivityCount
     * @return
     */
    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);


}
