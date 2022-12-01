package Game;

import Engine.GameWindow;
import Engine.ScreenManager;
import JSON.SimpleJSON;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator
 */

// Game created by Phil, Andrew L, Andrew K, Alec G, and Mica
public class Game {

    public static void main(String[] args) {
        new Game();
    }

    public Game() { 
    	SimpleJSON simpleJSON = new SimpleJSON(true);
        GameWindow gameWindow = new GameWindow();
        gameWindow.startGame();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
    }
}
