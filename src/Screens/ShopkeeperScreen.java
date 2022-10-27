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
import Maps.shopInterior;
import NPCs.Currency;
import Players.Cat;
import Utils.Direction;
import Utils.Point;

public class ShopkeeperScreen extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	 protected FlagManager flagManager;

	protected ShopkeeperScreenState shopkeeperScreenState;

	private KeyLocker keyLocker = new KeyLocker();
	//	public Currency screenCoin;
	private boolean wasSpacePressed = false;

	//protected Key MOVE_LEFT_KEY = Key.LEFT;
	// protected Key MOVE_RIGHT_KEY = Key.RIGHT;
	private final Key invKey = Key.I;
	private final Key buyKey = Key.ONE;
	private final Key sellKey = Key.TWO;


	public ShopkeeperScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}


	@Override
	public void initialize() {
		// TODO: Figure out Screen Coins
		//		screenCoin = new Currency();
		//		screenCoin = screenCoin.getCoin();
		
		 flagManager = new FlagManager();
		 flagManager.addFlag("inShop", false);
		 flagManager.addFlag("hasExitedShop", false);

		this.map = new shopInterior();
		map.reset();
		map.setFlagManager(flagManager);

		this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
		this.player.setMap(map);
		Point playerStartPosition = map.getPlayerStartPosition();
		this.player.setLocation(playerStartPosition.x, playerStartPosition.y);

		this.player.setFacingDirection(Direction.LEFT);

		this.shopkeeperScreenState = ShopkeeperScreenState.RUNNING;

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


	@Override
	public void update() {

		switch (shopkeeperScreenState) {
		case RUNNING:
			player.update();
			map.update(player);
			//screencoin.updateCoin();
			break;
		}

		if (!wasSpacePressed && Keyboard.isKeyDown(Key.SPACE)) {
			//	screenCoin.addCoin(25);
			wasSpacePressed = true; 
		}

		if (wasSpacePressed && Keyboard.isKeyUp(Key.SPACE)){
			wasSpacePressed = false; 
		}

		if(map.getFlagManager().isFlagSet("inShop")) {
			if (Keyboard.isKeyDown(buyKey)) {
				screenCoordinator.setGameState(GameState.BUY);
				keyLocker.lockKey(buyKey);
			} 
			if (Keyboard.isKeyDown(sellKey)) {
				screenCoordinator.setGameState(GameState.SELL);
				keyLocker.lockKey(sellKey);
			}
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
		
		if (map.getFlagManager().isFlagSet("hasExitedShop")) {
        	screenCoordinator.setGameState(GameState.LEVEL);
        	System.out.println("Shop entered");
        }

		screenCoordinator.setShopScreen(this);
		
	}


	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		switch (shopkeeperScreenState) {
		case RUNNING:
			map.draw(player, graphicsHandler);
			//			screencoin.draw(graphicsHandler);
			break;
		}
	}

	private enum ShopkeeperScreenState {
		RUNNING
	}

}
