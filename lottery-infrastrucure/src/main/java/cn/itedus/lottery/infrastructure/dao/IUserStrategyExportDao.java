package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.itedus.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户策略计算结果表
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/21 0021
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    @DBRouter(key = "uId")
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}
