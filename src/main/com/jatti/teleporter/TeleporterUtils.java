package com.jatti.teleporter;


import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for teleporter
 *
 * @author Jatti
 * @version 1.0
 */
public class TeleporterUtils {

    private static List<Teleporter> teleporterList = new ArrayList<Teleporter>();

    /**
     * List of all Teleporters
     * @return List<Teleporter>
     */
    public static List<Teleporter> getTeleporters() {
        if (teleporterList == null) teleporterList = new ArrayList<Teleporter>();
        return teleporterList;
    }

    /**
     * Adds teleporter to list
     * @param teleporter teleporter to add
     */
    public static void addTeleporter(Teleporter teleporter) {
        if (!teleporterList.contains(teleporter)) teleporterList.add(teleporter);
    }

    /**
     * Removes teleporter from list
     * @param teleporter teleporter to remove
     */
    public static void removeTeleporter(Teleporter teleporter) {
        if (teleporterList.contains(teleporter)) teleporterList.remove(teleporter);
    }

    /**
     * Gets all user's teleporters
     * @param user owner of those teleporters
     * @return List<Teleporter>
     */
    public static List<Teleporter> getTeleportersForUser(User user) {

        List<Teleporter> teleporters = new ArrayList<Teleporter>();

        for (Teleporter t : getTeleporters()) {

            if (t.getOwner().equals(user)) teleporters.add(t);

        }

        return teleporters;

    }
    /**
     * Gets all user's teleporters in specified channel
     * @param user owner of those teleporters
     * @param channel channel of those teleporters
     * @return List<Teleporter>
     */
    public static List<Teleporter> getTeleportersForUserInChannel(User user, int channel) {

        List<Teleporter> teleporters = new ArrayList<Teleporter>();

        for (Teleporter t : getTeleportersForUser(user)) {

            if (t.getChannel() == channel) {

                teleporters.add(t);

            }

        }

        return teleporters;

    }

}
