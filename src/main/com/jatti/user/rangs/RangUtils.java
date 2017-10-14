package com.jatti.user.rangs;

import java.util.ArrayList;
import java.util.List;

public class RangUtils {

    private static List<Rang> rangs = new ArrayList<Rang>();

    public static List<Rang> getRangs(){
        if(rangs == null) rangs = new ArrayList<Rang>();
        return rangs;
    }

    public static void addRang(Rang rang){
        if(!rangs.contains(rang)) rangs.add(rang);
    }

    public static void removeRang(Rang rang){
        if(rangs.contains(rang)) rangs.remove(rang);
    }
}
