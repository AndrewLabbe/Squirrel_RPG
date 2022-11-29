package Screens;

import java.awt.Color;

import Engine.Config;
import Engine.GamePanel;
import Engine.GameWindow;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Music;
import Engine.Screen;
import Engine.SoundE;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

// This is the class for the inventory menu screen
public class OptionsScreen extends Screen {
	// For sound effect
	protected ScreenCoordinator screenCoordinator;
	protected int currentItem = 0; // current item position
	protected int previousItem;
	protected int maxItem = 7;
	protected SpriteFont options, s, eg, soundText, musicText, fullScreenT;
	protected Map background;
	protected Stopwatch keyTimer = new Stopwatch();
	protected int pointerLocationX, pointerLocationY;
	protected KeyLocker keyLocker = new KeyLocker();
	// Volume
	Music m = new Music();
	SoundE se = new SoundE();

	private final Key escKey = Key.ESC;
	protected int yPos, range, itemBoxSize, base;
	protected float space, next;
	protected GameObject.Rectangle box1, box2, box3, box4, box5, box6, box7, opTable, info1, info2, info3, info4, info5;

	protected GameObject.Rectangle save, endGame, sound, music, fullScreen;
//    protected GameObject.Rectangle[] box = {box1, box2, box3, box4, box5, box6};

