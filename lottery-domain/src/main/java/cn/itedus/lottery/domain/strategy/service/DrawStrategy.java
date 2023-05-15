package cn.itedus.lottery.domain.strategy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawStrategy {

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
