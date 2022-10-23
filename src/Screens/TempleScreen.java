package Screens;

import java.awt.Color;
import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;

public class TempleScreen extends Screen {

	protected ScreenCoordinator screenCoordinator;
	protected Rectangle background;
	private SpriteFont templeLabel;
	
	public TempleScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }
	
    public void initialize() {
    	templeLabel = new SpriteFont("TOP SECRET TEMPLE", (Config.GAME_WINDOW_WIDTH / 2) - 90, Config.GAME_WINDOW_HEIGHT / 2, "Comic Sans", 30, Color.white);
		templeLabel.setOutlineColor(Color.black);
		templeLabel.setOutlineThickness(5.0f);
		
		//initialize actual temple map here
    }   

	public void update() {
		//logic within the temple map
		/*
		 * if (something){
		 * 		screenCoordinator.setGameState(GameState.LEVEL);
				screenCoordinator.switchBackToLevel();
			}
		 */
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(153, 102, 0));
		templeLabel.draw(graphicsHandler);
	}
}
