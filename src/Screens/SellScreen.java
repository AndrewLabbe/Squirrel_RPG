package Screens;

import java.awt.Color;
import java.util.ArrayList;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import Level.Weapon;
import SpriteFont.SpriteFont;

public class SellScreen extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Rectangle background;
	protected ArrayList<Weapon> items;
	private final Key escKey = Key.ESC;
	private SpriteFont sellLabel;
	
	public SellScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        sellLabel = new SpriteFont("Sell Screen", (Config.GAME_WINDOW_WIDTH / 2) - 90, Config.GAME_WINDOW_HEIGHT / 2, "Comic Sans", 30, Color.white);
		sellLabel.setOutlineColor(Color.black);
		sellLabel.setOutlineThickness(5.0f);
    }
	
    public void initialize() {

    }   

	public void update() {
		if (Keyboard.isKeyDown(escKey)) {
			screenCoordinator.setGameState(GameState.LEVEL);
			screenCoordinator.switchBackToLevel();
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(255, 25, 255));
		sellLabel.draw(graphicsHandler);
		/*
		for (Weapon weapon : items) {
            weapon.draw(graphicsHandler);
        }
        */
	}
}
