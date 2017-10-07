package com.jatti.camera;

import com.jatti.user.User;

import java.util.ArrayList;
import java.util.List;

public class CameraUtils {

    private static List<Camera> cameras = new ArrayList<Camera>();

    public static List<Camera> getAllCameras() {

        if (cameras == null) cameras = new ArrayList<Camera>();

        return cameras;
    }

    public static List<Camera> getCamerasForUser(User user) {

        List<Camera> cam = new ArrayList<Camera>();

        for (Camera c : cameras) {

            if (c.getOwner().equals(user)) cam.add(c);

        }

        return cam;

    }

    public static void addCamera(Camera camera) {

        if (!cameras.contains(camera)) cameras.add(camera);

    }

    public static void removeCamera(Camera camera) {

        if (cameras.contains(camera)) cameras.remove(camera);

    }

}
