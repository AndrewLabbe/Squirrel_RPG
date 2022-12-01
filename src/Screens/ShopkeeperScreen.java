package Screens; 

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import JSON.SimpleJSON;
import Level.EnhancedMapTile;
import Level.FlagManager;
import Level.Map;
import Level.MapTile;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import Maps.shopInterior;
import Players.Cat;
import Players.Squirrel;
import Utils.Direction;
import Utils.Point;

public class ShopkeeperScreen extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected FlagManager flagManager;

	protected ShopkeeperScreenState shopkeeperScreenState;

	private KeyLocker keyLocker = new KeyLocker();
	//public Currency screenCoin;
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
		//screenCoin = new Currency();
		//screenCoin = screenCoin.getCoin();

		flagManager = new FlagManager();
		flagManager.addFlag("inShop", false);
		flagManager.addFlag("hasExitedShop", false);
		flagManager.addFlag("leftShop", false);
		flagManager.addFlag("hasMetShopkeeper", false);

		this.map = new shopInterior();
		map.reset();
		map.setFlagManager(flagManager);

		this.player = new Squirrel(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, map);
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
			//screenCoin.addCoin(25);
			wasSpacePressed = true; 
		}

		if (wasSpacePressed && Keyboard.isKeyUp(Key.SPACE)){
			wasSpacePressed = false; 
		}

		if(map.getFlagManager().isFlagSet("inShop") && !map.getFlagManager().isFlagSet("leftShop")) {
			// Here is the game logic for purchasing the power-ups in the shopkeeper
			// if a key is pressed, check if currency is equal to price (runs script), apply power-up, deduct from currency amount

			if (Keyboard.isKeyDown(Key.A) && !keyLocker.isKeyLocked(Key.A)) {
				//System.out.println(map.loadCoins());
				// Assuming that a power-up costs 10 coins
				if (map.loadCoins() >= 10) {
					// Here is were a power-up is applied
					//map.increaseHealth();
					//Hellom
					SimpleJSON simpleJSON = new SimpleJSON(); 
					simpleJSON.setHealth(simpleJSON.getHealth() + 50);
					System.out.println("You purchased Health imporvements");
					map.removeCoins();
				}
				else {
					System.out.println("Not enough coins."); 
					
				}
				keyLocker.lockKey(Key.A);
			}

			if (Keyboard.isKeyDown(Key.B) && !keyLocker.isKeyLocked(Key.B)) {
				if (map.loadCoins() >= 10) {
					// Here is were a power-up is applied
					//map.

					System.out.println("You purchased Damage imporvements");
					map.removeCoins();
				}
				else {
					System.out.println("Not enough coins."); 
				}
				keyLocker.lockKey(Key.B);
			}

			if (Keyboard.isKeyDown(Key.C) && !keyLocker.isKeyLocked(Key.C)) {
				if (map.loadCoins() >= 10) {
					// Here is were a power-up is applied
					System.out.println("You purchased Stamina imporvements");
					map.removeCoins();
				}
				else {
					System.out.println("Not enough coins."); 
				}
				keyLocker.lockKey(Key.C);
			}

			if (Keyboard.isKeyDown(Key.D) && !keyLocker.isKeyLocked(Key.D)) {
				if (map.loadCoins() >= 10) {
					// Here is were a power-up is applied
					System.out.println("You purchased Speed imporvements");
					map.removeCoins();
				}
				else {
					System.out.println("Not enough coins."); 
				}
				keyLocker.lockKey(Key.D);
			}


			// Prevents key drag
			if (Keyboard.isKeyUp(Key.A)) {
				keyLocker.unlockKey(Key.A);
			}
			if (Keyboard.isKeyUp(Key.B)) {
				keyLocker.unlockKey(Key.B);
			}
			if (Keyboard.isKeyUp(Key.C)) {
				keyLocker.unlockKey(Key.C);
			}
			if (Keyboard.isKeyUp(Key.D)) {
				keyLocker.unlockKey(Key.D);
			}

			//if (Keyboard.isKeyDown(buyKey)) {
			//screenCoordinator.setGameState(GameState.BUY);
			//keyLocker.lockKey(buyKey);
			//} 
			//if (Keyboard.isKeyDown(sellKey)) {
			//screenCoordinator.setGameState(GameState.SELL);
			//keyLocker.lockKey(sellKey);
			//}
		}

		if (Keyboard.isKeyDown(invKey)) {
			screenCoordinator.setGameState(GameState.INVENTORY);
			keyLocker.lockKey(invKey);
		}

		//if (Keyboard.isKeyUp(buyKey)) {
		//keyLocker.unlockKey(buyKey);
		//}
		//if (Keyboard.isKeyUp(sellKey)) {
		//keyLocker.unlockKey(sellKey);
		//}
		//if (Keyboard.isKeyUp(invKey)) {
		//keyLocker.unlockKey(invKey);
		//}

		if (map.getFlagManager().isFlagSet("hasExitedShop")) {
			screenCoordinator.setGameState(GameState.RETURN);
			flagManager.unsetFlag("hasExitedShop");
		}

	}


	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		switch (shopkeeperScreenState) {
		case RUNNING:
			map.draw(player, graphicsHandler);
			//screencoin.draw(graphicsHandler);
			break;
		}
	}

	private enum ShopkeeperScreenState {
		RUNNING
	}

}
