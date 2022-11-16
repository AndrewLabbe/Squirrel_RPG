package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Level.Player;
import Maps.templeLevel2Map;
import Players.Squirrel;
import Utils.Direction;
import Utils.Point;

public class TempleScreen2 extends Screen{
	
	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected FlagManager flagManager;
	
	protected TempleScreenState templeScreenState;

	public TempleScreen2(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}
	
	@Override
	public void initialize() {
		flagManager = new FlagManager();
		
		this.map = new templeLevel2Map();
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
		// update logic
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
