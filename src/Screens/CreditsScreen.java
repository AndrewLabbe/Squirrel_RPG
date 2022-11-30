package Screens;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel; 
    protected SpriteFont createdByLabel2;
    protected SpriteFont createdByLabel3;
    protected SpriteFont createdByLabel4;
    protected SpriteFont createdByLabel5;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 15, 35, "Times New Roman", 30, Color.white);
        createdByLabel = new SpriteFont("Created by: Alex Thimineur", 100, 140, "Times New Roman", 20, Color.RED); 
        createdByLabel2 = new SpriteFont("Enhanced by: Phil Caldarella,", 100, 185, "Times New Roman", 20, Color.BLUE);
        createdByLabel3 = new SpriteFont("Garrett Goldberg, Andrew Labbe,", 100, 210, "Times New Roman", 20, Color.BLUE);
        createdByLabel4 = new SpriteFont("Alec Goriup, Andrew Kulowski,", 100, 235, "Times New Roman", 20, Color.BLUE);
        createdByLabel5 = new SpriteFont("Mica Grajales", 100, 260, "Times New Roman", 20, Color.BLUE);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 560, "Times New Roman", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.drawWithParsedNewLines(graphicsHandler);
        createdByLabel2.drawWithParsedNewLines(graphicsHandler);
        createdByLabel3.drawWithParsedNewLines(graphicsHandler);
        createdByLabel4.drawWithParsedNewLines(graphicsHandler);
        createdByLabel5.drawWithParsedNewLines(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
