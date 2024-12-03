package com.example.demo.core;
import java.util.*;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.ActorManager;
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

public abstract class AbstractLevel {
	private final GameLoop gameLoop;
	private boolean levelCompleted = false; //flag is true when the level is completed

	private static final double SCREEN_HEIGHT_ADJUSTMENT = 150;
	private static final int MILLISECOND_DELAY = 50;
	private final double screenHeight;
	private final double screenWidth;
	private final double enemyMaximumYPosition;

	private final Group root;
	//private final Timeline timeline;
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

	public AbstractLevel(LevelConfig config, double screenHeight, double screenWidth) {
		this.root = new Group();
		this.scene = new Scene(root, screenWidth, screenHeight);
		//this.timeline = new Timeline();

		this.user = new UserPlane(config.getPlayerInitialHealth());
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

		//initializeTimeline();
		friendlyUnits.add(user);
	}

	protected abstract void initializeFriendlyUnits();

	protected abstract void checkIfGameOver();

	protected abstract void spawnEnemyUnits();

	protected abstract LevelView instantiateLevelView(LevelConfig config);

	public Scene initializeScene() {
		backgroundHandler.initializeBackground(root,screenWidth,screenHeight);
		initializeFriendlyUnits();
		levelView.showHeartDisplay();
		return scene;
	}

	public void setEventListener(LevelEventListener listener) {
		this.eventListener=listener;
	}

	public void startGame() {
		levelCompleted=false; //levelCompleted flag reset when level starts
		background.requestFocus();
		gameLoop.start();
	}

	public void goToNextLevel(String levelName) {
		if (!levelCompleted && eventListener != null) {
			gameLoop.stop();
			eventListener.onLevelEvent(levelName);
			levelCompleted = true;}
	}
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

	/*private void initializeTimeline() {
		timeline.setCycleCount(Timeline.INDEFINITE);
		KeyFrame gameLoop = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> updateScene());
		timeline.getKeyFrames().add(gameLoop);
	}*/



	public void fireProjectile() {
		ActiveActorDestructible projectile = user.fireProjectile();
		root.getChildren().add(projectile);
		userProjectiles.add(projectile);
	}

	private void generateEnemyFire() {
		enemyUnits.forEach(enemy -> spawnEnemyProjectile(((FighterPlane) enemy).fireProjectile()));
	}

	private void spawnEnemyProjectile(ActiveActorDestructible projectile) {
		if (projectile != null) {
			root.getChildren().add(projectile);
			enemyProjectiles.add(projectile);
		}
	}

	protected void spawnEnemies(LevelConfig config) {
		EnemySpawner spawner=new EnemySpawner(config);
		List<ActiveActorDestructible> newEnemies=spawner.spawnEnemies(
				getCurrentNumberOfEnemies(),getScreenWidth(),getEnemyMaximumYPosition()
		);
		newEnemies.forEach(this::addEnemyUnit);
	}

	/*private void updateActors() {
		friendlyUnits.forEach(ActiveActorDestructible::updateActor);
		enemyUnits.forEach(ActiveActorDestructible::updateActor);
		userProjectiles.forEach(ActiveActorDestructible::updateActor);
		enemyProjectiles.forEach(ActiveActorDestructible::updateActor);
	}*/

	private void updateActors() {
		actorManager.updateActors(friendlyUnits);
		actorManager.updateActors(enemyUnits);
		actorManager.updateActors(userProjectiles);
		actorManager.updateActors(enemyProjectiles);
	}

	private void removeAllDestroyedActors() {
		actorManager.removeDestroyedActors(friendlyUnits);
		actorManager.removeDestroyedActors(enemyUnits);
		actorManager.removeDestroyedActors(userProjectiles);
		actorManager.removeDestroyedActors(enemyProjectiles);
	}




	private void handleCollisionsAndDamage() {
		handleEnemyPenetration();
		collisionHandler.handleCollisions(userProjectiles, enemyUnits);
		collisionHandler.handleCollisions(enemyProjectiles, friendlyUnits);
		collisionHandler.handleCollisions(friendlyUnits, enemyUnits);
	}



	private void handleEnemyPenetration() {
		for (ActiveActorDestructible enemy : enemyUnits) {
			if (collisionHandler.enemyHasPenetratedDefenses(enemy, screenWidth)) {
				user.takeDamage();
				enemy.destroy();
			}
		}
	}

	private void updateLevelView() {
		levelView.removeHearts(user.getHealth());
	}

	private void updateKillCount() {
		for (int i = 0; i < currentNumberOfEnemies - enemyUnits.size(); i++) {
			user.incrementKillCount();
		}
	}



	protected void winGame() {
		gameLoop.stop();
		if(eventListener!=null) {
			eventListener.onLevelEvent(Controller.GameEvent.WIN_GAME.name());
		}
	}

	protected void loseGame() {
		gameLoop.stop();
		if(eventListener!=null) {
			eventListener.onLevelEvent(Controller.GameEvent.GAME_OVER.name());
		}
		//setChanged();
		//notifyObservers("gameover");
		//levelView.showGameOverImage();
	}

	protected UserPlane getUser() {
		return user;
	}

	protected Group getRoot() {
		return root;
	}

	protected int getCurrentNumberOfEnemies() {
		return enemyUnits.size();
	}

	protected void addEnemyUnit(ActiveActorDestructible enemy) {
		enemyUnits.add(enemy);
		actorManager.addActor(enemy);
	}

	protected double getEnemyMaximumYPosition() {
		return enemyMaximumYPosition;
	}

	protected double getScreenWidth() {
		return screenWidth;
	}

	protected boolean userIsDestroyed() {
		return user.isDestroyed();
	}

	private void updateNumberOfEnemies() {
		currentNumberOfEnemies = enemyUnits.size();
	}


}
