package com.jatti.computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerUtils {

    private static List<Computer> computers = new ArrayList<Computer>();

    public static List<Computer> getComputers() {

        if (computers == null) computers = new ArrayList<Computer>();

        return computers;

    }

    public static void addComputer(Computer computer) {

        if (!computers.contains(computer)) computers.add(computer);

    }

    public static void removeComputer(Computer computer) {

        if (computers.contains(computer)) computers.remove(computer);

    }

}
