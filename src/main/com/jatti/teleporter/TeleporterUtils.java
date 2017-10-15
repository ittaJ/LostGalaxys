package com.jatti.teleporter;


import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

public class TeleporterUtils {

    private static List<Teleporter> teleporterList = new ArrayList<Teleporter>();

    public static List<Teleporter> getTeleporters() {
        if (teleporterList == null) teleporterList = new ArrayList<Teleporter>();
        return teleporterList;
    }

    public static void addTeleporter(Teleporter teleporter) {
        if (!teleporterList.contains(teleporter)) teleporterList.add(teleporter);
    }

    public static void removeTeleporter(Teleporter teleporter) {
        if (teleporterList.contains(teleporter)) teleporterList.remove(teleporter);
    }

    public static List<Teleporter> getTeleportersForUser(User user) {

        List<Teleporter> teleporters = new ArrayList<Teleporter>();

        for (Teleporter t : getTeleporters()) {

            if (t.getOwner() == user) teleporters.add(t);

        }

        return teleporters;

    }

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
