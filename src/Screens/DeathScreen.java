package Screens;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

// This class is for the win level screen
public class DeathScreen extends Screen {
    protected SpriteFont winMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected ScreenCoordinator screenCoordinator;

    public DeathScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }
    
    public DeathScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        winMessage = new SpriteFont("You died!", 350, 270, "Comic Sans", 30, Color.RED);
        instructions = new SpriteFont("Press Space to play again or Escape to go back to the main menu", 120, 300,"Comic Sans", 20, Color.white);
        //keyLocker.lockKey(Key.SPACE);
        //keyLocker.lockKey(Key.ESC);
        //screenCoordinator.setGameState(GameState.DEATH);
    }

    @Override
    public void update() {
    	//System.out.println("Ds update");
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            //playLevelScreen.resetLevel();
        	screenCoordinator.setGameState(GameState.LEVEL);
        } else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            //playLevelScreen.goBackToMenu();
        	screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        winMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
