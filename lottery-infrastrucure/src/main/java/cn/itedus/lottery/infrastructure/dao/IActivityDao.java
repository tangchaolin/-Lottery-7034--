package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;
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



}
