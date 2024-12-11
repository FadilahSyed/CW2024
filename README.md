# CW2024
This is the repository for Developing Maintainable Software (COMP2042) module coursework. 
[GitHub Repository](https://github.com/FadilahSyed/CW2024)

# Compilation Instructions
## Prerequisites
- A Java 21 JDK with JavaFX included
- 
The following tools may also be of use:
- Apache Maven or an IDE that comes bundled with it such as IntelliJ IDEA.
- git

## Source Code
 download the source code by cloning the repository:
```shell
git clone https://github.com/FadilahSyed/CW2024.git
cd CW2024
```
    
If you don't have git:  click on the code button on the GitHub page --> "Download ZIP". Then, extract the .zip file.

## Building
### From a CLI
While in the source code folder:
```shell
# Unix/Windows with Maven installed
mvn clean compile exec:java

# Unix without Maven
./mvnw clean compile exec:java

# Windows without Maven
mvnw.cmd clean compile exec:java
```

### From IntelliJ IDEA CE
Open the project folder in IDEA, then navigate to Run -> Edit Configurations in the menu. Then, click the + button at the top left, select Maven and add
```shell
clean compile exec:java
```
to the run field.

Click 'Apply' and then 'Okay'. Now, clicking the play button (green triangle) at the top right of the window should run the project.



# Features:
## Implemented and Working Properly:
### 1. User Interface
A UI was implemented consisting of:
- A main menu with buttons to start, show instructions and quit was implemented.
- A game over screen that appears when the player wins the game. It contains a replay button and an exit button.
- A win game screen that appears when the player loses the game. It contains a replay button and an exit button.
### 2. Enemies
2 Enemies were made: 
- An enemy plane that combines the straight horizontal movement of EnemyPlane with the random vertical movement of the Boss.
- A miniboss that is similar to the boss, just with smaller health and smaller projectile. 
### 3. New levels:
3 levels were added in between the original LevelOne and LevelTwo. 
- The new LevelTwo spawns the new enemy plane and is won after 10 kills
- LevelThree spawns 3 minibosses and is won after killing all of them
- LevelFour spawns both the original enemy plane from level one and the new enemy planes. It is won after 15 kills
### 4. Projectile
A projectile for the miniboss was made so that it moves in a zig-zag manner across the screen.
### 5. Factory Patterns:
Factory patterns were used for creating levels, planes, projectiles, level configurations, or menus for the user interface. It prevents hardcoding instances.
### 6. Strategy Patterns
Strategy patterns were used to handle the shield functions, the plane’s movement, and the projectile’s movement.
### 7. Utility classes
Utility classes were made:
- BackgroundHandler: manages background image + handles user input for controlling the player’s user plane in the game
- CollisionHandler: handles collision detection between game actors and processes damage or boundary violations (where enemyHasPenetratedDefenses)
- CommonConstants: contains globally accessible constants used throughout the application
- EnemySpawner: handles the spawning of enemies in the game based on level configurations.
- ImageLoader: responsible for loading images from the resource directory
### 8. Manager Classes
ActorManager and ShieldManager are classes responsible for updating, adding, removing, or positioning actors or the shield.
### 9. Level Configurations 
- A LevelConfig class encapsulates configuration details for each level. These include the background image, number of enemies, spawn probabilities, kill target, and initial player health. The class serves as a data object for level-specific properties and provides getter methods to access these properties. 
- A LevelConfigFactory initializes or loads these level configurations for each level. 
### 10. Event listeners
- A callback mechanism removed the usage of Observer and Observable in Java, as they were considered outdated and deprecated.
- An interface LevelEventListener is defined to handle events like level completion, game over or game won.
- The controller handles events by passing a lambda/instance of this LevelEventListener.
### 11. Userplane movement
The player can move horizontally and vertically using the arrow keys as well as with the W,A,S,D keys
### 12. Better Hitboxes
Hitboxes are more accurate as blanked spaces from images used are cropped out.
### 13. Package organization
Packages were made to organise classes into their respective responsibilities properly. 
The package hierarchy is:
- ![image](https://github.com/user-attachments/assets/356dd143-6608-422b-8b9e-d8b7b43011ff)
### 14. Space themed layout
Most images (backgrounds, planes, projectiles, hearts) were replaced with a more pixelated space theme. Pixel images were used to replicate the retro look of the original 1942 arcade game. The miniboss and boss are aliens instead of planes.
### 15. Overall encapsulation:
- Ensured fields were private and accessed via public getters/setters when necessary. 
- Ensured objects were passed via a constructor or a setter to avoid creating dependencies directly inside the class.

## Implemented but Not Working Properly
### EnemySpawner & PlaneFactory: 
EnemySpawner is a utility class to encapsulate enemy spawning logic into one class. It was made to remove code duplication across the levels, where each level implements its own spawnEnemyUnits logic.

However, it does not extend to the final level, where the boss is spawned. In LevelFinal, the boss is spawned like in its original code, instantiated in the constructor, and added in the spawnEnemyUnits() method. It does not use the EnemySpawner or the PlaneFactory classes at all. 

This is because the spawning logic is much simpler than other levels, where if there are no enemy units a boss entity is added to the group root. It would be unnecessary to extend the EnemySpawner and PlaneFactory, just to cater to the boss entity when it is much simpler to just follow the original process 

In addition to this, the EnemySpawner class prevents scalability because if another level is added with more complex spawning logic, the class would either not be able to handle it or becomes harder to maintain. Therefore, the class does not fulfill its initial function, which was to encapsulate all enemy spawning logic into a centralized class. Instead, it might’ve made the code more disordered, where some spawning logic is in the EnemySpawner class and some are in its own level classes.

### MovementStrategy for planes:
The same problem from above is repeated here, where the MovementStrategy is not implemented on the EnemyPlane class. This is because the EnemyPlane class only has a straight, horizontal movement, making it unnecessary to create a whole movement class just for this plane. The code is not intuitive, some movement logic uses MovementStrategy, while some are hardcoded into the plane’s class.

## Not Implemented
### Pause menu: 

a pause menu was halfway implemented into the code, where the user could press ‘P’ to pause and a menu displaying buttons to resume, restart the level or quit, appears. 

Due to the LevelParent already being split into helper classes, figuring out how to implement it so that the user input ‘P’ calls the showPauseMenu in either the LevelParent or controller was time-consuming. The timeline was an issue as well, in the resume and restarting functions. 

### Level-Up Display: 
This was actually fully implemented into the game. When the user progresses into the next level, the timeline would pause for 2 seconds to display a simple image stating ‘Level-Up’. 

This was implemented due to the slight confusion of test players when proceeding from one level to another.

However, the image would not show up on screen no matter what was tried, and was inevitably deleted off. Instead, different backgrounds for different levels were displayed. 

### User Shield: 

Plans for any user powerup was thought of at the initial stage of this project. In particular, a powerup where the user can press the ‘S’ key for a shield to defend itself from damage. The user would only get a maximum amount of frames to use the shield and would only be able to use it in the later levels. 

However, this was not implemented due to time constraints and also due to the fact I didn't know how to tell the user that they can use the shield in the later levels. Unfortunately, this game does not have any user power-ups, but it is still winnable.

### Tri-Projectile plane: 
An EnemyPlane that shoots 3 projectiles at once in different directions was attempted many times during this project. Unfortunately, it was never successful. From what I know, the FighterPlane would need a new method to handle multiple projectiles and AbstractLevel’s generateEnemyFire() would need to be updated to handle that new method. However, I didn’t know where to implement this projectile as 5 levels were already made and 2 planes were already added.

### Zig-Zag Plane Movement: 
This was actually implemented for Enemy2Plane, and it uses the same zig-zag logic from the ZigzagProjectileMovement. However, using the RandomMovementPattern from the boss and combining it with straight horizontal movement created a more unpredictable, harder-to-kill enemy. 

### Sound Effects: 
Adding sound effects was planned, but it was at the bottom of the priority list because I personally always mute games. It was not implemented due to time constraints. 


# Java Classes
## New Java Classes
New Java Classes are listed based on its location in the code. 
### <ins> com.example.demo.movement </ins>
#### MovementStrategy: 
- This is the strategy interface for the strategy design pattern used for the enemies’ movement. 
- it defines a contract for implementing moment strategies for the game’s enemies. 
- Key feature: It provides a method getNextMove for determining the next move

#### RandomMovementPattern: 
- implements MovementStrategy to provide a randomized vertical movement pattern for enemies, allowing them to move up, down, or remain stationary with random intervals
- Key feature: It generates a shuffled list of movement actions (up/down/no movement).
- Key feature: ensures a limit on consecutive moves in the same direction 

### <ins> com.example.demo.actors.planes </ins>
####  Enemy2Plane: 
- Enemy plane with random vertical movement using RandomMovementPattern, as well as moving straight horizontally (appears in level 2 and 4) 
####  MiniBoss: 
- A miniboss enemy with random vertical movement using RandomMovementPattern and a health value of 10 (appears in Level 3) 
#### PlaneFactory: 
- Factory class for creating instances of different types of fighter planes (userplane, enemyplane, enemy2plane, miniboss, boss)
- Key features: creates planes based on a string
- Key features: encapsulates plane creation logic in centralised method

###  <ins> com.example.demo.actors.shield </ins>
####  ShieldStrategy:
- A strategy interface for implementing shields
- Key features:updates shield status
- Key features:tracks when shield is active 
- Key features: updates shield position based on the boss’s plane position
#### ShieldManager:
- Implements ShieldStrategy to manage the shield feature for the boss plane – activating, deactivating and updating the shield position
- Key features: Activates the shield based on a probability.
- Key features: Tracks the active duration of the shield.
- Key features: Updates the shield's position relative to the boss.
### <ins> com.example.demo.actors </ins>
#### ActorManager: 
- Manages adding, updating and removing game actors (eg. enemies, projectiles, userplanes) from the game scene. 
- Key features: Add actors to game scene
- Key features: updates all active actors using method updateActor
- Key features: removes destroyed actors and cleans them from the scene


### <ins> com.example.demo.core.levels </ins>
####  LevelTwo: 
- A class for level 2 of the game.
- It spawns Enemy2Plane, with a cap of 5 enemies at a time, and is won after 10 kills.
- It uses LevelConfig and LevelConfigFactory for level settings.
#### LevelThree: 
- A class for level 3 of the game.
- It spawns 3 minibosses and is won after all are defeated.
- It uses LevelConfig and LevelConfigFactory for level settings.
#### LevelFour: 
- A class for level 4 of the game.
- It spawns both EnemyPlane and Enemy2Plane, with a cap of 7 enemies at a time, and is won after 15 kills.
- It also uses LevelConfig and LevelConfigFactory for level settings. 

### <ins> com.example.demo.core </ins>
#### GameLoop: 
- A helper class for AbstractLevel that encapsulates the game loop logic using JavaFX’x timeline to run update actions at regular intervals
- Key features: calls updateAction method periodically to update the game’s state

#### LevelConfig: 
- A class that encapsulates configuration details/settings for each level (background image, number of enemies, spawn probabilities, kill target and player’s initial health).
- It serves as a data object for level-specific properties and provides getter methods to access these properties. 

#### LevelConfigFactory: 
- A Factory class that initializes configurations for each level and makes them accessible
- Ensures consistency and reduces hardcoding in the level classes
- Key features: Uses a lookup map to store predefined level configurations for multiple levels
- Key features: Throws an exception for invalid level names

#### LevelEventListener: 
- Interface for handling level-specific events (eg. transitioning to another level, game is lost, game is won)
- Makes level event handling customizable
- Key features: Has one single method onLevelEvent, to handle events
#### LevelFactory: 
- a Factory class for creating AbstractLevel instances based on level names
- Creates levels dynamically
- Key features: uses a switch case to return instances of levels 
- Key features: throws an exception for invalid level names

### <ins> com.example.demo.projectiles.movement </ins>
#### ProjectileMovementStrategy: 
- Strategy interface defining a method updatePosition for handling projectile movement.
- Allows different movement behaviors to be implemented
#### StraightMovement: 
- Implements ProjectileMovementStrategy to move the projectile horizontally at a constant velocity
#### ZigZagMovement: 
- Implements ProjectileMovementStrategy to move the projectile in a horizontal zig-zag pattern using a sine wave for vertical displacement

###  <ins> com.example.demo.projectiles </ins>
#### MiniBossProjectile: 
- A projectile fired by a mini-boss that uses ZigZagMovement to move horizontally with vertical oscillation
#### ProjectileFactory: 
- A Factory class for creating different types of projectiles based on a string input (boss, enemy, miniboss, and user)

### <ins> com.example.demo.ui.menus </ins>
#### AbstractMenu: 
- An abstract base class for the game’s menu screens (MainMenu, GameOverMenu, WinGameMenu).
- It handles background rendering, title image display and image button creation.
- Also promotes reusability as it provides a template for all menus as the common logic for rendering menus is centralised
- Key features: Provides show method to display the menu scene with customizable buttons and background
- Key features: `createImageButton` method is responsible for creating buttons
  
#### GameOverMenu: 
- The menu displayed when the player loses.
- Key features: A replay button that restart the game
- Key features: An exit button to close the game
#### MainMenu: 
- The main menu displayed when launching the game.
- Key features: Start button that begins the game at level 1
- Key features: Tutorial button shows gameplay instructions in a pop up window
- Key features: Exit button that closes the game.
#### TutorialPopUp: 
- A popup window displayed when the tutorial button is clicked and shows instructions on how to play the game, with a simple UI containing text, a GIF, and a close button.
- Key features: Displays game instructions and controls
- Key features: Blocks interaction with the main game window
#### WinGameMenu: 
- The menu displayed when the player wins the game.
- Key features: A replay button that restart the game
- Key features: An exit button to close the game
  
### <ins> com.example.demo.ui </ins>
#### GameUIFactory: 
- A Factory class to create game menus (MainMenu, GameOverMenu, WinGameMenu)

### <ins> com.example.demo.utils </ins>
#### BackgroundHandler: 
- Initializes and manages the game background + manages user input for controlling the player’s plane  → helper class for AbstractLevel
- Key features: displays the background in the game scene
- Key features: listens for user input (key event) and processes it to:
- - Move the players plane
  - Fire projectile
  - Stops planes movement when keys are released
- It listens for the arrow keys, space key and W,A,S,D keys
  
#### CollisionHandler: 
- Handles collision detection between actors (eg. projectiles and planes) and checks if enemies penetrated user defenses → helper class for AbstractLevel
- Key features: Detect collisions between two list of actors and applies damage to both
- Key features: Checks if an enemy has penetrated the screen boundary (defenses)

#### EnemySpawner: 
- Handles the spawning of enemy actors in the game based on level configuration probabilities
- Key features: encapsulates and centralises all logic related to spawning enemies
- Key features: ensures appropriate enemy counts and types are generated

#### CommonConstants: 
- Centralized constants for movement, health, fire rates, and boundaries of plane, as well constants used for the menu
- Ensures all values are consistent throughout the code base and avoids hardcoding into the classes
- Made to avoid duplication and ensure maintainability. 
#### ImageLoader: 
- A utility class to load images for levels and actors
- Key features: simplifies image loading by using a path prefix
- Key features: throws an exception if an image resource is found

## Modified Java Classes
Modified java classes are listed based on location in the code.


# Unexpected Problems:

### 1. Shield was not appearing:
I started with using `System.out.println` to check and log whether the methods were actually being called. Next, I checked if `activateShield()` and `deactivateShield()` in the Boss class called the appropriate LevelView methods – they didn’t. For the Boss class and LevelViewLeveltTwo class to communicate and access methods, the boss constructor had to have an additional parameter for LevelViewLevelTwo. 

As it still wasn’t appearing, the position and image size were tested to ensure it was not too small to see or blocked by another object. It finally appeared after I removed the redundant addImagesToRoot method, directly added the image to the root in the constructor, and added shieldImage.ToFront() in the showShield() method.

### 2. Game-over menu & win menu were misaligned
The background, buttons and title for the Game Over menu and the Win Game menu were misaligned and not to the center, however Main Menu was perfectly fine. 

The first initial code for the menus involved using a StackPane root and a VBox layout. The background was also loaded in the show() method instead of the constructor. 

At first, I tried to force everything to be centered by using `layout.setAlignment(Pos.CENTER)`, `layout.setStyle(“-fx:alignment: center”)` with css, and many other things. The alignment was hardcoded as well using `layout.setLayoutX((SCREEN_WIDTH - layout.getWidth()) / 2)` and `layout.setLayoutY((SCREEN_HEIGHT - layout.getHeight()) / 2);`

After many tries, this was put on hold for a long while. 

I tried to log and verify the dimensions of each element I used in AbstractMenu. This was done by printing the height and width measurements for the stage, root, and layout, as well as adding border colours to the layout and root (using CSS) to visually highlight how the alignment was off. 

It turns out, after the Main Menu was displayed, the StackPane root dimensions were getting bigger. Therefore, it was misaligned because the root and layout dimensions were bigger than the window screen, resulting in the “center” of the root & layout being closer to the bottom-right of the window screen. 

I tried to bind the background with the stage dimensions using `.fitWidthProperty().bind()`, as well as force the layout and root to the screen width and screen height with `.setMinHeight()` and `.setMaxHeight()`, `root.setPrefSize()`, but none were working.
In the end, I copied the way that AbstractLevel/BackgroundHandler manages the background. The background was loaded using imageview in the constructor and a Group root was used instead of StackPane. 

### 3. ZigZag Projectile Movement
The Zig Zag Projectile movement was coded as:

![image](https://github.com/user-attachments/assets/2370f085-f837-43d9-a27e-ccd94b075be0)

Where the direction would be alternated every time its position is updated. 
However, it appeared more like 2 projectiles glitching through the screen.

Now, it follows the movement of a sin graph to simulate the 'zig-zag' effect. 

![image](https://github.com/user-attachments/assets/4cfe04f2-4d82-4012-b5ed-0e04210cb26a)


### 4. Splitting up LevelParent/AbstractLevel
This took some time, many tries, many abandoned branches, and many instances of leaving it on hold. 
I wanted to really split up the LevelParent/AbstractLevel class so that it was much shorter, however, there was always some error.
The initial plan was to make an elaborate gameManager, ActorManager, InputHandler, and UIManager, where:
- GameManager would coordinate the overall game flow (timeline, starting, stopping, transitioning to levels, checking win/lose conditions, calling methods from the other helper classes).
- UIManager would manage UI elements like the background, health display, win/lose screens, and update UI based on the game state.
- InputHandler would handle user inputs.
- ActorManager would manage the spawning, updating and removing of all game actors. It would include methods like addFriendlyUnit, addEnemyUnit, updateActors, handleCollision, handleAllCollisions, removeAllDestroyedActors, removeDestroyedActors.

I ended up just extracting logic and putting it in helper classes (BackgroundHandler, CollisionHandler, GameLoop, ActorManager). Unfortunately, LevelParent/AbstractLevel is still very lengthy.

### 5. Stagnant Enemies
When actors with the RandomMovement strategy are spawned or positioned at the Y-Bounds of the screen, they stay stagnant for a long time. 
This is due to the combination of the bound checking logic (if the plane goes outside of bounds it does not move) and the RandomMovement strategy making the plane remain stagnant or go towards the direction outside of bounds. 
This particularly is obvious with the miniboss. I tried to reduce the maximum frames with the same move, however, still does end up getting stuck sometimes.

# Thank you for reading my readme file :D <3
