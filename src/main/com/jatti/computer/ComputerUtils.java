package com.jatti.computer;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for computers
 * @author Jatti
 * @version 1.0
 */
public class ComputerUtils {

    private static List<Computer> computers = new ArrayList<Computer>();

    /**
     * Gets list of all computers
     * @return List<Computer>
     */
    public static List<Computer> getComputers() {

        if (computers == null) computers = new ArrayList<Computer>();

        return computers;

    }

    /**
     * Adds computer to list
     * @param computer computer to add
     */
    public static void addComputer(Computer computer) {

        if (!computers.contains(computer)) computers.add(computer);

    }

    /**
     * Removes computer from list
     * @param computer computer to remove
     */
    public static void removeComputer(Computer computer) {

        if (computers.contains(computer)) computers.remove(computer);

    }

}
