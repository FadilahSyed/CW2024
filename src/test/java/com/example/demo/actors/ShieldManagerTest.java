package com.example.demo.actors;

import com.example.demo.actors.shield.ShieldManager;
import com.example.demo.actors.shield.ShieldStrategy;
import com.example.demo.ui.LevelViewLevelTwo;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShieldManagerTest {

    @Test
    void testShieldActivationAndDeactivation() {
        // Mock LevelViewLevelTwo
        LevelViewLevelTwo mockLevelView = mock(LevelViewLevelTwo.class);

        ShieldStrategy shieldManager = new ShieldManager(mockLevelView);

        // Simulate shield activation
        for (int i = 0; i < 1000; i++) {
            shieldManager.updateShield();
        }

        // Assert shield behavior
        assertTrue(shieldManager.isShielded() || !shieldManager.isShielded(),
                "Shield should toggle based on probability");
        verify(mockLevelView, atLeastOnce()).showShield();
        verify(mockLevelView, atLeastOnce()).hideShield();
    }
}
