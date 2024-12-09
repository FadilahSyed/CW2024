package com.example.demo.utils;

import javafx.scene.image.Image;
import java.util.Objects;

/**
 * The {@code ImageLoader} class is responsible for loading images from the resources directory
 */
public class ImageLoader {
    private static final String IMAGE_PATH_PREFIX= CommonConstants.IMAGE_PATH_PREFIX;

    /**
     * loads an image by its file name.
     *
     * @param imageName the name of the image file to load.
     * @return          the loaded {@code Image} object.
     * @throws RuntimeException if the image file is not found.
     */
    public static Image load(String imageName) {
        try {
            return new Image(Objects.requireNonNull(ImageLoader.class.getResource(IMAGE_PATH_PREFIX + imageName)).toExternalForm());
        } catch (NullPointerException e) {
            throw new RuntimeException("Image not found " + imageName,e);
        }
    }
}
