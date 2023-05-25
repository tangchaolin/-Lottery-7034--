package cn.itedus.lottery.domain.activity.service.deploy;

import cn.itedus.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;

import java.util.List;

/**
 * @description: 部署活动配置接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IActivityDeploy {
    /**
     * 创建活动
     * @param req
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     * @param req 活动配置信息
     */

    void updateActivity(ActivityConfigReq req);

    /**
     * 扫描待处理的活动列表，状态为 ：通过、活动中。
     * 通过->时间符合时 ->活动中
     * 活动中->时间到期时->关闭
     * @param id ID
     * @return 待处理的活动集合
     */
    List<ActivityVO> scanToDoActivityList(Long id);
}
