package Game;

import Engine.GameWindow;
import Engine.ScreenManager;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator c
 */

// Game created by Phil, Andrew L, Andrew K, Alec G, and Mica
public class Game {

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        gameWindow.startGame();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
    }
}
