package com.example.demo.utils;

import com.example.demo.core.LevelParent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;

public class LevelLoader {
    public static LevelParent loadLevel(String className,double height, double width) throws ReflectiveOperationException {
        Class<?> levelClass= Class.forName(className);
        return (LevelParent) levelClass.getConstructor(double.class, double.class).newInstance(height,width);
      }
}



