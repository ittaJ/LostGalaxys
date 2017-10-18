package com.jatti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utils for entities
 * @author Jatti
 * @version 1.1
 */
public class EntitiesUtils {

    private static List<Entity> entities = new ArrayList<Entity>();

    /**
     * Gets list with all entities
     * @return List<Entity>
     */
    public static List<Entity> getEntities() {
        if (entities == null) entities = new ArrayList<Entity>();
        return entities;
    }

    /**
     * Adds entity to list with them
     * @param entity entity to add
     */
    public static void addEntity(Entity entity) {
        if (!entities.contains(entity)) entities.add(entity);
    }

    /**
     * Removes entity from list
     * @param entity entity to remove
     */
    public static void removeEntity(Entity entity) {
        if (entities.contains(entity)) entities.remove(entity);
    }

    /**
     * Gets random type for entity
     * @return EntityType
     */
    public static EntityType getRandType() {

        List<EntityType> types = new ArrayList<EntityType>();

        types.add(EntityType.DESERT_ZOMBIE);
        types.add(EntityType.SUCKER);
        types.add(EntityType.WISP);
        types.add(EntityType.ZOMBIE);

        int rand = new Random().nextInt(types.size());

        return types.get(rand);

    }
}
