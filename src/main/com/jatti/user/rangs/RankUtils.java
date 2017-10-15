package com.jatti.user.rangs;

import java.util.ArrayList;
import java.util.List;

public class RankUtils {

    private static List<Rank> rangs = new ArrayList<Rank>();

    public static List<Rank> getRangs() {
        if (rangs == null) rangs = new ArrayList<Rank>();
        return rangs;
    }

    public static void addRang(Rank rang) {
        if (!rangs.contains(rang)) rangs.add(rang);
    }

    public static void removeRang(Rank rang) {
        if (rangs.contains(rang)) rangs.remove(rang);
    }
}
