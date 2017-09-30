package com.jatti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static EntityType getRandType(){

        List<EntityType> types = new ArrayList<EntityType>();

        types.add(EntityType.DESERT_ZOMBIE);
        types.add(EntityType.SLIME);
        types.add(EntityType.SUCKER);
        types.add(EntityType.WISP);
        types.add(EntityType.ZOMBIE);

        int rand = new Random().nextInt(types.size());

        return types.get(rand);

    }
}
