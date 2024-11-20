package com.example.demo.utils;

import javafx.scene.image.Image;
import java.util.Objects;

public class ImageLoader {
    private static final String IMAGE_PATH_PREFIX="/com/example/demo/images/";
    /*public static Image load(String imageName) {
        return new Image(Objects.requireNonNull(ImageLoader.class.getResource(IMAGE_PATH_PREFIX + imageName)).toExternalForm());
    }*/
    public static Image load(String imageName) {
        try {
            return new Image(Objects.requireNonNull(ImageLoader.class.getResource(IMAGE_PATH_PREFIX + imageName)).toExternalForm());
        } catch (NullPointerException e) {
            throw new RuntimeException("Image not found " + imageName,e);
        }
    }
}
