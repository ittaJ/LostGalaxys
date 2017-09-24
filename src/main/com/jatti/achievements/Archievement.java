package com.jatti.achievements;

import com.jatti.achievements.prize.Prize;

import java.util.ArrayList;
import java.util.List;

public class Archievement {

    private String name;
    private List<Prize> prizes;

    public Archievement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Prize> getPrizes() {
        if(prizes == null) prizes = new ArrayList<Prize>();
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }


}
