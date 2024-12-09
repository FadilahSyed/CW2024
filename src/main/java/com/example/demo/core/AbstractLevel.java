package com.example.demo.core;
import java.util.*;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.ActorManager;
import com.example.demo.actors.planes.PlaneFactory;
import com.example.demo.actors.planes.FighterPlane;
import com.example.demo.controller.Controller;
import com.example.demo.ui.LevelView;
import com.example.demo.actors.planes.UserPlane;

import com.example.demo.utils.BackgroundHandler;
import com.example.demo.utils.CollisionHandler;
import com.example.demo.utils.EnemySpawner;
import com.example.demo.utils.ImageLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;

/**
 * the {@code AbstractLevel} class serves as a base class for all game levels in this app
 * it defines common behaviour/attributes shared in all levels
 * uses CollisionHandler, GameLoop, ActorManagement, BackgroundHandler
 *
 *     Subclasses implement abstract methods to define their own behaviour
 *     -- initializing friendly units, spawning enemies,
 *     determines gameover conditions, instantiating level views
*/

 public abstract class AbstractLevel {
	private final GameLoop gameLoop;
	private boolean levelCompleted = false;

	private static final double SCREEN_HEIGHT_ADJUSTMENT = 150;
	private static final int MILLISECOND_DELAY = 50;
	private final double screenHeight;
	private final double screenWidth;
	private final double enemyMaximumYPosition;

	private final Group root;
	private final UserPlane user;
	private final Scene scene;
	private final ImageView background;

	private final List<ActiveActorDestructible> friendlyUnits;
	private final List<ActiveActorDestructible> enemyUnits;
	private final List<ActiveActorDestructible> userProjectiles;
	private final List<ActiveActorDestructible> enemyProjectiles;

	private final ActorManager actorManager;
	private final BackgroundHandler backgroundHandler;
	private final CollisionHandler collisionHandler;
	private int currentNumberOfEnemies;
	private LevelEventListener eventListener;
	private LevelView levelView;

	/**
	 * Constructs an {@code AbstractLevel} with the given configuration and screen dimensions
	 * @param config 		The configuration for the levelConfig
	 * @param screenHeight  The height of the game screen
	 * @param screenWidth   The width of the game screen
	 */
	public AbstractLevel(LevelConfig config, double screenHeight, double screenWidth) {
		this.root = new Group();
		this.scene = new Scene(root, screenWidth, screenHeight);

		this.user = (UserPlane) PlaneFactory.createPlane("user",screenWidth,screenHeight,(config.getPlayerInitialHealth()));
		this.friendlyUnits = new ArrayList<>();
		this.enemyUnits = new ArrayList<>();
		this.userProjectiles = new ArrayList<>();
		this.enemyProjectiles = new ArrayList<>();

		this.background = new ImageView(ImageLoader.load(config.getBackgroundImage()));
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.enemyMaximumYPosition = screenHeight - SCREEN_HEIGHT_ADJUSTMENT;

		this.actorManager=new ActorManager(root);
		this.backgroundHandler=new BackgroundHandler(background,user,this);
		this.collisionHandler=new CollisionHandler();
		this.gameLoop=new GameLoop(MILLISECOND_DELAY,this::updateScene);
		this.levelView = instantiateLevelView(config);
		this.currentNumberOfEnemies = 0;

		friendlyUnits.add(user);
	}

	/**
	 * initialises friendly units in the level.
	 * Must be implemented in subclasses to define the
	 * placement + behaviour of friendly actors at the start of the level
	 */
	protected abstract void initializeFriendlyUnits();

	/**
	 * checks if the game is over.
	 * must be implemented in subclasses to determine
	 * level completion/level failure conditions
	 */
	protected abstract void checkIfGameOver();

	/**
	 * Spawns enemy units during the game.
	 * must be implemented in subclasses to define
	 * enemy behaviour
	 */
	protected abstract void spawnEnemyUnits();

	/**
	 * Instatiates the level view for displaying UI elements
	 * such as health and score
	 *
	 * @param config the level configuration
	 * @return A {@code LevelView} instance for the level
	 */
	protected abstract LevelView instantiateLevelView(LevelConfig config);

	/**
	 * initialises and returns the scene for this level,
	 * including the background and units
	 *
	 * @return The {@code Scene} object representing the level
	 */
	public Scene initializeScene() {
		backgroundHandler.initializeBackground(root,screenWidth,screenHeight);
		initializeFriendlyUnits();
		levelView.showHeartDisplay();
		return scene;
	}

	/**
	 * Sets the event listener for the level to handle events
	 * like GAME_OVER or WIN_GAME
	 *
	 * @param listener The {@code LevelEventListener} to set
	 */
	public void setEventListener(LevelEventListener listener) {
		this.eventListener=listener;
	}

	/**
	 * starts the game loop for the level
	 */
	public void startGame() {
		levelCompleted=false; //levelCompleted flag reset when level starts
		background.requestFocus();
		gameLoop.start();
	}

	/**
	 * Stops the current level and notifies the listener to
	 * proceed to the next level.
	 * @param levelName The name of the next level to load
	 */
	public void goToNextLevel(String levelName) {
		if (!levelCompleted && eventListener != null) {
			gameLoop.stop();
			eventListener.onLevelEvent(levelName);
			levelCompleted = true;}
	}

	/**
	 * Updates the game scene,
	 * -- includes actor movement, collisions, game state checks, etc
	 */
	private void updateScene() {
		spawnEnemyUnits();
		updateActors();
		generateEnemyFire();
		updateNumberOfEnemies();
		handleCollisionsAndDamage();
		removeAllDestroyedActors();
		updateKillCount();
		updateLevelView();
		checkIfGameOver();
	}

	/**
	 * fires a projectile from the userplane
	 */
	public void fireProjectile() {
		ActiveActorDestructible projectile = user.fireProjectile();
		root.getChildren().add(projectile);
		userProjectiles.add(projectile);
	}

	/**
	 * generates fire from enemy units
	 */
	private void generateEnemyFire() {
		enemyUnits.forEach(enemy -> spawnEnemyProjectile(((FighterPlane) enemy).fireProjectile()));
	}

	/**
	 * spawns a new enemy projectile + adds it to the game
	 * @param projectile the enemy projectile to be spawned
	 */
	private void spawnEnemyProjectile(ActiveActorDestructible projectile) {
		if (projectile != null) {
			root.getChildren().add(projectile);
			enemyProjectiles.add(projectile);
		}
	}

	/**
	 * spawn enemies based on level configurations
	 * @param config the level configurations
	 */
	protected void spawnEnemies(LevelConfig config) {
		EnemySpawner spawner=new EnemySpawner(config);
		List<ActiveActorDestructible> newEnemies=spawner.spawnEnemies(
				getCurrentNumberOfEnemies(),getScreenWidth(),getEnemyMaximumYPosition()
		);
		newEnemies.forEach(this::addEnemyUnit);
	}

	/**
	 * updates the state of all actors in the game
	 * -- friendly units, enemy units, projectiles
	 */
	private void updateActors() {
		actorManager.updateActors(friendlyUnits);
		actorManager.updateActors(enemyUnits);
		actorManager.updateActors(userProjectiles);
		actorManager.updateActors(enemyProjectiles);
	}

	/**
	 * removes all destroyed actors from group root
	 */
	private void removeAllDestroyedActors() {
		actorManager.removeDestroyedActors(friendlyUnits);
		actorManager.removeDestroyedActors(enemyUnits);
		actorManager.removeDestroyedActors(userProjectiles);
		actorManager.removeDestroyedActors(enemyProjectiles);
	}

	/**
	 * handles collisions, applies damage to affected actors
	 */
	private void handleCollisionsAndDamage() {
		handleEnemyPenetration();
		collisionHandler.handleCollisions(userProjectiles, enemyUnits);
		collisionHandler.handleCollisions(enemyProjectiles, friendlyUnits);
		collisionHandler.handleCollisions(friendlyUnits, enemyUnits);
	}

	/**
	 * applies damage to player's plane when enemy penetrated defenses
	 */
	private void handleEnemyPenetration() {
		for (ActiveActorDestructible enemy : enemyUnits) {
			if (collisionHandler.enemyHasPenetratedDefenses(enemy, screenWidth)) {
				user.takeDamage();
				enemy.destroy();
			}
		}
	}

	/**
	 * updates visual display of player's health
	 * -- hearts removed based on current health
	 */
	private void updateLevelView() {
		levelView.removeHearts(user.getHealth());
	}

	/**
	 * updates player's kill count based on destroyed enemy units
	 */
	private void updateKillCount() {
		for (int i = 0; i < currentNumberOfEnemies - enemyUnits.size(); i++) {
			user.incrementKillCount();
		}
	}

	/**
	 * handles when player wins game
	 * stops gameloop and calls for the wingame screen
	 */
	protected void winGame() {
		gameLoop.stop();
		if(eventListener!=null) {
			eventListener.onLevelEvent(Controller.GameEvent.WIN_GAME.name());
		}
	}

	/**
	 * handles when player loses game
	 * stops the gameloop and calls for the gameover screen
	 */
	protected void loseGame() {
		gameLoop.stop();
		if(eventListener!=null) {
			eventListener.onLevelEvent(Controller.GameEvent.GAME_OVER.name());
		}
	}

	/**
	 * Retrieves the user plane in this level
	 * @return the {2code UserPLane} instance
	 */
	protected UserPlane getUser() {
		return user;
	}

	/**
	 * retrieves the root group containing all the actors in this level
	 * @return The {@code Group} object
	 */
	protected Group getRoot() {
		return root;
	}

	/**
	 * retrieves the current number of enemies on the screen
	 * @return The number of active enemies
	 */
	protected int getCurrentNumberOfEnemies() {
		return enemyUnits.size();
	}

	/**
	 * Adds an enemy unit to the level
	 * @param enemy the enemy unit to add
	 */
	protected void addEnemyUnit(ActiveActorDestructible enemy) {
		enemyUnits.add(enemy);
		actorManager.addActor(enemy);
	}

	/**
	 * retrieves the maximum allowable Y position coordinate for enemy actors
	 * @return maximum y coordinate
	 */
	protected double getEnemyMaximumYPosition() {
		return enemyMaximumYPosition;
	}

	/**
	 * retrieves the screen width of the level
	 * @return the screen width
	 */
	protected double getScreenWidth() {
		return screenWidth;
	}

	/**
	 * checks if player's plane is destroyed
	 *
	 * @return {@code true} if the plane is destroyed; otherwise, {@code false}
	 */
	protected boolean userIsDestroyed() {
		return user.isDestroyed();
	}

	/**
	 * updates current number of active enemies in the game
	 */
	private void updateNumberOfEnemies() {
		currentNumberOfEnemies = enemyUnits.size();
	}


}
