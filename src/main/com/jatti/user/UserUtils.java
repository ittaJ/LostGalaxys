package com.jatti.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for User
 * @author Jatti
 * @version 1.0
 */
public class UserUtils {

    private static List<User> users = new ArrayList<User>();

    /**
     * Gives list of all users
     * @return List<User>
     *
     */
    public static List<User> getUsers() {

        if (users == null) users = new ArrayList<User>();

        return users;

    }

    /**
     * Adds specified User to users list if it doesn't contains that user
     * @param user user which will be added to list
     */
    public static void addUser(User user) {

        if (!users.contains(user)) users.add(user);

    }

    /**
     * Removes specified User from users list if it contains that user
     * @param user user which will be removed
     */

    public static void removeUser(User user) {

        if (users.contains(user)) users.remove(user);

    }

}
