package com.jatti.battery;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

public class BatteryUtils {

    private static List<Battery> batteries = new ArrayList<Battery>();

    public static List<Battery> getBatteries() {
        if (batteries == null) batteries = new ArrayList<Battery>();
        return batteries;
    }

    public static void addBattery(Battery battery) {
        if (!batteries.contains(battery)) batteries.add(battery);
    }

    public static void removeBattery(Battery battery) {
        if (batteries.contains(battery)) batteries.remove(battery);
    }

    public static List<Battery> getBatteriesForUser(User owner) {

        List<Battery> batt = new ArrayList<Battery>();

        for (Battery b : BatteryUtils.getBatteries()) {

            if (b.getOwner().equals(owner)) batt.add(b);

        }

        return batt;

    }

}
