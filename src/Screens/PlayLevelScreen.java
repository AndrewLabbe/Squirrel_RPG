package Screens;



import java.awt.Color;

import javax.swing.Timer;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.EnhancedMapTile;
import Level.FlagManager;
import Level.HealthBar;
import Level.KillCount;
import Level.Map;
import Level.MapTile;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import Maps.newTileMap;
import NPCs.Currency;
import Players.Cat;
import Players.Squirrel;
import SpriteFont.SpriteFont;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected DeathScreen deathScreen;
    protected FlagManager flagManager;
    private KeyLocker keyLocker = new KeyLocker();
    public Currency screenCoin;
    public KillCount screenKill;
    private boolean wasSpacePressed = false;
    private boolean wasFPressed = false;
    //protected Key MOVE_LEFT_KEY = Key.LEFT;
    //protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    private final Key invKey = Key.I;
    private final Key opsKey = Key.O;
	private final Key buyKey = Key.ONE;
	private final Key sellKey = Key.TWO; 
	
	//Play Level time 
	private int time; 	
	//Opacity for Day/Night Cycle 
	private int shade = 0; 
	//Changing to night or day 
	private boolean fading = true; 
	//Day or night is happening 
	private boolean changeDay = true; 
	//Length of day/night
	private static final int dayLength = 1000; 
	//Number of enemies that spawn 
	private int spawnNumber;
	//Displays the wave
	private SpriteFont wave; 
	//Specifies if it is day or night 
	private boolean day; 
	//Displays the power up timer 
	private SpriteFont powerUpTimer; 
	//Duration power-up will be on screen 
	private int powerUpOnScreen; 
	//Color or power-up counter 
	private Color powerUpTimerColor; 
	
	
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
    	
    	// Kill Count 
    	screenKill = new KillCount();
    	screenKill.setKill(0);
    	
        // setup state
        flagManager = new FlagManager();
        
        flagManager.addFlag("hasLostGirlfriend", false);
        
        flagManager.addFlag("enemyKilled",false);
//        flagManager.addFlag("hasLostBall", false);
//        flagManager.addFlag("hasTalkedToWalrus", false);
//        flagManager.addFlag("hasTalkedToDinosaur", false);
//        flagManager.addFlag("hasTalkedToFox", false);
//        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasEnteredTemple", false);
        flagManager.addFlag("hasEnteredShop", false);

        // define/setup map
