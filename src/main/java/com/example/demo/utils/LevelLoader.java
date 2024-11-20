package com.example.demo.utils;

import com.example.demo.core.LevelParent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;

public class LevelLoader {
    /*private final Stage stage;
    public LevelLoader(Stage stage) {
        this.stage=stage;
    }*/
    public static LevelParent loadLevel(String className,double height, double width) throws ReflectiveOperationException {
        Class<?> levelClass= Class.forName(className);
        Constructor<?> constructor = levelClass.getConstructor(double.class, double.class);
        return (LevelParent) constructor.newInstance(height,width);
    }
}

