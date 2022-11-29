package Screens;

import java.awt.Color;
import java.util.ArrayList;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import Level.Map;
import Level.Weapon;
import Maps.shopInterior;
import SpriteFont.SpriteFont;

public class BuyScreen extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Rectangle background;
	protected ArrayList<Weapon> items;
	private final Key escKey = Key.ESC;
	private SpriteFont buyLabel, doubleLabel, instaLabel, maxLabel, speedLabel;
	private KeyLocker keyLocker = new KeyLocker();
	
	public BuyScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        buyLabel = new SpriteFont("Buy Screen: Select an item", (Config.GAME_WINDOW_WIDTH / 8), Config.GAME_WINDOW_HEIGHT / 6, "Comic Sans", 30, Color.white);
		buyLabel.setOutlineColor(Color.black);
		buyLabel.setOutlineThickness(5.0f);
		
		doubleLabel = new SpriteFont("1. Double Points", (Config.GAME_WINDOW_WIDTH / 4) - 90, Config.GAME_WINDOW_HEIGHT * 2/6, "Comic Sans", 30, Color.white);
		doubleLabel.setOutlineColor(Color.black);
		doubleLabel.setOutlineThickness(3.0f);
		
		instaLabel = new SpriteFont("2. Insta Kill", (Config.GAME_WINDOW_WIDTH / 4) - 90, Config.GAME_WINDOW_HEIGHT * 3/6, "Comic Sans", 30, Color.white);
		instaLabel.setOutlineColor(Color.black);
		instaLabel.setOutlineThickness(3.0f);
		
		maxLabel = new SpriteFont("3. Max Health", (Config.GAME_WINDOW_WIDTH / 4) - 90, Config.GAME_WINDOW_HEIGHT * 4/6, "Comic Sans", 30, Color.white);
		maxLabel.setOutlineColor(Color.black);
		maxLabel.setOutlineThickness(3.0f);
		
		speedLabel = new SpriteFont("4. Speed Boost", (Config.GAME_WINDOW_WIDTH / 4) - 90, Config.GAME_WINDOW_HEIGHT * 5/6, "Comic Sans", 30, Color.white);
		speedLabel.setOutlineColor(Color.black);
		speedLabel.setOutlineThickness(3.0f);
		
		
    }
	
    public void initialize() {
    	this.map = new shopInterior();
		map.reset();
    }   

	public void update() {
		
		// Here is the game logic for purchasing the power-ups in the shopkeeper
		// if a key is pressed, check if currency is equal to price (runs script), apply power-up, deduct from currency amount
		
		if (Keyboard.isKeyDown(Key.ONE)) {
			System.out.println(map.loadCoins());
			// Assuming that a power-up costs 10 coins
			if (map.loadCoins() >= 10) {
				// Here is were a power-up is applied
//				System.out.println("You made your first transaction");
				map.removeCoins();
			}
			else {
//				System.out.println("You do not have enough coins for this power-up"); 
			}
			keyLocker.lockKey(Key.ONE);
		}
		
		if (Keyboard.isKeyDown(Key.TWO)) {
			if (map.loadCoins() >= 10) {
				// Here is were a power-up is applied
				
				map.removeCoins();
			}
			keyLocker.lockKey(Key.TWO);
		}
		
		if (Keyboard.isKeyDown(Key.THREE)) {
			if (map.loadCoins() >= 10) {
				// Here is were a power-up is applied
				
				map.removeCoins();
			}
			keyLocker.lockKey(Key.THREE);
		}
		
		if (Keyboard.isKeyDown(Key.FOUR)) {
			if (map.loadCoins() >= 10) {
				// Here is were a power-up is applied
				
				map.removeCoins();
			}
			keyLocker.lockKey(Key.FOUR);
		}
		
		
		// Prevents key drag
		if (Keyboard.isKeyUp(Key.ONE)) {
			keyLocker.unlockKey(Key.ONE);
		}
		if (Keyboard.isKeyUp(Key.TWO)) {
			keyLocker.unlockKey(Key.TWO);
		}
		if (Keyboard.isKeyUp(Key.THREE)) {
			keyLocker.unlockKey(Key.THREE);
		}
		if (Keyboard.isKeyUp(Key.FOUR)) {
			keyLocker.unlockKey(Key.FOUR);
		}
		
		if (Keyboard.isKeyDown(escKey)) {
			screenCoordinator.setGameState(GameState.SHOPKEEP);
			//screenCoordinator.switchBackToShop();
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 255));
		buyLabel.draw(graphicsHandler);
		doubleLabel.draw(graphicsHandler);
		instaLabel.draw(graphicsHandler);
		maxLabel.draw(graphicsHandler);
		speedLabel.draw(graphicsHandler);
		/*
		for (Weapon weapon : items) {
            weapon.draw(graphicsHandler);
        }
        */
	}
}
