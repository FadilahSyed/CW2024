# CW2024
github repo

This is the repository for Developing Maintainable Software (COMP2042) module coursework. 

# Compilation Instructions

# Features:
## Implemented and Working Properly:
### 1. User Interface
A UI was implemented consisting of:
- A main menu with buttons to start, show instructions and quit was implemented.
- A game over screen that appears when the player wins the game. It contains a replay button and an exit button.
- A win game screen that appears when the player loses the game. It contains a replay button and an exit button.
### 2. Enemies
2 enemies were made: 
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
![image](https://github.com/user-attachments/assets/356dd143-6608-422b-8b9e-d8b7b43011ff)
### 14. Space themed layout
Most images (backgrounds, planes, projectiles, hearts) were replaced with a more pixelated space theme. Pixel images were used to replicate the retro look of the original 1942 arcade game. The miniboss and boss are aliens instead of planes.
### 15. Junit Tests: 
### 16. Overall encapsulation:
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
