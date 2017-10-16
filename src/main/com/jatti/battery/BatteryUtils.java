package com.jatti.battery;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils For Battery
 *
 * @author Jatti
 * @version 1.0
 */
public class BatteryUtils {

    private static List<Battery> batteries = new ArrayList<Battery>();

    /**
     * List of all batteries
     * @return List<Battery>
     */
    public static List<Battery> getBatteries() {
        if (batteries == null) batteries = new ArrayList<Battery>();
        return batteries;
    }

    /**
     * Adds battery to list
     * @param battery battery to add
     */
    public static void addBattery(Battery battery) {
        if (!batteries.contains(battery)) batteries.add(battery);
    }

    /**
     * Removes battery from list
     * @param battery battery to remove
     */
    public static void removeBattery(Battery battery) {
        if (batteries.contains(battery)) batteries.remove(battery);
    }

    /**
     * Gets batteries for gived user
     * @param owner owner of batteries
     * @return List<Battery>
     */
    public static List<Battery> getBatteriesForUser(User owner) {

        List<Battery> batt = new ArrayList<Battery>();

        for (Battery b : BatteryUtils.getBatteries()) {

            if (b.getOwner().equals(owner)) batt.add(b);

        }

        return batt;

    }

}
