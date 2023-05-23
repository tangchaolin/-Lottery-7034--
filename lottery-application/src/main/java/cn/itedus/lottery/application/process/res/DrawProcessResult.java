package cn.itedus.lottery.application.process.res;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;

import javax.naming.spi.DirStateFactory;

/**
 * @description: 活动抽奖结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/22 0022
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawProcessResult extends Result {

    private DrawAwardInfo drawAwardInfo;

    public DrawProcessResult(String code,String info){
        super(code,info);
    }

    public DrawProcessResult(String code,String info,DrawAwardInfo drawAwardInfo) {
        super(code,info);
        this.drawAwardInfo=drawAwardInfo;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
