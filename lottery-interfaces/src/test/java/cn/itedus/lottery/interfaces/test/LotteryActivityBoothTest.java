package cn.itedus.lottery.interfaces.test;

import cn.itedus.lottery.interfaces.facade.LotteryActivityBooth;
import cn.itedus.lottery.rpc.ILotteryActivityBooth;
import cn.itedus.lottery.rpc.req.DrawReq;
import cn.itedus.lottery.rpc.req.QuantificationDrawReq;
import cn.itedus.lottery.rpc.res.DrawRes;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description: 测试接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryActivityBoothTest {

    @Resource
    private ILotteryActivityBooth lotteryActivityBooth;


    private Logger logger = LoggerFactory.getLogger(LotteryActivityBoothTest.class);

    @Test
    public void test_doDraw(){
        DrawReq drawReq = new DrawReq();

        drawReq.setUId("tangchaolin");
        drawReq.setActivityId(100001L);
        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        logger.info("请求参数：{}", JSON.toJSONString(drawReq));
        logger.info("请求结果：{}",JSON.toJSONString(drawRes));

    }

    @Test
    public void test_doQuantificaionDraw(){

        QuantificationDrawReq req=new QuantificationDrawReq();
        req.setUId("tangchaolin");
        req.setTreeId(2110081902L);
        req.setValMap(new HashMap<String,Object>(){{
            put("gender", "man");
            put("age", 18);

        }});
        DrawRes drawRes=lotteryActivityBooth.doQuantificationDraw(req);
        logger.info("请求参数：{}", JSON.toJSONString(req));
        logger.info("请求结果：{}",JSON.toJSONString(drawRes));

    }



}
