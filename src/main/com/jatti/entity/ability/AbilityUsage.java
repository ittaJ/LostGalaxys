package com.jatti.entity.ability;

import com.jatti.entity.Entity;

/**
 * Usage of abilities for entities
 *
 * @author Jatti
 * @version 1.0
 */
public class AbilityUsage {

    private Entity entity;

    /**
     * Creates new AbilityUsage
     *
     * @param entity entity which will use ability
     */
    public AbilityUsage(Entity entity) {
        this.entity = entity;
    }

    /**
     * Gets entity which will use Ability
     *
     * @return Entity
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * Uses ability
     *
     * @param type type of ability which will be used
     */
    public void useAbility(AbilityType type) {
        //TODO

    }
}
