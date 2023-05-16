package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DrawConfig {

    @Resource(name = "defaultRateRandomDrawAlgorithm")
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    public static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();


    @PostConstruct
    void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);

    }


}
