package com.example.demo.actors;

import javafx.scene.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActorManagerTest {
    private ActorManager actorManager;
    private Group root;
    private List<ActiveActorDestructible> actors;

    @BeforeEach
    void setUp() {
        root = new Group();
        actorManager = new ActorManager(root);
        actors = new ArrayList<>();
    }

    @Test
    void testAddActor() {
        TestActor actor = new TestActor();
        actorManager.addActor(actor);

        assertTrue(root.getChildren().contains(actor));
    }

    @Test
    void testUpdateActors() {
        TestActor actor = new TestActor();
        actors.add(actor);

        actorManager.updateActors(actors);
        assertTrue(actor.updated); // Custom flag to verify update
    }

    @Test
    void testRemoveDestroyedActors() {
        TestActor actor = new TestActor();
        actor.destroy();
        actors.add(actor);

        actorManager.removeDestroyedActors(actors);
        assertFalse(actors.contains(actor));
        assertFalse(root.getChildren().contains(actor));
    }

    static class TestActor extends ActiveActorDestructible {
        boolean updated = false;

        public TestActor() {
            super("test.png", 10, 0, 0);
        }

        @Override
        public void updatePosition() {}

        @Override
        public void updateActor() {
            updated = true;
        }

        @Override
        public void takeDamage() {
            destroy();
        }
    }
}
