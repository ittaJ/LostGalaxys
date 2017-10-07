package com.jatti.achievements.prize;

import java.util.ArrayList;
import java.util.List;

public class PrizeUtils {

    private static List<Prize> prizes = new ArrayList<Prize>();


    public static List<Prize> getPrizes() {
        if (prizes == null) prizes = new ArrayList<Prize>();
        return prizes;
    }

    public static void addPrize(Prize prize) {
        if (!prizes.contains(prize)) prizes.add(prize);
    }

    public static void removePrize(Prize prize) {
        if (prizes.contains(prize)) prizes.remove(prize);
    }

}
