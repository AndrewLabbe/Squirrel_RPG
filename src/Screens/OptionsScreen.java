package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

// This is the class for the inventory menu screen
public class OptionsScreen extends Screen {
	// For sound effect
	GamePanel gamePanel = new GamePanel();
	protected ScreenCoordinator screenCoordinator;
	protected int currentItem = 4; // current item position
	protected int previousItem;
	protected int maxItem = 7;
	protected SpriteFont options, s, sAndQ, soundText, musicText, fullscreenText;
	protected Map background;
	protected Stopwatch keyTimer = new Stopwatch();
	protected int pointerLocationX, pointerLocationY;
	protected KeyLocker keyLocker = new KeyLocker();

	private final Key escKey = Key.ESC;
	protected int yPos, range, itemBoxSize, base;
	protected float space, next;
	protected GameObject.Rectangle box1, box2, box3, box4, box5, box6, opTable, info1, info2, info3, info4, info5;

	protected GameObject.Rectangle save, sAndQuit, sound, music, fullscreen;
//    protected GameObject.Rectangle[] box = {box1, box2, box3, box4, box5, box6};

	public OptionsScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}

	@Override
	public void initialize() {
		range = Config.GAME_WINDOW_HEIGHT / 5; // range for item box and equal spaces
		itemBoxSize = range * 1 / 2;
		space = (range * 1 / 4) / 2;
		next = itemBoxSize + space;
		base = range * 3 / 4;

		// options table will include a save and save & quit buttons, sounds, music,
		// night or day checkboxes
		opTable = new GameObject.Rectangle(2 * space, 2 * space, Config.GAME_WINDOW_WIDTH * 3 / 4,
				Config.GAME_WINDOW_HEIGHT * 3 / 4);
		opTable.setColor(new Color(77, 75, 115));
		opTable.setBorderColor(Color.black);
		opTable.setBorderThickness(3);

		options = new SpriteFont("Options", itemBoxSize, base * 3 / 4, "Comic Sans", 32, new Color(49, 207, 240));
		options.setOutlineColor(Color.black);
		options.setOutlineThickness(3);

		save = new GameObject.Rectangle(4 * space, 6 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		save.setBorderColor(Color.black);
		save.setColor(new Color(90, 89, 110));
		save.setBorderThickness(5);

		s = new SpriteFont("SAVE", 9 * space, 9 * space, "Comic Sans", 21, new Color(49, 207, 240));
		s.setOutlineColor(Color.black);
		s.setOutlineThickness(3);

		sAndQuit = new GameObject.Rectangle(4 * space, 12 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		sAndQuit.setBorderColor(Color.black);
		sAndQuit.setColor(new Color(90, 89, 110));
		sAndQuit.setBorderThickness(5);

		sAndQ = new SpriteFont("SAVE & QUIT", 6 * space, 15 * space, "Comic Sans", 21, new Color(49, 207, 240));
		sAndQ.setOutlineColor(Color.black);
		sAndQ.setOutlineThickness(3);

		sound = new GameObject.Rectangle(21 * space, 6 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		sound.setBorderColor(Color.black);
		sound.setColor(new Color(90, 89, 110));
		sound.setBorderThickness(5);

		soundText = new SpriteFont("SOUND", 25 * space, 9 * space, "Comic Sans", 21, new Color(49, 207, 240));
		soundText.setOutlineColor(Color.black);
		soundText.setOutlineThickness(3);

		music = new GameObject.Rectangle(21 * space, 12 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		music.setBorderColor(Color.black);
		music.setColor(new Color(90, 89, 110));
		music.setBorderThickness(5);

		musicText = new SpriteFont("MUSIC", 25 * space, 15 * space, "Comic Sans", 21, new Color(49, 207, 240));
		musicText.setOutlineColor(Color.black);
		musicText.setOutlineThickness(3);

		fullscreen = new GameObject.Rectangle(21 * space, 18 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		fullscreen.setBorderColor(Color.black);
		fullscreen.setColor(new Color(90, 89, 110));
		fullscreen.setBorderThickness(5);

		fullscreenText = new SpriteFont("FULL SCREEN", 23 * space, 21 * space, "Comic Sans", 21,
				new Color(49, 207, 240));
		fullscreenText.setOutlineColor(Color.black);
		fullscreenText.setOutlineThickness(3);

//        night = new CheckBox();
//        day = new CheckBox();
//        music = new CheckBox();
//        sounds = new CheckBox();

//        for(int i = 0; i < box.length; i++) {
//        	System.out.println(box[i]);
////        	box[i] = new GameObject.Rectangle(itemBoxSize, base+(i*next), itemBoxSize, itemBoxSize);
//        	box[i].setColor(new Color(90, 89, 110));
//        	box[i].setBorderColor(Color.black);
//        	box[i].setBorderThickness(3);
//        }	

		background = new TitleScreenMap();
		background.setAdjustCamera(false);
		keyTimer.setWaitTime(200);
//        menuItemSelected = -1;
		keyLocker.lockKey(Key.SPACE);
	}

	public void update() {
		// update background map (to play tile animations)
		background.update(null);

		// if down or up is pressed, change selected item position. avoids currentItem
		// from being out of bounds
		if (Keyboard.isKeyDown(Key.UP) && previousItem != 1 && keyTimer.isTimeUp()) {
			keyTimer.reset();
			gamePanel.playSE(7);
			currentItem--;
		} else if (Keyboard.isKeyDown(Key.DOWN) && currentItem != 4 && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentItem++;
			gamePanel.playSE(7);
		}

		if (currentItem == 0) {
			save.setBorderColor(new Color(255, 215, 0)); // selected color
			sAndQuit.setBorderColor(new Color(90, 89, 110)); // natural color

		} else if (currentItem == 1) {
			save.setBorderColor(new Color(90, 89, 110));
			sAndQuit.setBorderColor(new Color(255, 215, 0));
			sound.setBorderColor(new Color(90, 89, 110));

		} else if (currentItem == 2) {
			sAndQuit.setBorderColor(new Color(90, 89, 110));
			sound.setBorderColor(new Color(255, 215, 0));
			music.setBorderColor(new Color(90, 89, 110));

		} else if (currentItem == 3) {
			sound.setBorderColor(new Color(90, 89, 110));
			music.setBorderColor(new Color(255, 215, 0));
			fullscreen.setBorderColor(new Color(90, 89, 110));
			//Pressing A should decrease volume
			if (Keyboard.isKeyDown(Key.A) && gamePanel.music.volumeScale > 0 && keyTimer.isTimeUp()) {
				//gamePanel.music.volumeScale--;
				//gamePanel.music.checkVolume();
				System.out.println("entro" + gamePanel.music.volume);
				keyTimer.reset();
			}
			//Pressing D should increase volume
			if (Keyboard.isKeyDown(Key.D) && gamePanel.music.volumeScale < 5 && keyTimer.isTimeUp()) {
				gamePanel.music.volumeScale++;
				gamePanel.music.checkVolume();
				gamePanel.music.checkVolume();
				System.out.println("entro");
			}

		} else if (currentItem == 4) {
			fullscreen.setBorderColor(new Color(255, 215, 0));
			music.setBorderColor(new Color(90, 89, 110));

		}

		// if escape is pressed in game, go back to game
		if (Keyboard.isKeyDown(escKey) && screenCoordinator.checkCurrentScreen() != null) {

			screenCoordinator.setGameState(GameState.LEVEL);
			screenCoordinator.switchBackToLevel();
		}
		// if escape i pressed in main menu, go back to menu
		if (Keyboard.isKeyDown(escKey) && screenCoordinator.checkCurrentScreen() == null) {
			screenCoordinator.setGameState(GameState.MENU);
		}

	}

	public void draw(GraphicsHandler graphicsHandler) {
		background.draw(graphicsHandler);
		opTable.draw(graphicsHandler);
		options.draw(graphicsHandler);
		save.draw(graphicsHandler);
		s.draw(graphicsHandler);
		sAndQuit.draw(graphicsHandler);
		sAndQ.draw(graphicsHandler);
		music.draw(graphicsHandler);
		musicText.draw(graphicsHandler);
		sound.draw(graphicsHandler);
		soundText.draw(graphicsHandler);
		fullscreen.draw(graphicsHandler);
		fullscreenText.draw(graphicsHandler);

//        box1.draw(graphicsHandler);
//        box2.draw(graphicsHandler);
//        box3.draw(graphicsHandler);
//        box4.draw(graphicsHandler);
//        box5.draw(graphicsHandler);

//        info1.draw(graphicsHandler);

	}

//    public void changeSelectedItem() {
//    	
//    }

}
