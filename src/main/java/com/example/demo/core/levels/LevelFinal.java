package com.example.demo.core.levels;

import com.example.demo.actors.planes.Boss;
import com.example.demo.core.LevelConfig;
import com.example.demo.core.LevelConfigFactory;
import com.example.demo.core.AbstractLevel;
import com.example.demo.ui.LevelView;
import com.example.demo.ui.LevelViewLevelTwo;

/**
 * the final level of the game
 * introduces final boss fight with shields
 * + spawns user plane, checks game over conditions
 */
public class LevelFinal extends AbstractLevel {
	private final Boss boss;
	private LevelViewLevelTwo levelView;
	private LevelConfig config;

	/**
	 * constructs the {@code LevelFinal} instance with the specified screen dimensions
	 * intialises the level configuration and creates a boss entity
	 * @param screenHeight  height of the game screen.
	 * @param screenWidth   width of the game screen.
	 */
	public LevelFinal(double screenHeight, double screenWidth) {
		super(LevelConfigFactory.getConfig("LevelFinal"),screenHeight,screenWidth);
		this.config = LevelConfigFactory.getConfig("LevelFinal");
		boss = new Boss(levelView);
	}

	/**
	 * initialises players plane + add to game root
	 */
	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
	}

	/**
	 * checks if game is over by evaluating 2 conditions:
	 * 1) user plane is destroyed --> game is lost
	 * 2) boss is destroyed --> game is won
	 */
	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();
		}
		else if (boss.isDestroyed()) {
			winGame();
		}
	}

	/**
	 * spawns enemy units for the level
	 * only enemy unit need is 1 boss -- added if theres no existing enemies (at the start)
	 */
	@Override
	protected void spawnEnemyUnits() {
		if (getCurrentNumberOfEnemies() == 0) {
			addEnemyUnit(boss);
		}
	}
	/**
	 * instantiates and initializes the level view for the final level.
	 * the {@code LevelViewLevelTwo} view is used to display game-related elements, like shields + health display
	 *
	 * @param config the configuration for the current level
	 * @return An instance of {@code LevelViewLevelTwo}
	 */
	@Override
	protected LevelView instantiateLevelView(LevelConfig config) {
		levelView = new LevelViewLevelTwo(getRoot(), config.getPlayerInitialHealth());
		return levelView;
	}

}
