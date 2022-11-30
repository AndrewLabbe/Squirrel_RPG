package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Level.Player;
import Maps.templeLevel3Map;
import Players.Squirrel;
import Utils.Direction;
import Utils.Point;

public class TempleScreen3 extends Screen{
	
	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected FlagManager flagManager;
	
	protected TempleScreenState templeScreenState;

	public TempleScreen3(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}
	
	@Override
	public void initialize() {
		flagManager = new FlagManager();
		flagManager.addFlag("hasEnteredLevel4", false);
		
		this.map = new templeLevel3Map();
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
        	screenCoordinator.setGameState(GameState.TEMPLELVL4);
            break;
		}
		
		if (map.getFlagManager().isFlagSet("hasEnteredLevel4")) {
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
		}
	}
	
	private enum TempleScreenState {
		RUNNING, LEVEL_COMPLETED;
	}

}
