package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;
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

}
