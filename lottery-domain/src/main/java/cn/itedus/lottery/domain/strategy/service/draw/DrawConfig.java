package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @description: 加载统一配置信息类
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin       
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class DrawConfig {

    @Resource(name = "entiretyRateRandomDrawAlgorithm")
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;

    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();



    /**
     * 初始化抽奖的配置类。注入了两种抽奖算法。
     */
    @PostConstruct
    void init() {
        drawAlgorithmGroup.put(Constants.StrategeMode.SINGLE.getCode(),singleRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(Constants.StrategeMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
    }


}
