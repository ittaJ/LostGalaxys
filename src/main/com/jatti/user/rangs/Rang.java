package com.jatti.user.rangs;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

public class Rang {

    private String name;
    private int level;
    private List<User> usersWith = new ArrayList<User>();

    public Rang(String name){
        this.name = name;
    }

    public static Rang get(String name){

        for(Rang r : RangUtils.getRangs()){

            if(r.name.equals(name)){

                return r;
            }
        }
        return new Rang(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<User> getUsersWith() {
        if(usersWith == null) usersWith = new ArrayList<User>();
        return usersWith;
    }

    public void setUsersWith(List<User> usersWith) {
        this.usersWith = usersWith;
    }
}
