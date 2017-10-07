package com.jatti.user;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    private static List<User> users = new ArrayList<User>();

    public static List<User> getUsers() {

        if (users == null) users = new ArrayList<User>();

        return users;

    }

    public static void addUser(User u) {

        if (!users.contains(u)) users.add(u);

    }

    public static void removeUser(User u) {

        if (users.contains(u)) users.remove(u);

    }

}
