package Engine;

import javax.swing.JFrame;

import Level.Keys;
import Level.KillCount;
import NPCs.Currency;

/*
 * The JFrame that holds the GamePanel
 * Just does some setup and exposes the gamePanel's screenManager to allow an external class to setup their own content and attach it to this engine.
 */
public class GameWindow {
	public static JFrame gameWindow;
	public static GamePanel gamePanel;

	public GameWindow() {
		gameWindow = new JFrame("Game");
		gamePanel = new GamePanel();
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
		gameWindow.setContentPane(gamePanel);
		gameWindow.setResizable(false);
		gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it'd be nice if this actually worked more than
																	// 1/3rd of the time
		gamePanel.setupGame();
		// Load Configurations
		gamePanel.config.loadConfigurations();
		//System.out.println(Music.volumeScale);
		//System.out.println(SoundE.volumeScale);

	}

	// triggers the game loop to start as defined in the GamePanel class
	public void startGame() {
		 //Load the saved items
		if (GamePanel.save) {
			gamePanel.saveLoad.load();
		}
		gamePanel.startGame();
		System.out.println("Starting kills: " + KillCount.KillNum);
		System.out.println("Starting keys: " + Keys.KeyCount);
		System.out.println("Starting COINS: " + Currency.CoinNum);
	}

	public ScreenManager getScreenManager() {
		return gamePanel.getScreenManager();
	}
}
