package cn.itedus.lottery.domain.activity.model.res;

import cn.itedus.lottery.common.Result;

/**
 * @description: 库存处理结果
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/27 0027
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StockResult extends Result {
    private String stockKey;

    private Integer stockSurplusCount;


    public StockResult() {
    }

    public StockResult(String code, String info) {
        super(code,info);
    }

    public StockResult(String stockKey, Integer stockSurplusCount) {
        this.stockKey = stockKey;
        this.stockSurplusCount = stockSurplusCount;
    }

    public StockResult(String code, String info, String stockKey, Integer stockSurplusCount) {
        super(code, info);
        this.stockKey=stockKey;
        this.stockSurplusCount=stockSurplusCount;
    }

    /**
     * 获取
     * @return stockKey
     */
    public String getStockKey() {
        return stockKey;
    }

    /**
     * 设置
     * @param stockKey
     */
    public void setStockKey(String stockKey) {
        this.stockKey = stockKey;
    }

    /**
     * 获取
     * @return stockSurplusCount
     */
    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    /**
     * 设置
     * @param stockSurplusCount
     */
    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

    public String toString() {
        return "StockResult{stockKey = " + stockKey + ", stockSurplusCount = " + stockSurplusCount + "}";
    }
}
