package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVo;
import cn.itedus.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*
 * @description: 奖品的信息表DAO
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Mapper
public interface IAwardDao {
    /**
     * 查询奖品信息
     * @param awardId 奖品id
     * @return 返回奖品信息
     */
    Award queryAwardInfo(String awardId);

    /**
     * 插入奖品信息
     * @param list 奖品配置
     */
    void insertList(List<Award> list);

}
