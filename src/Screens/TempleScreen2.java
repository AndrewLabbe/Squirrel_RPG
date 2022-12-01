package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.EnhancedMapTile;
import Level.FlagManager;
import Level.Map;
import Level.MapTile;
import Level.NPC;
import Level.Player;
import Level.PlayerState;
import Level.Trigger;
import Maps.templeLevel2Map;
import Players.Squirrel;
import Screens.PlayLevelScreen;
import Utils.Direction;
import Utils.Point;

public class TempleScreen2 extends Screen{
	
	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected FlagManager flagManager;
	
	protected TempleScreenState templeScreenState;  
	protected DeathScreen deathScreen;
	
	private int level2Time; 

	public TempleScreen2(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}
	
	@Override
	public void initialize() {
		flagManager = new FlagManager();
		flagManager.addFlag("templeSwam", false);
		flagManager.addFlag("hasEnteredLevel3", false);
		flagManager.addFlag("hasEnteredLevel2", false);
		
		this.map = new templeLevel2Map();
		map.reset();
		map.setFlagManager(flagManager);
		
		this.player = new Squirrel(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, map);
		this.player.setMap(map);
		Point playerStartPosition = map.getPlayerStartPosition();
		this.player.setLocation(playerStartPosition.x, playerStartPosition.y);

		this.player.setFacingDirection(Direction.LEFT);
		
		this.templeScreenState = TempleScreenState.RUNNING; 
		
		deathScreen = new DeathScreen(new PlayLevelScreen(screenCoordinator));
		
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
        
        //Level 2 game time starts at zero
        level2Time = 0;
	}

	@Override
	public void update() {
		switch (templeScreenState) {
		// if level is "running" update player and map to keep game logic for the platformer level going
        case RUNNING:
            player.update();
            map.update(player);
            break; 
        //If the player is eliminated bring up the end of game screen
        case DIED: 
        	screenCoordinator.setGameState(GameState.DEATH); 
        	break;
        // if level has been completed, bring up level cleared screen
        case LEVEL_COMPLETED:
        	screenCoordinator.setGameState(GameState.TEMPLELVL3);
            break;
		}
		
		if (map.getFlagManager().isFlagSet("hasEnteredLevel3")) {
        	templeScreenState = TempleScreenState.LEVEL_COMPLETED;
        }
		
		//If Player Enters Water Change State to Swimming
        if (map.getFlagManager().isFlagSet("templeSwam")) {
        	player.setPlayerState(PlayerState.SWIMMING);
        }
        
        //If Player Enters Land Change State to Walking
        if (map.getFlagManager().isFlagSet("templeWalked")) {
        	player.setPlayerState(PlayerState.WALKING);
        } 
		
        //Spawn enemies periodically 
        if(level2Time % 1000 == 0) {
        	map.spawnEnemies(1);
        }
        
        //If the health bar is reduced to zero change the game state to player eliminated 
        if (map.getHealthBarLeft() <= 0) {
      		templeScreenState = TempleScreenState.DIED;
      	}
        
        //Increment level 2 game time
        level2Time++; 
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		switch (templeScreenState) {
		 case RUNNING:
            map.draw(player, graphicsHandler);
            break;
		 case DIED: 
			 deathScreen.draw(graphicsHandler);
			 break;
         case LEVEL_COMPLETED:
            break;
		}
	}
	
	//Contains all of the possible states of the temple level 2
	private enum TempleScreenState {
		RUNNING, LEVEL_COMPLETED, DIED;
	}
	
}
