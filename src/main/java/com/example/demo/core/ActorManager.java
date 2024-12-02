package com.example.demo.core;

import com.example.demo.actors.ActiveActorDestructible;
import javafx.scene.Group;

import java.util.List;

public class ActorManager {
    private final Group root;
    public ActorManager(Group root) {
        this.root=root;
    }

    public void removeDestroyedActors(List<ActiveActorDestructible> actors) {
        actors.removeIf(actor-> {
            if(actor.isDestroyed()) {
                root.getChildren().remove(actor);
                return true;
            }
            return false;
        });
    }
}

