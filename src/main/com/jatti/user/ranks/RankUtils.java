package com.jatti.user.ranks;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for Rank
 *
 * @author Jatti
 * @version 1.0
 */
public class RankUtils {

    private static final List<Rank> ranks = new ArrayList<Rank>();

    /**
     * Gets list of ranks
     *
     * @return List<Rank>
     */
    public static List<Rank> getRanks() {
        return ranks;
    }

    /**
     * Adds rank to list
     *
     * @param rank which will be added
     */
    public static void addRank(Rank rank) {
        if (!ranks.contains(rank)) {
            ranks.add(rank);
        }
    }

    /**
     * Removes rank from list
     *
     * @param rank which will be removed
     */
    public static void removeRank(Rank rank) {
        if (ranks.contains(rank)) {
            ranks.remove(rank);
        }
    }
}
