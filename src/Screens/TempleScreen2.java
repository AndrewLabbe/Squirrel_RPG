package Screens;

import java.awt.Color;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Screen;
import Engine.ScreenManager;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

public class TempleScreen2 extends Screen{
	
	private SpriteFont templeLabel;
	protected ScreenCoordinator screenCoordinator;

	public TempleScreen2(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
		templeLabel = new SpriteFont("To be continued...", (Config.GAME_WINDOW_WIDTH / 2) - 130, Config.GAME_WINDOW_HEIGHT / 2, "Comic Sans", 30, Color.white);
		templeLabel.setOutlineColor(Color.black);
		templeLabel.setOutlineThickness(5.0f);
	}
	
	@Override
	public void initialize() {
		//implement new temple map
	}

	@Override
	public void update() {
		// update logic
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// TODO Auto-generated method stub
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(255, 170, 0));
		templeLabel.draw(graphicsHandler);
	}

}