	public OptionsScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}

	@Override
	public void initialize() {
		// gp.playMusic(0);
		range = Config.GAME_WINDOW_HEIGHT / 5; // range for item box and equal spaces
		itemBoxSize = range * 1 / 2;
		space = (range * 1 / 4) / 2;
		next = itemBoxSize + space;
		base = range * 3 / 4;

		opTable = new GameObject.Rectangle(2 * space, 2 * space, Config.GAME_WINDOW_WIDTH * 3 / 4,
				Config.GAME_WINDOW_HEIGHT * 3 / 4);
		opTable.setColor(new Color(77, 75, 115));
		opTable.setBorderColor(Color.black);
		opTable.setBorderThickness(3);

		options = new SpriteFont("Options", itemBoxSize, base * 3 / 4, "Comic Sans", 32, new Color(49, 207, 240));
		options.setOutlineColor(Color.black);
		options.setOutlineThickness(3);

		// Save Button
		save = new GameObject.Rectangle(4 * space, 6 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		save.setBorderColor(Color.black);
		save.setColor(new Color(90, 89, 110));
		save.setBorderThickness(5);

		s = new SpriteFont("SAVE", 9 * space, 9 * space, "Comic Sans", 21, new Color(49, 207, 240));
		s.setOutlineColor(Color.black);
		s.setOutlineThickness(3);

		// End game Button
		endGame = new GameObject.Rectangle(4 * space, 12 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		endGame.setBorderColor(Color.black);
		endGame.setColor(new Color(90, 89, 110));
		endGame.setBorderThickness(5);

		eg = new SpriteFont("END GAME", 7 * space, 15 * space, "Comic Sans", 21, new Color(49, 207, 240));
		eg.setOutlineColor(Color.black);
		eg.setOutlineThickness(3);

		// Sound Button
		sound = new GameObject.Rectangle(21 * space, 6 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		sound.setBorderColor(Color.black);
		sound.setColor(new Color(90, 89, 110));
		sound.setBorderThickness(5);

		soundText = new SpriteFont("SOUND", 25 * space, 9 * space, "Comic Sans", 21, new Color(49, 207, 240));
		soundText.setOutlineColor(Color.black);
		soundText.setOutlineThickness(3);

		// Music Button
		music = new GameObject.Rectangle(21 * space, 12 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		music.setBorderColor(Color.black);
		music.setColor(new Color(90, 89, 110));
		music.setBorderThickness(5);

		musicText = new SpriteFont("MUSIC", 25 * space, 15 * space, "Comic Sans", 21, new Color(49, 207, 240));
		musicText.setOutlineColor(Color.black);
		musicText.setOutlineThickness(3);

		// Full Screen Button
		fullScreen = new GameObject.Rectangle(21 * space, 18 * space, Config.GAME_WINDOW_WIDTH * 1 / 4,
				Config.GAME_WINDOW_HEIGHT * 1 / 8);
		fullScreen.setBorderColor(Color.black);
		fullScreen.setColor(new Color(90, 89, 110));
		fullScreen.setBorderThickness(5);

		fullScreenT = new SpriteFont("FULL SCREEN", 23 * space, 21 * space, "Comic Sans", 21, new Color(49, 207, 240));
		fullScreenT.setOutlineColor(Color.black);
		fullScreenT.setOutlineThickness(3);

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
		if (Keyboard.isKeyDown(Key.UP) && currentItem >= 1 && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentItem--;
			se.playSE(5);

		} else if (Keyboard.isKeyDown(Key.DOWN) && currentItem <= 3 && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentItem++;
			se.playSE(5);
		}

		// Save Game button
		if (currentItem == 0) {
			// Save
			save.setBorderColor(new Color(255, 215, 0)); // selected color
			save.setBorderThickness(5);
			// End Game
			endGame.setBorderColor(new Color(90, 89, 110));
			endGame.setBorderThickness(5);
			// Sound
			sound.setBorderColor(new Color(90, 89, 110));
			sound.setBorderThickness(5);
			// Music
			music.setBorderColor(new Color(90, 89, 110));
			music.setBorderThickness(5);
			// Full Screen
			fullScreen.setBorderColor(new Color(90, 89, 110));
			fullScreen.setBorderThickness(5);
			if (Keyboard.isKeyDown(Key.F)) {
				if (GamePanel.fullScreen == false && keyTimer.isTimeUp()) {
					System.out.println("era falso");
					GamePanel.fullScreen = true;
					keyTimer.reset();
					
				} else if (GamePanel.fullScreen == true && keyTimer.isTimeUp()) {
					GamePanel.fullScreen = false;
					System.out.println("era true");
					keyTimer.reset();
				}

			}

		}

		// Ends Game by going back to the initial screen
		else if (currentItem == 1) {
			// Save
			save.setBorderColor(new Color(90, 89, 110));
			save.setBorderThickness(5);
			// End Game
			endGame.setBorderColor(new Color(255, 215, 0)); // selected color
			endGame.setBorderThickness(5);
			// Sound
			sound.setBorderColor(new Color(90, 89, 110));
			sound.setBorderThickness(5);
			// Music
			music.setBorderColor(new Color(90, 89, 110));
			music.setBorderThickness(5);
			// Full Screen
			fullScreen.setBorderColor(new Color(90, 89, 110));
			fullScreen.setBorderThickness(5);
			if (Keyboard.isKeyDown(Key.SPACE)) {
				screenCoordinator.setGameState(GameState.MENU);
				screenCoordinator.update();
			}

			// Sound Item
		} else if (currentItem == 2) {
			// Save
			save.setBorderColor(new Color(90, 89, 110));
			save.setBorderThickness(5);
			// End Game
			endGame.setBorderColor(new Color(90, 89, 110));
			endGame.setBorderThickness(5);
			// Sound
			sound.setBorderColor(new Color(255, 215, 0));// selected color
			sound.setBorderThickness(5);
			// Music
			music.setBorderColor(new Color(90, 89, 110));
			music.setBorderThickness(5);
			// Full Screen
			fullScreen.setBorderColor(new Color(90, 89, 110));
			fullScreen.setBorderThickness(5);

			// Pressing A should decrease sound effects volume

			if (Keyboard.isKeyDown(Key.A) && SoundE.volumeScale > 0 && keyTimer.isTimeUp()) {
				SoundE.volumeScale--;
				se.checkVolume();
				se.playSE(5);
				keyTimer.reset();
			}
			// Pressing D should increase sound effects
			if (Keyboard.isKeyDown(Key.D) && SoundE.volumeScale < 5 && keyTimer.isTimeUp()) {
				SoundE.volumeScale++;
				se.checkVolume();
				se.playSE(5);
				keyTimer.reset();
			}

			// Music Item
		} else if (currentItem == 3) {
			// Save
			save.setBorderColor(new Color(90, 89, 110));
			save.setBorderThickness(5);
			// End Game
			endGame.setBorderColor(new Color(90, 89, 110));
			endGame.setBorderThickness(5);
			// Sound
			sound.setBorderColor(new Color(90, 89, 110));
			sound.setBorderThickness(5);
			// Music
			music.setBorderColor(new Color(255, 215, 0));// selected color
			music.setBorderThickness(5);
			// Full Screen
			fullScreen.setBorderColor(new Color(90, 89, 110));
			fullScreen.setBorderThickness(5);

			// Pressing A should decrease background volume
			if (Keyboard.isKeyDown(Key.A) && Music.volumeScale > 0 && keyTimer.isTimeUp()) {
				// gamePanel.se.checkVolume();
				Music.volumeScale--;
				System.out.println("volumen scale" + Music.volumeScale);
				System.out.println("volumen" + m.volume);
				m.checkVolume();
				se.playSE(5);

				keyTimer.reset();
			}
			// Pressing D should increase music
			if (Keyboard.isKeyDown(Key.D) && Music.volumeScale < 5 && keyTimer.isTimeUp()) {
				Music.volumeScale++;
				System.out.println("volumen scale" + Music.volumeScale);
				System.out.println("volumen" + m.volume);
				m.checkVolume();
				se.playSE(5);

				keyTimer.reset();
			}

		} else if (currentItem == 4 && Keyboard.isKeyDown(Key.F)) {
			System.out.println(currentItem);
			// Save
			save.setBorderColor(new Color(90, 89, 110));
			save.setBorderThickness(5);
			// End Game
			endGame.setBorderColor(new Color(90, 89, 110));
			endGame.setBorderThickness(5);
			// Sound
			sound.setBorderColor(new Color(90, 89, 110));
			sound.setBorderThickness(5);
			// Music
			music.setBorderColor(new Color(90, 89, 110));
			music.setBorderThickness(5);
			// Full Screen
			fullScreen.setBorderColor(new Color(255, 215, 0));// selected color
			fullScreen.setBorderThickness(5);
			System.out.println("entro");
			// Full Screen
		}

		// if escape is pressed in game, go back to game
		if (Keyboard.isKeyDown(escKey) && screenCoordinator.checkCurrentScreen() != null) {
			screenCoordinator.setGameState(GameState.LEVEL);
			screenCoordinator.switchBackToLevel();
		}
		// if escape i pressed in main menu, go back to menu--> It does not work
		if (Keyboard.isKeyDown(escKey) && screenCoordinator.checkCurrentScreen() == null) {
			screenCoordinator.setGameState(GameState.MENU);
		}
		// Save Configurations
		GameWindow.gamePanel.config.saveConfigurations();

	}

	public void draw(GraphicsHandler graphicsHandler) {
		background.draw(graphicsHandler);
		opTable.draw(graphicsHandler);
		options.draw(graphicsHandler);
		save.draw(graphicsHandler);
		s.draw(graphicsHandler);
		endGame.draw(graphicsHandler);
		eg.draw(graphicsHandler);
		music.draw(graphicsHandler);
		musicText.draw(graphicsHandler);
		sound.draw(graphicsHandler);
		soundText.draw(graphicsHandler);
		fullScreen.draw(graphicsHandler);
		fullScreenT.draw(graphicsHandler);

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
