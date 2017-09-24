package com.jatti.entity;

import java.util.ArrayList;
import java.util.List;

public class EntitiesUtils {

    private static List<Entity> entities = new ArrayList<Entity>();

    public static List<Entity> getEntities(){
        if(entities == null) entities = new ArrayList<Entity>();
        return entities;
    }

    public static void addEntity(Entity entity){
        if(!entities.contains(entity)) entities.add(entity);
    }

    public static void removeEntity(Entity entity){
        if(entities.contains(entity)) entities.remove(entity);
    }

}
