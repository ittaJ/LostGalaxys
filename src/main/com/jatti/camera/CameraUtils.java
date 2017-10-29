package com.jatti.camera;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for Cameras
 * @author Jatti
 * @version 1.0
 */
public class CameraUtils {

    private static final List<Camera> cameras = new ArrayList<Camera>();

    /**
     * Gets all cameras
     * @return List<Camera>
     */
    public static List<Camera> getAllCameras() {
        return cameras;
    }

    /**
     * Gets all user's cameras
     * @param user cameras' owner
     * @return List<Camera>
     */
    public static List<Camera> getCamerasForUser(User user) {
        List<Camera> cam = new ArrayList<Camera>();

        for (Camera c : cameras) {
            if (c.getOwner().equals(user)) {
                cam.add(c);
            }
        }

        return cam;

    }

    /**
     * Adds camera to list
     * @param camera camera to add
     */
    public static void addCamera(Camera camera) {
        if (!cameras.contains(camera)) {
            cameras.add(camera);
        }
    }

    /**
     * Removes camera from list
     * @param camera camera to remove
     */
    public static void removeCamera(Camera camera) {
        if (cameras.contains(camera)) {
            cameras.remove(camera);
        }
    }
}