package Game;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.BuyScreen;
import Screens.CreditsScreen;
import Screens.DeathScreen;
import Screens.InventoryScreen;
import Screens.MenuScreen;
import Screens.OptionsScreen;
import Screens.PlayLevelScreen;
import Screens.SellScreen;
import Screens.ShopkeeperScreen;
import Screens.TempleScreen1;
import Screens.TempleScreen1_5;
import Screens.TempleScreen2;
import Screens.TempleScreen3;
import Screens.TempleScreen4;
import Screens.WinScreen;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();
	protected Screen levelScreen; 
	protected Screen shopScreen;

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;

	public GameState getGameState() {
		return gameState;
	}

	public void setLevelScreen(PlayLevelScreen s) {
		this.levelScreen = s;
	}
	
	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState; 
	}
	
	@Override
	public void initialize() {
		//Start off game with the main menu screen 
		gameState = GameState.MENU; 
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this); 
						break;
					case BUY:
						currentScreen = new BuyScreen(this);
						break;
					case SELL:
						currentScreen = new SellScreen(this);
						break;
					case TEMPLELVL1:
						currentScreen = new TempleScreen1(this);
						break;
					case TEMPLELVL1_5:
						currentScreen = new TempleScreen1_5(this);
						break;
					case TEMPLELVL2:
						currentScreen = new TempleScreen2(this);
						break;
					case TEMPLELVL3:
						currentScreen = new TempleScreen3(this);
						break;
					case TEMPLELVL4:
						currentScreen = new TempleScreen4(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
					case INVENTORY:
						currentScreen = new InventoryScreen(this);
						break;
					case OPTIONS:
						currentScreen = new OptionsScreen(this);
						break;
					case SHOPKEEP:
						currentScreen = new ShopkeeperScreen(this);
						break;
					case DEATH:
						currentScreen = new DeathScreen(this);
						break;
					case WIN:
						currentScreen = new WinScreen(this);
						break;
					case RETURN: 
						currentScreen = levelScreen;
						break;
				} 
				
				if(gameState != GameState.RETURN) {
					currentScreen.initialize();}
				}
			
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
			
		} while (previousGameState != gameState);
	}
	
	public Screen checkCurrentScreen() {
		return currentScreen;}
	
	
	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}