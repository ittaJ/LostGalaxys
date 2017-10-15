package com.jatti.user.rangs;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private String name;
    private String prefix;
    private int level;
    private List<User> usersWith = new ArrayList<User>();

    public Rank(String name) {
        this.name = name;
    }

    public static Rank get(String name) {

        for (Rank r : RankUtils.getRangs()) {

            if (r.name.equals(name)) {

                return r;
            }
        }
        return new Rank(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<User> getUsersWith() {
        if (usersWith == null) usersWith = new ArrayList<User>();
        return usersWith;
    }

    public void setUsersWith(List<User> usersWith) {
        this.usersWith = usersWith;
    }

    public void addUser(User user){
        if(!usersWith.contains(user)) usersWith.add(user);
        user.setRank(this);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
