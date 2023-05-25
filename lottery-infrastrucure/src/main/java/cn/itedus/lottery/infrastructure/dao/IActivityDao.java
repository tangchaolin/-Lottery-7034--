package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*
 * @description: 活动基础信息表
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Mapper
public interface IActivityDao {
    /**
     * 插入数据
     * @param req 入参
     */
    void insert(Activity req);

    /**
     * 通过活动id查询活动
     * @param activityId 活动id
     * @return
     */
    Activity queryActivityById(Long activityId);

    /**
     * 变更活动状态
     * @param alterStateVO 【activityId，beforeState，afterState】
     * @return 更新数量
     */
    int alterState(AlterStateVO alterStateVO);

    /**
     * 扣减活动库存
     * @param activityId 活动ID
     * @return 更新数量
     */
    int subtractionActivityStock(Long activityId);

    /**
     * 扫描待处理的活动列表，状态为：通过，活动中。
     * @param id ID
     * @return 待处理的活动
     */
    List<Activity> scanToDoActivityList(Long id);

}
