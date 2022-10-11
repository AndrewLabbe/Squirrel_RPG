package Screens;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import Level.Weapon;

public class BuyScreen extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Rectangle background;
	protected ArrayList<Weapon> items;
	private final Key escKey = Key.ESC;
	
	public BuyScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }
	
    public void initialize() {
    	System.out.println("New Screen initiated.");
    }   

	public void update() {
		if (Keyboard.isKeyDown(escKey)) {
			screenCoordinator.setGameState(GameState.LEVEL);
			screenCoordinator.switchBackToLevel();
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 255));
		/*
		for (Weapon weapon : items) {
            weapon.draw(graphicsHandler);
        }
        */
	}
}
