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
	//protected Screen levelScreen2 = new PlayLevelScreen(this);
	protected Screen shopScreen;

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;

	public GameState getGameState() {
		return gameState;
	}

	/*public void setLevelScreen(PlayLevelScreen s) {
		this.levelScreen = s;
	}
	
	public void setShopScreen(ShopkeeperScreen s) {
		this.shopScreen = s;
	}*/
	
	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState; 
		if(this.gameState == GameState.SHOPKEEP) {
			//levelScreen = currentScreen;
		}
	}
	
	@Override
	public void initialize() {
		// start game off with Menu Screen
		//gameState = GameState.MENU; 
		gameState = GameState.TEMPLELVL4; 
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				//levelScreen = currentScreen;
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this); 
						
						//currentScreen = levelScreen2;
						//currentScreen = new TempleScreen1(this);
						//levelScreen2 = currentScreen;
						//currentScreen = levelScreen2;
//						if(checkCurrentScreen() == levelScreen2) {
//							
//						
//						System.out.println("Test");}
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
						//levelScreen = currentScreen;
						currentScreen = new ShopkeeperScreen(this);
						break;
					case DEATH:
						currentScreen = new DeathScreen(this);
						break;
					case WIN:
						currentScreen = new WinScreen(this);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
			
		} while (previousGameState != gameState);
	}
	
	/*public void switchBackToLevel() {
		currentScreen = levelScreen;
		previousGameState = gameState;
		currentScreen.update();
	}*/
	
	/*public void switchBackToShop() {
		currentScreen = shopScreen;
		previousGameState = gameState;
		currentScreen.update();
	}*/
	
	public Screen checkCurrentScreen() {
		return currentScreen;}
	
	
	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}
