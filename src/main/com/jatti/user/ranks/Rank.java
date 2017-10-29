package com.jatti.user.ranks;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Rank which User can get when it gets some level
 * 
 * @author Jatti
 * @version 1.1
 */
public class Rank {

    private String name;
    private String prefix;
    private int level;
    private List<User> usersWith = new ArrayList<User>();

    /**
     * Creates rank with specified name
     * 
     * @param name
     *            rank's name
     *
     */
    public Rank(String name) {
        this.name = name;
    }

    /**
     * Gets rank from all ranks list or makes new when it doesn't exists
     * 
     * @param name
     *            rank's name
     * @return Rank
     */
    public static Rank get(String name) {
        for (Rank r : RankUtils.getRanks()) {
            if (r.name.equals(name)) {
                return r;
            }
        }

        return new Rank(name);
    }

    /**
     * Gets rank's name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets rank's name
     * 
     * @param name
     *            rank's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets level when player can get this rank
     * 
     * @return int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level when player can get this rank
     * 
     * @param level
     *            min. level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets list of users with this rank
     * 
     * @return List<User>
     */
    public List<User> getUsersWith() {
        if (usersWith == null) {
            usersWith = new ArrayList<User>();
        }

        return usersWith;
    }

    /**
     * Sets list of users with this rank
     * 
     * @param usersWith
     *            users with this rank
     */
    public void setUsersWith(List<User> usersWith) {
        this.usersWith = usersWith;
    }

    /**
     * Adds user to this rank
     * 
     * @param user
     *            which will be added
     */
    public void addUser(User user) {
        if (!usersWith.contains(user)) {
            usersWith.add(user);
        }

        user.setRank(this);
    }

    /**
     * Removes user from this rank
     * 
     * @param user
     *            which will be removed
     */
    public void removeUser(User user) {
        if (usersWith.contains(user)) {
            usersWith.remove(user);
        }

        user.setRank(null);
    }

    /**
     * Gets rank's prefix
     * 
     * @return String
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets rank's prefix
     * 
     * @param prefix
     *            prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
