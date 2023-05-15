package cn.itedus.lottery.interfaces.test;

//import cn.itedus.lottery.domain.strategy.service.DrawStrategy;
import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import cn.itedus.lottery.infrastructure.po.Activity;
import cn.itedus.lottery.interfaces.ActivityBooth;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);



    @Resource
    private IActivityDao iActivityDao;

    @Test
    public void insert() {
        Activity activity = new Activity();
        activity.setActivityId(100001L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(10);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("xiaolinge");

        iActivityDao.insert(activity);

    }

    @Test
    public void queryActivityById() {
        Activity activity= iActivityDao.queryActivityById(100001L);
        logger.info(JSON.toJSONString(activity));


    }
    @Test
    public void test_idx() {

        Map<Integer, Integer> map = new HashMap<>();

        int HASH_INCREMENT = 0x61c88647;
        int hashCode = 0;
        for (int i = 1; i <= 100; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int idx = hashCode & (128 - 1);

            map.merge(idx, 1, Integer::sum);

            System.out.println("斐波那契散列：" + idx + " 普通散列：" + (String.valueOf(i).hashCode() & (128 - 1)));
        }

        System.out.println(map);
    }


    @Test
    public void test_strategy() {
        DrawStrategy drawStrategy=new DrawStrategy();

        SecureRandom random = new SecureRandom();

        int rate =random.nextInt(100);

        List<HashMap<String,String>> strategyList = new ArrayList<>();

        strategyList.add(new HashMap<String,String>() {
            {
                put("awardDesc", "一等奖：彩电");
                put("awardId", "10001");
                put("awardCount", "3");
                put("awardRate","20");

            }
        });

        strategyList.add(new HashMap<String,String>() {
            {
                put("awardDesc", "二等奖：冰箱");
                put("awardId", "10002");
                put("awardCount", "3");
                put("awardRate","30");

            }
        });

        strategyList.add(new HashMap<String,String>() {
            {
                put("awardDesc", "三等奖：小米手机");
                put("awardId", "10003");
                put("awardCount", "3");
                put("awardRate","50");

            }
        });

        drawStrategy.init_rateTuple(strategyList);
        logger.info("概率为{}",rate);
        logger.info("您抽中了{}",drawStrategy.randomDraw(rate));


    }


}


class DrawStrategy {

    private final int HASH_INCREMENT =0x61c88647;

    private String[] rateTuple = new String[128];


    public void init_rateTuple(List<HashMap<String, String>> drawConfig) {
        int cursorVal =0;

        for (Map<String, String> map : drawConfig) {
            int rateVal = Integer.parseInt(map.get("awardRate"));

            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {

                int hashCode = HASH_INCREMENT*i+HASH_INCREMENT;
                int idx = hashCode & (rateTuple.length - 1);

                rateTuple[idx] = map.get("awardDesc");

            }
            cursorVal+=rateVal;
        }
    }

    public String randomDraw(int rate) {
        int hashCode =HASH_INCREMENT*rate+HASH_INCREMENT;

        int idx = hashCode & (rateTuple.length - 1);

        return rateTuple[idx];
    }

    public String[] getRateTuple() {
        return rateTuple;
    }

}