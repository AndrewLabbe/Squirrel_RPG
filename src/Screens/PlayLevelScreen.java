package Screens;



import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import NPCs.Currency;
import Players.Cat;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    private KeyLocker keyLocker = new KeyLocker();
    public Currency screenCoin;
    private boolean wasSpacePressed = false;
    //protected Key MOVE_LEFT_KEY = Key.LEFT;
   // protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    private final Key invKey = Key.I;
	private final Key buyKey = Key.ONE;
	private final Key sellKey = Key.TWO;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
    	// Setup Currency
    	screenCoin = new Currency();
    	screenCoin.setCoin(50);
    	
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasTalkedToFox", false);
        flagManager.addFlag("hasFoundBall", false);

        // define/setup map
        this.map = new TestMap();
        map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);

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

        winScreen = new WinScreen(this);
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                screenCoin.updateCoin();
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;
        }
        
       // if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
    		//screenCoin.loseCoin(2);
    	//} 
    	 if (!wasSpacePressed && Keyboard.isKeyDown(Key.SPACE)) {
    		screenCoin.addCoin(25);
            wasSpacePressed = true; 
    	}

        if (wasSpacePressed && Keyboard.isKeyUp(Key.SPACE)){
            wasSpacePressed = false; 
        }
        
        if (Keyboard.isKeyDown(buyKey)) {
    		screenCoordinator.setGameState(GameState.BUY);
    		keyLocker.lockKey(buyKey);
    	} 
        if (Keyboard.isKeyDown(sellKey)) {
        	screenCoordinator.setGameState(GameState.SELL);
        	keyLocker.lockKey(sellKey);
    	}
        
        if (Keyboard.isKeyDown(invKey)) {
    		screenCoordinator.setGameState(GameState.INVENTORY);
    		keyLocker.lockKey(buyKey);
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
        
        screenCoordinator.setLevelScreen(this);
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                screenCoin.draw(graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
        }
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
        RUNNING, LEVEL_COMPLETED
    }
}
