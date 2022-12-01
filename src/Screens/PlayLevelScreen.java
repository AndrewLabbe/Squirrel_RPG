package Screens;



import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Timer;

import Collectibles.EasterEgg;
import Engine.Config;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.CollectibleItem;
import Level.EnhancedMapTile;
import Level.FlagManager;
import Level.HealthBar;
import Level.Keys;
import Level.KillCount;
import Level.Map;
import Level.MapTile;
import Level.NPC;
import Level.Player;
import Level.PlayerState;
import Level.Script;
import Level.Trigger;
import Maps.newTileMap;
import NPCs.Currency;
import Players.Cat;
import Players.Squirrel;
import Scripts.TestMap.LandScript;
import Scripts.TestMap.TempleScript;
import SpriteFont.SpriteFont;
import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;

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
    public Keys keyCounter;
    public KillCount screenKill;
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
	
	//Dedicated variables to the invScreen
	
    protected int currentItem = 0; // current item position
    protected SpriteFont inventory, line1, line2, line3;
    protected Map background;
    protected int pointerLocationX, pointerLocationY;
    protected Stopwatch keyTimer = new Stopwatch();
    private final Key escKey = Key.ESC;
    protected int yPos, range, itemBoxSize, base;
    protected boolean openInventory = false;
    
    private boolean templeUnlocked; 
    
    private boolean load = false;
    
    protected int numItems = 0;
    protected Sprite sprite, itemSprite1, itemSprite2, itemSprite3, itemSprite4;
    File file = new File("Acorn.txt");
    Scanner sc = new Scanner("Resources" + file);
    
    protected float space, next;
    protected GameObject.Rectangle box1, box2, box3, box4, box5, invTable
    								,info1;
	
    protected ArrayList<Sprite> itemSprites;
	
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
    	
    	if(load == false) {
    	// Kill Count 
    	screenKill = new KillCount();
    	screenKill.setKill(0);
    	
    	// Key Count
    	keyCounter = new Keys();
    	keyCounter.setKeys(0);
    	
        // setup state
        flagManager = new FlagManager();
        
        flagManager.addFlag("hasLostGirlfriend", false);
        
        flagManager.addFlag("enemyKilled",false);
//        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
//        flagManager.addFlag("hasTalkedToDinosaur", false);
//        flagManager.addFlag("hasTalkedToFox", false);
//        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasEnteredTemple", false);
        flagManager.addFlag("hasEnteredShop", false);
        flagManager.addFlag("hasSwam", false); 
        flagManager.addFlag("hasOpenedChestFate", false);
        flagManager.addFlag("hasOpenedChestDestiny", false);
        flagManager.addFlag("hasOpenedChestGenesis", false);
        flagManager.addFlag("hasOpenedChestRetribution", false);
        flagManager.addFlag("hasTempleUnlocked", false);
        
        // define/setup map
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
        
     // All objecsts and variables initialized in inventory screen
        range = Config.GAME_WINDOW_HEIGHT/5; //range for item box and equal spaces
    	itemBoxSize = range * 1/2;
    	space = (range * 1/4) /2;
    	next = itemBoxSize + space;
    	base = range * 3/4;
    	
    	// inventory table
    	invTable = new GameObject.Rectangle(2*space, 2*space, Config.GAME_WINDOW_WIDTH*1/2, Config.GAME_WINDOW_HEIGHT*3/4);
    	invTable.setColor(new Color(77, 75, 115));
    	invTable.setBorderColor(Color.black);
    	invTable.setBorderThickness(3);
    	
        inventory = new SpriteFont("Inventory", itemBoxSize, base*3/4, "Comic Sans", 32, new Color(49, 207, 240));
        inventory.setOutlineColor(Color.black);
        inventory.setOutlineThickness(3);
    	
//    	Rectangle box = new Rectangle(space, yPos+space, itemBoxSize, itemBoxSize);  
    	box1 = new GameObject.Rectangle(itemBoxSize, base, itemBoxSize, itemBoxSize);
    	box2 = new GameObject.Rectangle(itemBoxSize, base+(1*next), itemBoxSize, itemBoxSize);
    	box3 = new GameObject.Rectangle(itemBoxSize, base+(2*next), itemBoxSize, itemBoxSize);
    	box4 = new GameObject.Rectangle(itemBoxSize, base+(3*next), itemBoxSize, itemBoxSize);
    	box5 = new GameObject.Rectangle(itemBoxSize, base+(4*next), itemBoxSize, itemBoxSize);
    	
//    	itemSprite1 = new Sprite(ImageLoader.load(testMap.addInvItem("Acorn").get(1)), next+itemBoxSize, base+(numItems*next));
    	itemSprite1 = new Sprite(ImageLoader.load("Acorn.png"));
    	itemSprite2 = new Sprite(ImageLoader.load("Acorn.png"));
    	    	
//    	while (sc.hasNextLine()) {
		line1 = new SpriteFont("A", itemBoxSize*5/2, base*2, "Comic Sans", 32, new Color(49, 207, 240));
		line1.setOutlineColor(Color.black);
		line1.setOutlineThickness(3);
		
		line2 = new SpriteFont("A", itemBoxSize*5/2, base*3, "Comic Sans", 24, new Color(49, 207, 240));
		line2.setOutlineColor(Color.black);
		line2.setOutlineThickness(3);
		
		line3 = new SpriteFont("A", itemBoxSize*5/2, base*4, "Comic Sans", 24, new Color(49, 207, 240));
		line3.setOutlineColor(Color.black);
		line3.setOutlineThickness(3);
		
		box1.setColor(new Color(90, 89, 110));
    	box1.setBorderColor(Color.black);
    	box1.setBorderThickness(3);
    	
    	box2.setColor(new Color(90, 89, 110));
    	box2.setBorderColor(Color.black);
    	box2.setBorderThickness(3);
    	
    	box3.setColor(new Color(90, 89, 110));
    	box3.setBorderColor(Color.black);
    	box3.setBorderThickness(3);
    	
    	box4.setColor(new Color(90, 89, 110));
    	box4.setBorderColor(Color.black);
    	box4.setBorderThickness(3);
    	
    	box5.setColor(new Color(90, 89, 110));
    	box5.setBorderColor(Color.black);
    	box5.setBorderThickness(3);
    	
    	info1 = new GameObject.Rectangle(next+itemBoxSize, base, itemBoxSize*4, itemBoxSize*6);
    	
//    	info1.setColor(new Color(90, 89, 110));
    	info1.setBorderColor(Color.black);
    	info1.setBorderThickness(3);
    	
    	inventory = new SpriteFont("Inventory", itemBoxSize, base*3/4, "Comic Sans", 32, new Color(49, 207, 240));
        inventory.setOutlineColor(Color.black);
        inventory.setOutlineThickness(3);

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
        
        powerUpTimer = new SpriteFont("Power-Up", 5, 150, "Comic Sans", 20, new Color(0, 0, 0)); 
        
        powerUpTimerColor = new Color(150,0,0);
        
        winScreen = new WinScreen(screenCoordinator);
        deathScreen = new DeathScreen(screenCoordinator); 
        
        itemSprites = new ArrayList<>(); 
        
        templeUnlocked = false; 
        load = true;

    	}
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
            case DIED:
            	screenCoordinator.setGameState(GameState.DEATH);
            	//deathScreen.update();
            	break;
        }
        
        if (player.getUpdate()) {
    		screenKill.addKill(1); 
            player.setUpdate(false);
    	}
        
        //Switches boolean statement when invkey is pressed
        if (Keyboard.isKeyDown(invKey) && !keyLocker.isKeyLocked(invKey)) {
    		openInventory = !openInventory;
        	
    		keyLocker.lockKey(invKey);
    	}
        
        if (Keyboard.isKeyUp(invKey)) {
			keyLocker.unlockKey(invKey);
		}
        
        // Removing items keyboard logic 
        
        //Investigate this later if you have time
        if (Keyboard.isKeyDown(Key.D) && !keyLocker.isKeyLocked(Key.D)) {
        	if (currentItem == player.getInvItem().indexOf("EasterEgg.png")) {
        		itemSprites.remove(player.getInvItem().indexOf("EasterEgg.png"));
        		removeItem("EasterEgg.png"); 
        		Point point = new Point(player.getX() + 50f, player.getY() + 50f);
        		EasterEgg easterEgg = new EasterEgg(point);
        		map.addCollectibles(easterEgg);
        	}
        	
        	else {
        		System.out.println("You cannot drop this item");
        	}
        	
    		keyLocker.lockKey(Key.D);
    	}
        
        if (Keyboard.isKeyUp(Key.D)) {
			keyLocker.unlockKey(Key.D);
		}
        
        // keyboard logic for selecting an item
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
        	if (currentItem == player.getInvItem().indexOf("Acorn.png")) {
        		line1.setText("Acorn");
        		line2.setText("Damage: 5");
        		line3.setText("Durability: UNKOWN");
        	}
        	
        	else {
        		line1.setText("");
        		line2.setText("");
        		line3.setText("");
        	}
        	
    		keyLocker.lockKey(Key.SPACE);
    	}
        
        if (Keyboard.isKeyUp(Key.SPACE)) {
			keyLocker.unlockKey(Key.SPACE);
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
        
        if (map.getFlagManager().isFlagSet("hasEnteredTemple")) {
        	screenCoordinator.setGameState(GameState.TEMPLELVL1);
        }
        
        // If Player Entered Door Change Map to Shop
        if (flagManager.isFlagSet("hasEnteredShop")) {
        	screenCoordinator.setGameState(GameState.SHOPKEEP);
        	flagManager.unsetFlag("hasEnteredShop");
        }
        
        //If Player Enters Water Change State to Swimming
        if (map.getFlagManager().isFlagSet("hasSwam")) {
        	//player.setPlayerState(PlayerState.SWIMMING);
        }
        
        //If Player Enters Land Change State to Walking
        if (map.getFlagManager().isFlagSet("hasWalked")) {
        	//player.setPlayerState(PlayerState.WALKING);
        } 
        
        //If Player interacts with the chest of fate
        if (map.getFlagManager().isFlagSet("hasOpenedChestFate")) {
        	
        } 
        
        //If Player interacts with the chest of destiny
        if (map.getFlagManager().isFlagSet("hasOpenedChestDestiny")) {
         	
        }
        
        //If Player interacts with the chest of genesis
        if (map.getFlagManager().isFlagSet("hasOpenedChestGenesis")) {
        	
        } 
        
        //If Player interacts with the chest of retribution
        if (map.getFlagManager().isFlagSet("hasOpenedChestRetribution")) {
         	
        } 
        
        //If the temple entrance is open or not
        if (map.getFlagManager().isFlagSet("hasTempleUnlocked")) {
         	
        }
        
        //Add picture of item to be displayed at spot in inventory 
    	if (player.getInvItem().size() != 0) { 
    		itemSprites.clear();
    		ArrayList<String> items = player.getInvItem(); 
    		SpriteSheet keysSpriteSheet = new SpriteSheet(ImageLoader.load("Keys.png"), 16, 16);
    		int position = 0; 
    		if (position < 4) {
    			Sprite itemSprite;
    			for(String item : items) {
    				if(item == "KEY_FATE") {
    					itemSprite = new Sprite(keysSpriteSheet.getSprite(0, 0));
    				}
    				else if(item == "KEY_DESTINY") {
    					itemSprite = new Sprite(keysSpriteSheet.getSprite(0, 1)); 
    				} 
    				else if(item == "KEY_GENESIS") {
    					itemSprite = new Sprite(keysSpriteSheet.getSprite(0, 2));
    				}
    				else if(item == "KEY_RETRIBUTION") {
    					itemSprite = new Sprite(keysSpriteSheet.getSprite(0, 3));
    				}
    				else {
    					itemSprite = addItem(item);
    				}
    				itemSprite.setLocation(itemBoxSize, base+(position*next));
    				itemSprite.setHeight(itemBoxSize);
    				itemSprite.setWidth(itemBoxSize); 
    				itemSprites.add(itemSprite); 
    				position++;
    			}
    		}
    	}
    	
    	
        // if down or up is pressed, change selected item position. avoids currentItem from being out of bounds
        if (Keyboard.isKeyDown(Key.DOWN) && currentItem != 4 && !keyLocker.isKeyLocked(Key.DOWN)) {
            currentItem++;
            keyLocker.lockKey(Key.DOWN);
        } else if (Keyboard.isKeyDown(Key.UP) && currentItem != 0 && !keyLocker.isKeyLocked(Key.UP)) {
            currentItem--;
            keyLocker.lockKey(Key.UP);
        }
        
        if (Keyboard.isKeyUp(Key.DOWN)) {
			keyLocker.unlockKey(Key.DOWN);
		}
        if (Keyboard.isKeyUp(Key.UP)) {
			keyLocker.unlockKey(Key.UP);
		}
        

        // sets color of spritefont text based on which menu item is being hovered
        if (currentItem == 0) {
        	box1.setColor(new Color(255, 215, 0)); // selected color
        	box2.setColor(new Color(90, 89, 110)); // natural color

        } else if (currentItem == 1) {
        	box1.setColor(new Color(90, 89, 110));
        	box2.setColor(new Color(255, 215, 0));
        	box3.setColor(new Color(90, 89, 110));

        } else if (currentItem == 2) {
        	box2.setColor(new Color(90, 89, 110));
        	box3.setColor(new Color(255, 215, 0));
        	box4.setColor(new Color(90, 89, 110));

        } else if (currentItem == 3) {
        	box3.setColor(new Color(90, 89, 110));
        	box4.setColor(new Color(255, 215, 0));
        	box5.setColor(new Color(90, 89, 110));

        } else if (currentItem == 4) {
        	box4.setColor(new Color(90, 89, 110));
        	box5.setColor(new Color(255, 215, 0));

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
      	//Increments time
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
      	
      	//Show Key Count for Main Level
      	keyCounter.setKeys(player.getKeyCounter());
      	keyCounter.updateKeyText();
      	
        //screenCoordinator.setLevelScreen(this);
        powerUpTimer.setColor(powerUpTimerColor); 
        
        //Creates trigger to enter temple when all of the keys are collected
        if(keyCounter.getKeys() == 4 && !templeUnlocked) {
        	Trigger trigger = new Trigger(1120, 50, 110, 1, new TempleScript(), "hasEnteredTemple");
    	    
    	    trigger.getTriggerScript().setMap(map); 
    	    trigger.getTriggerScript().setPlayer(player);
    	    map.addTrigger(trigger); 
    	    
    	    templeUnlocked = true; 
    	    flagManager.setFlag("hasTempleUnlocked");
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
                keyCounter.draw(graphicsHandler);
                break;
            case DIED:
            	deathScreen.draw(graphicsHandler);
            	break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
        } 
        
        if (openInventory) {
        	
            invTable.draw(graphicsHandler);
            inventory.draw(graphicsHandler);
            
            box1.draw(graphicsHandler);
            box2.draw(graphicsHandler);
            box3.draw(graphicsHandler);
            box4.draw(graphicsHandler);
            box5.draw(graphicsHandler);
            
            info1.draw(graphicsHandler);
            line1.draw(graphicsHandler);
            line2.draw(graphicsHandler);
            line3.draw(graphicsHandler); 
            
            for(Sprite itemSprite : itemSprites) {
            	itemSprite.draw(graphicsHandler);
            } 
        
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

    //reset level and Health 
    public void resetLevel() {
    	screenCoordinator.setGameState(GameState.LEVEL);
        //this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        initialize();
        map.resetHealthBar();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, DIED
    } 
    
    public Sprite addItem(String image) {
		//numItems++;
		return new Sprite(ImageLoader.load(image), next+itemBoxSize, base+(numItems*next));
		
	}
	
	public void removeItem(String image) {
		// TODO Auto-generated method stub
		ArrayList<String> items = player.getInvItem();
		if (items.contains(image)) {
			int itemIndex = items.indexOf(image);
			//items.remove(itemIndex);
			player.getInvItem().remove(image); 
			player.removeInvItem(image); 
			player.setEasterEggCollected();
		} 
		numItems--;
	}
	
	// Return Player State as an Int (Idea?)
	public int returnPlayerState() {
		int state = 0;
		if (player.getPlayerState() == PlayerState.STANDING) {
			state = 1;
		}
		else if (player.getPlayerState() == PlayerState.WALKING) {
			state = 2;
		}
		else if (player.getPlayerState() == PlayerState.SWIMMING) {
			state = 3;
		}
		return state;
	}
}
