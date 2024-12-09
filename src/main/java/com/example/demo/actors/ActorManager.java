package com.example.demo.actors;

import javafx.scene.Group;

import java.util.List;

/**
 * manages the lifecycle of game actors
 * such as: adding, updating, and removing actors
 */
public class ActorManager {
    private final Group root;

    /**
     * constructs an {@code ActorManager} for a specific root group.
     * @param root the root group where game actors are displayed.
     */
    public ActorManager(Group root) {
        this.root=root;
    }

    /**
     * adds a new actor to the game scene.
     * @param actor The {@code ActiveActorDestructible} to be added.
     */
    public void addActor(ActiveActorDestructible actor) {
        root.getChildren().add(actor);
    }

    /**
     * updates all active actors in the provided list.
     * @param actors the list of active actors to update.
     */
    public void updateActors(List<ActiveActorDestructible> actors) {
        actors.forEach(ActiveActorDestructible::updateActor);
    }

    /**
     * removes actors marked as destroyed from both the game scene and the actor list
     *
     * @param actors The list of active actors to check and clean
     */
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

