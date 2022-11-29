package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Level.Player;
import Maps.templeLevel4Map;
import Players.Squirrel;
import Screens.TempleScreen2;
import Utils.Direction;
import Utils.Point;

public class TempleScreen4 extends Screen{
	
	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected FlagManager flagManager;
	
	protected TempleScreenState templeScreenState;

	public TempleScreen4(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}
	
	@Override
	public void initialize() {
		flagManager = new FlagManager();
		flagManager.addFlag("hasBeatenBoss", false);
		
		this.map = new templeLevel4Map();
		map.reset();
		map.setFlagManager(flagManager);
		
		this.player = new Squirrel(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, map);
		this.player.setMap(map);
		Point playerStartPosition = map.getPlayerStartPosition();
		this.player.setLocation(playerStartPosition.x, playerStartPosition.y);

		this.player.setFacingDirection(Direction.LEFT);
		
		this.templeScreenState = TempleScreenState.RUNNING;
		
		map.getTextbox().setInteractKey(player.getInteractKey());
	}

	@Override
	public void update() {
		switch (templeScreenState) {
		// if level is "running" update player and map to keep game logic
        case RUNNING:
            player.update();
            map.update(player);
            break;
        // if level has been completed, bring up level cleared screen
        case LEVEL_COMPLETED:
        	screenCoordinator.setGameState(GameState.WIN);
            break;
		}
		
		if (flagManager.isFlagSet("hasEnteredLevel4")) {
        	templeScreenState = TempleScreenState.LEVEL_COMPLETED;
        }
		
		//If the health bar is reduced to zero change the game state to player eliminated 
        if (map.getHealthBarLeft() <= 0) {
      		templeScreenState = TempleScreenState.DIED;
      	} 
        
        //If the boss is beaten set the level to completed 
        if (flagManager.isFlagSet("hasBeatenBoss")) {
    	    templeScreenState = TempleScreenState.LEVEL_COMPLETED;
        } 
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		switch (templeScreenState) {
		 case RUNNING:
            map.draw(player, graphicsHandler);
            break;
        case LEVEL_COMPLETED:
            break;
		case DIED: 
			screenCoordinator.setGameState(GameState.DEATH); 
			break;
		}
	}
	
	private enum TempleScreenState {
		RUNNING, LEVEL_COMPLETED, DIED;
	}

}
