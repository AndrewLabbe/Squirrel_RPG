package Level;

import Engine.Key;
import Engine.Sound;
import Engine.KeyLocker;
import Engine.Keyboard;
import Level.Projectile;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import NPCs.Currency;
import Projectiles.Acorn;
import Projectiles.Bullet;
import Utils.Direction;
import Utils.Stopwatch;

import java.util.ArrayList;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    protected float walkSpeed = 0;
    protected int interactionRange = 5;
    protected Direction currentWalkingXDirection;
    protected Direction currentWalkingYDirection;
    protected Direction lastWalkingXDirection;
    protected Direction lastWalkingYDirection;
    
	//Initialize sound
	Sound sound = new Sound(); 

    // values used to handle player movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected Direction lastMovementDirection;

    // classes that listen to player events can be added to this list
    protected ArrayList<PlayerListener> listeners = new ArrayList<>();

    // define keyscd cd 
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.LEFT;
    protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    protected Key MOVE_UP_KEY = Key.UP;
    protected Key MOVE_DOWN_KEY = Key.DOWN;
    protected Key INTERACT_KEY = Key.SPACE; 
    //Key to walk faster
    protected Key SPEED_KEY = Key.SHIFT;
    
    //Key for firing projectiles
    protected Key FIRE_BULLET_KEY = Key.F; 
    //Puts a delay on firing which eliminates infinite firing issue
    private Stopwatch fireDelay; 
    
    //Speed boost active or not 
    private boolean speedBoost; 
    //Speed boost timeout 
    private Stopwatch speedBoostTimeout; 
    
    private final int powerUpDuraction = 20000;
    
    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        previousPlayerState = playerState;
        this.affectedByTriggers = true;
        fireDelay = new Stopwatch();
        fireDelay.setWaitTime(1000);  
        speedBoostTimeout = new Stopwatch();
        //speedBoostTimeout.setWaitTime(1000);
        speedBoost = false;
    }

    public void update() {
        moveAmountX = 0;
        moveAmountY = 0;

        // if player is currently playing through level (has not won or lost)
        // update player's state and current actions, which includes things like determining how much it should move each frame and if its walking or jumping
        do {
            previousPlayerState = playerState;
            handlePlayerState();
        } while (previousPlayerState != playerState);
        
        // move player with respect to map collisions based on how much player needs to move this frame
        if (playerState != PlayerState.INTERACTING) {
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
            
        }
        //Fires a bullet if the f key is hit and the player is not interacting 
        if(Keyboard.isKeyDown(FIRE_BULLET_KEY) && playerState != PlayerState.INTERACTING) {
        	fireBullet();
        } 
        //Handle what power-ups are active
        handlePowerUps();
        
        handlePlayerAnimation();

        updateLockedKeys();
        
        // update player's animation
        super.update();
        
    }

	// based on player's current state, call appropriate player state handling method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                break;
            case WALKING:
                playerWalking();
                break;
            case INTERACTING:
                playerInteracting();
                break;
        }
    }

    // player STANDING state logic
    protected void playerStanding() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            playerState = PlayerState.WALKING;
        }
    }

    // player WALKING state logic
    protected void playerWalking() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY)&& Math.round(getX()) > -15 && !Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountX -= walkSpeed;
            facingDirection = Direction.LEFT;
            currentWalkingXDirection = Direction.LEFT;
            lastWalkingXDirection = Direction.LEFT;
        }
        //Walk faster
        else if(Keyboard.isKeyDown(MOVE_LEFT_KEY)&& Math.round(getX()) > -15 && Keyboard.isKeyDown(SPEED_KEY)) {
        	moveAmountX -= walkSpeed*2;
            facingDirection = Direction.LEFT;
            currentWalkingXDirection = Direction.LEFT;
            lastWalkingXDirection = Direction.LEFT;
        }

        // if walk right key is pressed, move player to the right 
        //Checks to see if main character has reach map bounds
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY) && Math.round(getX()) < 1090 && !Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountX += walkSpeed;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;
        }
        //Walk faster
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY) && Math.round(getX()) < 1090 && Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountX += walkSpeed*2;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;
        }
        
        else {
            currentWalkingXDirection = Direction.NONE;
        }
        
        //Checks to see if main character has hit map bounds
        if (Keyboard.isKeyDown(MOVE_UP_KEY)&& Math.round(getY()) > -15 && !Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountY -= walkSpeed;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP; 
        }
        //Walk faster
        else if (Keyboard.isKeyDown(MOVE_UP_KEY)&& Math.round(getY()) > -15 && Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountY -= walkSpeed*2;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP;
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)&& !Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountY += walkSpeed;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
        }
        //Walk faster
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)&& Keyboard.isKeyDown(SPEED_KEY)) {
            moveAmountY += walkSpeed*2;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
        }
        else {
            currentWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingXDirection == Direction.RIGHT || currentWalkingXDirection == Direction.LEFT) && currentWalkingYDirection == Direction.NONE) {
            lastWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingYDirection == Direction.UP || currentWalkingYDirection == Direction.DOWN) && currentWalkingXDirection == Direction.NONE) {
            lastWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY)) {
            playerState = PlayerState.STANDING;
        }
    }

    // player INTERACTING state logic -- intentionally does nothing so player is locked in place while a script is running
    protected void playerInteracting() { 
    	//playSE(6);
    }
    

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(INTERACT_KEY) && playerState != PlayerState.INTERACTING) {
            keyLocker.unlockKey(INTERACT_KEY);
            
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
        else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" : "WALK_LEFT";
        }
        else if (playerState == PlayerState.INTERACTING) {
            // sets animation to STAND when player is interacting
            // player can be told to stand or walk during Script by using the "stand" and "walk" methods
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) { }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) { }

    // other entities can call this method to hurt the player
    public void hurtPlayer(MapEntity mapEntity) {

    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }

    public Rectangle getInteractionRange() {
        return new Rectangle(
                getBounds().getX1() - interactionRange,
                getBounds().getY1() - interactionRange,
                getBounds().getWidth() + (interactionRange * 2),
                getBounds().getHeight() + (interactionRange * 2));
    }

    public Key getInteractKey() { return INTERACT_KEY; }
    public Direction getCurrentWalkingXDirection() { return currentWalkingXDirection; }
    public Direction getCurrentWalkingYDirection() { return currentWalkingYDirection; }
    public Direction getLastWalkingXDirection() { return lastWalkingXDirection; }
    public Direction getLastWalkingYDirection() { return lastWalkingYDirection; }

    public void stand(Direction direction) {
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "STAND_LEFT";
        }
    }

    public void walk(Direction direction, float speed) {
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "WALK_LEFT";
        }
        else {
            if (this.currentAnimationName.contains("RIGHT")) {
                this.currentAnimationName = "WALK_RIGHT";
            }
            else {
                this.currentAnimationName = "WALK_LEFT";
            }
        }
        if (direction == Direction.UP) {
            moveY(-speed);
        }
        else if (direction == Direction.DOWN) {
            moveY(speed);
        }
        else if (direction == Direction.LEFT) {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT) {
            moveX(speed);
        }
    }
    
    //Creates new acorn when called
    public void fireBullet() {
    	if(fireDelay.isTimeUp()) { 
    	int projectileX;
    	int projectileY; 
    	float directionX; 
    	float directionY;
    	
    	projectileX = Math.round(getX()); 
    	directionX = -1;
    	directionY = 0; 
    	
    	//Sets spawn point and direction of projectile depending on which was character is facing 
    	//If moving in horizontally or vertically only set movement to 1 but if traveling both vertically 
    	//and horizontally at the same time use .71 and .71 because length of that vector will equal 1 
    	//This eliminates the bug where firing diagonally moves faster 
    	//If player is moving left 
    	if(getCurrentWalkingXDirection() == Direction.LEFT || getLastWalkingXDirection() == Direction.LEFT) {
    		directionX = -1;
    		//If player is moving left and up
    		if(getCurrentWalkingYDirection() == Direction.UP || getLastWalkingYDirection() == Direction.UP) {
        		directionY = -.71F; 
        	}
    		//If player is moving left and down
        	if(getCurrentWalkingYDirection() == Direction.DOWN || getLastWalkingYDirection() == Direction.DOWN){
        		directionY = .71F; 
        	}
    	}
    	//If player is moving right
    	else if(getCurrentWalkingXDirection() == Direction.RIGHT || getLastWalkingXDirection() == Direction.RIGHT) {
    		projectileX = Math.round(getX()) + 40; 
    		directionX = 1;
    		//If player is moving right and up 
    		if(getCurrentWalkingYDirection() == Direction.UP || getLastWalkingYDirection() == Direction.UP) {
        		directionY = -.71F; 
        	}
    		//If player is moving right and down 
        	if(getCurrentWalkingYDirection() == Direction.DOWN || getLastWalkingYDirection() == Direction.DOWN){
        		directionY = .71F; 
        	}
    	} 
    	//If player is moving up 
    	else if(getCurrentWalkingYDirection() == Direction.UP || getLastWalkingYDirection() == Direction.UP) {
    		directionY = -1.0F; 
    		directionX = 0.0F; 
    		//If player is facing right
    		if(facingDirection == Direction.RIGHT) {
    			projectileX = Math.round(getX() + 40); 
    		}
    	}
    	//If player is moving down 
    	else if(getCurrentWalkingYDirection() == Direction.DOWN || getLastWalkingYDirection() == Direction.DOWN){
    		directionY = 1.0F; 
    		directionX = 0.0F;
    		//If player is facing right
    		if(facingDirection == Direction.RIGHT) {
    			projectileX = Math.round(getX() + 40); 
    		}
    	}
    	
    	//Sets Y spawn coordinate to the middle of the main character roughly
    	projectileY = Math.round(getY()) + 30;
    	
    	//Creates a new bullet 
    	Acorn acorn = new Acorn(projectileX, projectileY, directionX, directionY); 
    	map.addProjectiles(acorn); 
    	fireDelay.reset(); 
    	
    	//Firing sound 
    	playSE(7);
    	} 
    }
    
	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	public void stopMusic() {
		sound.stop();
	}
	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	} 
	//Returns current player speed 
	public float getWalkSpeed() {
		return walkSpeed;
	}
	//Sets player movement speed 
	public void setWalkSpeed(float speed) {
		walkSpeed = speed;
	} 
	//Activates speed boost for given period of time 
	public void setSpeedBoostActive() {
		speedBoost = true; 
		speedBoostTimeout.setWaitTime(powerUpDuraction);
	} 
	//Handles power-ups
	public void handlePowerUps() {
		if(speedBoost == true) {
			if(speedBoostTimeout.isTimeUp() == true) {
				speedBoost = false; 
				setWalkSpeed(walkSpeed/2.0f);
			}
		}
	}
}