//        this.map = new TestMap();
        this.map = new newTileMap();
        map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Squirrel(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, map);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.RIGHT);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // setup map scripts to have references to the map and player
        for (MapTile mapTile : map.getMapTiles()) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(map);
                mapTile.getInteractScript().setPlayer(player);
            }
        }
        for (NPC npc : map.getNPCs()) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(map);
                npc.getInteractScript().setPlayer(player);
            }
        }
        for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(map);
                enhancedMapTile.getInteractScript().setPlayer(player);
            }
        }
        for (Trigger trigger : map.getTriggers()) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(map);
                trigger.getTriggerScript().setPlayer(player);
            }
        }
        
        time = 0; 
        
        powerUpOnScreen = 20;
        
        spawnNumber = 1; 
        
        wave = new SpriteFont("Wave: I", 350, 30, "Comic Sans", 20, new Color(255, 0, 0)); 
        
        day = false;
        
        powerUpTimer = new SpriteFont("Power-Up", 5, 115, "Comic Sans", 20, new Color(0, 0, 0)); 
        
        powerUpTimerColor = new Color(150,0,0);
        
        winScreen = new WinScreen(this);
        deathScreen = new DeathScreen(this);
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;
        }
        
        if (player.getUpdate()) {
    		screenKill.addKill(1);
            wasFPressed = true; 
            player.setUpdate(false);
    	}
        
        if (Keyboard.isKeyDown(invKey)) {
    		screenCoordinator.setGameState(GameState.INVENTORY);
    		keyLocker.lockKey(buyKey);
    	}
        
        if (Keyboard.isKeyDown(opsKey)) {
    		screenCoordinator.setGameState(GameState.OPTIONS);
    		keyLocker.lockKey(opsKey);
    	}
        
        if (Keyboard.isKeyUp(buyKey)) {
			keyLocker.unlockKey(buyKey);
		}
		if (Keyboard.isKeyUp(sellKey)) {
			keyLocker.unlockKey(sellKey);
		}
		if (Keyboard.isKeyUp(invKey)) {
			keyLocker.unlockKey(invKey);
		}
		

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
        
        if (map.getFlagManager().isFlagSet("hasEnteredTemple")) {
        	screenCoordinator.setGameState(GameState.TEMPLELVL1);
        }
        
        // If Player Entered Door Change Map to Shop
        if (map.getFlagManager().isFlagSet("hasEnteredShop")) {
        	screenCoordinator.setGameState(GameState.SHOPKEEP);
        	System.out.println("Shop entered");
        }
        
        //If day/night time has ended commence fade 
        if(time % dayLength == 0) {
      		changeDay = true; 
      		if(time % (dayLength*2) == 0) {
      			if(spawnNumber == 1)
      				wave.setText("Wave: I"); 
      			else if(spawnNumber == 2) {
      				wave.setText("Wave: II"); 
      			}
      			else if(spawnNumber == 3) {
      				wave.setText("Wave: III"); 
      			}
      			else if(spawnNumber == 4) {
      				wave.setText("Wave: IV"); 
      			}
      			else {
      				wave.setText("Wave: V"); 
      			}
      		}
      	} 
      	//If day/night is changing call the day/night fade 
      	if(changeDay == true) {
      		if (time % 5 == 0) {
      			cycleDay(); 
      		}
      	} 
      	//Spawns enemies when night falls 
      	if(time == 0 || time % (dayLength*2) == 0) {
        	map.spawnEnemies(spawnNumber);
        } 
      	//Increaments time
      	time++;
      	//Removes enemies when day rises 
      	if(time == dayLength || time % ((dayLength*2)+dayLength) == 0) {
      		map.removeEnemies();
      	}
      	//Changes day night
      	if(time % dayLength == 0) {
      		day = !day;
      	} 
      	//Updates wave
      	waveTracker();
      	
      	if(time % 10 == 0) {
      		int temp = powerUpTimerColor.getRed();
      		if(temp == 150) {
      			powerUpTimerColor = new Color(100, 0, 0);
      		} 
      		else {
      			powerUpTimerColor = new Color(150, 0, 0);
      		}
      	}
      	
      	if(map.getPowerUpActive()) {
      		powerUpOnScreen = map.getPowerUpStartTime() + 20 - map.getCurrentTime();
      		powerUpTimer.setText("Power-up: " + powerUpOnScreen);
      	} 
      		
      	
      	if (map.getHealthBarLeft() <= 0) {
      		playLevelScreenState = PlayLevelScreenState.DIED;
      	}
      	
      	
      	
        screenCoordinator.setLevelScreen(this);
        
    }

    //Fade to day/night
  	public void cycleDay() {
  		if (fading == true) { 
  			//System.out.println("Turning Night");
  			if(shade < 125) {
  				shade = shade + 5; 
  			} 
  			else {
  				fading = false; 
  				changeDay = false;
  			}
  		}
  		else { 
  			//System.out.println("Turning Day");
  			if(shade > 0) {
  				shade = shade - 5;
  			}
  			else {
  				fading = true;
  				changeDay = false;
  			}
  		}
  	} 
  	
  	public void waveTracker() {
  		if(spawnNumber < 5) {
  			if(time % (dayLength*2) == 0) {
  				spawnNumber++;
  			}
  		}
  	}
    
    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                screenKill.draw(graphicsHandler);
                break;
            case DIED:
            	deathScreen.draw(graphicsHandler);
            	break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
        } 
        
        // Shade for Day Night Cycle
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, shade));
    
        if(map.getPowerUpActive()) {
        	powerUpTimer.draw(graphicsHandler);
        }
        
        wave.draw(graphicsHandler);
        
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }


    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, DIED
    } 
    
}
