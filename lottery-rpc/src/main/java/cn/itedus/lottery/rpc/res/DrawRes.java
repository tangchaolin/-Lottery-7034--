package cn.itedus.lottery.rpc.res;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * @description: 抽奖结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawRes extends Result implements Serializable {

    private AwardDTO awardDTO;


    public DrawRes(String code,String info) {
        super(code,info);
    }

    public DrawRes(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

    /**
     * 获取
     * @return awardDTO
     */
    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    /**
     * 设置
     * @param awardDTO
     */
    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

    public String toString() {
        return "DrawRes{awardDTO = " + awardDTO + "}";
    }
}
