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
import Level.Trigger;
import Maps.templeLevel1Map;
import Players.Cat;
import Players.Squirrel;
import Utils.Direction;
import Utils.Point;

public class TempleScreen1 extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected FlagManager flagManager;
	
	protected TempleScreenState templeScreenState;
	
	public TempleScreen1(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }
	
    public void initialize() {
    	flagManager = new FlagManager();
    	flagManager.addFlag("hasFoundKey", false);
    	flagManager.addFlag("hasTalkedToTable", false);
    	flagManager.addFlag("doneWithPuzzle", false);
    	flagManager.addFlag("hasFinishedFirstLevel", false);
		
    	this.map = new templeLevel1Map();
		map.reset();
		map.setFlagManager(flagManager);
		
		this.player = new Squirrel(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, map);
		this.player.setMap(map);
		Point playerStartPosition = map.getPlayerStartPosition();
		this.player.setLocation(playerStartPosition.x, playerStartPosition.y);

		this.player.setFacingDirection(Direction.LEFT);
		
		this.templeScreenState = TempleScreenState.RUNNING;
		
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
    }   

	public void update() {
		switch (templeScreenState) {
		// if level is "running" update player and map to keep game logic for the platformer level going
        case RUNNING:
            player.update();
            map.update(player);
            break;
        // if level has been completed, bring up level cleared screen
        case LEVEL_COMPLETED:
        	screenCoordinator.setGameState(GameState.TEMPLELVL1_5);
            break;
		}
		
		if (map.getFlagManager().isFlagSet("hasFinishedFirstLevel")) {
            templeScreenState = TempleScreenState.LEVEL_COMPLETED;
        }
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		switch (templeScreenState) {
		 case RUNNING:
             map.draw(player, graphicsHandler);
             break;
         case LEVEL_COMPLETED:
             break;
		}
	}
	
	private enum TempleScreenState {
		RUNNING, LEVEL_COMPLETED;
	}
}
